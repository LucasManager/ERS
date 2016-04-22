<%@include file="/WEB-INF/jsp/taglib.jsp" %>
<%@taglib uri="/WEB-INF/fn.tld" prefix="fn"%>
<head>
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.booking.displayname"/></title>
<LINK href="css/main.css?v=20151110" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/getBookingCtn.js?v=20151299"></script>
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
  	<tr><td>
  		<table>
  		<tr>
	  		<td colspan="1" class="DataTitle"><fmt:message key="booking.blnumber.displayname"/>:</td>
	  		<td colspan="2" class="BlockCodeDataBody"><c:out value="${booking.blnumber }"/></td>
			<td colspan="1" class="DataTitle"><fmt:message key="booking.placeofdeliverycode.displayname"/>:</td>
			<td colspan="2" class="BlockCodeDataBody"><c:out value="${booking.placeofdeliverycode}"/></td>
			<td colspan="1" class="DataTitle"><fmt:message key="booking.blockcode.displayname"/>:</td>
			<td colspan="2" class="BlockCodeDataBody"><c:out value="${booking.blockcode}"/></td>
			<td align="center"><ers:priv privName="setBookingCtnAction"><a href="setBookingCtn.jspf" ><img  src="image/modify.gif" title="<fmt:message key='setBookingCtn.function.displayname'/>"/></a></ers:priv></td>
			<td align="center"><ers:priv privName="setBookingCtnAction">|</ers:priv></td>
			<td align="center"><ers:priv privName="setBookingCtnAction"><a href="setBookingCtnType.jspf" ><img  src="image/modify.gif" title="<fmt:message key='setBookingCtnType.function.displayname'/>"/></a></ers:priv></td>
			
		</tr>
		<tr>
	  		<td colspan="1" class="DataTitle"><fmt:message key="booking.vesselname.displayname"/>:</td>
	  		<td colspan="5" class="VesselNameDataBody"><c:out value="${booking.vesselname }"/></td>
	  		<td colspan="1" class="DataTitle"><fmt:message key="booking.voyage.displayname"/>:</td>
			<td colspan="2" class="VesselNameDataBody"><c:out value="${fn:substring(booking.vslvoyid, 4, -1)}"/></td>
			<td colspan="3"></td>
		</tr>		
		<tr>
			<td colspan="1" class="DataTitle"><fmt:message key="booking.tempdefine.displayname"/>:</td>
	  		<td colspan="2" class="BlockCodeDataBody"><c:out value="${booking.tempdefine }"/></td>
			<td colspan="1" class="DataTitle"><fmt:message key="booking.airrate.displayname"/>:</td>
			<td colspan="2" class="BlockCodeDataBody"><c:out value="${booking.airrate}"/></td>
			<td colspan="6"></td>
		</tr>
		<tr>
			<td colspan="1" class="DataTitle"><fmt:message key="booking.settemp.displayname"/>:</td>
	  		<td colspan="2" class="BlockCodeDataBody"><c:out value="${booking.settemp }"/></td>
			<td colspan="1" class="DataTitle"><fmt:message key="booking.maxtemp.displayname"/>:</td>
			<td colspan="2" class="BlockCodeDataBody"><c:out value="${booking.maxtemp}"/></td>
			<td colspan="1" class="DataTitle"><fmt:message key="booking.mintemp.displayname"/>:</td>
			<td colspan="2" class="BlockCodeDataBody"><c:out value="${booking.blockcode}"/></td>
			<td colspan="3"></td>
		</tr>
  		</table>
  		</td>
	</tr>
	<tr valign="top">
	<td>
	<form action="setBookingCtnStatus.do"  name="setBookingCtnStatusForm"  method="post">
	<table>
		<tr class="DataTitle">
		<th><input type="checkbox" id="allchecks" onclick="allChecks(this)"/></th>
		<th><fmt:message key="booking.container.ctntype.displayname"/></th>
		<th><fmt:message key="booking.container.intlcode.displayname"/></th>
		<th><fmt:message key="booking.container.ctnqty.displayname"/></th>
		<th><fmt:message key="booking.container.depotcname.displayname"/></th>
		</tr>
		<ers:priv privName="SetBookingCtnStatusAction" privParam="P" var="setCtnPStatus">
		</ers:priv>
		<ers:priv privName="SetBookingCtnStatusAction" privParam="R" var="setCtnRStatus">
		</ers:priv>
	<c:forEach items="${bkgCtnGroup}" var="ctnGroup" >
		
		<tr class="DataBody">
		<td><a href="#" ><img  src="image/modify.gif"  onclick="showCtnList('${ctnGroup.value.depotCode}${ctnGroup.value.ctnCode}')" title="<fmt:message key='function.modify.displayname' />"/></a></td>
		<td>${ctnGroup.value.ctnCode}</td>
		<td></td>
		<c:choose>
			<c:when test="${ctnGroup.value.ctnQty !=0}">
   				<td><c:out value="${ctnGroup.value.ctnQty}"/></td>
  			</c:when>
   			<c:otherwise> 
				<td><c:out value="${ctnGroup.value.numbers}"/></td>
 			</c:otherwise>
		</c:choose>
