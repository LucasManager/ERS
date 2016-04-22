<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.booking.displayname"/></title>
<meta name="keywords" content="Application,booking" />
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top">
  <table cellSpacing="5" cellPadding=0 border="0">
	<tr>
		<th width="5%"></th>
		<th width="10%"></th>
		<th width="10%"></th>
		<th width="10%"></th>
		<th width="65%"></th>
	</tr>
  	<tr class="WPHeader">
		<td width="5%">
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getBookingCtnGroups.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
		<td width="95%" colspan="4" class="WPTitle" align="right">
		</td>
	</tr>
	</table>
	<table class="listable" style="table-layout: fixed;">
	<tr>
		<th width="5%"></th>
		<th width="5%"><fmt:message key="booking.container.depotcode.displayname"/></th>
		<th width="10%"><fmt:message key="booking.container.ctncode.displayname"/></th>
		<th width="10%"><fmt:message key="booking.container.status.displayname"/></th>
		<th width="5%"><fmt:message key="booking.container.ctnqty.displayname"/></th>
		<th width="60%"><fmt:message key="booking.container.blnumber.displayname"/></th>
	
	</tr>
	<c:forEach items="${bookingctngroups}" var="bookingCtnGroup" varStatus="status">
	<c:choose>
		<c:when test="${status.index mod 2 ==0 }">
		<tr class="trOdd">
		</c:when>
		<c:otherwise><tr class="trEven"></c:otherwise>
	</c:choose> 
		<td>${status.index+1 }</td>
		<td><c:out value="${bookingCtnGroup.depotCode}"/></td>
		<td><c:out value="${bookingCtnGroup.ctnCode}" /></td>
		<td><fmt:message key="booking.container.status.${bookingCtnGroup.status}.displayname"/></td>
		<td><c:out value="${bookingCtnGroup.ctnQty}" /></td>
		<td style="word-wrap: break-word;"><c:out value="${bookingCtnGroup.blnumbers}" escapeXml="false"/></td>
	</tr>
	</c:forEach>	
	</table>
</td>
</tr>	
</table>