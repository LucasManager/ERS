<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<%@page import="java.util.List,com.apl.sha.ers.model.BlockCodeUpdate,com.apl.sha.ers.model.User;" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.booking.displayname"/></title>
<meta name="keywords" content="application,booking" />
<script language="JavaScript">
<!--
 function deleteitem(){
 setForm.delete_flag.value = "Y";
 }
 -->
 </script> 
</head>
<%@ include file="/WEB-INF/jsp/pageheader.jsp" %>
<table>
<tr>
<td valign="top">
<%@ include file="/WEB-INF/jsp/applicationnav.jsp" %>
</td>
<td valign="top" width="60%">
		<%
		    BlockCodeUpdate bcu=null;
			if(request.getParameter("seq")!=null){
				List list=(List)session.getAttribute("BlockCodeUpdates");
				int seq=Integer.parseInt(request.getParameter("seq"));
				bcu=(BlockCodeUpdate)list.get(seq);
			}else{
				User user=(User)session.getAttribute("user");
				bcu=new BlockCodeUpdate();
			}
			pageContext.setAttribute("bcu",bcu);
		%>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="setBlockCodeUpdate.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		<form action="setBlockCodeUpdate.do" class="SetForm" name="setForm" method="post">
		<input type="hidden" name="id" value="${bcu.id }"/>
		<input type="hidden" name="delete_flag" value=""/>
		<table>
			
			<tr>
			<td><fmt:message key="vessel.svcname.displayname"/></td>
			<td>
				<input type="text" name="svcname" value="${bcu.svcname}" class="inputbox" property="svcname"/>
			</td>
			<td>
			<html:errors property="svcname"/>
			</td>
			</tr>
			<tr>
			<td><fmt:message key="booking.portofloadingcode.displayname"/></td>
			<td>
				<input type="text" name="portofloadingcode" value="${bcu.portofloadingcode}" class="inputbox" property="portofloadingcode"/>
			
				</td>
			<td><html:errors property="portofloadingcode"/></td>
			</tr>
			<tr>
			<td><fmt:message key="booking.blockcode.displayname"/></td>
			<td>
				<input type="text" name="block_code" value="${bcu.block_code}" class="inputbox" property="block_code"/>
			</td>
			<td><html:errors property="block_code"/></td>
			</tr>
			<tr><td colspan="3">
				<input type="submit" value='<fmt:message key="button.submit.displayname"/>' class="button"/>
				<input type="submit" value='<fmt:message key="button.disable.displayname"/>' onclick="JavaScript:deleteitem();" class="button"/>
				<html:cancel styleClass="button"><fmt:message key="button.return.displayname"/></html:cancel>
			</td></tr>
		</table>
		</form>
</td>
</tr>
</table>

