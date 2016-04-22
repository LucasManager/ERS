<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.depot.displayname"/></title>
<meta name="keywords" content="application,depot" />
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top" width="60%">
		<html:form action="/setDepot" styleClass="SetForm">
			<html:hidden property="id"/><html:errors property="id"/><br/>
			<fmt:message key="depot.depotcode.displayname"/>: 
			<c:choose>
				<c:when test="${setDepotForm.id==0 }"><html:text property="depotcode" styleClass="inputbox"/></c:when>
				<c:otherwise><html:text property="depotcode" styleClass="inputbox" readonly="true"/></c:otherwise>
			</c:choose>
			<html:errors property="depotcode"/><br/>
			<fmt:message key="depot.location.displayname"/>: <html:text property="location" readonly="true" styleClass="inputbox"/><html:errors property="location"/><br/>
			<fmt:message key="depot.ename.displayname"/>: <html:text property="ename" styleClass="inputbox"/><html:errors property="ename"/><br/>
			<fmt:message key="depot.cname.displayname"/>: <html:text property="cname" styleClass="inputbox"/><html:errors property="cname"/><br/>
			<fmt:message key="depot.tel.displayname"/>: <html:text property="tel" styleClass="inputbox"/><html:errors property="tel"/><br/>
			<fmt:message key="depot.fax.displayname"/>: <html:text property="fax" styleClass="inputbox"/><html:errors property="fax"/><br/>
			<fmt:message key="depot.eaddress.displayname"/>: <html:text property="eaddress" styleClass="inputbox" size="50"/><html:errors property="eaddress"/><br/>
			<fmt:message key="depot.caddress.displayname"/>: <html:text property="caddress" styleClass="inputbox" size="50"/><html:errors property="caddress"/><br/>
			<fmt:message key="depot.contact.displayname"/>: <html:text property="contact" styleClass="inputbox"/><html:errors property="contact"/><br/>
			<fmt:message key="depot.email.displayname"/>: <html:text property="email" styleClass="inputbox"/><html:errors property="email"/><br/>
			<html:errors property="error"/><br/>
			<html:submit styleClass="button" onclick="if(!fnSubmit()){return false;}"><fmt:message key="button.submit.displayname"/></html:submit><html:cancel styleClass="button"><fmt:message key="button.cancel.displayname"/></html:cancel>
			
		</html:form>
</td>
</tr>
</table>

