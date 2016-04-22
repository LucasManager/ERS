<html>
<head>
<LINK href="css/ows.css" type=text/css rel=stylesheet>
<LINK href="css/menu.css" type=text/css rel=stylesheet>
<LINK href="css/sps.css" type=text/css rel=stylesheet>
<script src="js/menu.js" type="text/javascript"></script>
</head>
<body>
<table bgcolor="#FCFDFE">
	<tr>
		<TD style="PADDING-RIGHT: 2px" width=126>
            <TABLE class=Ms-pvnav id=SPSWC_NavBar 
            style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0 
            width="100%" DisplayType="v1">
              <TBODY>
              <TR>
              	<TD class="ms-navheader"><img src="image/admin.gif" /><fmt:message key="module.admin.displayname"/></TD></TR>
              <ers:priv privName="AdminAccountAction">
              <TR>
                <TD>
                  <TABLE class=Ms-pvnavtableone1 
                  style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0 
                  width="100%">
                    <TBODY>
                    <TR>
                      <TD id="accountsubmenutd" class="Ms-pvnavmidc1" ><li><A id=NavCatV0_C_0_0 
                        href="adminAccount.jsp" 
                        target=_self><fmt:message key="module.admin.user.displayname"/></A></li></TD>
					</TR></TBODY></TABLE></TD></TR>
			 </ers:priv>
              <TR>
                <TD>
                  <TABLE class=Ms-pvnavtableone1 
                  style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0 
                  width="100%">
                    <TBODY>
                    <TR>
                      <TD id="systemsubmenutd" class="Ms-pvnavmidc1"><li><A id=NavCatV0_C_0_1 
                        href="adminSystem.jsp" 
                        target=_self><fmt:message key="module.admin.system.displayname"/></A></li></TD>
					</TR></TBODY></TABLE></TD></TR>
              <TR>
                <TD>
                  <TABLE class=Ms-pvnavtableone1 
                  style="BORDER-COLLAPSE: collapse" cellSpacing=0 cellPadding=0 
                  width="100%">
                    <TBODY>
                    <TR>
                      <TD id="bulletinsubmenutd" class="Ms-pvnavmidc1" ><li><A id=NavCatV0_C_0_0 
                        href="adminBulletin.jsp" 
                        target=_self><fmt:message key="module.admin.bulletin.displayname"/></A></li></TD>
					</TR></TBODY></TABLE></TD></TR>
					</TBODY></TABLE>
                <IMG height=1 alt="" src="image/trans.gif" width=126> 
        </TD>
  </tr>
</table>
</body>
<script type="text/javascript">
subMenuSelect();
</script>
</html>