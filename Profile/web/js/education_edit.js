
function educationValidator() {
	var beginDateObj = $("#beginDate");
	var beginDate = $.trim(beginDateObj.val());
	
	if(!beginDate){
		Resume.showMsg(beginDateObj, "请填写开始时间");
		return false;
	}

	if(!isFormatDate(beginDate)){
		Resume.showMsg(beginDateObj, "请填写正确的开始时间");
		return false;
	}

	var endDateObj = $("#endDate");
	var endDate = $.trim(endDateObj.val());
	if(endDate && "至今"!=endDate && !isFormatDate(endDate)){
		Resume.showMsg(endDateObj, "请填写正确的结束时间");
		return false;
	}				

	var schoolNameObj = $("#schoolName");
	var schoolName = $.trim(schoolNameObj.val());
	if(!schoolName){
		Resume.showMsg(schoolNameObj, "请填写学校名称");
		return false;
	}

	var specialityObj = $("#speciality");
	var speciality = $.trim(specialityObj.val());
	if(!speciality){
		Resume.showMsg(specialityObj, "请填写专业名称");
		return false;
	}

	
	var degreeIdObj = $("#degreeId");
	var degreeId = $.trim(degreeIdObj.val());
	if(degreeId==-1){
		Resume.showMsg(degreeIdObj, "请选择学历");
		return false;
	}
	return true;
}

$(function(){
	$("#eductionBack").click(function(){
		$("#educationEditContainer").html("").hide();
	});

	var educationStauts = true;
	$("#eductionSave").click(function(){
		
		if(!educationValidator()) {
			return ;
		}

		if(!educationStauts) {
			return ;
		}
		educationStauts=false;
		$.post(basePath + "/profile/educationMerge.shtml", $("#educationForm").serialize(),function(){
			$("#educationContainer").load(basePath + "/profile/educationShow.shtml");
			$("#educationEditContainer").html("").hide();
			educationStauts=true;
		});

	});
	
})