<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<%@page import="com.apl.sha.ers.model.BlockCodeUpdate" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.booking.displayname"/></title>
<meta name="keywords" content="application,booking" />
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
		<fmt:message key="getBlockCodeUpdate.function.displayname"/>
		<a href="<c:url value='setBlockCodeUpdate.jsp?function=add'></c:url>"><img src="image/add.gif" title='<fmt:message key="button.add.displayname"/>'/></a>
		</SPAN>
		</NOBR>
		</div>
  <table cellSpacing="4" cellPadding=0 border="0" >
	<tr class="DataTitle">
		<th>ID</th>
		<th><fmt:message key="vessel.svcname.displayname"/></th>
		<th><fmt:message key="booking.portofloadingcode.displayname"/></th>
		<th><fmt:message key="booking.blockcode.displayname"/></th>
	</tr>
	<c:forEach items="${BlockCodeUpdates}" var="BlockCodeUpdates" varStatus="status">
	<tr class="DataBody">
		<td><a href="<c:url value='setBlockCodeUpdate.jsp'><c:param name='seq' value='${status.index}'/></c:url>"><img src="image/modify.gif" title="<fmt:message key='function.modify.displayname'/>"/></a></td>
		<td>${BlockCodeUpdates.svcname}</td>
		<td>${BlockCodeUpdates.portofloadingcode}</td>
		<td>${BlockCodeUpdates.block_code}</td>
	</tr>
	</c:forEach>	
	</table>
</td>
</tr>	
</table>