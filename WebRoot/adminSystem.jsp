<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<%@taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<LINK href="css/calendar.css" type="text/css" rel="stylesheet" />
<meta name="keywords" content="admin,system" />
<title><fmt:message key="module.admin.system.displayname"/></title>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/adminnav.jsp" %>
</td>
<td valign="top" width="85%">
	
	<table cellSpacing=0 cellPadding=0 border="0" >
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="refreshCache.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr class="WPBody"><td>
		<form action="refreshCache.do">
		<html:submit styleClass="button" ><fmt:message key="button.submit.displayname"/></html:submit> 
		<html:messages id="msg" message="true" property="refreshCacheMSG" header="messages.header" footer="messages.footer">${msg}</html:messages>
		</form>
	</td></tr>
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="adminAccount.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr class="WPBody"><td>
		<form action="getLogs.do" class="SetForm">
		<table>
		<tr><td><fmt:message key="user.username.displayname"/>:</td>
		<td><select name="userid"> 
			<option value="0">All</option>
			<c:forEach items="${users}" var="user">
				<option value="${user.userid }">${user.username }</option>
			</c:forEach>
		</select> </td></tr>
		<tr><td><fmt:message key="log.type.displayname"/>:</td>
		<td>
		<select name="type">
			<option value="all">All</option>
			<option value="INFO">INFO</option>
			<option value="WARN">WARN</option>
		</select></td></tr>
		<tr><td><fmt:message key="log.function.displayname"/>:</td>
		<td>
		<select name="function">
			<option value="All">All</option>
			<option value="setBookingCtnType">setBookingCtnType</option>
			<option value="setBookingCtns">setBookingCtns</option>
			<option value="setBookingCtnsStatus">setBookingCtnsStatus</option>
			<option value="setDepotCtns">setDepotCtns</option>
			<option value="setNews">setNews</option>
			<option value="setOneWayCtns">setOneWayCtns</option>
			<option value="setOverdueCtn">setOverdueCtn</option>
			<option value="setUser">setUser</option>
			<option value="setVessel">setVessel</option>
		</select></td></tr>
		<tr><td><fmt:message key="keywords.begDate"/>:</td>
		<td><input type="text" name="begDate" onfocus="showCalendarControl(this);" class="inputbox" size="10" maxlength="10"/><html:errors property="begDate"/></td></tr>
		<tr><td><fmt:message key="keywords.endDate"/>:</td>
		<td><input type="text" name="endDate" onfocus="showCalendarControl(this);" class="inputbox" size="10" maxlength="10"/><html:errors property="endDate"/></td></tr>
		<tr><td colspan="2"><html:submit styleClass="button" ><fmt:message key="button.submit.displayname"/></html:submit> </td>
		</tr>
		</table>
		</form>
	</td></tr>
	</table>
	
	<table class="listable" style="table-layout: fixed;">
	<tr>
		<th width="5%"><fmt:message key="log.username.displayname"/></th>
		<th width="10%"><fmt:message key="log.ipaddress.displayname"/></th>
		<th width="20%"><fmt:message key="log.function.displayname"/></th>
		<th width="5%"><fmt:message key="log.type.displayname"/></th>
		<th width="10%"><fmt:message key="log.eventime.displayname"/></th>
		<th width="30%"><fmt:message key="log.event.displayname"/></th>
		<th width="20%"><fmt:message key="log.comments.displayname"/></th>
	</tr>
	<c:forEach items="${logs}" var="log" varStatus="status">
		<c:choose>
			<c:when test="${status.index mod 2 ==0 }">
				<tr class="trOdd">
			</c:when>
			<c:otherwise><tr class="trEven"></c:otherwise>
		</c:choose>
		<td><c:out value="${log.username}"/></td>
		<td><c:out value="${log.ipaddress}"/></td>
		<td><c:out value="${log.function}"/></td>
		<td><c:out value="${log.type}"/></td>
		<td><fmt:formatDate value="${log.eventime}" pattern="${datetimeFormat}"/></td>
		<td><c:out value="${log.event}"/></td>
		<td><c:out value="${log.comments}"/></td>
	</c:forEach>	
	</table>

</td>
</tr>
</table>
