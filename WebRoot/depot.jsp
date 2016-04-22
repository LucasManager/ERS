<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<LINK href="css/calendar.css" type="text/css" rel="stylesheet" />
<meta name="keywords" content="application,depot" />
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.depot.displayname"/></title>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top" width="600">
	<table cellSpacing=0 cellPadding=0 border="0" >
	<ers:priv privName="GetDepotAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getDepot.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getDepot.do" method="post">
		  	<table>
			  	<tr>
			  		<td valign="top">
		  			<input type="text" name="depotcode" maxlength="5" size="5"/>
			  		</td>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
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
		<fmt:message key="getDepots.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getDepots.do" method="post">
		  	<table>
			  	<tr>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
			  		</td>
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
		<NOBR><SPAN> 
		<fmt:message key="getDepotsCtns.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getDepotsCtns.do" method="post">
		  	<table>
			  	<tr>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="SetDepotAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="addDepot.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="initSetDepot.do?pagepath=/depot.jsp" method="post">
		  	<table>
			  	<tr>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="GetOneWayCtnsAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getOneWayCtns.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getOneWayCtns.do" method="post">
		  	<table>
		  		<tr><td><select name="ctnCode">
		  				<option value="All"><fmt:message key="keywords.all"/></option>
						<c:forEach items="${ctncodes}" var="ctncode">
							<option value="${ctncode.key}">${ctncode.key}</option>
						</c:forEach>
						</select> </td>
						<td>
			  		<div class="WPBody">
		            <NOBR><SPAN> 
		            <fmt:message key="keywords.valid"/>:
		            </SPAN>
		            </NOBR>
		            </div>
			  		</td>
					<td>
						<select name="status">
						<option value="all"><fmt:message key="keywords.all"/></option>
						<option value="true"><fmt:message key="keywords.true"/></option>
						<option value="false"><fmt:message key="keywords.false"/></option>
						</select> </td>
			  		<td valign="bottom">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
	  		</table>
		  	</form>
		</td>
	</tr>
	</ers:priv>
	<ers:priv privName="GetCtnReportAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="GetCtnReport.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		  	<form action="getCtnReport.do" class="SetForm">
		  	<table>
			  	<tr>
			  		<td>
			  		<div class="WPBody">
		            <NOBR><SPAN> 
		            <fmt:message key="ctnreport.begdate.displayname"/>:
		            </SPAN>
		            </NOBR>
		            </div>
			  		</td>
			  		<td valign="top">
		  			<input type="text" name="begDate" maxlength="10" size="7" onfocus="showCalendarControl(this);"/><html:errors property="begDate"/>
			  		</td>	  		
			  		<td rowspan="4">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
			  	<tr>
			  	    <td>
			  		<div class="WPBody">
		            <NOBR><SPAN> 
		            <fmt:message key="ctnreport.enddate.displayname"/>:
		            </SPAN>
		            </NOBR>
		            </div>
			  		</td>
			  		<td>
		  			<input type="text" name="endDate" maxlength="10" size="7" onfocus="showCalendarControl(this);"/><html:errors property="endDate"/>
			  		</td>
			  	</tr>
			  	<tr>
			  	    <td>
			  		<div class="WPBody">
		            <NOBR><SPAN> 
		            <fmt:message key="booking.vesselname.displayname"/>:
		            </SPAN>
		            </NOBR>
		            </div>
			  		</td>
					<td>
			  		    <select name="vessel">
			  			<option value="allVsl"><fmt:message key="keywords.all"/></option>
			  			<c:forEach items="${vessels}" var="vessel">
			  			   <option value="${vessel.id}">${vessel.name}  ->${vessel.id}</option>
			  			</c:forEach>
			  			</select> 
			  		</td>
			  	</tr>
			  	<tr>
			  	    <td>
			  		<div class="WPBody">
		            <NOBR><SPAN> 
		            <fmt:message key="depot.depotcode.displayname"/>:
		            </SPAN>
		            </NOBR>
		            </div>
			  		</td>
			  	    <td>
			  	        <select name="localdepotcode">
		  				<option value="All"><fmt:message key="keywords.all"/></option>
                        <c:forEach items="${localdepots}" var="localdepot">
                           <option value="${localdepot.value.depotcode}">${localdepot.value.depotcode}</option>
						</c:forEach>
						</select> 
					</td>					
			  	</tr>

	  		</table>
		  	</form>
		</td>
	</tr>
    </ers:priv>
    <ers:priv privName="GetSVCNameMapAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getSVCNameMap.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td> 
		  	<form action="getSVCNameMap.do" method="post">
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
	<ers:priv privName="GetPendingCtnAction">
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="getPendingCtn.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
        <td>
		  	<html:form action="/getPendingCtn" styleClass="SetForm">
		  	  <table>
			  	<tr>
			  		<td>
			  		<div class="WPBody">
		            <NOBR><SPAN> 
		            <fmt:message key="ctnreport.begdate.displayname"/>:
		            </SPAN>
		            </NOBR>
		            </div>
			  		</td>
			  		<td valign="top">
			  		<html:text property="begPassedDate" size="7" maxlength="10" onfocus="showCalendarControl(this);"/>
		  			<html:errors property="begPassedDate"/>
			  		</td>	  		
			  		<td rowspan="2">
				  		<input type="image" src="image/go.gif" />
			  		</td>
			  	</tr>
			  	<tr>
			  	    <td>
			  		<div class="WPBody">
		            <NOBR><SPAN> 
		            <fmt:message key="ctnreport.enddate.displayname"/>:
		            </SPAN>
		            </NOBR>
		            </div>
			  		</td>
			  		<td>
			  		<html:text property="endPassedDate" size="7" maxlength="10" onfocus="showCalendarControl(this);"/>
		  			<html:errors property="endPassedDate"/>
			  		</td>
			  	</tr>
			  	<tr>
			  	    <td colspan="3">
			  	    <html:errors property="getPendingCtnError"/>
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
