
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<c:if test="${user==null}">
	<c:redirect url="userLogin.jsp"></c:redirect>
</c:if>
<fmt:setLocale value="${user.locale}" scope="session"/>
<fmt:setBundle basename="com.apl.sha.ers.struts.ApplicationResources" scope="session"/>
<fmt:message key="format.date.standard" var="dateFormat" scope="session"/>
<fmt:message key="format.datetime.standard" var="datetimeFormat" scope="session"/>
<c:redirect url="home.jsp"></c:redirect>
