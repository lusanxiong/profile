<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%menu = "job";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>职位搜索</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>
		<script type="text/javascript" src="${basePath}/js/jquery.blockUI.js"></script>
		<script type="text/javascript" src="${basePath}/js/address.js"></script>
		<script type="text/javascript" src="${basePath}/js/addressdialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/calling.js"></script>
		<script type="text/javascript" src="${basePath}/js/callingdialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/jobs.js"></script>
		<script type="text/javascript" src="${basePath}/js/recommend.js"></script>

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
						<span>职位搜索</span>
					</div>
					<div class="basic_rs" style="display: none">
						<span>English</span>
					</div>
				</div>

				<div class="job_up_box">
					<div class="job_up_box_s">
						<form name="frmJobs" method="post" action="searchJobs.shtml">
							<input name="jobFunction1" id="jobFunction1" type="hidden" value="">
							<input name="jobFunction2" id="jobFunction2" type="hidden" value="">
							<input name="jobFunction3" id="jobFunction3" type="hidden" value="">
							<input name="jobLocation1" id="jobLocation1" type="hidden" value="">
							<input name="jobLocation2" id="jobLocation2" type="hidden" value="">
							<input name="jobLocation3" id="jobLocation3" type="hidden" value="">
							<input name="calling1" id="calling1" type="hidden" value="">
							<input name="calling2" id="calling2" type="hidden" value="">
							<input name="calling3" id="calling3" type="hidden" value="">
							<span>
							<input type="text" name="keyword" id="keyword" class="job_con_block" style="width: 228px" value="${keyWord}" />
							</span>
							<span class="job_con_dxk">
							<input name="keywordType" type="radio" value="0">
							</span>
							<span class="job_con_txt">职位</span>
							<span class="job_con_dxk">
							<input name="keywordType" type="radio" value="1">
							</span>
							<span class="job_con_txt">单位</span>
							<span class="job_con_dxk">
							<input name="keywordType" type="radio" value="2">
							</span>
							<span class="job_con_txt">不限</span>
							<span class="job_up_box_bg" id="btnCalling">行业类别</span>
							<span class="job_up_box_bg" id="btnJobLocation">所在地区</span>
							<span class="job_con_center_drop_button">
							<input type="button" value="搜  素" class="job_con_center_drop_buttons" id="btnSearch" />
							</span>
					</div>
					<div class="jobs_up" id="divMoreCk">
						<span>高级搜索</span>
					</div>
					<div style="display: none" id="divMore">
						<div class="job_up_box_line"></div>
						<div class="clear"></div>
						<div class="job_up_box_x">
							<span class="job_con_center_drop_word">职位类别：</span>
							<span><label>
									<input type="button" class="job_up_select"
										value="${searcher.function!=null?searcher.function:'请选择'}"
										id="btnJobFunction" />
								</label>
							</span>
							<span class="job_con_center_drop_word">公司性质：</span>
							<span> <label>
									<select class="job_con_center_drop_kuang" name="properity"
										id="properity">
										<option value="">
											--请选择--
										</option>
										<option value="1">
											外资
										</option>
										<option value="2">
											合资
										</option>
										<option value="3">
											国企
										</option>
										<option value="4">
											民营公司
										</option>
										<option value="5">
											其它性质
										</option>
									</select>
								</label> </span>

							<span class="job_con_center_drop_word"
								style="float: left; margin-left: 30px; display: inline">学历要求：</span>
							<span> <label>
									<select name="degreeID" class="job_con_center_drop_kuang"
										id="degreeID">
										${searcher.degreeStr}
										<option value="">
											--请选择--
										</option>
										<option value="10">
											初中
										</option>
										<option value="20">
											高中
										</option>
										<option value="25">
											中技
										</option>
										<option value="30">
											中专
										</option>
										<option value="40">
											大专
										</option>
										<option value="50">
											本科
										</option>
										<option value="55">
											MBA
										</option>
										<option value="60">
											硕士
										</option>
										<option value="70">
											博士
										</option>
										<option value="90">
											不限
										</option>
									</select>
								</label> </span>
						</div>
						<div class="job_up_box_x">
							<span class="job_con_center_drop_word">发布日期：</span>
							<span> <label>
									<select size="1" name="positionPostDate" id="positionPostDate"
										class="job_con_center_drop_kuang">
										${searcher.postDateStr}
										<option value="">
											--请选择--
										</option>
										<option value="1">
											一天内
										</option>
										<option value="3">
											三天内
										</option>
										<option value="7">
											一周内
										</option>
										<option value="15">
											半月内
										</option>
										<option value="30">
											一月内
										</option>
										<option value="90">
											三月内
										</option>
										<option value="180">
											半年内
										</option>
										<option value="360">
											一年内
										</option>
									</select>
								</label> </span>

							<span class="job_con_center_drop_word"
								style="float: left; margin-left: 61px; display: inline">工作年限：</span>
							<span> <label>
									<select name="ReqWorkyear" class="job_con_center_drop_kuang" id="ReqWorkyear">
										<option value="">
											--请选择--
										</option>
										<option value="-1">
											在读学生
										</option>
										<option value="0">
											毕业生
										</option>
										<option value="1">
											1年
										</option>
										<option value="2">
											2年
										</option>
										<option value="3">
											3年
										</option>
										<option value="5">
											5年
										</option>
										<option value="8">
											8年
										</option>
										<option value="10">
											10年
										</option>
										<option value="11">
											不限
										</option>
									</select>
								</label> </span>

							<span class="job_con_center_drop_word"
								style="float: left; margin-left: 30px; display: inline">月薪范围：</span>
							<span> <label>
									<select class="job_con_center_drop_kuang" name="providesalary"
										id="providesalary">
										<option value="">
											--请选择--
										</option>
										<option value="0">
											面议
										</option>
										<option value="1">
											1500以下
										</option>
										<option value="2">
											2000-2999
										</option>
										<option value="3">
											3000-4499
										</option>
										<option value="4">
											4500-5999
										</option>
										<option value="5">
											6000-7999
										</option>
										<option value="6">
											8000-9999
										</option>
										<option value="7">
											10000-14999
										</option>
										<option value="8">
											15000-19999
										</option>
										<option value="9">
											20000-29999
										</option>
										<option value="10">
											30000-49999
										</option>
										<option value="11">
											50000及以上
										</option>
									</select>
								</label> </span>
						</div>
						<div class="jobs_dw" style="display: none" id="divLessCk">
							<span>简单搜索</span>
						</div>
					</div>
					<div class="clear"></div>
				</div>



				</form>

				<div class="job_con_center_tle">
					<span>搜索到的职位</span><span style="color: red; display: none;"
						id="spMsg">请选择行业！</span>
				</div>

				<div class="job_con_center_list" id="jobItems" style="display: "><%@include
						file="jobItem.jsp"%></div>
			</div>
			<div class="clear"></div>
		</div>
		</div>

		</div>
		<!--求职 E-->

		<!-- S地区 -->
		<%@include file="/common/address_dialog.jsp"%>
		<%@include file="/common/calling_dialog.jsp"%>

		<!-- E地区 -->

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>



	</body>
</html>
