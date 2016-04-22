<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<%@page import="com.apl.sha.ers.model.PendingCtn;"%>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.depot.displayname"/></title>
<meta name="keywords" content="application,depot" />
<style type="text/css">
<!--
.itable {
	border-right: 1px solid #ccc;
	border-left: 1px solid #ccc;
}
.itrh {
    background-image:url(image/tr_back.gif);
}
.itdh {
    border-bottom: 1px solid #ccc;
	font-size:15px;
	color:#CCCCCC;
	font-weight:bold;
	padding-left:10px;
}
.itrc {
    background-image:url(image/grid-blue-hd.gif);
}
.itdc {
    font-size:12px; 
	color:#663333;
	text-align:center;
	border-bottom: 1px solid #ccc;
	border-top:1px solid #ccc;
	border-right:1px solid #ccc;
}
.itdc2 {
    font-size:12px; 
	color:#663333;
	text-align:center;
	border-bottom: 1px solid #ccc;
	border-top:1px solid #ccc;
}
.itdrow {
    font-size:12px; 
	color:#000000;
	text-align:center;
	border-bottom:1px solid #ccc;
	border-right:1px solid #ccc;
}
.itdrow2 {
    font-size:12px; 
	color:#000000;
	text-align:center;
	border-bottom:1px solid #ccc;
}
-->
</style>
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top">
		<div class="WPTitle">
		<NOBR>
		<SPAN> 
		<a href="<c:url value='depot.jsp'></c:url>"><img src="image/return.gif" title='<fmt:message key="button.return.displayname"/>'/></a>
		</SPAN>
		</NOBR>
		</div>

	<table width="500" border="0" cellspacing="0" cellpadding="0" class="itable">
	  <tr class="itrc">
	    <td height="20" class="itdc"><fmt:message key="booking.blnumber.displayname"/></td>
	    <td class="itdc"><fmt:message key="booking.portofloadingcode.displayname"/></td>
	    <td class="itdc"><fmt:message key="booking.status.passedtime.displayname"/></td>
	    <td class="itdc"><fmt:message key="booking.container.ctncode.displayname"/></td>
	    <td class="itdc"><fmt:message key="booking.container.intlcode.displayname"/></td>
	    <td class="itdc2"><fmt:message key="booking.container.ctnqty.displayname"/></td>
	  </tr>
	  <c:forEach items="${PendingCtns}" var="PendingCtns" varStatus="status">
	  <tr>
	    <td height="20" class="itdrow">${PendingCtns.blnumber}&nbsp;</td>
	    <td class="itdrow">${PendingCtns.loadingcode}&nbsp;</td>    
	    <td class="itdrow">${PendingCtns.passedtime}&nbsp;</td>
	    <td class="itdrow">${PendingCtns.ctncode}&nbsp;</td>
	    <td class="itdrow">${PendingCtns.intlcode}&nbsp;</td>
	    <td class="itdrow2">${PendingCtns.ctnqty}&nbsp;</td>
	  </tr>
	  </c:forEach>
  </table>
</td>
</tr>	
</table>