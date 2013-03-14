<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.job528.sina.weibo.Oauth2" %>
<%@ page import="java.util.Map" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/taglib.jsp"%> 
<%@include file="/common/meta.jsp"%>
<title>新浪微博登录回调页</title>
<script type="text/javascript" src="js/weibo/sinaWeibo.js"></script>
</head>

<body>
	<%
		String code = request.getParameter("code");
		code = code != null ? code : "";
	%>
	<script>
		LoginSynWeibo('<%=code%>');
	</script>
	正在跳转...
</body>
</html>