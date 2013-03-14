<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%
	menu = "job";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>推荐给我的职位</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/hqerve.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>
		<script type="text/javascript">
	//收藏
	function f_open(val) {
		window.open(
				"${job528Domain}/personal/center/util/placetomyfavourite.do?posId="
						+ val, "", "width=500,height=350");
	}
	//应聘				
	function r_open(val) {
		window.open(
				"${job528Domain}/personal/center/util/my_apply_online.do?posId="
						+ val, "", "width=500,height=350");
	}

	function delReJob() {

		var reIds = "";

		for ( var i = 0; i < document.thisForm.elements.length; i++) {

			var e = document.thisForm.elements[i];

			if (e.name == 'reId' && e.checked == true) {

				if (reIds != "")

					reIds += ",";

				reIds += $(e).val();

			}

		}

		if (reIds == "") {

			alert("请选择要删除的职位！");

		} else {

			$("#reIds").val(reIds);

			document.thisForm.action = "myRecommend.shtml";

			document.thisForm.submit();

		}

	}

	function goPage(p) {

		$("#page").val(p);

		document.thisForm.action = "myRecommend.shtml";

		document.thisForm.submit();

	}
</script>
	</head>
	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->
		<!--求职 S-->
		<div class="job_box">
			<%@include file="/common/left.jsp"%>
			<div class="job_left">
				<div class="basic">
					<div class="basic_l">
						<span>推荐的职位</span>
					</div>
					<div class="basic_r" style="display: none">
						<span>English</span>
					</div>
				</div>
				<form name="thisForm" method="post">
					<input type="hidden" id="reIds" name="reIds" />
					<input type="hidden" id="page" name="page" />
					<table width="769" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#e0e8ec" style="font-size: 12px; float:left">
						<tr style="background-color:#f3f7f9;">
							<td width="30" height="30">&nbsp;
								
							</td>
							<td width="200" height="30" align="left"  class="jobs_me">
								推荐岗位
							</td>
							<td width="200" height="30" align="left"  class="jobs_me">
								企业名称
							</td>
							<td width="80" height="30" align="center"  class="jobs_me">
								推荐日期
							</td>
							<td width="65" height="30" align="center"  class="jobs_me">
								推荐人
							</td>
						</tr>
						<c:forEach items="${jobPager.list}" var="job">
							<tr>

								<td height="30" align="center" valign="middle" bgcolor="#FFFFFF">
									<label>
										<input type="checkbox" name="reId" id="reId"
											value="${job.myRecommendJob.id}" />
									</label>
								</td>

								<td height="30" bgcolor="#FFFFFF" class="jobs_me">
									<a
										href="${job528Domain}/resume/util/p${job.myRecommendJob.posId}.html"
										class="ls" target="_blank">${job.posName}</a>
								</td>
								<td height="30" bgcolor="#FFFFFF" class="jobs_me">
									<a
										href="${job528Domain}/resume/util/${job.myRecommendJob.memId}.html"
										class="ls" target="_blank">${job.memName}</a>
								</td>
								<td height="30" align="center" bgcolor="#FFFFFF" class="jobs_me">
									${job.postDate}
								</td>
								<td height="30" align="center" bgcolor="#FFFFFF" class="jobs_me">
									<a
										href="../profile/user.shtml?uid=${job.myRecommendJob.userId}"
										class="blues" target="_blank">${job.userName}看看他(她)是谁</a>
								</td>
							</tr>
						</c:forEach>
						<c:if test="${jobPager.totalPages <= 0}">	
						<tr>
							<td height="30" colspan="5" align="left" bgcolor="#FFFFFF">
								<div style="text-align: center"><font id="noWeiboTip" style="color:#999;font-size:14px;">没有推荐给你的职位！</font></div>
							</td>
						</tr>
						</c:if>
					</table>
				</form>
				<c:if test="${jobPager.totalPages > 0}">
				<div class="jobs_an">
				
				    <c:if test="${jobPager.totalPages > 1}">
     <c:if test="${page > 1}"><span class="jobs_aniu" onclick="goPage(${page-1});">上一页</span></c:if>
      <c:if test="${page <= 1}"><span class="jobs_aniu" style="cursor: text;" onclick="alert('已经是第一页了！');">上一页</span></c:if>
	 
	 <c:if test="${page < jobPager.totalPages}">
	 <span class="jobs_aniu" onclick="goPage(${page+1});">下一页</span>
	 </c:if>
	 
	  <c:if test="${page >= jobPager.totalPages}">
	 <span class="jobs_aniu" style="cursor: text;" onclick="alert('已经是最后一页了！');">下一页</span>
	 </c:if>
	 
	 </c:if>
					<span class="jobs_aniu" onclick="delReJob();">删除职位</span>
				</div>
				</c:if>
			</div>



			<div class="clear"></div>
		</div>
		<!--求职 E-->

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
