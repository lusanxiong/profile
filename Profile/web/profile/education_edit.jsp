<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${educations}" var="education">
<script type="text/javascript" src="${basePath}/js/education_edit.js"></script>
<script type="text/javascript">
$(function(){
	$("#educationForm").find("#degreeId").val(${education.myEducation.degreeId}); //初始化学位
})
</script>
	<div class="resume_left">
		<form method="post" id="educationForm">
			<table width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th width="81"  align="right" nowrap="nowrap">
						<input type="hidden" id="id" name="id" value="${education.myEducation.id}" />
						<span class="font_hilite">*</span>教育时间：
					</th>
					<td width="516" valign="middle">
						<span style="margin-left: 5px; float: left; display: inline">
							<input name="beginDate" type="text" class="resume_profile_wbk"
								value="${education.myEducation.beginDate}" id="beginDate" style="width:81px;" /> </span>
						<!-- <span
																	style="margin-left: 5px; float: left; display: inline; cursor: pointer">
																	<img src="${basePath}/images/date_book.gif" width="14"
																		height="16" />
																</span>-->
						<span style="float: left; margin: 4px 0 0 5px; display: inline">至</span>
						<span style="margin-left: 5px; float: left; display: inline;">
							<input name="endDate" type="text" class="resume_profile_wbk"
								value="${education.myEducation.endDate}" id="endDate" style="width:81px;" /> </span>
						<span id="msgTimeShow"
							style="float: left; margin: 4px 0 0 5px; display: inline; color:#8b8a8a;">(格式：2011-09)</span>
					</td>
				</tr>
				<tr>
					<th width="81"  align="right" nowrap="nowrap">
						<span class="font_hilite">*</span>学校名称：
					</th>
					<td valign="middle">
						<span style="margin-left: 5px; float: left; display: inline;">
							<input name="schoolName" type="text" size="26" value="${education.myEducation.schoolName}"
								class="resume_profile_wbk" id="schoolName" maxlength="50" /> </span>
					</td>
				</tr>
				<tr>
					<th width="81"  align="right" valign="middle"
						nowrap="nowrap">
						<span class="font_hilite">*</span>专 业：
					</th>
					<td align="center" valign="middle">
						<span style="margin: 0 5px; float: left; display: inline;">
							<input name="speciality" type="text" class="resume_profile_wbk"
								size="26" id="speciality" maxlength="50" value="${education.myEducation.speciality}" /> </span>
					</td>
				</tr>
				<tr>
					<th width="81"  align="right" valign="middle"
						nowrap="nowrap">
						证书编号：
					</th>
					<td align="center" valign="middle">
						<span style="margin: 0 5px; float: left; display: inline;">
							<input name="certificate" type="text" class="resume_profile_wbk"
								size="26" id="certificate" maxlength="50" value="${education.myEducation.certificate}" /> </span>
					</td>
				</tr>
				<tr>
					<th width="81"  align="right" valign="middle"
						nowrap="nowrap">
						<span class="font_hilite">*</span>学 历：
					</th>
					<td align="center" valign="middle">
						<span style="margin: 0 5px; float: left; display: inline;">
							<select name="degreeId" id="degreeId">
								<option value="-1" selected="selected">
									请选择学历
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
							</select> </span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="resume_right">
		<a href="javascript:void(0);" id="eductionSave" class="new_FB_a_1"><img
				src="../images/resume/btn_save.gif" />
		</a><a href="javascript:void(0);" id="eductionBack" class="new_FB_a_1"><img
				src="../images/resume/btn_reback.gif" />
		</a>
	</div>
</c:forEach>
