<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<head>
<LINK href="css/main.css" type="text/css" rel="stylesheet" />
<title><fmt:message key="module.application.displayname"/>-<fmt:message key="module.application.depot.displayname"/></title>
<meta name="keywords" content="application,depot" />
<script language="javascript">
<!--
function senfe(o,a,b,c,d){
 var t=document.getElementById(o).getElementsByTagName("tr");
 for(var i=0;i<t.length;i++){
  t[i].style.backgroundColor=(t[i].sectionRowIndex%2==0)?a:b;
  t[i].onclick=function(){
   if(this.x!="1"){
    this.x="1";
    this.style.backgroundColor=d;
   }else{
    this.x="0";
    this.style.backgroundColor=(this.sectionRowIndex%2==0)?a:b;
   }
  }
  t[i].onmouseover=function(){
   if(this.x!="1")this.style.backgroundColor=c;
  }
  t[i].onmouseout=function(){
   if(this.x!="1")this.style.backgroundColor=(this.sectionRowIndex%2==0)?a:b;
  }
 }
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
<td valign="top">
  <table cellSpacing="5" cellPadding=0 border="0" id="ctnslist" width="400">
	<tr class="DataTitle">
		<td><fmt:message key="depot.container.ctntype.displayname"/></td>
		<td><fmt:message key="depot.depotcode.displayname"/></td>
		<td><fmt:message key="depot.container.initalqty.displayname"/></td>
		<td><fmt:message key="depot.container.reservedqty.displayname"/></td>
		<td><fmt:message key="depot.container.pickupedqty.displayname"/></td>
		<td><fmt:message key="depot.container.remainqty.displayname"/></td>
		<td><fmt:message key="depot.container.initaldate.displayname"/></td>
	</tr>
	<c:forEach items="${depotsctns}" var="ctn">
	<tr class="DataBody">
		<td><c:out value="${ctn.ctnCode}"/></td>
		<td><c:out value="${ctn.depotCode}"/></td>
		<td><c:out value="${ctn.initalQty}"/></td>
		<td><c:out value="${ctn.reservedQty}"/></td>
		<td><c:out value="${ctn.pickupedQty}"/></td>
		<td><c:out value="${ctn.initalQty-ctn.pickupedQty-ctn.reservedQty}"/></td>
		<td><fmt:formatDate value="${ctn.initalDate}" pattern="${dateFormat}"/></td>
	</tr>
	</c:forEach>	
	</table>
</td>
<td valign="top" align="right">
	<img src="multiPieChart.jsp?width=800&span=100"/>
</td>
</tr>	
</table>
<script language="javascript">
<!--
senfe("ctnslist","#f8fbfc","#e5f1f4","#ecfbd4","#bce774");
-->
</script>