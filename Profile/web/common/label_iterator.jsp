<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach  items="${labels}" var="label" varStatus="vs" >
<%@ include file="label_content.jsp" %>
</c:forEach>
