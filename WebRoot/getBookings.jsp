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
  <table cellSpacing="5" cellPadding=0 border="0" >
  	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getBookings.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
		<td colspan="4" class="WPTitle" align="right">
		<table>
			<tr>
			<td class="WPTitle" align="left">
				<c:choose>
					<c:when test="${paging.page>=2 }">
						<a href="<c:url value='getBookings.do'><c:param name='page' value='1'></c:param><c:param name='size' value='${paging.size}'></c:param><c:param name='days' value='${param.days}'></c:param><c:param name='vessel' value='${param.vessel}'></c:param><c:param name='dest' value='${param.dest}'></c:param></c:url>"><<</a>&nbsp
						<a href="<c:url value='getBookings.do'><c:param name='page' value='${paging.page-1}'></c:param><c:param name='size' value='${paging.size}'></c:param><c:param name='days' value='${param.days}'></c:param><c:param name='vessel' value='${param.vessel}'></c:param><c:param name='dest' value='${param.dest}'></c:param></c:url>"><</a>
					</c:when>
					<c:otherwise>
						<<&nbsp<
					</c:otherwise>
				</c:choose>
			</td>
			<td class="WPTitle" align="right">
				
				<c:forEach var="x" begin="${paging.beginPage }" end="${paging.endPage }" step="1">
					<c:choose>
					<c:when test="${x!=paging.page }">
						<a href="<c:url value='getBookings.do'><c:param name='page' value='${x}'></c:param><c:param name='size' value='${paging.size}'></c:param><c:param name='days' value='${param.days}'></c:param><c:param name='vessel' value='${param.vessel}'></c:param><c:param name='dest' value='${param.dest}'></c:param></c:url>">${x}</a>
					</c:when>
					<c:otherwise>
						${x}
					</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${paging.page<paging.pages }">
						<a href="<c:url value='getBookings.do'><c:param name='page' value='${paging.page+1}'></c:param><c:param name='size' value='${paging.size}'></c:param><c:param name='days' value='${param.days}'></c:param><c:param name='vessel' value='${param.vessel}'></c:param><c:param name='dest' value='${param.dest}'></c:param> </c:url>">></a>&nbsp 
						<a href="<c:url value='getBookings.do'><c:param name='page' value='${paging.pages }'></c:param><c:param name='size' value='${paging.size}'></c:param><c:param name='days' value='${param.days}'></c:param><c:param name='vessel' value='${param.vessel}'></c:param><c:param name='dest' value='${param.dest}'></c:param> </c:url>">>></a>
					</c:when>
					<c:otherwise>
						>&nbsp>>
					</c:otherwise>
				</c:choose>
				<fmt:message key="Paging.total.displayname"/>: ${paging.total }/
				<fmt:message key="Paging.pages.displayname"/>: ${paging.pages }
			</td>
			</tr>
		</table>
		</td>
	</tr>
	</table>
	<table class="listable" style="table-layout: fixed;">
	<tr>
		<th width="2%"></th>
		<th width="8%"><fmt:message key="booking.blnumber.displayname"/></th>
		<th width="5%"><fmt:message key="booking.blockcode.displayname"/></th>
		<th width="25%"><fmt:message key="booking.vesselname.displayname"/>-<fmt:message key="booking.voyage.displayname"/></th>
		<th width="6%"><fmt:message key="booking.container.ctncode.displayname"/></th>
		<th width="2%"><fmt:message key="booking.container.ctnqty.displayname"/></th>		
		<th width="30%"><fmt:message key="booking.container.depotcname.displayname"/></th>
		<th width="12%"><fmt:message key="booking.status.passedtime.displayname"/></th>
	
	</tr>
	<c:forEach items="${bookings}" var="booking" varStatus="status">
		<c:set var="tmpSeq" value="1" ></c:set>
	<c:forEach items="${booking.ctns}" var="ctn">
	<c:choose>
		<c:when test="${status.index mod 2 ==0 }">
		<tr class="trOdd">
		</c:when>
		<c:otherwise><tr class="trEven"></c:otherwise>
	</c:choose> 
		<c:choose>
		<c:when test="${tmpSeq==1}">
		<td>${status.index+1 }</td>
		<td><a href="<c:url value='getBooking.do'><c:param name='blnumber' value='${ booking.blnumber }'></c:param></c:url>"><c:out value="${booking.blnumber}"/></a></td>
		<td><c:out value="${booking.blockcode}" /></td>
		<td><c:out value="${booking.vesselname}-${booking.voyage }" /></td>
		<td><c:out value="${ctn.value.ctnCode }"/> </td>
		<td><c:out value="${ctn.value.ctnQty }"/> </td>
		<td><c:out value="${ctn.value.depotCname }"/> </td>
		<td>
			<fmt:formatDate value="${booking.status.passedTime}" pattern="${datetimeFormat}"/>
			<c:if test="${booking.status.passedTime==null}"><fmt:message key="booking.status.unpassed.displayname"/></c:if>
		</td>
		<c:set var="tmpSeq" value="0" ></c:set>
		</c:when>
		<c:otherwise>
		<td>${status.index+1 }</td>
		<td></td>
		<td></td>
		<td></td>
		<td><c:out value="${ctn.value.ctnCode }"/> </td>
		<td><c:out value="${ctn.value.ctnQty }"/> </td>
		<td><c:out value="${ctn.value.depotCname }"/> </td>
		<td></td>
		</c:otherwise>
		</c:choose>
	</tr>
	</c:forEach>
	</c:forEach>	
	</table>
</td>
</tr>	
</table>