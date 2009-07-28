<%@page import="org.openxava.controller.meta.MetaAction"%>
<%@page import="org.openxava.web.Ids"%>
<%@page import="org.openxava.controller.meta.MetaControllers"%>
<%@page import="org.openxava.util.Is"%>

<table id="<xava:id name='<%=idCollection%>'/>" class="<%=style.getList()%>" width="100%" <%=style.getListCellSpacing()%> style="<%=style.getListStyle()%>">
<tr class="<%=style.getListHeader()%>">
	<% if (lineAction != null) { %>	
	<th class=<%=style.getListHeaderCell()%>></th>
	<% } %>	
	<th class=<%=style.getListHeaderCell()%> width="5"></th>
<%
// Heading
Iterator it = subview.getMetaPropertiesList().iterator();
while (it.hasNext()) {
	MetaProperty p = (MetaProperty) it.next();
%>
	<th class=<%=style.getListHeaderCell()%>><%=p.getLabel(request)%>&nbsp;</th>
<%
}
%>
</tr>

<%
// Values
Collection aggregates = subview.getCollectionValues();
if (aggregates == null) aggregates = java.util.Collections.EMPTY_LIST;
Iterator itAggregates = aggregates.iterator();
int f=0;
while (itAggregates.hasNext()) {
	Map row = (Map) itAggregates.next();
	String cssClass=f%2==0?style.getListPair():style.getListOdd();
	String cssCellClass=f%2==0?style.getListPairCell():style.getListOddCell();
	String selectedClass = "";
	if (f == subview.getCollectionEditingRow()) { 
		selectedClass = f%2==0?style.getListPairSelected():style.getListOddSelected();
		cssClass = cssClass + " " + selectedClass;		
		if (style.isApplySelectedStyleToCellInList()) cssCellClass = cssCellClass + " " + selectedClass; 
	}		
	String events=f%2==0?style.getListPairEvents(selectedClass):style.getListOddEvents(selectedClass);
	String idRow = Ids.decorate(request, idCollection + "_" + f);
	String cssSelectedRow = style.getSelectedRow();
	String selectedRowStyle = style.getSelectedRowStyle();
	String rowStyle = "border-bottom: 1px solid;";
	String onSelectCollectionElementAction = subview.getOnSelectCollectionElementAction();
	MetaAction onSelectCollectionElementMetaAction = Is.empty(onSelectCollectionElementAction) ? null : MetaControllers.getMetaAction(onSelectCollectionElementAction);
%>
<tr id="<%=idRow%>" class="<%=cssClass%>" <%=events%> style="border-bottom: 1px solid;">
<% if (lineAction != null) { %>
<td class="<%=cssCellClass%>" style="vertical-align: middle;text-align: center;padding-right: 2px; <%=style.getListCellStyle()%>">
<xava:action action="<%=lineAction%>" argv='<%="row="+f + ",viewObject="+viewName%>'/>
</td>
<% } 
	String actionOnClick = "onClick=\"openxava.onSelectElement(" +
	"'" + request.getParameter("application") + "'," + 
	"'" + request.getParameter("module") + "'," + 
	"'" + onSelectCollectionElementAction + "'," + 
	"'row=" + f + ",viewObject=" + viewObject + "'," +
	"this.checked," + 
	"'" + idRow + "'," +  
	!Is.empty(subview.getOnSelectCollectionElementAction()) + "," +
	"'" + cssSelectedRow + "'," + 
	"'" + cssClass + "'," +
	"'" + selectedRowStyle + "'," +
	"'" + rowStyle + "'," +
	"'" + (Is.empty(onSelectCollectionElementMetaAction)?"":onSelectCollectionElementMetaAction.getConfirmMessage()) + "'," + 
	(Is.empty(onSelectCollectionElementMetaAction)?false:onSelectCollectionElementMetaAction.isTakesLong()) + 
	")\"";
%>
<td class="<%=cssCellClass%>" width="5" style="<%=style.getListCellStyle()%>">
<input type="CHECKBOX" name="<xava:id name='xava_selected'/>" value="<%=propertyPrefix%>__SELECTED__:<%=f%>" <%=actionOnClick%>/>
</td>
<%
	f++;
	it = subview.getMetaPropertiesList().iterator();
	while (it.hasNext()) {
		MetaProperty p = (MetaProperty) it.next();
		String align =p.isNumber() && !p.hasValidValues()?"vertical-align: middle;text-align: right; ":"vertical-align: middle; ";
		String cellStyle = align + style.getListCellStyle();
		String fvalue = null;
		Object value = null;
		String propertyName = p.getName();
		value = Maps.getValueFromQualifiedName(row, propertyName);
		if (p.hasValidValues()) {
			if (value instanceof Number) {
				fvalue = p.getValidValueLabel(request, ((Number) value).intValue());
			}
			else {
				// In this case value is a enum type
				fvalue = p.getValidValueLabel(request, value);
			}
		}
		else {
			fvalue = WebEditors.format(request, p, value, errors, view.getViewName(), true);	
		}
%>
	<td class="<%=cssCellClass%>" style="<%=cellStyle%>"><%=fvalue%>&nbsp;</td>
<%
	}
}
%>
</tr>
</table>