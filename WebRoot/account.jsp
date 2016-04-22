<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<meta name="keywords" content="account" />
<title><fmt:message key="module.account.displayname"/></title>
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/accountnav.jsp" %>
</td>
<td valign="top" width="65%">
	<table cellSpacing=0 cellPadding=0 border="0" >
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="setAccount.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		</td>
	</tr>
	<tr>
		<td>
		<html:form action="/setAccount" styleClass="SetForm">
			<table>
			<tr><td><html:hidden property="userid"/></td><td><html:errors property="userid"/></td></tr>
			<tr><td><fmt:message key="user.firstname.displayname"/>:</td><td> <html:text property="firstname" readonly="true" styleClass="inputbox" /><html:errors property="firstname"/></td></tr>
			<tr><td><fmt:message key="user.lastname.displayname"/>:</td><td> <html:text property="lastname" readonly="true" styleClass="inputbox" /><html:errors property="lastname"/></td></tr>
			<tr><td><fmt:message key="user.username.displayname"/>:</td><td> <html:text property="username" readonly="true" styleClass="inputbox" /><html:errors property="username"/></td></tr>
			<tr><td><fmt:message key="user.pwd.displayname"/>:</td><td> <html:password property="pwd" styleClass="inputbox" maxlength="20"/><html:errors property="pwd"/></td></tr>
			<tr><td><fmt:message key="user.cfmpwd.displayname"/>:</td><td> <html:password property="cfmpwd" styleClass="inputbox" maxlength="20"/><html:errors property="cfmpwd"/></td></tr>
			<tr><td><fmt:message key="user.title.displayname"/>:</td><td> <html:text property="title" styleClass="inputbox" /><html:errors property="title"/></td></tr>
			<tr><td><fmt:message key="user.email.displayname"/>:</td><td> <html:text property="email" styleClass="inputbox" /><html:errors property="email"/></td></tr>
			<tr><td><fmt:message key="user.locale.displayname"/>:</td><td> <html:select property="locale">
															<html:option value="en_US"><fmt:message key="user.locale.en_us.displayname"/></html:option>
															<html:option value="zh_CN"><fmt:message key="user.locale.zh_cn.displayname"/></html:option>
														  </html:select>
															<html:errors property="locale"/></td></tr>
			</table>
			<html:submit styleClass="button" ><fmt:message key="button.submit.displayname"/></html:submit>  <html:cancel styleClass="button"><fmt:message key="button.cancel.displayname"/></html:cancel>
		</html:form>
		</td>
	</tr>
	</table>
</td>
</tr>
</table>
