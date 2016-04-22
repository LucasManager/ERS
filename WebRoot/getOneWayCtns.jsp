<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<%@page import="com.apl.sha.ers.model.OneWayCtn" %>
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
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getOneWayCtns.function.displayname"/>
		<a href="<c:url value='setOneWayCtn.jsp?function=add'></c:url>"><img src="image/add.gif" title='<fmt:message key="button.add.displayname"/>'/></a>
		</SPAN>
		</NOBR>
		</div>
  <table cellSpacing="5" cellPadding=0 border="0" >
	<tr class="DataTitle">
		<th>ID</th>
		<th><fmt:message key="depot.location.displayname"/></th>
		<th><fmt:message key="booking.container.ctncode.displayname"/></th>
		<th><fmt:message key="booking.placeofdeliverycode.displayname"/></th>
		<th><fmt:message key="depot.depotcode.displayname"/></th>
		<th><fmt:message key="keywords.valid"/></th>
	</tr>
	<c:forEach items="${oneWayCtns}" var="oneWayCtn" varStatus="status">
	<tr class="DataBody">
		<td><a href="<c:url value='setOneWayCtn.jsp'><c:param name='seq' value='${status.index}'/></c:url>"><img src="image/modify.gif" title="<fmt:message key='function.modify.displayname'/>"/></a></td>
		<td>${oneWayCtn.location}</td>
		<td>${oneWayCtn.ctnCode}</td>
		<td>${oneWayCtn.dest}</td>
		<td>${oneWayCtn.depotCode}</td>
			<c:set value="${oneWayCtn.status}" var="st" scope="page"></c:set>
			
		<td><c:choose>
			<c:when test="${oneWayCtn.status}">
			<img src="image/yes.gif"/>
			</c:when>
			<c:otherwise>
			<img src="image/no.gif"/>
			</c:otherwise>
			</c:choose>
		</td>
	</tr>
	</c:forEach>	
	</table>
</td>
</tr>	
</table>