<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%
 session = request.getSession(false);
 out.println("session="+session);
 
 if(session == null) {
	 
	 out.println("session=test");
 }
 %>