<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		$("#workSave").click(function(){
			var yearObj = $("#workedYear");
			var monthObj = $("#workedMonth");
			var numberObj = $("#workedComNumber");
			var year = $.trim(yearObj.val());
			var month = $.trim(monthObj.val()); 
			var number = $.trim(numberObj.val());  

			if(year && !isNumber(year)) {
				Resume.showMsg(yearObj, "请填写正确的工作时间（年份）")
				return;
			}
			if(month && !isNumber(month)) {
				Resume.showMsg(monthObj, "请填写正确的工作时间（月份）")
				return;
			}
			if(number && !isNumber(number)) {
				Resume.showMsg(numberObj, "请填写正确的工作时间（企业）")
				return;
			}
			
			$.post(basePath + "/profile/workUpdate.shtml", $("#workForm").serialize(),function(){
				$("#workContainer").load(basePath + "/profile/workShow.shtml");
			});
		});

		$("#workBack").click(function(){
			$("#workContainer").load(basePath + "/profile/workShow.shtml");
		});
	})
</script>
<form id="workForm">
<div class="resume_left">
<table width="680" border="0" cellspacing="0" cellpadding="0"
	class="exper_title">
	<tr>
		<td width="59%" align="left">
			我有：
			<input type="text" class="resume_profile_wbks" id="workedYear" name="workedYear"
				value="${loginResume.myResume.workedYear}" />
			年
			<input type="text" class="resume_profile_wbks" id="workedMonth" name="workedMonth"
				value="${loginResume.myResume.workedMonth}" />
			月工作经验 曾在
			<input type="text" class="resume_profile_wbks" size="1"
				id="workedComNumber" name="workedComNumber" value="${loginResume.myResume.workedComNumber}" />
			家企业工作
		</td>
		<td width="41%">
			
		</td>
		<td class="2"></td>
	</tr>
</table>
</div>
</form>
<div class="resume_right"><span id="workSave" style="background: url(${basePath}/images/resume/btn_save.gif) no-repeat; float: right; width: 45px; height: 17px; display: block; cursor: pointer; margin-top:5px;"></span>
			<span id="workBack" style="color: red; margin-left: 5px;"></span></div>