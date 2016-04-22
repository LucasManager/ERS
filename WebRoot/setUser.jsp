<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for SetUserForm form</title>
	</head>
	<body>
		<html:form action="/setUser">
			username : <html:text property="username"/><html:errors property="username"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

