<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML dir=ltr xmlns:v = "urn:schemas-microsoft-com:vml" xmlns:o ="urn:schemas-microsoft-com:office:office">
<HEAD>
<%--<TITLE id=onetidTitle>PageHeader</TITLE>--%>
<META http-equiv=content-type content="text/html; charset=utf-8">
<META http-equiv=expires content=0>
<META content="MSHTML 6.00.2900.3020" name=GENERATOR>
<META content=SharePoint.WebPartPage.Document name=ProgId>
<META content=default name="microsoft theme">
<META content=none name="microsoft border">
<SCRIPT src="js/menu.js"></SCRIPT>
<LINK href="css/ows.css" type="text/css" rel="stylesheet">
<LINK href="css/sps.css" type="text/css" rel="stylesheet">
<LINK href="css/main.css" type="text/css" rel="stylesheet" /><!--begmstheme--><!--endmstheme-->
</HEAD>
<BODY id=PageBody marginheight="0" marginwidth="0" onload="menuSelect()" >
<FORM>
<TABLE class=ms-main cellSpacing=0 cellPadding=0 width="100%" border="0">
  <TBODY>
  <TR>
    <TD width="100%" colSpan=3>
      <TABLE class=ms-bannerframe cellSpacing=0 cellPadding=0 width="100%" border="0">
        <TBODY>
        <TR>
          <TD vAlign="middle" noWrap align=left width=0><A title="Site Logo" 
            href="home.jsp" target="_parent"><IMG alt="Site Logo" src="image/ers.gif" border=0></A></TD>
          <TD class=ms-banner vAlign=middle noWrap align="right" 
            width="99%"><c:out value="${user.lastname}  ${user.firstname}"/>|</TD>
          <TD class=ms-banner vAlign=middle noWrap align="right" 
            width="99%"><A href="help.jsp"><fmt:message key="button.help.displayname"/></A>|</TD>
          <TD class=ms-banner vAlign=middle noWrap align="right" 
            width="99%"><A href="userLogout.do?function=logout"><fmt:message key="button.logout.displayname"/></A>|</TD>
          <TD class=ms-banner vAlign=middle noWrap align="right" 
            width="99%"><A href="userLogout.do?function=exit"><fmt:message key="button.exit.displayname"/></A></TD></TR></TBODY></TABLE>
      <DIV class="ms-phnav1wrapper ms-navframe">
      <TABLE class=Ms-phnavtableone id=SPSWC_NavBar style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0 >
        <TBODY>
        <TR><TD><TABLE class=Ms-phnavtableone1 style="BORDER-COLLAPSE: collapse" 
            cellSpacing=0 cellPadding=0>
              <TBODY><TR>
                <TD id="homemenutd" class=Ms-phnavmidc1 noWrap><A id=NavCatH0_C_0_0 title=Home 
                  href="home.jsp" 
                  target=_self><fmt:message key="module.home.displayname"/> </A></TD></TR>
              </TBODY></TABLE></TD>
          <TD>
            <TABLE class=Ms-phnavtableone1 style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0>
              <TBODY>
              <TR><TD  id="newsmenutd" class=Ms-phnavmidc1 noWrap><A id=NavCatH0_C_0_0 title=News 
                  href="test.jsp" 
                  target=_self><fmt:message key="module.news.displayname"/></A></TD></TR>
              </TBODY></TABLE></TD>
          <TD><TABLE class=Ms-phnavtableone1 style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0>
              <TBODY><TR><TD id="applicationmenutd" class=Ms-phnavmidc1 noWrap><A id=NavCatH0_C_0_1 
                  title="Application" href="depot.jsp" target=_self><fmt:message key="module.application.displayname"/></A></TD>
                </TR></TBODY></TABLE></TD>
          <TD><TABLE class=Ms-phnavtableone1 style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding="0">
              <TBODY><TR><TD id="accountmenutd" class=Ms-phnavmidc1 noWrap><A id=NavCatH0_C_0_2 title="Account" href="initSetAccount.do" target=_self><fmt:message key="module.account.displayname"/></A></TD>
                </TR></TBODY></TABLE></TD>
          <ers:priv privName="AdminAccountAction">
          <TD><TABLE class=Ms-phnavtableone1 style="BORDER-COLLAPSE: collapse" 
            cellSpacing=0 cellPadding=0><TBODY><TR><TD id="adminmenutd" class=Ms-phnavmidc1 noWrap><A id=NavCatH0_C_0_3 
                  title=Admin href="admin.jsp" target=_self><fmt:message key="module.admin.displayname"/></A></TD>
			  </TR></TBODY></TABLE></TD>
			  </ers:priv>
          <TD><TABLE class=Ms-phnavtableone1 style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0>
              <TBODY><TR><TD id="backup1menutd" class=Ms-phnavmidc1 noWrap><A id=NavCatH0_C_0_4 
                  title="Backup1" href="test.jsp" target=_self><fmt:message key="module.backup1.displayname"/></A></TD>
			  </TR></TBODY></TABLE></TD>
          <TD><TABLE class=Ms-phnavtableone1 style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0>
              <TBODY><TR><TD id="backup2menutd" class=Ms-phnavmidc1 noWrap><A id=NavCatH0_C_0_5
                  title=Backup2 href="test.jsp" target=_self><fmt:message key="module.backup2.displayname"/></A></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></DIV></TD></TR>
  <TR>
    <TD class=ms-titleareaframe colSpan=3>
      <DIV class=ms-titleareaframe>
      <TABLE class=ms-titleareaframe cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY><TR><TD><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY><TR><TD colSpan=5 height=2><IMG height=1 alt="" src="image/blank.gif" width=1></TD></TR>
              <TR><TD class=ms-titlearealine colSpan=5 height=1><IMG height=1 alt="" src="image/blank.gif" width=1></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE>
</FORM></BODY></HTML>