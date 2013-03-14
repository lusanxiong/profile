<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${experiences}" var="experience" varStatus="con">
	<%@ include file="experience_content.jsp"%>
</c:forEach>