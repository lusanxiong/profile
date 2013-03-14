<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${hotLabels}" var="labels" varStatus="vs">
	<a title="添加" href="javascript:void(0);" onclick="Label.add2('${labels.labelName}')"><span>${labels.labelName}</span><em></em></a>
</c:forEach>