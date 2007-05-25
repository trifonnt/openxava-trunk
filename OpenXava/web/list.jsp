<%@ include file="imports.jsp"%>

<%@ page import="org.openxava.tab.impl.IXTableModel" %>
<%@ page import="org.openxava.util.Strings" %>
<%@ page import="org.openxava.util.XavaPreferences" %>
<%@ page import="org.openxava.model.meta.MetaProperty" %>
<%@ page import="org.openxava.web.WebEditors" %>

<jsp:useBean id="errors" class="org.openxava.util.Messages" scope="request"/>
<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>

<%
org.openxava.controller.ModuleManager manager = (org.openxava.controller.ModuleManager) context.get(request, "manager", "org.openxava.controller.ModuleManager");
String collection = request.getParameter("collection"); 
String id = "list";
String collectionArgv = "";
String prefix = "";
String tabObject = request.getParameter("tabObject");
tabObject = (tabObject == null || tabObject.equals(""))?"xava_tab":tabObject;
if (collection != null && !collection.equals("")) {
	id = collection;
	collectionArgv=",collection="+collection;
	prefix = tabObject + "_";
}

org.openxava.tab.Tab tab = (org.openxava.tab.Tab) context.get(request, tabObject);
String action=request.getParameter("rowAction");
action=action==null?manager.getEnvironment().getValue("XAVA_LIST_ACTION"):action;
String viewObject = request.getParameter("viewObject");
String actionArgv = viewObject != null && !viewObject.equals("")?",viewObject=" + viewObject:"";
String sfilter = request.getParameter("filter");
boolean filter = !"false".equals(sfilter);
String lastRow = request.getParameter("lastRow");
boolean singleSelection="true".equalsIgnoreCase(request.getParameter("singleSelection"));
%>

<% if (tab.isTitleVisible()) { %>
<table width="100%" id="list-title" class=<%=style.getListTitleWrapper()%>>
<tr><td class=<%=style.getListTitle()%>>
<%=tab.getTitle()%>
</td></tr>
</table>
<% } %>

