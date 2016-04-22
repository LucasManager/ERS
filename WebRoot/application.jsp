<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.application.displayname"/></title>
<meta name="keywords" content="application"/>
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top" width="65%">
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
	</table>
</td>
</tr>
</table>