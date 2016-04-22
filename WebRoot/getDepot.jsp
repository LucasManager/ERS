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
  <table cellSpacing="5" cellPadding=0 border="0" >
  	<tr><td colspan="8">
  	<table>
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR>
		<fmt:message key="depot.info.displayname"/>
		</NOBR>
		</div>
		</td>
		<td><a href="<c:url value='initSetDepot.do'><c:param name='depotcode' value='${depot.depotcode}'/><c:param name='pagepath' value='/getDepot.jsp'/></c:url>"><img src="image/modify.gif" title="<fmt:message key='function.modify.displayname'/>"/></a></td>
	</tr>
	</table>
	</td></tr>
	<tr class="DataTitle">
		<td><fmt:message key="depot.depotcode.displayname"/></td>
		<td><fmt:message key="depot.location.displayname"/></td>
		<td><fmt:message key="depot.ename.displayname"/></td>
		<td><fmt:message key="depot.cname.displayname"/></td>
	</tr>
	<tr class="DataBody">
		<td><c:out value="${depot.depotcode}"/></td>
		<td><c:out value="${depot.location}"/></td>
		<td><c:out value="${depot.ename}"/></td>
		<td><c:out value="${depot.cname}"/></td>
	</tr>
	<tr class="DataTitle">
		<td><fmt:message key="depot.tel.displayname"/></td>
		<td><fmt:message key="depot.fax.displayname"/></td>
		<td><fmt:message key="depot.email.displayname"/></td>
		<td><fmt:message key="depot.contact.displayname"/></td>
	</tr>
	<tr class="DataBody">
		<td><c:out value="${depot.tel}"/></td>
		<td><c:out value="${depot.fax}"/></td>
		<td><c:out value="${depot.email}"/></td>
		<td><c:out value="${depot.contact}"/></td>
	</tr>
	<tr  class="DataTitle">
		<td colspan="8"><fmt:message key="depot.eaddress.displayname"/></td>
	</tr>
	<tr class="DataBody">
		<td colspan="8"><c:out value="${depot.eaddress}"/></td>
	</tr>
	<tr  class="DataTitle">
		<td colspan="8"><fmt:message key="depot.caddress.displayname"/></td>
	</tr>
	<tr class="DataBody">
		<td colspan="8"><c:out value="${depot.caddress}"/></td>
	</tr>
	</table>
	<table>
	<tr><td colspan="8">
	<table>
	<tr class="WPHeader">
		<td>
		<div class="WPTitle">
		<NOBR>
		<fmt:message key="depot.container.info.displayname"/>
		</NOBR>
		</div>
		</td>
		<td>
		<ers:priv privName="SetDepotAction">
		<a href="<c:url value='initSetDepotCtn.do'><c:param name='depotcode' value='${depot.depotcode}'/><c:param name='pagepath' value='/getDepot.jsp'/></c:url>"><img src="image/modify.gif" title="<fmt:message key='function.modify.displayname'/>"/></a>
		</ers:priv>
		</td>
	</tr>
	</table>	
	</td></tr>
	<tr class="DataTitle">
		<td><fmt:message key="depot.container.ctntype.displayname"/></td>
		<td><fmt:message key="depot.container.initalqty.displayname"/></td>
		<td><fmt:message key="depot.container.reservedqty.displayname"/></td>
		<td><fmt:message key="depot.container.pickupedqty.displayname"/></td>
		<td><fmt:message key="depot.container.initaldate.displayname"/></td>
	</tr>
	<c:forEach items="${depot.containers}" var="ctn">
	<tr class="DataBody">
		<td><c:out value="${ctn.value.ctnCode}"/></td>
		<td><c:out value="${ctn.value.initalQty}"/></td>
		<td><c:out value="${ctn.value.reservedQty}"/></td>
		<td><c:out value="${ctn.value.pickupedQty}"/></td>
		<td><fmt:formatDate value="${ctn.value.initalDate}" pattern="${dateFormat}"/></td>
	</tr>
	</c:forEach>	
	</table>
</td>
<td valign="top" align="right">
<img src="barChart.jsp?width=400&span=15"/>
</td>
</tr>	
</table>