<table id="<%=id%>" class=<%=style.getList()%> width="100%" <%=style.getListCellSpacing()%>>
<tr>
<th class=<%=style.getListHeader()%> style="text-align: center" width="60"><xava:image action="List.customize"/></th>
<th class=<%=style.getListHeader()%> width="5">
<% if (tab.isCustomize()) { %><xava:image action="List.addColumns"/><% } %>
</th>
<%
tab.reset();
java.util.Collection properties = tab.getMetaProperties();
java.util.Iterator it = properties.iterator();
int columnIndex = 0;
while (it.hasNext()) {
	MetaProperty property = (MetaProperty) it.next();
	String align = "";
	if (style.isAlignHeaderAsData()) {
		align =property.isNumber() && !property.hasValidValues()?"style='vertical-align: middle;text-align: right'":"style='vertical-align: middle;'";
	}
%>
<th class="<%=style.getListHeader()%>" <%=align%>>
<% if (tab.isCustomize()) { %><xava:image action="List.moveColumnToLeft" argv='<%="columnIndex="+columnIndex%>'/><% } %>
<%
	if (property.isCalculated()) {		
%>
<%=property.getLabel(request)%>&nbsp;
<%
	} else {
%>
<span class="<%=style.getListOrderBy()%>">
<xava:link action='List.orderBy' argv='<%="property="+property.getQualifiedName() + collectionArgv%>'><%=property.getLabel(request)%></xava:link>&nbsp;
</span>
<%
		if (tab.isOrderAscending(property.getQualifiedName())) {
%>
<img src="<%=request.getContextPath()%>/xava/images/<%=style.getAscendingImage()%>" alt="Ordenado ascendentemente" border="0" align="middle"/>
<%
		}
%>
<%
		if (tab.isOrderDescending(property.getQualifiedName())) {
%>
<img src="<%=request.getContextPath()%>/xava/images/<%=style.getDescendingImage()%>" alt="Ordenado descendente" border="0" align="middle"/>
<%
		}
%>
	
<% 
   }
   
   if (tab.isCustomize()) { %>
	<xava:image action="List.moveColumnToRight" argv='<%="columnIndex="+columnIndex%>'/>
	<xava:image action="List.removeColumn" argv='<%="columnIndex="+columnIndex%>'/>
<% }
 
%>
</th>
<%
	columnIndex++;
}
%>
</tr>
<% if (filter) { %>
<tr class=<%=style.getListSubheader()%>>
<th class=<%=style.getListSubheader()%> style="text-align: center" width="60">
<xava:action action="List.filter" argv="<%=collectionArgv%>"/>
</th>
<th class=<%=style.getListSubheader()%> width="5">
	<script>
	function clear<%=prefix%>ConditionValues() {
		for (i=0; i<document.<%=manager.getForm()%>.<%=prefix%>conditionValues.length; i++) {
			document.<%=manager.getForm()%>.<%=prefix%>conditionValues[i].value = '';
	  	}
	}
	</script>
	<a title='<xava:message key="clear_condition_values"/>' href="javascript:void(0)">
		<img src='<%=request.getContextPath()%>/xava/images/clear-right.gif'
			border='0' align='middle' onclick="clear<%=prefix%>ConditionValues()"/>
	</a>
</th>
<%
it = properties.iterator();
String [] conditionValues = tab.getConditionValues();
String [] conditionComparators = tab.getConditionComparators();
int iConditionValues = 0;
while (it.hasNext()) {
	MetaProperty property = (MetaProperty) it.next();
	if (!property.isCalculated()) {
		boolean isValidValues = property.hasValidValues();
		boolean isString = "java.lang.String".equals(property.getType().getName());
		boolean isBoolean = "boolean".equals(property.getType().getName()) || "java.lang.Boolean".equals(property.getType().getName());
		boolean isDate = java.util.Date.class.isAssignableFrom(property.getType()) && !property.getType().equals(java.sql.Time.class);
		int maxLength = property.getSize();
		int length = Math.min(isString?property.getSize()/2:property.getSize(), 20);
		String value= conditionValues==null?"":conditionValues[iConditionValues];
		String comparator = conditionComparators==null?"":Strings.change(conditionComparators[iConditionValues], "=", "eq");
		iConditionValues++;
		if (isValidValues) {
	%>	
<th class=<%=style.getListSubheader()%> align="left">
<jsp:include page="comparatorsValidValuesCombo.jsp">
	<jsp:param name="validValues" value="<%=property.getValidValuesLabels(request)%>" />
	<jsp:param name="value" value="<%=value%>" />
	<jsp:param name="base0" value="<%=!property.isNumber()%>" />
	<jsp:param name="prefix" value="<%=prefix%>"/>
</jsp:include>		
	<%	
		}
		else if (isBoolean) { 
	%>
<th class=<%=style.getListSubheader()%> align="left">
<jsp:include page="comparatorsBooleanCombo.jsp">
	<jsp:param name="comparator" value="<%=comparator%>" />
	<jsp:param name="prefix" value="<%=prefix%>"/>
</jsp:include>
	<% } else { // Not boolean %>
<th class=<%=style.getListSubheader()%> align="left">
<% 
String urlComparatorsCombo = "comparatorsCombo.jsp" // in this way because websphere 6 has problems with jsp:param
	+ "?comparator=" + comparator
	+ "&isString=" + isString
	+ "&isDate=" + isDate
	+ "&prefix=" + prefix;
%>
<jsp:include page="<%=urlComparatorsCombo%>" />
<input name="<%=prefix%>conditionValues" class=<%=style.getEditor()%> type="text" maxlength="<%=maxLength%>" size="<%=length%>" value="<%=value%>"/>
	<% } %>
</th>
<% 
	}
	else {
%>
<th class=<%=style.getListSubheader()%>></th>
<%
	} 
} // while	
%>
</tr>
<% } /* if (filter) */ %>
<%
int totalSize = 0;
if (tab.isRowsHidden()) {
%>
	<tr id="nodata"><td align="center">
	<xava:link action="List.showRows" argv="<%=collectionArgv%>"/>
	</td></tr>
<%
}
else {
	
IXTableModel model = tab.getTableModel(); 
totalSize = tab.getTotalSize();
if (totalSize > 0) {
for (int f=tab.getInitialIndex(); f<model.getRowCount() && f < tab.getFinalIndex(); f++) {
	String checked=tab.isSelected(f)?"checked='true'":"";
	String cssClass=f%2==0?style.getListPair():style.getListOdd();	
	String cssStyle = tab.getStyle(f);
%>
<tr class=<%=cssClass%>>
	<td class=<%=cssClass%> style='vertical-align: middle;text-align: center'>
<% if (!org.openxava.util.Is.emptyString(action)) { %>
<xava:action action='<%=action%>' argv='<%="row=" + f + actionArgv%>'/>
<% } %>
	</td>
	<td class=<%=cssClass%>>
	<INPUT type="<%=singleSelection?"RADIO":"CHECKBOX"%>" name="<%=prefix + "selected"%>" value="<%=f%>" <%=checked%>/>
	</td>	
<%
	for (int c=0; c<model.getColumnCount(); c++) {
		MetaProperty p = tab.getMetaProperty(c);
		String align =p.isNumber() && !p.hasValidValues()?"style='vertical-align: middle;text-align: right'":"style='vertical-align: middle;'";
		String fvalue = null;
		if (p.hasValidValues()) {
			fvalue = p.getValidValueLabel(request, model.getValueAt(f, c));
		}
		else {
			fvalue = WebEditors.format(request, p, model.getValueAt(f, c), errors);
		}
%>
	<td class=<%=cssClass%> <%=align%>>
	<% if (cssStyle != null) { %> <div id="cellStyle" class=<%=cssStyle%>> <% } %>
		<%=fvalue%>&nbsp;
	<% if (cssStyle != null) { %> </div> <% } %>
	</td>
<%
	}
%>
</tr>
<%
}

}
else {
%>
<tr id="nodata"><td class=<%=totalSize==0?style.getMessages():style.getErrors()%>>
<% if (totalSize == 0) { %>
<b><xava:message key="no_objects"/></b>
<% } else { %>
<b><xava:message key="list_error"/></b>
<% } %>
</td></tr>
<%
}
}

