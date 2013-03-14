<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/common/taglib.jsp"%> 
<%@include file="/common/meta.jsp"%>
<script type="text/javascript" src="${basePath}/js/jquery.js"></script>
<script type="text/javascript" src="${basePath}/weibo/tencent/tencent.js"></script>
</head>
<body>
	<%
	     String code = request.getParameter("code");
         String openid = request.getParameter("openid");
         String openkey = request.getParameter("openkey");
         code=code!=null?code:"";
         openid=openid!=null?openid:"";
         openkey=openkey!=null?openkey:"";          
	%>
	
	<script>
		TencentLogin('<%=code%>','<%=openid%>','<%=openkey%>');
	</script>
</body>
</html>