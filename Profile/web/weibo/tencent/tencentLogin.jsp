<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.job528.tencent.weibo.WeiBoOAuth"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>tencentLogin</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <%@include file="/common/taglib.jsp"%> 
    <%@include file="/common/meta.jsp"%>
    <script type="text/javascript" src="${basePath}/js/jquery.js"></script>
  </head>
  
  <body>
   <%
	if("1".equals(request.getParameter("opt")))
	{
	   response.sendRedirect(WeiBoOAuth.generateAuthorizationURL());
	}else{
	%>
	 <a href="${basePath}/tencent/tencentLogin.jsp?opt=1">用腾讯微博账号登录</a>   
	<%}%>

  </body>
</html>
