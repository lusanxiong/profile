<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${experiences}" var="experience" varStatus="con">
	<div class="info_table" id="experienceContainer${experience.myWorkExp.id}">
		<%@ include file="experience_content.jsp"%>
	</div>
	<div class="blankline"></div>
</c:forEach>