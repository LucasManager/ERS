<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<LINK href="css/calendar.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/setDepotCtn.js"></script>
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.depot.displayname"/></title>
<meta name="keywords" content="application,depot" />
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top" width="60%">
		<html:form action="/setDepotCtn" styleClass="SetForm" method="post">
			<table id="ctntable">
			<tr>
				<th><input type="checkbox" id="allchecks" onclick="allChecks(this)" checked="checked"/></th>
				<th><fmt:message key="depot.container.ctntype.displayname"/></th>
				<th><fmt:message key="depot.container.initaldate.displayname"/></th>
				<th><fmt:message key="depot.container.initalqty.displayname"/></th>
				<th></th>
			</tr>
			<c:forEach items="${setDepotCtnForm.rowIdList}" var="row" varStatus="status">
			<tr>
				<td><html:checkbox property="attribute(${row}_checked)"/></td>
				<td><html:hidden property="attribute(${row}_id)"/>${row}</td>
				<td><html:text property="attribute(${row}_initalDate)" onfocus="showCalendarControl(this);" styleClass="inputbox" size="10" maxlength="10"/></td>
				<td><html:text property="attribute(${row}_initalQty)" size="5" maxlength="9" styleClass="inputbox"/></td>
				<td><html:errors property="${row}" /></td>
			</tr>
			</c:forEach>
			</table>
			<br/>
			<select id="ctntypeSelect">
				<c:forEach items="${ctncodes}" var="ctncode">
					<option value="${ctncode.key}">${ctncode.key}</option>
				</c:forEach>
			</select> <input type="button" value="<fmt:message key='button.add.displayname'/>" onclick="addCtn()" class="button"/>
			<br/><br/><br/><br/><br/>
			<input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
			<html:submit styleClass="button" onclick="if(!fnSubmit()){return false;}"><fmt:message key="button.submit.displayname"/></html:submit><html:cancel styleClass="button"><fmt:message key="button.cancel.displayname"/></html:cancel>
		</html:form>
</td>
</tr>
</table>

