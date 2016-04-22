<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@taglib uri="/WEB-INF/fmt.tld" prefix="fmt" %>
<%@taglib uri="/WEB-INF/fn.tld" prefix="fn"%>
<%@taglib uri="/WEB-INF/oscache.tld" prefix="cache" %>
<fmt:setBundle basename="com.apl.sha.ers.struts.ApplicationResources"/>

<html> 
	<head>
		<title>ERS</title>
		<LINK href="css/main.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="js/userLogin.js"></script>
	</head>
	<body><IMG src="image/ers.gif">
	
		<html:form action="/userLogin" focus="username">
		   <p>&nbsp;</p>
		   <p>&nbsp;</p>
			<div align="center">
    <TABLE border="2" align="center"  bgcolor="#CCCCCC">
	<tr><td> 

	<table border="0" bgcolor="#b9d1f4" align="center" style="color: #003399">
      <tr><td style="color: #CC0033"><h2><b><fmt:message key="userLogin.function.displayname"/>:</b></h2></td></tr>
		<tr><td align="left" ><B><fmt:message key="login.username"/></B></TD></tr>
		<tr><TD><html:text maxlength="20" size="30" property="username" styleClass="inputbox"/><html:errors property="username"/></TD></TR>
		<tr><td align="left" ><B><fmt:message key="login.password"/></B></TD></tr>
		<tr><TD><html:password maxlength="20" size="30" property="password" redisplay="false" styleClass="inputbox"/><html:errors property="password"/></TD></TR>
		<tr><td align="left" ><B><fmt:message key="login.safecode"/></B></TD></tr>
		<TR><TD><html:text property="safecode" maxlength="4" size="4" styleClass="inputbox"></html:text>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<cache:cache refresh="true"><html:img  src="safecode.jsp"/></cache:cache> <html:errors property="safecode"/></TD> </TR>
		<TR align="center"><TD><html:errors property="loginfail"/></TD></TR>
		<TR align="center"><TD><html:submit  styleClass="button"><fmt:message key="button.login.displayname"/>  </html:submit>
				<html:submit onclick="anonymousLogin();" styleClass="button"><fmt:message key="button.guest.displayname"/>  </html:submit> 
		 </TD></TR>
		
			</TABLE>
			</td></tr>
			</table>
			</div>
		</html:form>
		<table align="center">
		<tr>
			<td><fmt:message key="home.network.mirrorsite.displayname"/>:</td>
			<td>
			<c:choose>
			<c:when test="${fn:containsIgnoreCase(pageContext.request.requestURL,'220.248.6.18')}">
			<a href="http://222.66.25.206/ERS/"><fmt:message key="home.network.ctc.displayname"/></a>
			</c:when>
			<c:otherwise>
			<a href="http://220.248.6.18/ERS/"><fmt:message key="home.network.cnc.displayname"/></a>
			</c:otherwise>
			</c:choose>
			</td>
		</tr>
		</table>
	<div id="siteinfo">
    <img src="image/apl_logo.gif" width="44" height="40">
    <fmt:bundle basename="com.apl.sha.ers.struts.ApplicationResources">
    <fmt:message key="home.siteinfo.essay"/>
    </fmt:bundle>
</div>
	</body>
</html>