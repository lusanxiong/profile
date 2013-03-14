<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
$(function(){
	$("#settingSave").click(function(){
		$.post(basePath + "/profile/settingUpdate.shtml", $("#settingForm").serialize(),function(){
			$("#settingContainer").load(basePath + "/profile/settingShow.shtml");
			$("#settingEditContainer").hide();
		});
	});

	$("#settingBack").click(function(){
		$("#settingEditContainer").hide();
	});
});
</script>
<form action="" id="settingForm">
<table cellpadding="0" cellspacing="1" width="500">
	<tr>
		<th align="left" nowrap="nowrap">
			简历资料设置
		</th>
		<th align="left" nowrap="nowrap">
			联系方式设置
		</th>
		<th rowspan="3">
			<a href="javascript:void(0);" id="settingSave" class="new_FB_a_1"><img
					src="../images/resume/btn_save.gif" /> </a>
			<a href="javascript:void(0);" id="settingBack" class="new_FB_a_1"><img
			src="../images/resume/btn_reback.gif" /> </a>
		</th>
	</tr>
	<tr>
		<td nowrap="nowrap">
			<input type="radio" name="chkResumeStatus" value="0" ${account.resumeStatus==0?'checked="checked"':''} />
			完全公开我的简历
		</td>
		<td nowrap="nowrap">
			<input type="radio" name="chkRelationFlag" value="0" ${account.relationFlag==0?'checked="checked"':''}/>
			公开我的联系方式
		</td>
	</tr>
	<tr>
		<td nowrap="nowrap">
			<input type="radio" name="chkResumeStatus" value="1" ${account.resumeStatus==1?'checked="checked"':''} />
			不公开（完全保密，任何人都搜索不到您的简历）
		</td>
		<td nowrap="nowrap">
			<input type="radio" name="chkRelationFlag" value="1" ${account.relationFlag==1?'checked="checked"':''} />
			不公开我的联系方式
		</td>
	</tr>
	<tr>
		<td colspan="3" nowrap="nowrap">
			<input type="radio" name="chkResumeStatus" value="2" ${account.resumeStatus==2?'checked="checked"':''}/>
			公开，但对
			<input type="text" value="${account.partComName}" name="partComName" style="width:217px;" class="resume_profile_wbk" />
			保密<span class="edit_tishi">（多个企业用英文分号“;”分隔）</span>
		</td>
	</tr>
</table>
</form>