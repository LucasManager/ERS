<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<meta name="keywords" content="application,booking">
<script type="text/javascript" src="js/common.js"></script>
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.booking.displayname"/></title>
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top" width="600">
	<table cellSpacing=0 cellPadding=0 border="0" >
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
			  	<tr>
			  		<td valign="top">
		  			<input type="text" name="blnumber" maxlength="9" size="9"/>
			  		</td>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	<ers:priv privName="DelBookingAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="delBooking.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="delBooking.do" name="delBookingForm">
		  	<table>
			  	<tr>
			  		<td valign="top">
		  			<input type="text" name="blnumber" maxlength="9" size="9"/>
		  			<input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
			  		</td>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" onclick="if(!smtCfm(delBookingForm)){return false;}"/>
				  		<html:messages id="msg" message="true" property="delBookingMSG" header="messages.header" footer="messages.footer">${msg}</html:messages>
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="SetCtnStatusforAmendAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="setCtnStatus.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="setCtnStatusforAmend.do" name="setNormalCheckForm">
		  	<table>
			  	<tr>
			  		<td valign="top">
		  			<input type="text" name="blnumber" maxlength="9" size="9"/>
		  			<input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
			  		</td>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" onclick="if(!smtCfm(setNormalCheckForm)){return false;}"/>
				  		<html:errors property="blnumber"/>
				  		<html:messages id="msg" message="true" property="ChangeCtnStatusMSG" header="messages.header" footer="messages.footer">${msg}</html:messages>
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="SetOverdueCtnAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="setOverdueCtn.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="setOverdueCtn.do" name="serOverdueCtnForm" class="SetForm">
		  	<table>
			  	<tr>
			  		<td valign="top"><fmt:message key="booking.vesselname.displayname"/>:</td>
			  		<td>
			  		<select name="vessel_o"><c:forEach items="${vessels}" var="vessel">
		  				<option value="${vessel.id}">${vessel.sname}</option></c:forEach>
		  			</select> 
			  		</td>
			  		<td rowspan="3">
		  			    <input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
				  		<input type="image" src="image/go.gif" onclick="if(!smtCfm(serOverdueCtnForm)){return false;}"/>
				    </td>
			  	</tr>
			  	<tr>
			  		<td valign="top"><fmt:message key="booking.voyage.displayname"/>:</td>
			  		<td valign="bottom">
				  		<input type="text" name="voyage_o" maxlength="3" size="3"/>
			  		</td>
			  		<td></td>
			  	</tr>
			  	<tr>
			  		<td valign="top" colspan="2">
			  		    <html:errors property="setOverdueCtnError"/>
			  			<html:messages id="msg" message="true" property="setOverdueCtnMSG" header="messages.header" footer="messages.footer">${msg}</html:messages>
			  	    </td>
			  	    <td></td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="SetVesselAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="setVessel.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<html:form action="/setVessel" styleClass="SetForm">
		  		<table>
		  		<tr><td><fmt:message key="vessel.id.displayname"/>:</td><td><html:text property="id" styleClass="inputbox"/><html:errors property="id"/></td></tr>
				<tr><td><fmt:message key="vessel.name.displayname"/>:</td><td><html:text property="name" styleClass="inputbox"/><html:errors property="name"/></td></tr>
				<tr><td><fmt:message key="vessel.simplename.displayname"/>:</td><td><html:text property="simpleName" styleClass="inputbox"/><html:errors property="simpleName"/></td></tr>
				<tr><td><fmt:message key="vessel.cname.displayname"/>:</td><td><html:text property="cname" styleClass="inputbox"/><html:errors property="cname"/></td></tr>
				<tr><td><fmt:message key="vessel.svcname.displayname"/>:</td><td><html:text property="svcname" styleClass="inputbox"/><html:errors property="svcname"/></td></tr>
				<tr><td valign="bottom">
				  		<input type="image" src="image/go.gif" onclick="if(!smtCfm(setVesselForm)){return false;}"/><input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
			  		</td><td><html:messages id="msg" message="true" property="setVesselMSG" header="messages.header" footer="messages.footer">${msg}</html:messages></td></tr>
				</table>		  		
		  	</html:form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="SetBookingInfoAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="setBookingInfo.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<html:form action="/setBookingInfo" styleClass="SetForm">
		  		<table>
			  		<tr>
			  			<td>
			  				<fmt:message key="booking.blnumber.displayname"/>:
			  			</td>
			  			<td>
			  				<html:text property="setBI_blnumber" styleClass="inputbox"/>
			  				<html:errors property="setBI_blnumber"/>
			  			</td>
			  		</tr>
					<tr>
						<td>
							<fmt:message key="booking.blockcode.displayname"/>:
						</td>
						<td>
							<html:text property="setBI_blockcode" styleClass="inputbox"/>
							<html:errors property="setBI_blockcode"/>
						</td>
					</tr>
					<tr>
					    <td valign="bottom">
					  		<input type="image" src="image/go.gif" onclick="if(!smtCfm(setBookingInfoForm)){return false;}"/><input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
				  		</td>
				  		<td>
				  			<html:messages id="msg" message="true" property="setBookingInfoMSG" header="messages.header" footer="messages.footer">${msg}</html:messages>
				  		</td>
				  	</tr>
				</table>		  		
		  	</html:form>
		</td>
	</tr>
	</ers:priv>
	
	<ers:priv privName="GetIvoyEvoyMapAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getIvoyEvoyMap.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getIvoyEvoyMap.do" method="post">
		  	<table>
		  		<tr><td valign="bottom">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="GetBlockCodeUpdateAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getBlockCodeUpdate.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getBlockCodeUpdate.do" method="post">
		  	<table>
		  		<tr><td valign="bottom">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
    <ers:priv privName="SetVslVoyAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="setVslVoy.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<html:form action="/setVslVoy" styleClass="SetForm">
		  		<table>
		  		<tr><td><fmt:message key="booking.blnumber.displayname"/>:</td>
		  		    <td><html:text property="vblnumber" styleClass="inputbox" maxlength="9"/>
		  		        <html:errors property="vblnumber"/></td></tr>
				<tr><td><fmt:message key="vessel.id.displayname"/>:</td>
				    <td><html:text property="vslcd" styleClass="inputbox" maxlength="3"/>
				        <html:errors property="vslcd"/></td></tr>
				<tr><td><fmt:message key="booking.voyage.displayname"/>:</td>
				    <td><html:text property="voyid" styleClass="inputbox" maxlength="3"/>
				        <html:errors property="voyid"/></td></tr>
				<tr><td valign="bottom">
				  		<input type="image" src="image/go.gif" onclick="if(!smtCfm(setVslVoyForm)){return false;}"/>
				  		<input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
			  		</td>
			  		<td>		  		
			  		</td>
			  	</tr>
			  	<tr><td valign="bottom" colspan="2">
			  	        <html:errors property="setVslVoyError"/>
				  		<html:messages id="msg" message="true" property="setVslVoyMSG" header="messages.header" footer="messages.footer">${msg}</html:messages>
			  		</td>
			  	</tr>
				</table>		  		
		  	</html:form>
		</td>
	</tr>
	</ers:priv>	
	
	</table>
</td>
</tr>
</table>
