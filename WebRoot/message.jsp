<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
	<title><fmt:message key="page.message.displayname" /></title>
</head>
<body>
	<table>
	<tr>
	<td width="30%"><IMG src=<fmt:message key="message.iamge.path"/> ></td>
	<td><div class="WPTitle">
		<h1 class="DataTitle">
			<fmt:message key="message.title.displayname"></fmt:message>
			<BR>
		</h1>
		</div>
	</td>
	</tr>
	<tr>
		<td></td>
		<td><h3 class="ErrorData">
		<fmt:message key="message.success.displayname"></fmt:message>
		</h3>
		<c:if test="${ returnPath==null}"><c:set scope="page" var="returnPath" value="${param.returnPath }"></c:set> </c:if>
		<a href="<c:url value='${returnPath }'/>"><fmt:message
				key="message.return.displayname" />
		</a>
		</td>
	</tr>
	</table>
</body>
