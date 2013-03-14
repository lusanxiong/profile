<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
$(function(){
	$("#itSkillEditBtn").click(function(){
		$("#itSkillContainer").load(basePath + "/profile/itSkillEdit.shtml");
	});
})
</script>
<div class="resume_left">
	<table width="100%" border="0" cellspacing="1" cellpadding="0">
		<tr>
			<th width="83"  align="right" nowrap="nowrap">
				技术职称：
			</th>
			<td width="508" align="left" valign="middle">
				${resume.myResume.techTitle}
			</td>
			<th width="93"  align="right" nowrap="nowrap">
				计算机能力：
			</th>
			<td width="508" align="left" valign="middle">
				${computerLevel}
			</td>
		</tr>
		<tr>
			<th width="83"  align="right" valign="middle"
				nowrap="nowrap">
				技能描述：
			</th>
			<td align="left" valign="middle" colspan="3">
				<span style="margin: 0px 5px 0 5px; float: left; display: inline;">${resume.myResume.computerSkills}</span>
			</td>
		</tr>
	</table>
</div>
<div class="resume_right">
	<a href="javascript:void(0);" id="itSkillEditBtn" class="new_FB_a_1"><img
			src="../images/resume/btn_modify.gif" /> </a>
</div>
