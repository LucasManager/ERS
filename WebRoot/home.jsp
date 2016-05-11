<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.home.displayname"/></title>
<meta name="keywords" content="home"/>
<script type="text/javascript" src="js/common.js"></script>
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/homenav.jsp" %>
</td>
<td valign="top" width="65%">
	<table cellSpacing=0 cellPadding=0 border="0" >
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<a href="news.jsp"><fmt:message key="module.news.displayname"/></a>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr><td>
	<div class="newsScroll" style="background-color:#d0effd" >
	<marquee height="20px" onmouseover="this.stop()" onmouseout="this.start()" scrollamount="2"  scrolldelay="1" direction="left" width="98%" style="padding: 0px; white-space: nowrap;">
		<c:forEach items="${newses}" var="news">
		<fmt:formatDate value="${news.value.begDate}" pattern="MM-dd"/>:
		<a href=<c:url value="getNews.jsp"><c:param name="newsID" value="${news.value.id}"></c:param></c:url> target="_blank">
		<c:out value="${news.value.brief}"></c:out></a>&nbsp;&nbsp;&nbsp;
		</c:forEach>
	</marquee>
	</div></td>
	</tr>
	<ers:priv privName="GetBookingsAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getBookings.function.displayname"/></SPAN></NOBR></div></td>
	</tr>
	<tr>
		<td>
		  	<form action="getBookings.do" name="getBKGSForm" >
		  	<table>
			  	<tr class="WPBody">
			  		<td valign="top">
			  		<select name="size">
			  			<option value="10">10</option>
			  			<option value="20" selected="selected">20</option>
			  			<option value="30">30</option></select>
			  		<fmt:message key="paging.size.displayname"/>
			  		</td>
			  		<td><fmt:message key="booking.vesselname.displayname"/></td>
			  		<td>
			  		<select name="vessel">
			  				<option value="allVsl"><fmt:message key="keywords.all"/></option>
			  			<c:forEach items="${vessels}" var="vessel"><option value="${vessel.id}">${vessel.sname}</option></c:forEach>
			  			</select> </td>
			  		<td rowspan="2">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
			    <tr class="WPBody">
			  		<td>
			  		<select name="days">
			  			<option value="5"  selected="selected">5</option>
			  			<option value="10">10</option>
			  			<option value="30">30</option>
			  			<option value="90">90</option>
			  		</select>
			  		<fmt:message key="param.uploaddatebftoday.displayname"/>
			  		</td>
			  		<td><fmt:message key="booking.placeofdeliverycode.displayname"/></td>
			  		<td><input type="text" name="dest" value="All Dest" maxlength="8"/></td>
			  	</tr>			  	
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="GetBookingCtnGroupsAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getBookingCtnGroups.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getBookingCtnGroups.do">
		  	<table>
			  	<tr class="WPBody">
			  		<td valign="top">
			  		<select name="size">
			  			<option value="10">10</option>
			  			<option value="20" selected="selected">20</option>
			  			<option value="30">30</option>
			  		</select>
			  		<fmt:message key="paging.size.displayname"/>
			  		</td>
			  		<td><fmt:message key="booking.vesselname.displayname"/></td>
			  		<td>
			  		<select name="vessel" onfocus="if(this.options.length<=1){copyOptions(getBKGSForm.vessel,this,1);}">
			  			<option value="allVsl"><fmt:message key="keywords.all"/></option>
			  			</select> </td>
			  		<td rowspan="2">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
			    <tr class="WPBody">
			  		<td>
			  		<select name="days">
			  			<option value="5"  selected="selected">5</option>
			  			<option value="10">10</option>
			  			<option value="30">30</option>
			  		</select>
			  		<fmt:message key="param.uploaddatebftoday.displayname"/>
			  		</td>
			  		<td></td>
			  	</tr>			  	
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="GetBookingAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getBooking.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getBooking.do">
		  	<table>
			  	<tr class="WPBody">
			  		<td valign="top">
		  			<fmt:message key="booking.blnumber.displayname"/>:<input type="text" name="blnumber" maxlength="11" size="11"/>
			  		</td>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
				  		<html:errors property="getBookingError"/>
				  		<html:messages id="msg" message="true" property="getBookingMSG" header="messages.header" footer="messages.footer">${msg}</html:messages>
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="GetBookingCtnAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getBookingCtn.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getBookingCtn.do">
		  	<table>
			  	<tr class="WPBody">
			  		<td valign="top">
		  			<fmt:message key="booking.blnumber.displayname"/>:<input type="text" name="blnumber" maxlength="11" size="11"/>
			  		</td>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
				  		<html:errors property="getBookingCtnError"/>
				  		<html:messages id="msg" message="true" property="getBookingCtnMSG" header="messages.header" footer="messages.footer">${msg}</html:messages>
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getBookingBL.refereceNo.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getBLByRefer.do">
		  	<table>
			  	<tr class="WPBody">
			  		<td valign="top">
		  			<fmt:message key="refereceNo.displayname"/>:<input type="text" name="referenceNo" value="${referenNo }" size="35" />
			  		</td>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
	  		</table>
	  		<table id="showB" class="listable" cellspacing=7 >
	  		<c:if test="${refereMess!=null }">
	  			<thead >
	  				<tr style="font-weight:bold;font-size:15px;">
	  					&nbsp;&nbsp;<td style="height:29px;"><fmt:message key="booking.blnumber.displayname"/></td>
	  					&nbsp;&nbsp;<td style="height:29px;"><fmt:message key="booking.vessel.displayname"/></td>
	  					&nbsp;&nbsp;<td style="height:29px;"><fmt:message key="booking.voyage.displayname"/></td>
	  					&nbsp;&nbsp;<td style="height:29px;"><fmt:message key="booking.packagesDesc.displayname"/></td>
	  					&nbsp;&nbsp;<td style="height:29px;"><fmt:message key="booking.receiveTime.displayname"/></td>
	  				</tr>
	  			</thead>
	  			<tbody>
		  			<c:forEach items="${refereMess }" var="bl">
						<tr >
							&nbsp;&nbsp;<td>APLU<c:out value="${bl.blnumber}"></c:out></td>
							&nbsp;&nbsp;<td>${bl.vesselName}</td>
							&nbsp;&nbsp;<td>${bl.voyage}</td>
							&nbsp;&nbsp;<td>${bl.packages}&nbsp;&nbsp;${bl.kindOfPackages }</td>
							&nbsp;&nbsp;<td>${bl.receiveTime }</td>
						</tr>
					</c:forEach>
	  			</tbody>
	  		</c:if>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="GetDepotAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN><fmt:message key="getDepot.function.displayname"/></SPAN></NOBR></div></td>
	</tr>
	<tr>
		<td>
		  	<form action="getDepot.do" method="post">
		  	<table>
			  	<tr class="WPBody">
			  		<td valign="top">
		  			<fmt:message key="depot.depotcode.displayname"/>:<input type="text" name="depotcode" maxlength="5" size="5"/>
			  		</td>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="GetDepotAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getDepots.function.displayname"/></SPAN></NOBR></div></td>
	</tr>
	<tr>
		<td>
		  	<form action="getDepots.do" method="post">
		  	<table>
			  	<tr>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" /></td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="GetDepotsCtnsAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN><fmt:message key="getDepotsCtns.function.displayname"/></SPAN></NOBR></div></td>
	</tr>
	<tr>
		<td>
		  	<form action="getDepotsCtns.do" method="post">
		  	<table>
			  	<tr>
			  		<td valign="bottom"><input type="image" src="image/go.gif" /></td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>

