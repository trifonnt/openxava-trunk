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
String displayFilter=""; 
String imageFilter="hide-filter";
String filterMessage="hide_filters";
if (!tab.isFilterVisible()) {
	displayFilter="none"; 
	imageFilter ="show-filter"; 
	filterMessage="show_filters";
}
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

<table id="<%=id%>" class="<%=style.getList()%>" width="100%" <%=style.getListCellSpacing()%> <%=style.getListStyle()%>>
<tr id="xava-tr-list" class="<%=style.getListHeader()%>">
<th class="<%=style.getListHeaderCell()%>" style="text-align: center" width="60">     
	<a id="xava-filter-link-<%=id%>" href="javascript:manageFilterRow('<%=id%>')" title="<xava:message key='<%=filterMessage%>'/>"><img id="xava-filter-image-<%=id%>" align='middle' 
		src='<%=request.getContextPath()%>/xava/images/<%=imageFilter%>.gif' border='0'/></a>
	<xava:image action="List.customize" argv="<%=collectionArgv%>"/>
</th>
<th class="<%=style.getListHeaderCell()%>" width="5">
<% if (tab.isCustomize()) { %><xava:image action="List.addColumns" argv="<%=collectionArgv%>"/><% } %>
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
<th class="<%=style.getListHeaderCell()%>" <%=align%>>
<% if (tab.isCustomize()) { %><xava:image action="List.moveColumnToLeft" argv='<%="columnIndex="+columnIndex+collectionArgv%>'/><% } %>
<%
	if (property.isCalculated()) {		
%>
<%=property.getQualifiedLabel(request)%>&nbsp;
<%
	} else {
%>
<span class="<%=style.getListOrderBy()%>">
<xava:link action='List.orderBy' argv='<%="property="+property.getQualifiedName() + collectionArgv%>'><%=property.getQualifiedLabel(request)%></xava:link>&nbsp;
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
	<xava:image action="List.moveColumnToRight" argv='<%="columnIndex="+columnIndex+collectionArgv%>'/>
	<xava:image action="List.removeColumn" argv='<%="columnIndex="+columnIndex+collectionArgv%>'/>
<% }
 
%>
</th>
<%
	columnIndex++;
}
%>
</tr>
<% if (filter) { %>
<tr id="xava-tr-list-filter-<%=id%>" class=<%=style.getListSubheader()%> style="display: <%=displayFilter%>"> 
<th class=<%=style.getListSubheaderCell()%> style="text-align: center" width="60">
<xava:action action="List.filter" argv="<%=collectionArgv%>"/>
</th>
<th class=<%=style.getListSubheaderCell()%> width="5">
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
		int length = Math.min(isString?property.getSize()*4/5:property.getSize(), 20);
		String value= conditionValues==null?"":conditionValues[iConditionValues];
		String comparator = conditionComparators==null?"":Strings.change(conditionComparators[iConditionValues], "=", "eq");
		iConditionValues++;
		if (isValidValues) {
	%>	
<th class=<%=style.getListSubheaderCell()%> align="left">
<%-- Boolean.toString( ) for base0 is needed in order to work in WebSphere 6 --%>
<jsp:include page="comparatorsValidValuesCombo.jsp">
	<jsp:param name="validValues" value="<%=property.getValidValuesLabels(request)%>" />
	<jsp:param name="value" value="<%=value%>" />
	<jsp:param name="base0" value="<%=Boolean.toString(!property.isNumber())%>" />
	<jsp:param name="prefix" value="<%=prefix%>"/>
</jsp:include>		
	<%	
		}
		else if (isBoolean) { 
	%>
<th class=<%=style.getListSubheaderCell()%> align="left">
<jsp:include page="comparatorsBooleanCombo.jsp">
	<jsp:param name="comparator" value="<%=comparator%>" />
	<jsp:param name="prefix" value="<%=prefix%>"/>
</jsp:include>
	<% } else { // Not boolean %>
<th class=<%=style.getListSubheaderCell()%> align="left">
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
<th class=<%=style.getListSubheaderCell()%>></th>
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
	String cssCellClass=f%2==0?style.getListPairCell():style.getListOddCell(); 
	String cssStyle = tab.getStyle(f);
	if (cssStyle != null) {
		cssClass = cssClass + " " + cssStyle; 
		if (style.isApplySelectedStyleToCellInList()) cssCellClass = cssCellClass + " " + cssStyle; 
	}
	String events=f%2==0?style.getListPairEvents(cssStyle):style.getListOddEvents(cssStyle);	
%>
<tr id="xava-tr-list" class="<%=cssClass%>" <%=events%> style="border-bottom: 1px solid;">
	<td class="<%=cssCellClass%>" style='vertical-align: middle;text-align: center'>
<% if (!org.openxava.util.Is.emptyString(action)) { %>
<xava:action action='<%=action%>' argv='<%="row=" + f + actionArgv%>'/>
<% } %>
	</td>
	<td class="<%=cssCellClass%>">
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
	<td class="<%=cssCellClass%>" <%=align%>><%=fvalue%>&nbsp;</td>
<%
	}
%>
</tr>
<%
}

}
else {
%>
<tr id="nodata"><td class="<%=totalSize==0?style.getMessages():style.getErrors()%>">
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
<table width="100%" class="<%=style.getListInfo()%>">
<tr class='<%=style.getListInfoDetail()%>'>
<td class='<%=style.getListInfoDetail()%>' style='vertical-align: middle'>
<%
int last=tab.getLastPage();
int current=tab.getPage();
if (current > 1) {
%>
<xava:image action='List.goPreviousPage' argv='<%=collectionArgv%>'/>
<% } 
for (int i=1; i<=last; i++) {
if (i == current) {
%>	 
 <b><%=i%></b>
<% } else { %>
 <xava:link action='List.goPage' argv='<%="page=" + i + collectionArgv%>'><%=i%></xava:link>
<% }} 
if (!tab.isLastPage()) {
%>
 <xava:image action='List.goNextPage' argv='<%=collectionArgv%>'/> 
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
