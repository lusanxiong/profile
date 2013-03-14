<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${positionPager.list}" var="position" varStatus="con">
	<c:if test="${con.index % 2 == 0}">
		<div class="job_con_center_list_y">
	</c:if>
	<c:if test="${con.index % 2 != 0}">
		<div class="job_con_center_list_w">
	</c:if>

	<span class="job_con_center_list_post"><a
		href="${job528Domain}/resume/util/p${position.memSearchBean.posID}.html"
		class="blue" target="_blank">${position.memSearchBean.posName}</a> </span>
	<span class="information_company">${position.memSearchBean.memName}</span>
	<span class="job_con_center_list_add">${position.location}</span>
	<span class="job_con_center_list_time">${position.postDate}</span>
	<span class="job_con_center_list_money">${position.salary}</span>
	<span class="job_con_center_list_app"><a
		href="javascript:r_open(${position.memSearchBean.posID})"
		class="blues">申请</a> </span>
	<span class="job_con_center_list_recom"><a
		href="javascript:recommend(${position.memSearchBean.posID},${position.memSearchBean.memID});"
		class="blues">推荐</a> </span>
	</div>
</c:forEach>
 <c:if test="${positionPager.totalPages > 0}">

<div class="clear"></div>
<div class="job_con_center_list_fenye">
	<div class="job_con_center_list_fenye_l">
           <span><input type="button" value="上一页"
					class="job_con_center_list_fenye_ls" onclick="goPager(${positionPager.pageNo-1},${positionPager.totalPages})"/></span>
		   <span style="line-height:24px; margin:0 30px;">${positionPager.pageNo}/${positionPager.totalPages}</span>
			<span><input type="button" value="下一页"
					class="job_con_center_list_fenye_ls" onclick="goPager(${positionPager.pageNo + 1},${positionPager.totalPages})"/>
			</span>
	</div>
</div><div class="clear"></div>
</c:if>
<%@include file="/friends/loadfriends.jsp"%>



