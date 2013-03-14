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
<title>发送新浪微博</title>
<script type="text/javascript" src="${basePath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<script type="text/javascript" src="${basePath}/weibo/sina/weiboLogin.js"></script>
	微博内容：<textarea id="texts" name="texts" rows="4" cols="34"></textarea>
	<input type="button" name="sendWeiboButton" id="sendWeiboButton" value="发布" />
</body>
</html>