<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
<c:forEach items="${userPage.list}" var="friend">
	<li>
		<span class="fxk"><input name="ckFriends" type="checkbox" value="${friend.uid}"/>
		</span><span class="img"><img src="${basePath}/images/ricky.gif" width="30"
				height="30" />
		</span><span class="name">${friend.name}</span>
	</li>
</c:forEach>

</ul>

<c:if test="${userPage.totalPages <= 0}">
  <div style="margin-top: 5px; margin-buttom: 5px;"> 没有粉丝数据！</div>
</c:if>

<input type="hidden" id="txtFrdPages" value="${userPage.totalPages}"/>