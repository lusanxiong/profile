
function trainingValidator(){
	var beginDateObj =  $("#beginDate");
	var beginDate = $.trim(beginDateObj.val());
	if(!beginDate) {
		Resume.showMsg(beginDateObj, "请填写开始时间");
		return false;
	}

	if(!isFormatDate(beginDate)){
		Resume.showMsg(beginDateObj, "请填写正确的开始时间");
		return false;
	}

	var endDateObj =  $("#endDate");
	var endDate = endDateObj.val();
	if(!endDate) {
		Resume.showMsg(endDateObj, "请填写结束时间");
		return false;
	}

	if(!isFormatDate(endDate)){
		Resume.showMsg(endDateObj, "请填写正确的结束时间");
		return ;
	}

	var organizationObj = $("#organization");
	var organization = $.trim(organizationObj.val());
	if(!organization){
		Resume.showMsg(organizationObj, "请填写培训机构");
		return false;
	}

	var courseObj = $("#course");
	var course = $.trim(courseObj.val())
	if(!course){
		Resume.showMsg(courseObj, "请填写培训项目");
		return false;
	}
	return true;
}

$(function(){
	var trainingStatus = true;
	$("#trainingSave").click(function(){
		if(!trainingValidator()){
			return;
		}
		
		if(!trainingStatus) {
			return false;
		}
		
		trainingStatus = false;
		$.post(basePath + "/profile/trainingMerge.shtml", $("#trainingForm").serialize(),function(){
			$("#trainingContainer").load(basePath + "/profile/trainingShow.shtml");
			$("#trainingEditContainer").html("").hide();
			trainingStatus = true;
		});
		
	});

	$("#trainingBack").click(function(){
		$("#trainingEditContainer").html("").hide();
	});	
})