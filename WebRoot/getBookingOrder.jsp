<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.booking.displayname"/></title>
<meta name="keywords" content="Application,booking" />
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td>
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top">
 	<c:import url="${path }"></c:import>
</td>
</tr>	
</table>