
<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<cache:flush scope="session"/>
<%@page import="com.apl.sha.ers.struts.form.*" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<LINK href="css/calendar.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/setBookingCtnType.js"></script>
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.booking.displayname"/></title>
<meta name="keywords" content="application,depot" />
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top" width="60%">
		<html:form action="/setBookingCtnType" styleClass="SetForm" method="post">
		<span class="DataTitle"><fmt:message key="setBookingCtnType.function.displayname"/></span><br/><br/>
			<select id="ctntypeSelect">
				<c:forEach items="${ctntypes}" var="ctntype">
					<option value="${ctntype.value.ctncode}">${ctntype.key}</option>
				</c:forEach>
			</select><input type="button" value="<fmt:message key='button.add.displayname'/>" onclick="addCtn()" class="button"/>
				<table id="ctntable">
			<tr>
				<th><input type="checkbox" id="allchecks" onclick="allChecks(this)" checked="checked"/></th>
				<th><fmt:message key="booking.container.ctncode.displayname"/></th>
				<th><fmt:message key="booking.container.intlcode.displayname"/></th>				
				<th><fmt:message key="booking.container.ctnqty.displayname"/></th>
				<th></th>
			</tr>
			<c:forEach items="${setBookingCtnForm.rowIdList}" var="row" varStatus="status">
			<tr>
				<td><html:checkbox property="attribute(${row}_checked)"/></td>
				<td><html:text property="attribute(${row}_ctnCode)"  maxlength="10" size="8" readonly="true" styleClass="inputbox"/></td>
				<td><html:text property="attribute(${row}_intlCode)" maxlength="10" size="5" readonly="true" styleClass="inputbox"/></td>
				<td><html:text property="attribute(${row}_ctnQty)" size="5" maxlength="9" styleClass="inputbox"/></td>
				<td><html:errors property="${row}" /></td>
			</tr>
			</c:forEach>
			</table>
			<br/>
			<html:errors property="error"/><br/><br/><br/><br/>
			<input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
			<html:submit styleClass="button" onclick="if(!fnSubmit()){return false;}"><fmt:message key="button.submit.displayname"/></html:submit><html:cancel styleClass="button"><fmt:message key="button.cancel.displayname"/></html:cancel>
		</html:form>
</td>
</tr>
</table>