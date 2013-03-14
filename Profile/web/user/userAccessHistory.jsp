<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<ul>
	<c:forEach items="${userInfoList}" var="userInfo">
	<li id="_lilf${userInfo.accessUserId}">
	<div class="per_pic"><a href="${basePath}/profile/user.shtml?uid=${userInfo.accessUserId}" target="_blank">
	<img src="${userInfo.photo}" height="50" border="0" width="50"/>
	</a>
	</div>
	<div class="per_word">
        <p class="per_word_1"><span class="p_name"><a href="${basePath}/profile/user.shtml?uid=${userInfo.accessUserId}" target="_blank">${userInfo.accessUserName }</a></span><span class="p_area">${userInfo.nowPlaceName }</span></p> 
        <p class="per_word_2">${userInfo.accessUserPost }</p> 
        <p class="per_word_3">${userInfo.accessDateStr }</p>    
	</div>
	</li>
	</c:forEach>
</ul>
