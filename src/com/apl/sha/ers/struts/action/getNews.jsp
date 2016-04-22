<%@ include file="/WebRoot/WEB-INF/jsp/taglib.jsp" %>
<head>
	<title><fmt:message key="module.news.displayname" /></title>
	<LINK href="css/main.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<table>
	<c:forEach items="${newses}" var="news">
		<c:if test="${news.value.id==param.newsID }">
			<tr>
			<td width="30%" rowspan="2"><img src="image/news.gif"/></td>
			<td><div class="WPTitle">
				<h1 class="DataTitle" >
					<c:out value="${news.value.brief}"></c:out>
					<BR>
				</h1>
				</div>
			</td>
			</tr>
			<tr>
				<td>
				<c:out value="${news.value.content}"></c:out>
				</td>
			</tr>
		</c:if>
		</c:forEach>
	</table>
</body>
