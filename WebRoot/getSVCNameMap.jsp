<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<%@page import="com.apl.sha.ers.model.SVCNameMap" %>
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
		<fmt:message key="getSVCNameMap.function.displayname"/>
		<a href="<c:url value='setSVCNameMap.jsp?function=add'></c:url>"><img src="image/add.gif" title='<fmt:message key="button.add.displayname"/>'/></a>
		</SPAN>
		</NOBR>
		</div>
  <table cellSpacing="5" cellPadding=0 border="0" >
	<tr class="DataTitle">
		<th>ID</th>
		<th><fmt:message key="vessel.svcname.displayname"/></th>
		<th><fmt:message key="booking.portofloadingcode.displayname"/></th>
		<th><fmt:message key="booking.Placeofreturn.displayname"/></th>
	</tr>
	<c:forEach items="${SVCNameMaps}" var="SVCNameMaps" varStatus="status">
	<tr class="DataBody">
		<td height="10"><a href="<c:url value='setSVCNameMap.jsp'><c:param name='seq' value='${status.index}'/></c:url>"><img src="image/modify.gif" width="16" height="16" title="<fmt:message key='function.modify.displayname'/>"/></a></td>
		<td align='center'>${SVCNameMaps.svcname}</td>
		<td align='center'>${SVCNameMaps.portofloadingcode}</td>
		<td>${SVCNameMaps.placeofreturn}</td>
	</tr>
	</c:forEach>	
	</table>
</td>
</tr>	
</table>