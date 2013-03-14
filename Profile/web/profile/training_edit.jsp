<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${trainingList}" var="training">
<script type="text/javascript" src="${basePath}/js/training_edit.js"></script>
	<div class="resume_left">
		<form method="post" id="trainingForm">
		<input type="hidden" name="id" value="${training.myTraining.id}" />
			<table width="100%" border="0" cellspacing="1" cellpadding="0">
				<tr>
					<th width="81"  align="right" nowrap="nowrap">
						<span class="font_hilite">*</span>培训时间：
					</th>
					<td width="516" valign="left" colspan="3">
						<span style="margin-left: 0px; float: left; display: inline">
							<input name="beginDate" id="beginDate" type="text" 
								class="resume_profile_wbk" value="${training.myTraining.beginDate}" style="width:77px;" /> </span>
						<span style="float: left; margin: 4px 0 0 5px; display: inline">至</span>
						<span style="margin-left: 5px; float: left; display: inline;">
							<input name="endDate" id="endDate" type="text"
								class="resume_profile_wbk" value="${training.myTraining.endDate}" style="width:77px;" /> </span>
						<span id="msgTimeShow"
							style="float: left; margin: 4px 0 0 5px; display: inline; color:#8b8a8a;">(格式：2011-09)</span>
					</td>
				</tr>
				<tr>
					<th width="81"  align="right" nowrap="nowrap" >
						<span class="font_hilite">*</span>培训机构：
					</th>
					<td valign="middle" colspan="3" align="left">
							<input name="organization" id="organization" type="text" value="${training.myTraining.organization}"
								size="26" maxlength="26"  class="resume_profile_wbk" style="width:184px;"/>
					</td>
				</tr>
				<tr>
					<th width="81"  align="right" valign="middle"
						nowrap="nowrap">
						<span class="font_hilite">*</span>培训项目：
					</th>
                    <td align="left" valign="middle" nowrap="nowrap"><input name="course" id="course" type="text" value="${training.myTraining.course}"class="resume_profile_wbk" size="26" maxlength="26" style="width:184px;" /> </td>
                    <th width="81"  align="right" valign="middle" nowrap="nowrap">获奖证书：</th>
                      <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="certificate" id="certificate" value="${training.myTraining.certificate}" class="resume_profile_wbk" size="26" maxlength="26" style="width:184px;"/> </td>
				</tr>
			</table>
		</form>
	</div>
	<div class="resume_right">
		<a href="javascript:void(0);" class="new_FB_a_1" id="trainingSave"><img
				src="../images/resume/btn_save.gif" />
		</a><a href="javascript:void(0);" class="new_FB_a_1" id="trainingBack"><img
				src="../images/resume/btn_reback.gif" />
		</a>
	</div>
</c:forEach>