<%@ include file="imports.jsp"%>

<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.openxava.model.meta.MetaReference" %>
<%@ page import="org.openxava.view.meta.MetaPropertyView" %>

<jsp:useBean id="errors" class="org.openxava.util.Messages" scope="request"/>
<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>

<%
boolean onlyEditor = "true".equalsIgnoreCase(request.getParameter("onlyEditor"));
String viewObject = request.getParameter("viewObject");
viewObject = (viewObject == null || viewObject.equals(""))?"xava_view":viewObject;
org.openxava.view.View view = (org.openxava.view.View) context.get(request, viewObject);
String referenceKey = request.getParameter("referenceKey");
MetaReference ref = (MetaReference) request.getAttribute(referenceKey); 
String labelKey = referenceKey + "_LABEL_";
%>

<%@ include file="htmlTagsEditor.jsp"%>

<%
String editableKey = referenceKey + "_EDITABLE_";
boolean editable = view.isEditable(ref);
int labelFormat = view.getLabelFormatForReference(ref);
String label = ref.getLabel(request);
%>
<% if (!onlyEditor) { %>
<%=preLabel%>
<% if (labelFormat == MetaPropertyView.NORMAL_LABEL) { %>
<%=label%>
<% } %>
<%=postLabel%>
<%=preIcons%>
<% if (ref.isKey()) { %>
<img src="<%=request.getContextPath()%>/xava/images/key.gif"/>
<% } else if (ref.isRequired()) {  %>	
<img src="<%=request.getContextPath()%>/xava/images/required.gif"/>
<% } %> 
<span id="xava_error_image_<%=ref.getQualifiedName()%>">
<% if ( errors.memberHas(ref)) {%>
<img src="<%=request.getContextPath()%>/xava/images/error.gif"/>
<% } %>
</span>
<%=postIcons%>
<%=preEditor%>
<% if (labelFormat == MetaPropertyView.SMALL_LABEL) { 
	label = labelFormat == MetaPropertyView.SMALL_LABEL?label:"&nbsp;";
%>
<table border='0' cellpadding='0', cellspacing='0'><tr><td align='bottom' id='<%=labelKey%>'>
<span class=<%=style.getSmallLabel()%>><%=label%></span>

</td></tr>
<tr><td style='vertical-align: middle'>
<% } %>

<% } // !onlyEditor %>
<%
Collection keys = ref.getMetaModelReferenced().getKeyPropertiesNames();
String keyProperty = "";
String keyProperties = "";
String propertyKey = null;
if (keys.size() == 1) {		
	keyProperty = keys.iterator().next().toString();
	propertyKey = referenceKey + "." + keyProperty;	
	Map values = (Map) view.getValue(ref.getName());	
	values = values == null?java.util.Collections.EMPTY_MAP:values;
	Object value = values.get(keyProperty);
	String valueKey = propertyKey + ".value";
	request.setAttribute(valueKey, value);	
	String fvalue = value==null?"":value.toString();
	request.setAttribute(propertyKey + ".fvalue", fvalue);
}
else {	
	propertyKey = referenceKey + ".KEY";
	Map values = (Map) view.getValue(ref.getName());
	values = values == null?java.util.Collections.EMPTY_MAP:values;
	java.util.Iterator it = keys.iterator();
	StringBuffer sb = new StringBuffer();
	while (it.hasNext()) {
		String property = (String) it.next();		
		Object value = values.get(property);
		String valueKey = referenceKey + "." + property + ".value";
		request.setAttribute(valueKey, value);
		sb.append(property);
		if (it.hasNext()) {
			sb.append(',');
		}
	}	
	String key = ref.getMetaModelReferenced().toString(values); 
	String fvalue = key==null?"0":key;
	request.setAttribute(propertyKey + ".fvalue", fvalue);
	keyProperties = sb.toString();
}

String descriptionProperty = view.getDescriptionPropertyInDescriptionsList(ref);
String descriptionProperties = view.getDescriptionPropertiesInDescriptionsList(ref);

org.openxava.controller.ModuleManager manager = (org.openxava.controller.ModuleManager) context.get(request, "manager", "org.openxava.controller.ModuleManager");
String formName = manager.getForm();	
boolean throwChanged=view.throwsReferenceChanged(ref);
String script = throwChanged?
	"onchange='openxava.throwPropertyChanged(\"" + propertyKey + "\")'":"";

String parameterValuesProperties=view.getParameterValuesPropertiesInDescriptionsList(ref);
String condition = view.getConditionInDescriptionsList(ref);
boolean orderByKey = view.isOrderByKeyInDescriptionsList(ref);
String order = view.getOrderInDescriptionsList(ref); 
org.openxava.tab.meta.MetaTab metaTab = ref.getMetaModelReferenced().getMetaComponent().getMetaTab();
String filterArg = "";
if (metaTab.hasFilter()) {
	filterArg = "&filter=" + metaTab.getMetaFilter().getClassName();
}
if (metaTab.hasBaseCondition()) {
	if (org.openxava.util.Is.emptyString(condition)) {
		condition = metaTab.getBaseCondition();
	}
	else {
		condition = metaTab.getBaseCondition() + " AND " + condition;
	}
}
String urlDescriptionEditor = "editors/descriptionsEditor.jsp" // in this way because websphere 6 has problems with jsp:param
	+ "?script=" + script
	+ "&propertyKey=" + propertyKey
	+ "&editable=" + editable
	+ "&model=" + ref.getReferencedModelName()
	+ "&keyProperty=" + keyProperty
	+ "&keyProperties=" + keyProperties
	+ "&descriptionProperty=" + descriptionProperty
	+ "&descriptionProperties=" + descriptionProperties
	+ "&parameterValuesProperties=" + parameterValuesProperties
	+ "&condition=" + condition
	+ "&orderByKey=" + orderByKey
	+ "&order=" + order
	+ filterArg;
%>
<span id="xava_descriptions_list_<%=referenceKey%>">
<input type="hidden" name="<%=editableKey%>" value="<%=editable%>"/>
<jsp:include page="<%=urlDescriptionEditor%>" />

<%
if (editable && view.isCreateNewForReference(ref)) {
%>
<xava:action action='Reference.createNew' argv='<%="model="+ref.getReferencedModelName() + ",keyProperty=" + propertyKey%>'/>
<%
}
%>
<%
if (editable && view.isModifyForReference(ref)) {
%>
<xava:action action='Reference.modify' argv='<%="model="+ref.getReferencedModelName() + ",keyProperty=" + propertyKey%>'/>
<%
}
%>


<%
java.util.Iterator itActions = view.getActionsNamesForReference(ref, editable).iterator();
while (itActions.hasNext()) {
	String action = (String) itActions.next();
%>
<xava:action action="<%=action%>"/>
<%
}
%>
</span>
<%=postEditor%>
<% if (!onlyEditor && labelFormat == MetaPropertyView.SMALL_LABEL) { %>
</td></tr>
</table>
<% } %>
