
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@taglib uri="/WEB-INF/ers.tld" prefix="ers"%>
<%@taglib uri="/WEB-INF/oscache.tld" prefix="cache"%>
<c:if test="${user==null}">
	<c:redirect url="userLogin.jsp"></c:redirect>
</c:if>

