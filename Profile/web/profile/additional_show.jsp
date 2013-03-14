<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
$(function(){
	$("#additionalEditBtn").click(function(){
		$("#additionalContainer").load(basePath + "/profile/additionalEdit.shtml");
	});
})
</script>
<span class="item_name_2"><h1>
		相关技能
	</h1>
</span>
<div class="resume_left">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="668" colspan="2" align="left" bgcolor="#FFFFFF">
				${resume.myResume.otherSkills}
			</td>
		</tr>
	</table>
</div>
<div class="resume_right">
	<a href="javascript:void(0);" id="additionalEditBtn" class="new_FB_a_1"><img
			src="../images/resume/btn_modify.gif" />
	</a>
</div>
