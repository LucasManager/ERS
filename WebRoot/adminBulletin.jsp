<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<LINK href="css/calendar.css" type="text/css" rel="stylesheet" />
<meta name="keywords" content="admin,bulletin" />
<title><fmt:message key="module.admin.bulletin.displayname"/></title>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/adminnav.jsp" %>
</td>
<td valign="top" width="90%">
	<table cellSpacing=0 cellPadding=0 border="0" >
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="module.admin.bulletin.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr class="WPBody">
		<td><a href="adminBulletin.do?method=get" class="btn"><fmt:message key="button.query.displayname"/></a></td>
		<td><a href="adminBulletin.jsp?method=add" class="btn"><fmt:message key="button.add.displayname"></fmt:message></a></td> 
	</tr>
	</table>
	<html:messages id="msg" message="true" property="delNewsMSG" header="messages.header" footer="messages.footer">${msg}</html:messages>
	<hr></hr>
	<c:if test="${param.method=='add'}">
	<html:form action="/adminBulletin" method="post" styleClass="setForm">
		<table>
		<tr><td></td><td><html:hidden property="id"/><html:errors property="id"/></td></tr>
		<tr><td><fmt:message key="news.groupName.displayname"/>:</td><td>
				<html:select property="groupid">
					<html:option value="-1">None</html:option>
					<html:option value="0">All</html:option>
					<html:option value="1">Admin</html:option>
					<html:option value="2">Client</html:option>
					<html:option value="3">Depot</html:option>
					<html:option value="4">Guest</html:option>
				</html:select>
				<html:errors property="groupid"/></td></tr>
		<tr><td><fmt:message key="news.userFullName.displayname"/>:</td><td>
				<html:select property="userid">
					<html:option value="0">None</html:option>
					<html:options collection="users" property="userid" labelProperty="username"/>
				</html:select> <html:errors property="userid"/></td></tr>
		<tr><td><fmt:message key="news.location.displayname"/>:</td><td>
				<html:select property="location">
					<html:option value="">All</html:option>
				</html:select>
				<html:errors property="location"/></td></tr>
		<tr><td><fmt:message key="news.brief.displayname"/>*:</td><td><html:text property="brief"/><html:errors property="brief"/></td></tr>
		<tr><td><fmt:message key="news.content.displayname"/>*:</td><td><html:textarea property="content" cols="50" rows="4"/><html:errors property="content"/></td></tr>
		<tr><td><fmt:message key="news.ismandatory.displayname"/>:</td><td>
				<html:select property="isMandatory">
					<html:option value="1"><fmt:message key="keywords.true"/> </html:option>
					<html:option value="o"><fmt:message key="keywords.false"/> </html:option>
				</html:select>
				<html:errors property="isMandatory"/></td></tr>
		<tr><td><fmt:message key="news.begdate.displayname"/>*:</td><td><html:text property="begDate" onfocus="showCalendarControl(this);" /><html:errors property="begDate"/></td></tr>
		<tr><td><fmt:message key="news.enddate.displayname"/>*:</td><td><html:text property="endDate" onfocus="showCalendarControl(this);" /><html:errors property="endDate"/></td></tr>
		</table>
		<input type="hidden" name="method" value="add"/>
		<input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
		<html:submit onclick="if(!smtCfm(adminBulletinForm)){return false;}" styleClass="button"><fmt:message key="button.submit.displayname"/></html:submit>
	</html:form>
	</c:if>
	<input id="cfmStr" type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
	<table class="listable">
	<tr>
		<th><fmt:message key="function.displayname"/></th>
		<th><fmt:message key="news.groupName.displayname"/></th>
		<th><fmt:message key="news.userFullName.displayname"/></th>
		<th><fmt:message key="news.location.displayname"/></th>
		<th><fmt:message key="news.brief.displayname"/></th>
		<th><fmt:message key="news.content.displayname"/></th>
		<th><fmt:message key="news.ismandatory.displayname"/></th>
		<th><fmt:message key="news.begdate.displayname"/></th>
		<th><fmt:message key="news.enddate.displayname"/></th>
		<th><fmt:message key="news.updatetime.displayname"/></th>
		<th><fmt:message key="news.updateuser.displayname"/></th>
	</tr>
	<c:forEach items="${allNewses}" var="news" varStatus="status">
	<tr align="center">
		<td><a href="<c:url value='adminBulletin.do'><c:param name='id' value='${news.id}'/><c:param name='method' value='delete'/></c:url>" target="_parent"><img src="image/delete.jpg" onclick="if(!smtCfm()){return false;}" title="Delete"/></a> </td>
		<td>${news.groupName}</td>
		<td>${news.userFullName}</td>
		<td>${news.location}</td>
		<td>${news.brief}</td>
		<td>${news.content}</td>
		<td><c:if test="${news.isMandatory==1}"><fmt:message key="keywords.true"/></c:if>
			<c:if test="${news.isMandatory==0}"><fmt:message key="keywords.false"/></c:if></td>
		<td><fmt:formatDate value="${news.begDate}" pattern="${dateFormat}"/></td>
		<td><fmt:formatDate value="${news.endDate}" pattern="${dateFormat}"/></td>
		<td><fmt:formatDate value="${news.updateTime}" pattern="${datetimeFormat}"/></td>
		<td>${news.updateUser}</td>
	</tr>
	</c:forEach>
	</table>
</td>
</tr>
</table>
