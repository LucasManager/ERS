<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td>
<%@ include file="/WEB-INF/jsp/homenav.jsp" %>
</td>
<td>
  <table>
	<tr>
		<th>ID</th>
		<th>BLNUMBER</th>
		<th>BLOCKCODE</th>
		<th>REFERENCENO</th>
		<th>ACCOUNTCODE</th>
		<th>SHIPPERCODE</th>
		<th>SHIPPER</th>
		<th>SHIPPERNAME</th>
		<th>CONSIGNEECODE</th>
		<th>CONSIGNEE</th>
		<th>CONSIGNEENAME</th>
		<th>NOTIFYPARTYCODE</th>
		<th>NOTIFYPARTYNAME</th>
		<th>ALSONOTIFYPARTYCODE</th>
		<th>ALSONOTIFYPARTYNAME1</th>
		<th>ALSONOTIFYPARTYNAME2</th>
		<th>COMMODITY</th>
		<th>DESCRIPTIONOFGOODS</th>
		<th>MARKS</th>
		<th>PLACEOFRECEIPTCODE</th>
		<th>PLACEOFRECEIPT</th>
		<th>PORTOFLOADINGCODE</th>
		<th>PORTOFLOADING</th>
		<th>PORTOFDISCHARGECODE</th>
		<th>PORTOFDISCHARGE</th>
		<th>PLACEOFDELIVERYCODE</th>
		<th>PLACEOFDELIVERY</th>
		<th>VSLVOYID</th>
		<th>VESSELNAME</th>
		<th>VOYAGE</th>
		<th>ONBOARDDATE</th>
		<th>CARGOMODEL</th>
		<th>SHIPPINGMODEL</th>
		<th>SEAWAYBILL</th>
		<th>EXPRESSBILL</th>
		<th>SHOWOCEANFREIGHT</th>
		<th>PREPAIDCOLLECT</th>
		<th>TRADETERM</th>
		<th>PACKAGES</th>
		<th>KINDOFPACKAGES</th>
		<th>DESCRIPTIONOFPACKAGES</th>
		<th>GROSSWEIGHT</th>
		<th>MEASUREMENT</th>
		<th>PACKAGESOFCARTONS</th>
		<th>KINDOFCARTONS</th>
		<th>MESSAGECONFIRMDATE</th>
		<th>BOOKINGUPLOAD</th>
		<th>READYUPLOAD</th>
		<th>TEMPDEFINE</th>
		<th>SETTEMP</th>
		<th>MAXTEMP</th>
		<th>MINTEMP</th>
		<th>AIRRATE</th>
  	</tr>
	<tr>
		<td><c:out value="${booking.id}"/></td>
		<td><c:out value="${booking.blnumber}"/></td>
		<td><c:out value="${booking.blockcode}"/></td>
		<td><c:out value="${booking.referenceno}"/></td>
		<td><c:out value="${booking.accountcode}"/></td>
		<td><c:out value="${booking.shippercode}"/></td>
		<td><c:out value="${booking.shipper}"/></td>
		<td><c:out value="${booking.shippername}"/></td>
		<td><c:out value="${booking.consigneecode}"/></td>
		<td><c:out value="${booking.consignee}"/></td>
		<td><c:out value="${booking.consigneename}"/></td>
		<td><c:out value="${booking.notifypartycode}"/></td>
		<td><c:out value="${booking.notifypartyname}"/></td>
		<td><c:out value="${booking.alsonotifypartycode}"/></td>
		<td><c:out value="${booking.alsonotifypartyname1}"/></td>
		<td><c:out value="${booking.alsonotifypartyname2}"/></td>
		<td><c:out value="${booking.commodity}"/></td>
		<td><c:out value="${booking.descriptionofgoods}"/></td>
		<td><c:out value="${booking.marks}"/></td>
		<td><c:out value="${booking.placeofreceiptcode}"/></td>
		<td><c:out value="${booking.placeofreceipt}"/></td>
		<td><c:out value="${booking.portofloadingcode}"/></td>
		<td><c:out value="${booking.portofloading}"/></td>
		<td><c:out value="${booking.portofdischargecode}"/></td>
		<td><c:out value="${booking.portofdischarge}"/></td>
		<td><c:out value="${booking.placeofdeliverycode}"/></td>
		<td><c:out value="${booking.placeofdelivery}"/></td>
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
		<td><c:out value="${booking.tradeterm}"/></td>
		<td><c:out value="${booking.packages}"/></td>
		<td><c:out value="${booking.kindofpackages}"/></td>
		<td><c:out value="${booking.descriptionofpackages}"/></td>
		<td><c:out value="${booking.grossweight}"/></td>
		<td><c:out value="${booking.measurement}"/></td>
		<td><c:out value="${booking.packagesofcartons}"/></td>
		<td><c:out value="${booking.kindofcartons}"/></td>
		<td><c:out value="${booking.messageconfirmdate}"/></td>
		<td><c:out value="${booking.bookingupload}"/></td>
		<td><c:out value="${booking.readyupload}"/></td>
		<td><c:out value="${booking.tempdefine}"/></td>
		<td><c:out value="${booking.settemp}"/></td>
		<td><c:out value="${booking.maxtemp}"/></td>
		<td><c:out value="${booking.mintemp}"/></td>
		<td><c:out value="${booking.airrate}"/></td>

	</tr>
	</table>
	<a href="booking.jsp" id="return_link" target="_parent">Return</a>
</td></tr>
</table>