
function intentionValidator() {
	var jobFunction1 = $("#jobFunction1").val();
	var jobFunction2 = $("#jobFunction2").val();
	var jobFunction3 = $("#jobFunction3").val();
	
	if(jobFunction1 == "0" && jobFunction2 == "0" && jobFunction3 == "0"){
		Resume.showMsg($("#spCalling"), "请选择岗位类别 ")
		return false;
	}
	
	var jobSeeking1 = $("#jobSeeking1").val();
	var jobSeeking2 = $("#jobSeeking2").val();
	var jobSeeking3 = $("#jobSeeking3").val();
	
	if(jobSeeking1 == "" && jobSeeking2 == "" && jobSeeking3 == ""){
		Resume.showMsg($("#jobSeeking1"), "请填写意向职位 ")
		return false;
	}
	
	var jobLocation1 = $("#jobLocation1").val();
	var jobLocation2 = $("#jobLocation2").val();
	var jobLocation3 = $("#jobLocation3").val();
	if(jobLocation1=="0"&&jobLocation2=="0"&&jobLocation3=="0"){
		Resume.showMsg($("#spLocation"), "请选择工作地点 ")
        return false;
	}
	return true;
}

$(function() {
	$("#intentionBack").click(function() {
		$("#intentionContainer").load(basePath + "/profile/intentionShow.shtml");
	});

	var intentionStatus = true;
	$("#intentionSave").click(function() {
		if(!intentionValidator()) {
			return;
		}
		if(!intentionStatus){
			return;
		}
		intentionStatus = false;
		
		$.post(basePath + "/profile/intentionUpdate.shtml", $("#intentionForm").serialize(),function(){
			$("#intentionContainer").load(basePath + "/profile/intentionShow.shtml");
			intentionStatus = true;
		});
	});

});