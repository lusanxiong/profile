<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
String url = request.getServerName(); 
String mainWeb = "http://www.528.cn";
if(url.indexOf(".com.cn") != -1)
	mainWeb = "http://www.528.com.cn";
request.setAttribute("basePath",basePath);
request.setAttribute("mainWeb",mainWeb);
String menu = "";
%>
<!-- 用来定义js全局变量 -->
<script type="text/javascript" >
var basePath = "${basePath}";
var mainWeb = "${mainWeb}";
</script>