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
  <table cellSpacing="5" cellPadding=0 border="0" >
	<tr>
	<th class="DataTitle">
			<fmt:message key="booking.blnumber.displayname"/>
		</th>
		<th  class="DataTitle">
			<fmt:message key="booking.blockcode.displayname"/>
		</th>
		<th class="DataTitle">
			<fmt:message key="booking.bookingparty.displayname"/>
		</th>
		<th class="DataTitle">
			<fmt:message key="booking.status.receivetime.displayname"/>
		</th>
		<th class="DataTitle"><fmt:message key="booking.referenceno.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.accountcode.displayname"/></th>
		
	</tr>
	<tr class="DataBody">
		<td><c:out value="${booking.blnumber}"/></td>
		<td><c:out value="${booking.blockcode}"/></td>
		<td><c:out value="${booking.bookingparty}"/></td>
		<td><fmt:formatDate value="${booking.status.receiveTime }" pattern="${datetimeFormat}"/></td>
		<td><c:out value="${booking.referenceno}"/></td>
		<td><c:out value="${booking.accountcode}"/></td>
	</tr>
  </table>
  <table>
	<tr>
		<th class="DataTitle"><fmt:message key="booking.shippercode.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.shipper.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.shippername.displayname"/></th>
		
	</tr>
	<tr class="DataBody">
		<td><c:out value="${booking.shippercode}"/></td>
		<td><c:out value="${booking.shipper}"/></td>
		<td><c:out value="${booking.shippername}"/></td>
	</tr>
	</table>
	<table>
	<tr>
		<th class="DataTitle"><fmt:message key="booking.consigneecode.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.consignee.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.consigneename.displayname"/></th>
	</tr>
	<tr class="DataBody">
		<td><c:out value="${booking.consigneecode}"/></td>
		<td><c:out value="${booking.consignee}"/></td>
		<td><c:out value="${booking.consigneename}"/></td>
	</tr>
	</table>
	<table>
	<tr>
		<th class="DataTitle"><fmt:message key="booking.notifypartycode.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.notifypartyname.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.alsonotifypartycode.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.alsonotifypartyname1.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.alsonotifypartyname2.displayname"/></th>
	</tr>
	<tr class="DataBody">
		<td><c:out value="${booking.notifypartycode}"/></td>
		<td><c:out value="${booking.notifypartyname}"/></td>
		<td><c:out value="${booking.alsonotifypartycode}"/></td>
		<td><c:out value="${booking.alsonotifypartyname1}"/></td>
		<td><c:out value="${booking.alsonotifypartyname2}"/></td>
	</tr>
	</table>
	<table>
	<tr>
		<th class="DataTitle"><fmt:message key="booking.vslvoyid.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.vesselname.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.voyage.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.onboarddate.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.cargomodel.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.shippingmodel.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.seawaybill.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.expressbill.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.showoceanfreight.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.prepaidcollect.displayname"/></th>
	</tr>
	<tr class="DataBody">
		<td><c:out value="${booking.vslvoyid}"/></td>
		<td><c:out value="${booking.vesselname}"/></td>
		<td><c:out value="${booking.voyage}"/></td>
		<td><c:out value="${booking.onboarddate}"/></td>
		<td><c:out value="${booking.cargomodel}"/></td>
		<td><c:out value="${booking.shippingmodel}"/></td>
		<td><c:out value="${booking.seawaybill}"/></td>
		<td><c:out value="${booking.expressbill}"/></td>
		<td><c:out value="${booking.showoceanfreight}"/></td>
		<td><c:out value="${booking.prepaidcollect}"/></td>
	</tr>
	</table>
	<table>
	<tr>
		<th class="DataTitle"><fmt:message key="booking.placeofreceiptcode.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.placeofreceipt.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.portofloadingcode.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.portofloading.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.portofdischargecode.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.portofdischarge.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.placeofdeliverycode.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.placeofdelivery.displayname"/></th>
	</tr>
	<tr class="DataBody">
		<td><c:out value="${booking.placeofreceiptcode}"/></td>
		<td><c:out value="${booking.placeofreceipt}"/></td>
		<td><c:out value="${booking.portofloadingcode}"/></td>
		<td><c:out value="${booking.portofloading}"/></td>
		<td><c:out value="${booking.portofdischargecode}"/></td>
		<td><c:out value="${booking.portofdischarge}"/></td>
		<td><c:out value="${booking.placeofdeliverycode}"/></td>
		<td><c:out value="${booking.placeofdelivery}"/></td>
	</tr>
	</table>
	<table>
	<tr>
		<th class="DataTitle"><fmt:message key="booking.tradeterm.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.packages.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.kindofpackages.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.descriptionofpackages.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.grossweight.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.measurement.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.packagesofcartons.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.kindofcartons.displayname"/></th>
	</tr>
	<tr class="DataBody">
		<td><c:out value="${booking.tradeterm}"/></td>
		<td><c:out value="${booking.packages}"/></td>
		<td><c:out value="${booking.kindofpackages}"/></td>
		<td><c:out value="${booking.descriptionofpackages}"/></td>
		<td><c:out value="${booking.grossweight}"/></td>
		<td><c:out value="${booking.measurement}"/></td>
		<td><c:out value="${booking.packagesofcartons}"/></td>
		<td><c:out value="${booking.kindofcartons}"/></td>
	</tr>
	</table>
	<table>
	<tr>
		<th class="DataTitle"><fmt:message key="booking.messageconfirmdate.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.bookingupload.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.readyupload.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.tempdefine.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.settemp.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.maxtemp.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.mintemp.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.airrate.displayname"/></th>
	</tr>
	<tr class="DataBody">
		<td><fmt:formatDate value="${booking.messageconfirmdate}" pattern="${dateFormat}"/></td>
		<td><c:out value="${booking.bookingupload}"/></td>
		<td><c:out value="${booking.readyupload}"/></td>
		<td><c:out value="${booking.tempdefine}"/></td>
		<td><c:out value="${booking.settemp}"/></td>
		<td><c:out value="${booking.maxtemp}"/></td>
		<td><c:out value="${booking.mintemp}"/></td>
		<td><c:out value="${booking.airrate}"/></td>
	</tr>
	</table>
	<table>
	<tr>
		<th class="DataTitle"><fmt:message key="booking.commodity.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.marks.displayname"/></th>
		<th class="DataTitle"><fmt:message key="booking.descriptionofgoods.displayname"/></th>
	</tr>
	<tr class="DataBody">
		<td><c:out value="${booking.commodity}"/></td>
		<td><c:out value="${booking.marks}"/></td>
		<td><textarea rows="5" cols="60">${booking.descriptionofgoods}</textarea> </td>
	</tr>
	</table>
	<table>
		<tr class="DataTitle">
		<th><fmt:message key="booking.container.ctntype.displayname"/></th>
		<th><fmt:message key="booking.container.ctnqty.displayname"/></th>
		<th><fmt:message key="booking.container.depotcode.displayname"/></th>
		<th><fmt:message key="booking.container.masterblnumber.displayname"/></th>
		<th><fmt:message key="booking.container.pickupdate.displayname"/></th>
	</tr>
	<c:forEach items="${booking.ctns}" var="ctn">
	<tr class="DataBody">
		<td><c:out value="${ctn.value.ctnType}"/></td>
		<td><c:out value="${ctn.value.ctnQty}"/></td>
		<td><c:out value="${ctn.value.depotCode}"/></td>
		<td><c:out value="${ctn.value.masterBlnumber}"/></td>
		<td><fmt:formatDate value="${ctn.value.pickupDate}" pattern="${dateFormat}"/></td>
	</tr>
	</c:forEach>	
	</table>
</td>
</tr>	
</table>