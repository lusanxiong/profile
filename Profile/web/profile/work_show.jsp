<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		$("#workEditBtn").click(function(){
			$("#workContainer").load(basePath + "/profile/workEdit.shtml");
		});
	})
</script>
<div class="resume_left">
<table width="680" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="59%" align="left">
			我有： ${resume.myResume.workedYear}年${resume.myResume.workedMonth}月工作经验 曾在${resume.myResume.workedComNumber}家企业工作
		</td>
        <td width="60"colspan="2"></td>
		<td width="41%">
			
		</td>
		
	</tr>
</table></div>
<div class="resume_right"><span id="workEditBtn" style="background: url(${basePath}/images/resume/btn_modify.gif) no-repeat; float: right; width: 45px; height: 17px; display: block; cursor: pointer; margin-top:5px;"></span>
			<span id="_bsSubmitMsg1" style="color: red; margin-left: 5px;"></span></div>