<!--		<td><c:out value="${ctnGroup.value.ctnQty}"/></td>-->
		<td><a href="<c:url value='getDepot.do'><c:param name='depotcode' value='${ctnGroup.value.depotCode }'></c:param></c:url>"> <c:out value="${ctnGroup.value.depotCname}"/></a></td>
		</tr>
		<tr><td colspan="10"><table id="${ctnGroup.value.depotCode}${ctnGroup.value.ctnCode}" style="display: none" border="1">
		<tr class="DataTitle">
		<th></th>
		<th><fmt:message key="booking.container.printflag.displayname"/></th>
		<th><fmt:message key="booking.container.ctntype.displayname"/></th>
		<th><fmt:message key="booking.container.intlcode.displayname"/></th>
		<th><fmt:message key="booking.container.ctnqty.displayname"/></th>
		<th><fmt:message key="booking.container.status.displayname"/></th>
		<th><fmt:message key="booking.container.reservedate.displayname"/></th>		
		<th><fmt:message key="booking.container.pickupdate.displayname"/></th>
		<th><fmt:message key="booking.container.ctnnbr.displayname"/></th>
		<th><fmt:message key="booking.container.cuser.displayname"/></th>
		</tr>
		<c:forEach items="${booking.ctns}" var="ctn" varStatus="status">
		<c:choose>
			<c:when test="${ctnGroup.value.depotCode==ctn.value.depotCode&&ctnGroup.value.ctnCode==ctn.value.ctnCode }">
			<c:choose>
				<c:when test="${ctn.value.status=='R'}">
					<tr class="DataBody" bgcolor="lightpink">
					<td align="center"><c:if test="${user.depot==null||user.depot==ctn.value.depotCode}"><input type="checkbox" name="ctnID" value="${ctn.value.id}"/></c:if></td>
				</c:when>
				<c:when test="${ctn.value.status=='P'}">
					<tr class="DataBody">
					<td align="center"><c:if test="${user.depot==null||user.depot==ctn.value.depotCode}"><input type="checkbox" name="ctnID" value="${ctn.value.id}"/></c:if></td>
				</c:when>
				<c:otherwise>
					<tr class="DataBody">
					<td align="center"></td>
				</c:otherwise>
			</c:choose>
		        <td align="center"><c:if test="${user.depot==null||user.depot==ctn.value.depotCode}"><input type="radio" name="PrintID" value="${ctn.value.id}"/></c:if></td>
				<td><c:out value="${ctn.value.ctnCode}"/></td>
				<td><c:out value=""/></td>
				<td><c:out value="${ctn.value.ctnQty}"/></td>
				<td><fmt:message key="booking.container.status.${ctn.value.status}.displayname"/></td>
				<td><fmt:formatDate value="${ctn.value.reserveDate}" pattern="${dateFormat}"/></td>
				<td><fmt:formatDate value="${ctn.value.pickupDate}" pattern="${dateFormat}"/></td>
				<td><input type="text" name="ctnnbr${ctn.value.id}" value="${ctn.value.ctnNbr}" maxlength="11" size="11"/></td>
				<td><input type="text" name="cuser${ctn.value.id}" value="" size="6"/></td>
			</c:when>
		</c:choose>
		</c:forEach>
		</table></td></tr>
	</c:forEach>
	
	
	<tr><td colspan="2">
		<input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
		<input type="hidden" name="uncheckedStr" value="<fmt:message key="error.unchecked"/>"/>
		<input type="hidden" name="ctnNbrErr" value="<fmt:message key="error.booking.ctn.ctnnbr.unmatched"/>"/>
		<input type="hidden" name="buttontype" value="default" >
		<c:if test="${setCtnPStatus=='true'}"><html:submit property="pStatus" styleClass="button" onclick="if(!fnSubmit()){return false;}"><fmt:message key="button.pick.displayname"/></html:submit></c:if>
		<c:if test="${setCtnRStatus=='true'}"><html:submit property="rStatus" styleClass="button" onclick="if(!fnSubmit()){return false;}"><fmt:message key="button.reserve.displayname"/></html:submit></c:if>
		<c:if test="${setCtnPStatus=='true'}"><html:submit property="printctn" styleClass="button" onclick="if(!fnPrint()){return false;}"><fmt:message key="button.print.displayname"/></html:submit></c:if>
		<ers:priv privName="SetBookingCtnStatusAction" privParam="T" var="setCtnTStatus">
		<html:submit property="updateCtnNum" style="width:60px;" styleClass="button"><fmt:message key="button.udtCtnNum.displayname"/></html:submit>
		</ers:priv>
		
		<html:cancel styleClass="button"><fmt:message key="button.return.displayname"/></html:cancel> </td></tr>
	<tr>
	<tr><td colspan="2"><html:errors property="setBookingCtnError"/></td></tr>
	</table>	
	</form>
	
	</td>
	<td valign="top" align="right">
			<form action="setBookingStatus.do" method="post" name="setBookingStatusForm">
			<table>
			<tr class="DataTitle">
				<th><fmt:message key="booking.status.remark.displayname"/></th>
			</tr>
			<tr>
			<td>
			<textarea id="remark" name="remark" rows="${fn:length(booking.ctns) }" cols="30" <ers:priv privName="SetBookingStatusAction" caseExist="false">readonly="readonly"</ers:priv>><c:out value="${booking.status.remark }"/><c:if test="${booking.status.sremark!=null}">#<c:out value="${booking.status.sremark }"/>#</c:if></textarea>
			<input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
			<input type="hidden" id="remarkMaxLenStr" name="remarkMaxLenStr" value='<fmt:message key="errors.maxlength">
				<fmt:param><fmt:message key="booking.status.remark.displayname"/></fmt:param> 
				<fmt:param>100</fmt:param> 
			</fmt:message>'>
			</td>
			</tr>
			<tr><td><html:errors property="remark"/></td></tr>
			<tr><td align="center">
			<ers:priv privName="SetBookingStatusAction">
			<input type="submit" value="<fmt:message key='button.submit.displayname'/>" onclick="if(!fnSubmitStatus()){return false};" class="button"/> 
			</ers:priv>
			</td>
			</tr>
			</table>
			</form>
	</td>
	</table>
	<c:choose>
		<c:when test="${depots=='{}'}">
			<html:button property="" styleId="distr" styleClass="distributionDepot" onclick="distributionDepot(${booking.blnumber})"><fmt:message key="button.distributionDepot.displayname"/></html:button>
		</c:when>
		<c:otherwise>
			<html:button property=""  styleClass="distributionDepot" disabled="true"><fmt:message key="button.distributionDepot.displayname"/></html:button>
		</c:otherwise>
	</c:choose>
		<table cellSpacing="5" cellPadding=0 border="0" >
		<tr class="DataTitle">
			<td><fmt:message key="depot.ename.displayname"/></td>
			<td><fmt:message key="depot.cname.displayname"/></td>
			<td><fmt:message key="depot.tel.displayname"/></td>
			<td><fmt:message key="depot.fax.displayname"/></td>
			<td><fmt:message key="depot.contact.displayname"/></td>
			<td><fmt:message key="depot.caddress.displayname"/></td>
		</tr>
	
		<c:forEach items="${depots}" var="depot">
		<tr class="DataBody">
			<td><c:out value="${depot.value.ename}"/></td>
			<td><c:out value="${depot.value.cname}"/></td>
			<td nowrap="nowrap"><c:out value="${depot.value.tel}"/></td>
			<td><c:out value="${depot.value.fax}"/></td>
			<td><c:out value="${depot.value.contact}"/></td>
			<td width="40%"><c:out value="${depot.value.caddress}"/></td>
		</tr>
		</c:forEach>	
		</table>
	</tr>
	</table>

