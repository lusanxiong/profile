<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${languageAbility.languages}" var="language"
	varStatus="status">
	<div class="info_table"
		id="languageContainer${language.myLanguage.languageId}">
		<%@ include file="language_content.jsp"%>
		<div class="blankline"></div>
	</div>
</c:forEach>
<p class="add_info">
	<input type="button" value="增加信息" class="resume_addInfo"
		onclick="Language.add()" />
	<span id="_bsSubmitMsg" style="color: red; margin-left: 5px;"></span>
</p>