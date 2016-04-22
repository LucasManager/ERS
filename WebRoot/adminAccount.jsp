<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<meta name="keywords" content="admin,account" />
<title><fmt:message key="module.admin.user.displayname"/></title>
<script type="text/javascript" src="js/common.js"></script>
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/adminnav.jsp" %>
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
	<tr class="WPBody"><td>
		<form action="initSetAccount.do">
		<fmt:message key="user.username.displayname"/>:<input type="text" name="paramUsername" value=""/><html:errors property="paramUsername"/>
		<html:submit styleClass="button" ><fmt:message key="button.query.displayname"/></html:submit> 
		</form>
	</td></tr>
	<tr><td><hr></hr></td></tr>
	<tr>
		<td>
		<html:form action="/adminAccount" focus="firstname" styleClass="SetForm">
			<html:reset styleClass="button"><fmt:message key="button.reset.displayname"/></html:reset>
			<html:button property="reset" onclick="setAccountForm.userid.value=0;setAccountForm.username.value='';" styleClass="button"><fmt:message key="button.add.displayname"/></html:button>
			<html:messages id="msg" message="true" header="messages.header" footer="messages.footer">${msg}</html:messages>
			<table>
			<tr><td><fmt:message key="user.userid.displayname"/>:</td><td><html:text readonly="true" property="userid" styleClass="inputbox"/><html:errors property="userid"/></td></tr>
			<tr><td><fmt:message key="user.firstname.displayname"/>:</td><td> <html:text property="firstname" styleClass="inputbox" /><html:errors property="firstname"/></td></tr>
			<tr><td><fmt:message key="user.lastname.displayname"/>: </td><td> <html:text property="lastname" styleClass="inputbox" /><html:errors property="lastname"/></td></tr>
			
			<tr><td><fmt:message key="user.username.displayname"/>:</td><td> <html:text property="username" styleClass="inputbox" /><html:errors property="username"/></td></tr>
			<tr><td><fmt:message key="user.pwd.displayname"/>:</td><td>  <html:password property="pwd" styleClass="inputbox" maxlength="20"/><html:errors property="pwd"/></td></tr>
			<tr><td><fmt:message key="user.cfmpwd.displayname"/>:</td><td>  <html:password property="cfmpwd" styleClass="inputbox" maxlength="20"/><html:errors property="cfmpwd"/></td></tr>
			<tr><td><fmt:message key="user.title.displayname"/>:</td><td>  <html:text property="title" styleClass="inputbox" /><html:errors property="title"/></td></tr>
			<tr><td><fmt:message key="user.email.displayname"/>:</td><td>  <html:text property="email" styleClass="inputbox" /><html:errors property="email"/></td></tr>
			<tr><td><fmt:message key="user.createtime.displayname"/>:</td><td>  <html:text property="createtime" readonly="true" styleClass="inputbox" /><html:errors property="createtime"/></td></tr>
			<tr><td><fmt:message key="user.updatetime.displayname"/>:</td><td>  <html:text property="updatetime" readonly="true" styleClass="inputbox" /><html:errors property="updatetime"/></td></tr>
			<tr><td><fmt:message key="user.status.displayname"/>:</td><td>  <html:select property="status" style="width: 80px">
															<html:option value="0"><fmt:message key="user.status.0.displayname"/></html:option>
															<html:option value="1"><fmt:message key="user.status.1.displayname"/></html:option>
															<html:option value="2"><fmt:message key="user.status.2.displayname"/></html:option>
														  </html:select>
															<html:errors property="status"/></td></tr>
			<tr><td><fmt:message key="user.locale.displayname"/>:</td><td>  <html:select property="locale" style="width: 80px">
															<html:option value="en_US"><fmt:message key="user.locale.en_us.displayname"/></html:option>
															<html:option value="zh_CN"><fmt:message key="user.locale.zh_cn.displayname"/></html:option>
														  </html:select>
														  <html:errors property="locale"/></td></tr>
			<tr><td><fmt:message key="user.usergroup.displayname"/>:</td><td> <html:select property="usergroup" style="width: 80px">
															<html:option value="1">Admin</html:option>
															<html:option value="2">Client</html:option>
															<html:option value="3">Depot</html:option>
															<html:option value="4">Guest</html:option>
															<html:option value="5">PowerUser</html:option>
															</html:select><html:errors property="usergroup"/></td></tr>
			<tr><td><fmt:message key="user.location.displayname"/>:</td><td> <html:select property="location" style="width: 80px">
			                                                <html:option value="ALL">ALL</html:option>
															<html:option value="SHA">Shanghai</html:option>
															<html:option value="NGB">Ningbo</html:option>
															<html:option value="HSN">TianJing</html:option>
															<html:option value="DAI">Dalian</html:option>
															<html:option value="LYG">LianYunGang</html:option>
															<html:option value="WNZ">WenZhou</html:option>
															<html:option value="XIA">XiaMen</html:option>
															<html:option value="TSI">QingDao</html:option>
															</html:select><html:errors property="location"/></td></tr>
			<tr><td><fmt:message key="user.bookingparty.displayname"/>:</td><td>  <html:text property="bookingParty" styleClass="inputbox" /><html:errors property="bookingParty"/></td></tr>
			<tr><td><fmt:message key="user.depot.displayname"/>:</td><td>  <html:text property="depot" styleClass="inputbox" /><html:errors property="depot"/></td></tr>
			
			</table>
			<br/>
			 
			<input type="hidden" name="confirmStr" value="<fmt:message key="function.confirm.displayname"/>"/>
			<html:submit onclick="if(!smtCfm(setAccountForm)){return false;}" styleClass="button"><fmt:message key="button.submit.displayname"/></html:submit>  
			<html:cancel styleClass="button"><fmt:message key="button.cancel.displayname"/></html:cancel>
			<html:errors property="AdminAccountError"/>
		</html:form>
		</td>
	</tr>
	</table>
</td>
</tr>
</table>
