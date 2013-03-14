<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.job528.sina.weibo.Oauth2" %>
<%@ page import="java.util.Map" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <%@include file="/common/taglib.jsp"%> 
 <%@include file="/common/meta.jsp"%>
<title>新浪微博同步</title>
<script type="text/javascript" src="${basePath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${basePath}/weibo/sina/weiboLogin.js"></script>
</head>
<body>
	<%
		String oauthUrl= Oauth2.getAuthorizationURL();//授权页URL
		
		String code = request.getParameter("code");
		code = (code!=null ? code : "");
	%>
	<a href="###" id="synWeiboBtn">同步新浪微博</a><br/>
	<a href="###" id="pauseWeiboBtn">暂停新浪微博</a><br/>
	<a href="###" id="cancelWeiboBtn">取消新浪微博</a><br/>
	<input type="hidden" id="code" name="code" value="${param.code }"/>
	<input type="hidden" id="oauthUrl" name="oauthUrl" value="<%=oauthUrl %> "/>
	
	<script type="">synWeibo();</script>
</body>
</html>