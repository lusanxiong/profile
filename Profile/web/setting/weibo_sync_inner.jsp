<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<table width="650" border="0" cellspacing="1" cellpadding="0">
	  <tr>
	    <th width="218" align="left">同步类型</th>
	    <th width="266" align="left">同步状态</th>
	    <th width="162" align="left">操作</th>
	  </tr>
	  <c:forEach items="${userWeiboList}" var="userWeiboInfo">
		 <tr>
		    <td><img src="../images/setting/${userWeiboInfo.weiboServicePhoto }" /></td>
		    <td>${userWeiboInfo.activeName }</td>
		    <td>
		    	<c:if test="${userWeiboInfo.active==0}">
		    	<a href="javascript:void(0);" onclick="weiboOauth('${userWeiboInfo.weiboServiceType }')">认证</a>
		    	</c:if>
		    	
		    	<c:if test="${userWeiboInfo.active==1}">
		    	<a href="javascript:void(0);" id="pauseWeiboBtn" onclick="pauseSyncWeibo('${userWeiboInfo.weiboServiceType }');">暂停同步</a>
		    	</c:if>
		    	
		    	<c:if test="${userWeiboInfo.active==2}">
		    	<a href="javascript:void(0);" onclick="recoverSyncWeibo('${userWeiboInfo.weiboServiceType }');">恢复同步</a>
		    	</c:if>
		    	
		    	<c:if test="${userWeiboInfo.active!=0}">
		    	<a href="javascript:void(0);" onclick="delWeiSync('${userWeiboInfo.weiboServiceType }')">删除账号</a>
		    	</c:if>
		    </td>
		 </tr>
	  </c:forEach>
	  
</table>