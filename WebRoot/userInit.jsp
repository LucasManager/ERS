
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.apl.sha.ers.model.*,java.util.Locale,org.apache.struts.Globals" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<c:if test="${user==null}">
	<c:redirect url="userLogin.jsp"></c:redirect>
</c:if>
<%User user=(User)session.getAttribute("user");
Locale locale=new Locale(user.getLocale().substring(0, 2),user.getLocale().substring(3));
session.setAttribute(Globals.LOCALE_KEY, locale);
%>
<fmt:setLocale value="${user.locale}" scope="session"/>
<fmt:setBundle basename="com.apl.sha.ers.struts.ApplicationResources" scope="session"/>
<fmt:message key="format.date.standard" var="dateFormat" scope="session"/>
<fmt:message key="format.datetime.standard" var="datetimeFormat" scope="session"/>
<c:set scope="page" var="returnPath" value="home.jsp"></c:set>
<c:if test="${ param.returnPath!=null}"><c:set scope="page" var="returnPath" value="${param.returnPath }"></c:set> </c:if>
<c:redirect url="${returnPath}" ></c:redirect>