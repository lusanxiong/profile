<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
<c:forEach items="${userWeiboList}" var="userWeibo">
	<li>
		<span>${userWeibo.weiboUserId}</span>
		<span>${userWeibo.active}</span> 
		<span>${userWeibo.activeName}</span>
		<span>${userWeibo.userId}</span> 
		<span>${userWeibo.weiboServiceType}</span>
		<span>${userWeibo.weiboServiceName}</span> 
		<span>${userWeibo.updateTime}</span>
	</li>
</c:forEach>

</ul>
