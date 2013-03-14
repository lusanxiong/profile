<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
$(function(){
	$("#settingEditBtn").click(function(){
		$("#settingEditContainer").load(basePath+"/profile/settingEdit.shtml").show();
	});
});
</script>
<p class="RB_resumeSet"><span>${account.resumeStatusName}&nbsp;&nbsp;&nbsp;&nbsp;联系方式${account.contactStatusName}</span><a  href="javascript:void(0);"><img id="settingEditBtn" src="../images/resume/btn_modify.gif"/></a></p>