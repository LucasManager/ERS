<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<%@taglib uri="/WEB-INF/ers.tld" prefix="ers"%>
<html>
<body>
Reserved for future expansion.<br/>
<%=request.getParameter("status") %>
<form action="test.jsp">
<input type="checkbox" name="status" checked="no" value="a"/>
<input type="submit"/>
</form>

</body>

</html>