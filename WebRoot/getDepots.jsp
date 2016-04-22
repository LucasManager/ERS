<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.depot.displayname"/></title>
<meta name="keywords" content="application,depot" />
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top">
  <table cellSpacing="5" cellPadding=0 border="0" >
	<tr class="DataTitle">
		<td><fmt:message key="function.displayname"/></td>
		<td><fmt:message key="depot.depotcode.displayname"/></td>
		<td><fmt:message key="depot.location.displayname"/></td>
		<td><fmt:message key="depot.ename.displayname"/></td>
		<td><fmt:message key="depot.cname.displayname"/></td>
		<td><fmt:message key="depot.tel.displayname"/></td>
		<td><fmt:message key="depot.fax.displayname"/></td>
		<td><fmt:message key="depot.email.displayname"/></td>
		<td><fmt:message key="depot.contact.displayname"/></td>
	</tr>
	<c:forEach items="${depots}" var="depot">
	<tr class="DataBody">
		<td><a href="<c:url value='initSetDepot.do'><c:param name='depotcode' value='${ depot.value.depotcode }'/><c:param name='pagepath' value='/getDepots.jsp'/></c:url>"><img  src="image/modify.gif" title="<fmt:message key='function.modify.displayname'/>"/></a></td>
		<td><a href="<c:url value='getDepot.do'><c:param name='depotcode' value='${ depot.value.depotcode }'></c:param></c:url>"><c:out value="${depot.value.depotcode}"/></a></td>
		<td><c:out value="${depot.value.location}"/></td>
		<td><c:out value="${depot.value.ename}"/></td>
		<td><c:out value="${depot.value.cname}"/></td>
		<td><c:out value="${depot.value.tel}"/></td>
		<td><c:out value="${depot.value.fax}"/></td>
		<td><c:out value="${depot.value.email}"/></td>
		<td><c:out value="${depot.value.contact}"/></td>
	</tr>
	</c:forEach>	
	</table>
</td>
</tr>	
</table>