<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title>Application-Depot</title>
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td>
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top">
  <table cellSpacing="5" cellPadding=0 border="0" >
	<tr class="DataTitle">
		<td><fmt:message key="depot.id.displayname"/></td>
		<td><fmt:message key="depot.depotcode.displayname"/></td>
		<td><fmt:message key="depot.location.displayname"/></td>
		<td><fmt:message key="depot.ename.displayname"/></td>
		<td><fmt:message key="depot.cname.displayname"/></td>
		<td><fmt:message key="depot.tel.displayname"/></td>
		<td><fmt:message key="depot.email.displayname"/></td>
		<td><fmt:message key="depot.contact.displayname"/></td>
	</tr>
	<tr class="DataBody">
		<td><c:out value="${depot.id}"/></td>
		<td><c:out value="${depot.depotcode}"/></td>
		<td><c:out value="${depot.location}"/></td>
		<td><c:out value="${depot.ename}"/></td>
		<td><c:out value="${depot.cname}"/></td>
		<td><c:out value="${depot.tel}"/></td>
		<td><c:out value="${depot.email}"/></td>
		<td><c:out value="${depot.contact}"/></td>
	</tr>
	<tr  class="DataTitle">
		<td colspan="8"><fmt:message key="depot.eaddress.displayname"/></td>
	</tr>
	<tr class="DataBody">
		<td colspan="8"><c:out value="${depot.eaddress}"/></td>
	</tr>
	<tr  class="DataTitle">
		<td colspan="8"><fmt:message key="depot.caddress.displayname"/></td>
	</tr>
	<tr class="DataBody">
		<td colspan="8"><c:out value="${depot.caddress}"/></td>
	</tr>
	</table>
	<table>
	<tr class="DataTitle">
		<td><fmt:message key="depot.container.ctntype.displayname"/></td>
		<td><fmt:message key="depot.container.volume.displayname"/></td>
		<td><fmt:message key="depot.container.initaltime.displayname"/></td>
		<td><fmt:message key="depot.container.updatetime.displayname"/></td>
	</tr>
	<c:forEach items="${depot.containers}" var="ctn">
	<tr class="DataBody">
		<td><c:out value="${ctn.value.ctnType}"/></td>
		<td><c:out value="${ctn.value.volume}"/></td>
		<td><fmt:formatDate value="${ctn.value.initaltime}" pattern="${dateFormat}"/></td>
		<td><fmt:formatDate value="${ctn.value.updatetime}" pattern="${dateFormat}"/></td>
	</tr>
	</c:forEach>	
	</table>
</td>
</tr>	
</table>