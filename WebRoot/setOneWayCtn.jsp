<%@ include file="/WEB-INF/jsp/taglib.jsp"%>
<%@page import="java.util.List,com.apl.sha.ers.model.*;" %>
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
<td valign="top" width="600" align="left">
		<%
			OneWayCtn owc=null;
			if(request.getParameter("seq")!=null){
				List list=(List)session.getAttribute("oneWayCtns");
				int seq=Integer.parseInt(request.getParameter("seq"));
				owc=(OneWayCtn)list.get(seq);
			}else{
				User user=(User)session.getAttribute("user");
				owc=new OneWayCtn();
				owc.setId(0);
				owc.setLocation(user.getLocation());
				owc.setStatus(new Boolean(true));
			}
			pageContext.setAttribute("owc",owc);
		%>
		<div class="WPTitle">
		<NOBR><SPAN> 
		<fmt:message key="setOneWayCtn.function.displayname"/>
		</SPAN>
		</NOBR>
		</div>
		<form action="setOneWayCtn.do" class="SetForm" name="setOneWayCtnForm" method="post">
		<input type="hidden" name="id" value="${owc.id }"/>
		<table>
			
			<tr>
			<td><fmt:message key="depot.location.displayname"/></td>
			<td width="60" align="left">
				<input type="text" name="location" readonly="readonly" value="${owc.location}" class="inputbox" property="location"/>
			</td>
			<td>
			<html:errors property="location"/>
			</td>
			</tr>
			<tr>
			<td><fmt:message key="booking.placeofdeliverycode.displayname"/></td>
			<td>
				<input type="text" name="dest" value="${owc.dest }" class="inputbox" property="dest"/>
			</td>
			<td>
			<html:errors property="dest"/>
			</td>
			</tr>
			<tr>
			<td><fmt:message key="booking.container.ctncode.displayname"/></td>
			<td>
				<select name="ctnCode">
						<c:forEach items="${ctncodes}" var="ctncode">
							<option value="${ctncode.key}">${ctncode.key}</option>
						</c:forEach>
						</select>
			</td></tr>
			<tr>
			<td><fmt:message key="depot.depotcode.displayname"/></td>
			<td>
				<select name="depotCode">
						<c:forEach items="${localdepots}" var="depot">
							<option value="${depot.key}">${depot.key}</option>
						</c:forEach>
						</select>
				
			</td></tr>
			<tr>
			<td><fmt:message key="booking.status.remark.displayname"/></td>
			<td>
			<textarea id="oremark" name="oremark" rows="3" cols="30" property="oremark">${owc.oremark}</textarea>
			</td>
			</tr>
			<tr><td><fmt:message key="keywords.valid"/></td>
				<td><input name="status" type="checkbox" <c:if test="${owc.status }">checked="checked"</c:if> value="true"/> </td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value='<fmt:message key="button.submit.displayname"/>' class="button"/>
				<html:cancel styleClass="button"><fmt:message key="button.return.displayname"/></html:cancel></td></tr>
		</table>
		</form>
</td>
</tr>
</table>
<script type="text/javascript">
		for (i=0; i< setOneWayCtnForm.ctnCode.options.length; i++){
			if(setOneWayCtnForm.ctnCode.options(i).value=="${owc.ctnCode}"){
				setOneWayCtnForm.ctnCode.options(i).selected=true;
				break;
			}
		}
		for (i=0; i< setOneWayCtnForm.depotCode.options.length; i++){
			if(setOneWayCtnForm.depotCode.options(i).value=="${owc.depotCode}"){
				setOneWayCtnForm.depotCode.options(i).selected=true;
				break;
			}
		}
</script>
