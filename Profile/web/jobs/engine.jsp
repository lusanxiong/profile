<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%menu="job";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>个人搜索器</title>
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
		<script type="text/javascript">

	    <!--
$(function(){ 
    var keywordType = "${searcher.mySearcher.keywordType}";
    $("#keywordType"+keywordType).attr("checked","checked");
})

		 -->

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
						<span>个人搜索器</span>
					</div>
					
				</div>
				<form name="frmSearcher" method="post" action="saveSearcher.shtml">
				    <input name="jobFunction1" id="jobFunction1" type="hidden" value="${searcher.mySearcher.jobFunction1}">
                    <input name="jobFunction2" id="jobFunction2" type="hidden" value="${searcher.mySearcher.jobFunction2}">
                    <input name="jobFunction3" id="jobFunction3" type="hidden" value="${searcher.mySearcher.jobFunction3}">
                    <input name="jobLocation1" id="jobLocation1" type="hidden" value="${searcher.mySearcher.jobLocation1}">
                    <input name="jobLocation2" id="jobLocation2" type="hidden" value="${searcher.mySearcher.jobLocation2}">
                    <input name="jobLocation3" id="jobLocation3" type="hidden" value="${searcher.mySearcher.jobLocation3}">
                    <input name="calling1" id="calling1" type="hidden" value="${searcher.mySearcher.calling1}">
                    <input name="calling2" id="calling2" type="hidden" value="${searcher.mySearcher.calling2}">
                    <input name="calling3" id="calling3" type="hidden" value="${searcher.mySearcher.calling3}">
                    <input name="sid" id="sid" type="hidden" value="${searcher.mySearcher.id}">
				    
					<table width="769" cellspacing="1" bgcolor="e9edf1"
					style="font-size: 12px; float: left">
					<tr>
                    <td width="113" height="32" align="center" bgcolor="#f3f7f9">搜索器名称：</td>
					<td width="245" height="32" align="left" bgcolor="#FFFFFF" class="table_td">
					<span><input type="text" name="searcherName" id="searcherName"
					class="job_con_block" style="width: 230px" value="${searcher.mySearcher.searcherName}"/> </span>							</td>
				<td width="113" height="32" colspan="-1" align="center" bgcolor="#f3f7f9">订阅类型：</td>
				<td height="32" align="center" bgcolor="#FFFFFF">
				<span class="job_con_fxk">
							<c:if test="${searcher.mySearcher.phoneOrder}">
							<input name="ckMobileOrder" onclick="bookChangerMobile(this);" type="checkbox" value="${loginResume.myResume.mobileNum}" checked="checked" />
							</c:if>
							<c:if test="${!searcher.mySearcher.phoneOrder}">
							<input name="ckMobileOrder" onclick="bookChangerMobile(this);" type="checkbox" value="${loginResume.myResume.mobileNum}"/>
							</c:if>
						</span>
			<span class="job_con_txt">手机订阅</span>
			<span class="job_con_fxk">
			<c:if test="${searcher.mySearcher.subscibeFlag}"><input name="ckEmailOrder" type="checkbox" onclick="bookChangerEmail(this);" value="${loginResume.myResume.email}" checked="checked" /></c:if>
			<c:if test="${!searcher.mySearcher.subscibeFlag}"><input name="ckEmailOrder" type="checkbox" onclick="bookChangerEmail(this);" value="${loginResume.myResume.email}"/></c:if>
			</span>
			<span class="job_con_txt">邮件订阅</span>							</td>
						</tr>
					<tr>
                      <td height="32" align="center" bgcolor="#f3f7f9">关&nbsp;&nbsp;键&nbsp;&nbsp;字：</td>
					  <td height="32" colspan="3" align="left" bgcolor="#FFFFFF" class="table_td"><span>
           <input type="text" name="keyword" id="keyword"
		   class="job_con_block" style="width:230px" value="${searcher.mySearcher.keyword}"/></span>
		  <span class="job_con_dxk"><input name="keywordType" id="keywordType0" type="radio" value="0"></span>
          <span class="job_con_txt">职位</span>
          <span class="job_con_dxk"><input name="keywordType" id="keywordType1" type="radio" value="1"></span>
          <span class="job_con_txt">单位</span>
          <span class="job_con_dxk"><input name="keywordType" id="keywordType2" type="radio" value="2"></span>
          <span class="job_con_txt">不限</span>
		   </td>
					  </tr>
						<tr>
							<td width="113" height="32" align="center" bgcolor="#f3f7f9">
								发布日期：							</td>
							<td height="32" bgcolor="#FFFFFF" class="table_td">
								<span class="job_con_center_drop_kuang"> <label>
										<select size="1" name="positionPostDate" id="positionPostDate"
											class="job_con_center_drop_kuang">
											${searcher.postDateStr}
											<option value="">
												--请选择--
											</option>
											<option value="1">
												一天内											</option>
											<option value="3">
												三天内											</option>
											<option value="7">
												一周内											</option>
											<option value="15">
												半月内											</option>
											<option value="30">
												一月内											</option>
											<option value="90">
												三月内											</option>
											<option value="180">
												半年内											</option>
											<option value="360">
												一年内											</option>
										</select>
									</label> </span>							</td>

							<td width="113" height="32" colspan="-1" align="center" bgcolor="#f3f7f9">
								工作地方：							</td>
							<td height="32" bgcolor="#FFFFFF" class="table_td">
								<span class="job_con_center_drop_kuang"> <input
										type="button" id="btnJobLocation"
										class="resume_profile_select" value="${searcher.location!=null?searcher.location:'请选择'}" /> </span>							</td>
						</tr>
						<tr>
						<td width="113" height="32" colspan="-1" align="center" bgcolor="#f3f7f9">
								公司行业：							</td>
							<td height="32" bgcolor="#FFFFFF" class="table_td">
								<span class="job_con_center_drop_kuang"><label>
										<input type="button" class="resume_profile_select" value="${searcher.calling!=null?searcher.calling:'请选择'}"
											id="btnCalling" />
									</label> </span>							</td>
							<td width="113" height="32" align="center" bgcolor="#f3f7f9">
								职位类别：							</td>
							<td height="32" bgcolor="#FFFFFF" class="table_td">
								<span class="job_con_center_drop_kuang"><label>
										<input type="button" class="resume_profile_select" value="${searcher.function!=null?searcher.function:'请选择'}"
											id="btnJobFunction"/>
									</label> </span>							</td>

							
						</tr>
						<tr><td width="113" height="32" align="center" bgcolor="#f3f7f9">
								学历要求：														</td>
							<td height="32" bgcolor="#FFFFFF" class="table_td"><select name="degreeID" class="job_con_center_drop_kuang"
											id="degreeID">
							  
											${searcher.degreeStr}
											
							  <option value=""> --请选择-- </option>
                              <option value="10"> 初中 </option>
                              <option value="20"> 高中 </option>
                              <option value="25"> 中技 </option>
                              <option value="30"> 中专 </option>
                              <option value="40"> 大专 </option>
                              <option value="50"> 本科 </option>
                              <option value="55"> MBA </option>
                              <option value="60"> 硕士 </option>
                              <option value="70"> 博士 </option>
                              <option value="90"> 不限 </option>
                            </select>							</td>
							
							
<td width="113" height="32" colspan="-1" align="center" bgcolor="#f3f7f9">
								工作年限：							</td>
							<td height="32" bgcolor="#FFFFFF" class="table_td">
								<span class="job_con_center_drop_kuang"> <label>

										<select class="job_con_center_drop_kuang" name="ReqWorkyear"
											id="ReqWorkyear">
											${searcher.workYearStr}
											<option  value="11">
												不限
											</option>
											<option value="-1">
												在读学生											</option>
											<option value="0">
												毕业生											</option>
											<option value="1">
												1年											</option>
											<option value="2">
												2年											</option>
											<option value="3">
												3年											</option>
											<option value="5">
												5年											</option>
											<option value="8">
												8年											</option>
											<option value="10">
												10年											</option>
										</select>
									</label> </span>							</td>
						</tr>
						</table>
					<span class="job_con_center_drop_button">
					<input type="button" value="保  存"
					class="job_con_center_drop_buttons" id="btnSearch" onclick="save();" />
					</span>
				</form>
			</div>
		</div>						
		<div class="clear"></div>
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
