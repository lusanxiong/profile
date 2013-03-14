<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
$(function(){
	var additionalStatus = true;
	$("#additionalSave").click(function(){
		if(!additionalStatus) {
			return;
		}
		additionalStatus = false;
		$.post(basePath + "/profile/additionalUpdate.shtml", $("#additionalForm").serialize(),function(){
			$("#additionalContainer").load(basePath + "/profile/additionalShow.shtml");
			additionalStatus  = true;
		});
	});

	$("#additionalBack").click(function(){
		$("#additionalContainer").load(basePath + "/profile/additionalShow.shtml");
	});
});
</script>
<div class="resume_left">
	<form method="post" id="additionalForm">
		<input type="hidden" name="edtag" value="0" />
		<table width="100%" border="0" cellspacing="1" cellpadding="0">
			<tr>
				<td height="34" colspan="2" align="left">
					<span
						style="margin: 8px 5px 0 5px; padding-bottom: 8px; float: left; text-align: left; display: inline; color:#8b8a8a;">请详细并有重点地描述您的相关技能，字数在20~1000字之间。另外，请注明一些与您职业密切相关的关键字，<br/>如“企业管理5年经验”等，以便人事经理在查询人才时，使用这些关键字快速地找到。
					</span>
				</td>
			</tr>
			<tr>
				<td align="left" valign="middle">
					<span style="margin: 8px 5px; float: left; display: inline;">
						<textarea name="otherSkills" cols="68" rows="4"
							class="resume_profile_tbks">${resume.myResume.otherSkills}</textarea>
					</span>
				</td>
			</tr>
		</table>
	</form>
</div>
<div class="resume_right">
	<a href="javascript:void(0);" id="additionalSave" class="new_FB_a_1"><img
			src="../images/resume/btn_save.gif" />
	</a><a href="javascript:void(0);" id="additionalBack" class="new_FB_a_1"><img
			src="../images/resume/btn_reback.gif" />
	</a>
</div>
