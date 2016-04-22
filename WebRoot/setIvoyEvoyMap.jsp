<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<%@page import="java.util.List,com.apl.sha.ers.model.*;" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.booking.displayname"/></title>
<meta name="keywords" content="application,booking" />
<script language="JavaScript">
<!--
 function deleteitem(){
 setForm.delete_flag.value = "Y";
 //var checkid = setForm.delete_flag.value;
 //alert(checkid);
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
		    IvoyEvoyMap iem=null;
			if(request.getParameter("seq")!=null){
				List list=(List)session.getAttribute("IvoyEvoyMaps");
				int seq=Integer.parseInt(request.getParameter("seq"));
				iem=(IvoyEvoyMap)list.get(seq);
			}else{
				User user=(User)session.getAttribute("user");
				iem=new IvoyEvoyMap();
			}
			pageContext.setAttribute("iem",iem);
		%>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="setIvoyEvoyMap.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		<form action="setIvoyEvoyMap.do" class="SetForm" name="setForm" method="post">
		<input type="hidden" name="v_id" value="${iem.v_id }"/>
		<input type="hidden" name="delete_flag" value=""/>
		<table>
			
			<tr>
			<td><fmt:message key="vessel.id.displayname"/></td>
			<td>
				<input type="text" name="vslcd" value="${iem.vslcd}" class="inputbox" property="vslcd"/>
			</td>
			<td><html:errors property="vslcd"/></td>
			</tr>
			<tr>
			<td><fmt:message key="booking.vslvoyid.ivoyid.displayname"/></td>
			<td>
				<input type="text" name="internal_voyid" value="${iem.internal_voyid}" class="inputbox" property="internal_voyid"/>
			</td>
			<td>
			<html:errors property="internal_voyid"/>
			</td>
			</tr>
			<tr>
			<td><fmt:message key="booking.vslvoyid.evoyid.displayname"/></td>
			<td>
				<input type="text" name="external_voyid" value="${iem.external_voyid}" class="inputbox" property="external_voyid"/>
			</td>
			<td><html:errors property="external_voyid"/></td>
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

