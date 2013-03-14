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
<title>新浪微博登录</title>
<script type="text/javascript" src="${basePath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<%
		String oauthUrl= Oauth2.getAuthorizationURL();//授权页URL
		
		String code = request.getParameter("code");
		code = code != null ? code : "";
	%>
	<img alt="微博登录" src="${basePath}/images/weiboLogin.png" style="cursor:pointer" title="使用微博账号登录" onclick="weiboLogin('<%=oauthUrl %>')" />
	<script type="text/javascript" src="${basePath}/weibo/sina/weiboLogin.js"></script>
	<script>
		LoginSynWeibo('<%=code%>');
	</script>
</body>
</html>