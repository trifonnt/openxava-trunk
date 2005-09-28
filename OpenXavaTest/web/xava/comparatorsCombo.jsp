<%@ include file="imports.jsp"%>

<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>

<%
String comparator = request.getParameter("comparator");
boolean isString = "true".equals(request.getParameter("isString"));
boolean isDate = "true".equals(request.getParameter("isDate"));
String eq = "eq".equals(comparator)?"selected='selected'":"";
String ne = "ne".equals(comparator)?"selected='selected'":"";
String ge = "ge".equals(comparator)?"selected='selected'":"";
String le = "le".equals(comparator)?"selected='selected'":"";
String gt = "gt".equals(comparator)?"selected='selected'":"";
String lt = "lt".equals(comparator)?"selected='selected'":"";
String startsWith = "starts_comparator".equals(comparator)?"selected='selected'":"";
String contains = "contains_comparator".equals(comparator)?"selected='selected'":"";
String year = "year_comparator".equals(comparator)?"selected='selected'":"";
String month = "month_comparator".equals(comparator)?"selected='selected'":"";
%>

<select name="conditionComparators" class=<%=style.getEditor()%>>
	<%
	if (isString) {
	%>						
	<option value="starts_comparator" <%=startsWith%>><fmt:message key="starts_comparator"/></option>
	<option value="contains_comparator" <%=contains%>><fmt:message key="contains_comparator"/></option>
	<%
	}
	%>
	<option value="eq" <%=eq%>>=</option>
	<option value="ne" <%=ne%>><></option>
	<option value="ge" <%=ge%>>>=</option>
	<option value="le" <%=le%>><=</option>	
	<option value="gt" <%=gt%>>></option>
	<option value="lt" <%=lt%>><</option>
	<%
	if (isDate) {
	%>
	<option value="year_comparator" <%=year%>><fmt:message key="year_comparator"/></option>
	<option value="month_comparator" <%=month%>><fmt:message key="month_comparator"/></option>
	<%
	}	
	%>
</select>	
	