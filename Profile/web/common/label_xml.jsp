<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<result>
<resultCode>${labelResult.resultCode}</resultCode>
<labelId>${labelResult.labelId}</labelId>
<html>
<![CDATA[
<c:forEach  items="${labels}" var="label" varStatus="vs" >
<%@ include file="label_content.jsp" %>
</c:forEach>
]]>
</html>
</result>