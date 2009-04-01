<%@ include file="imports.jsp"%>

<%@ page import="java.util.Iterator" %>
<%@ page import="org.openxava.view.View" %>
<%@ page import="org.openxava.view.meta.MetaGroup" %>
<%@ page import="org.openxava.view.meta.PropertiesSeparator" %>
<%@ page import="org.openxava.model.meta.MetaProperty" %>
<%@ page import="org.openxava.model.meta.MetaReference" %>
<%@ page import="org.openxava.model.meta.MetaCollection" %>
<%@ page import="org.openxava.web.WebEditors" %>


<%@page import="org.openxava.web.taglib.IdTag"%>
<%@page import="org.openxava.web.Ids"%><jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>
<%
String viewObject = request.getParameter("viewObject");
viewObject = (viewObject == null || viewObject.equals(""))?"xava_view":viewObject;
org.openxava.view.View view = (org.openxava.view.View) context.get(request, viewObject);
view.setViewObject(viewObject); 
String propertyPrefix = request.getParameter("propertyPrefix");
propertyPrefix = (propertyPrefix == null)?"":propertyPrefix; 
view.setPropertyPrefix(propertyPrefix);
boolean onlySections = view.hasSections() && view.getMetaMembers().isEmpty(); // tmp
%>

<% if (!onlySections) { %>

<% if (view.isFrame()) { %>
<table>
<tr>
<% } %>


<%
Iterator it = view.getMetaMembers().iterator();
String sfirst = request.getParameter("first");
boolean first = !"false".equals(sfirst);
String slast = request.getParameter("last");
boolean last = !"false".equals(slast);
boolean lastWasEditor = false;
boolean lastWasProperty = false; 
while (it.hasNext()) {
	Object m = it.next();
	lastWasProperty = false; 
	if (m instanceof MetaProperty) {		
		MetaProperty p = (MetaProperty) m;		
		if (!PropertiesSeparator.INSTANCE.equals(m)) {			
			boolean hasFrame = WebEditors.hasFrame(p, view.getViewName());		
			lastWasEditor = !hasFrame;
			lastWasProperty = true;
			String propertyKey= Ids.decorate(
					request.getParameter("application"),
					request.getParameter("module"),
					propertyPrefix + p.getName());
			request.setAttribute(propertyKey, p);
			String urlEditor = "editor.jsp" // in this way because websphere 6 has problems with jsp:param
				+ "?propertyKey=" + propertyKey
				+ "&first=" + first
				+ "&hasFrame=" + hasFrame;			
%>
	<jsp:include page="<%=urlEditor%>" />
<%
			first = false;
		}
		else {
			if (!it.hasNext()) break; 					
			first = true;						
			if (lastWasEditor && !view.isAlignedByColumns()) { 	
			%>
			</tr></table>			
			<% 
			} 
			lastWasEditor = false;
			%>
			</td></tr>
			<tr>
	<%	}
	}
	else {
		lastWasEditor = false;
	  	if (m instanceof MetaReference) {
			MetaReference ref = (MetaReference) m;			
			if (view.displayAsDescriptionsList(ref)) {
				lastWasEditor = true;
				String referenceKey = Ids.decorate(
						request.getParameter("application"),
						request.getParameter("module"),
						propertyPrefix +  ref.getName()); 
				request.setAttribute(referenceKey, ref);			
				String urlDescriptionsList = "descriptionsList.jsp" // in this way because websphere 6 has problems with jsp:param
					+ "?referenceKey=" + referenceKey
					+ "&first=" + first;
	%>
		<jsp:include page="<%=urlDescriptionsList%>"/>
	<%
				first = false;		
			}
			else {				
				String viewName = viewObject + "_" + ref.getName();
				View subview = view.getSubview(ref.getName());
				context.put(request, viewName, subview);
				String propertyInReferencePrefix = propertyPrefix + ref.getName() + ".";
				boolean withFrame = subview.isFrame() && 
					(!view.isSection() || view.getMetaMembers().size() > 1);
				lastWasEditor = !withFrame; 
				boolean firstForSubdetail = first || withFrame; 
				if (withFrame || (view.isSection() && view.getMembersNames().size() ==1)) {
					if (first) { 						
	%>		
		<tr><td colspan="4">
	<%	
					} 
				}
				if (withFrame) { 					 					
					String labelKey = Ids.decorate(
						request.getParameter("application"),
						request.getParameter("module"),
						"label_" + propertyPrefix + ref.getName()); 
					String label = view.getLabelFor(ref);
	%>						 
		<%=style.getFrameHeaderStartDecoration() %>
		<%=style.getFrameTitleStartDecoration() %>
		<span id="<%=labelKey%>"><%=label%></span>
		<%=style.getFrameTitleEndDecoration() %>
		<%=style.getFrameHeaderEndDecoration() %>
		<%=style.getFrameContentStartDecoration() %>						
	<%			} // withFrame
		%>	
		<%-- Boolean.toString() for params is for working on WebSphere 6.0 --%>
		<jsp:include page="detail.jsp"> 
			<jsp:param name="viewObject" value="<%=viewName%>" />
			<jsp:param name="propertyPrefix" value="<%=propertyInReferencePrefix%>" />
			<jsp:param name="first" value="<%=Boolean.toString(firstForSubdetail)%>" /> 
			<jsp:param name="last" value="<%=Boolean.toString(!it.hasNext())%>" />
		</jsp:include>			
	<%			if (withFrame) {
		%>			
		<%=style.getFrameContentEndDecoration() %>
		<%
				} // withFrame
			}
			first = false; 
		} else if (m instanceof MetaCollection) {
			MetaCollection collection = (MetaCollection) m;			
			String urlCollection = "collection.jsp";
			boolean withFrame = !view.isSection() || view.getMetaMembers().size() > 1;
		%>
		<tr><td colspan="4">		
	<%			if (withFrame) {
		%>	
		<%=style.getFrameHeaderStartDecoration()%>
		<%=style.getFrameTitleStartDecoration()%>
		<%=collection.getLabel(request) %>
		<%=style.getFrameTitleEndDecoration()%>
		<%=style.getFrameHeaderEndDecoration()%>
		<%=style.getFrameContentStartDecoration()%>
	<%			} // withFrame
		%>	
		<jsp:include page="<%=urlCollection%>"> 
			<jsp:param name="collectionName" value="<%=collection.getName()%>"/>
			<jsp:param name="viewObject" value="<%=viewObject%>"/>			
		</jsp:include>
	<%			if (withFrame) {
		%>
		<%=style.getFrameContentEndDecoration()%>			
	<%			} // withFrame
		} else if (m instanceof MetaGroup) {
			MetaGroup group = (MetaGroup) m;			
			String viewName = viewObject + "_" + group.getName();
			View subview = view.getGroupView(group.getName());			
			context.put(request, viewName, subview);
		%>
		<%
		if (first) { 
			first = false;
		%>
		<tr><td colspan="4">
		<% }  %>
		<%=style.getFrameHeaderStartDecoration()%>
		<%=style.getFrameTitleStartDecoration()%>
		<%=group.getLabel(request)%>
		<%=style.getFrameTitleEndDecoration()%>
		<%=style.getFrameHeaderEndDecoration()%>
		<%=style.getFrameContentStartDecoration() %>
		<jsp:include page="detail.jsp">
			<jsp:param name="viewObject" value="<%=viewName%>" />
		</jsp:include>
		<%=style.getFrameContentEndDecoration() %>
		
	<%
		}
	} // if is not MetaProperty
}
%>
<% if (lastWasEditor) { %>
		<% if (!(view.isRepresentsEntityReference() || view.isRepresentsAggregate()) || view.isFrame()) {
		%> </tr></table> <% } %>
			</td>			
<% } %>

<% 	
	if (view.isFrame() && 
			!(last && view.getParent() != null && !view.getParent().isFrame()) && 
			!(!lastWasProperty && view.isSection() && view.getMembersNames().size() == 1 
					&& view.getParent() != null && view.getParent().isFrame())) {		
%>
</tr>
</table>
<% } %>

<% } // if (!onlySections) %>

<%
if (view.hasSections()) { 
%>
	<% if (!onlySections && view.isSubview() && !view.isFrame()) { // tmp !onlySections %> 
	          </tr>                
              </table>
              </td>
            </tr>
            <tr>
              <td colspan="4">
              <table>                
                  <tr>
                    <td>
	<% } %>
	<div id="<xava:id name='<%="sections_" + viewObject%>'/>"> 
	<jsp:include page="sections.jsp"/>
	</div>
	
	<% if (!onlySections && view.isSubview() && !view.isFrame()) { // tmp !onlySections %>
		 			</td>
	<% } %>
		
<%
}
%>