<!-- 	<ers:priv privName="GetCtnReleaseAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="GetCtnRelease.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="GetCtnRelease.do" method="post">
		  	<table>
			  	<tr class="WPBody">
			  		<td valign="top">
		  			<fmt:message key="booking.blnumber.displayname"/>:<input type="text" name="blnumber" maxlength="9" size="9"/>
			  		</td>
			  		<td>
			  		<fmt:message key="booking.blnumber.cuser"/>:<input type="text" name="cuser" value="" maxlength="8" size="9"/>
			  		</td>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
			  	<tr class="WPBody">
			  	<td><fmt:message key="help.containerorder.displayname"/></td>
			  	<td>
			  	<div>
			   <img src="image/go.gif" usemap="#Map">
			   <map name="Map">
			    <area shape="rect" coords="-1,0,73,33" href="helpaboutcro.htm" target="_black">
			    </map></div>
			    </td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv> -->

	</table>
</td>
<td valign="top" align="right" width="100%">
	<table cellSpacing=0 cellPadding=0 border="0" >
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN><img src="image/welcome.gif" height="30px" width="30px"/><fmt:message key="home.welcome.displayname"/></SPAN></NOBR>
		</div>
		</td>
	</tr>
	<tr class="WPBody">
		<td><c:out value="${user.lastname} ${user.firstname }"></c:out></td>
	</tr>
	
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN><img src="image/bulletin.gif" width="30px" height="30px"><fmt:message key="home.bulletin.displayname"/></SPAN></NOBR></div></td>
	</tr>
	<tr><td>
	<div class="newsScroll" style="background-color:#d0effd" >
	<marquee height="250px" onmouseover="this.stop()" onmouseout="this.start()" scrollamount="1"  scrolldelay="60" direction="up" width="98%">
		<c:forEach items="${bulletins}" var="bulletin">
		<span style="font-weight:bold; font-size:14px; color:#000099"><fmt:formatDate value="${bulletin.value.begDate}" pattern="MM-dd"/>:
		<c:out value="${bulletin.value.brief}"></c:out><br/></span>
		<br/>
		&nbsp;&nbsp;&nbsp;&nbsp; <c:out value="${bulletin.value.content}"></c:out><br/>
		<br/>
		</c:forEach>
	</marquee>
	</div></td>
	</tr>
    <tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN><img src="image/download.gif" width="30px" height="30px"/><fmt:message key="home.downloadfile.title.displayname"/></SPAN></NOBR></div></td>
	</tr>
	<tr class="WPBody">
		<td><A href="http://220.248.6.18/ERS/EIRA.xls"><fmt:message key="home.downloadfile.link.displayname"/></A></td>
	</tr>
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN><img src="image/email.gif" width="30px" height="30px"/><fmt:message key="home.contact.displayname"/></SPAN></NOBR></div></td>
	</tr>
	<tr class="WPBody">
		<td><fmt:message key="home.contact.essay"/>: <br/><A href="mailto:helm_feedback@nol.com.sg">ERS_feedback@apl.com</A></td>
	</tr>
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN><img src="image/account.gif" height="30px" width="30px"/><fmt:message key="module.account.displayname"/></SPAN></NOBR></div></td>
	</tr>
	<tr class="WPBody">
		<td><a href="initSetAccount.do"><fmt:message key="home.locale.essay"/></a></td>
	</tr>
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN><img src="image/apl_logo.gif" height="30px" width="30px"/><fmt:message key="home.companysite.displayname"/></SPAN></NOBR></div></td>
	</tr>
	<tr>
		<td>
			<div>
			<img src="image/all_logo.gif" width="212" height="34" border="0" hspace="5" vspace="5" align="center" usemap="#Map">
			<map name="Map">
			  <area shape="rect" coords="-1,0,73,33" href="http://www.nol.com.sg">
			  <area shape="rect" coords="83,1,130,36" href="http://www.apl.com">
			  <area shape="rect" coords="140,0,215,35" href="http://www.apllogistics.com">
			</map></div>
		</td>
	</tr>
</table>
</td>
</tr>
<tr height="20%"><td rowspan="1" colspan="3">&nbsp</td> </tr>
<tr valign="bottom" >
	<td></td>
	<td colspan="2">
	<div id="siteinfo"><img src="image/apl_logo.gif" width="44" height="40"><fmt:message key="home.siteinfo.essay"/></div>
</td>
</tr>
</table>


