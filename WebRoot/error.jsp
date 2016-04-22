<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<head>
	<title><fmt:message key="page.error.displayname" /></title>
</head>
<body>
	<table>
	<tr>
	<td height="100%" width="190" valign="top"><IMG src="<fmt:message key='error.iamge.path'/>"/></td>
	<td ><h3 class="ErrorData">
		<html:errors property="error"/>
		</h3>
		<a href="<c:url value='${returnPath }'/>" class="test"><fmt:message key="error.return.displayname" /></a>
		</td>
	</tr>
	</table>
</body>
