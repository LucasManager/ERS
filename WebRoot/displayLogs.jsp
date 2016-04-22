<%@ include file="/WEB-INF/jsp/taglib.jsp" %>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%> 
<LINK href="css/screen.css" type="text/css" rel="stylesheet" />
<display:table name="${logs}" pagesize="10" export="false" class="mars" sort="page">
<display:column property="username" titleKey="user.username.displayname" sortable="true" style="width:40px;"></display:column>
<display:column property="type" titleKey="log.type.displayname" sortable="true"></display:column>
<display:column property="ipaddress" titleKey="log.ipaddress.displayname" sortable="true"></display:column>
<display:column property="function" titleKey="log.function.displayname" sortable="true"></display:column>
<display:column property="event" titleKey="log.event.displayname" ></display:column>
<display:column property="comments" titleKey="log.comments.displayname" ></display:column>
</display:table>
