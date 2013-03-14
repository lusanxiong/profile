<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session 属性值</title>
</head>
<body>
<%
	out.println("session属性如下：<br><br>");
	HttpSession session = request.getSession(false);
	out.println(request);
	out.println(session);
	Enumeration er =  session.getAttributeNames();
	while(er.hasMoreElements()) {
		String name = (String)er.nextElement();
		out.println(name+"="+session.getAttribute(name)+"<br>");
	}
%>
	sessionId:<%=session.getId() %><br/>
</body>
</html>