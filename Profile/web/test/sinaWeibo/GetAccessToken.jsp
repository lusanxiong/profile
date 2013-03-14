<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.job528.sina.weibo.Oauth2" %>   
<%@ page import="com.job528.sina.weibo.SinaAccount" %>   
<%@ page import="java.util.*" %> 
<%
	//换取Access Token 
	String code = request.getParameter("code");
	Map<String, String> map = Oauth2.getAccessTokenByCode(code);
	out.println("map=="+map);
	
	String accessToken = map.get("accessToken");
	out.println("sina_uid="+SinaAccount.getUid(accessToken));
	
%>