if (lastRow != null) {
%>
<tr>
	<jsp:include page="<%=lastRow%>"/>
</tr>
<%
}
%>
</table>
<% if (!tab.isRowsHidden()) { %>
<table width="100%" class=<%=style.getListInfo()%>>
<tr class='<%=style.getListInfoDetail()%>'>
<td class='<%=style.getListInfoDetail()%>' style='vertical-align: middle'>
<%
int last=tab.getLastPage();
int current=tab.getPage();
if (current > 1) {
%>
<xava:image action='List.goPreviousPage'/>
<% } 
for (int i=1; i<=last; i++) {
if (i == current) {
%>	 
 <b><%=i%></b>
<% } else { %>
 <xava:link action='List.goPage' argv='<%="page="+i%>'><%=i%></xava:link>
<% }} 
if (!tab.isLastPage()) {
%>
 <xava:image action='List.goNextPage'/> 
<% } %>	 
</td>
<td style='text-align: right; vertical-align: middle' class='<%=style.getListInfoDetail()%>'>
<% if (XavaPreferences.getInstance().isShowCountInList()) { %>
<xava:message key="list_count" intParam="<%=totalSize%>"/>
<% } %>
(<xava:link action="List.hideRows" argv="<%=collectionArgv%>"/>)
</td>
</tr>
</table>
<% } %>
