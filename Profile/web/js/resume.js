var Resume = {};

Resume.showMsg = function (obj, text) {
	obj.focus();
	if($("#tipBox").length>0){
		$("#tipBox").find(".point").html(text).end().show();
		obj.closest("tr").before($("#tipBox"));
	}
	else {
		var tip = $('<tr id="tipBox"><td  height="20" align="left" valign="middle" nowrap="nowrap" colspan="4"><span class="point">'+text+'</span></td></tr>');
		obj.closest("tr").before(tip);
	}
	obj.focus();
}

Resume.closeMsg = function () {
	$("#tipBox").hide();
}

Resume.status = true;
Resume.reset = function() {
	Resume.status = true;
	$("#savingBox").hide();
}
Resume.saveAll = function() {
	if(!Resume.status){
		return;
	}
	Resume.status = false;
	$("#savingBox").show();
	//基本信息
	if($("#baseInfoForm").length>0) {
		if(!baseInfoValidator()) {
			Resume.reset();
			alert("基本信息未填写完整");
			return;
		}
		$.post(basePath + "/profile/baseInfoUpdate.shtml", $("#baseInfoForm").serialize());
	}
	
	//教育经历
	if($("#educationForm").length>0) {
		if(!educationValidator()) {
			$("#savingBox").hide();
			alert("教育简历未填写完整");
			return;
		}
		$.post(basePath + "/profile/educationMerge.shtml", $("#educationForm").serialize());
	}
	
	//培训经历
	if($("#trainingForm").length>0){
		if(!trainingValidator()) {
			$("#savingBox").hide();
			alert("培训简历未填写完整");
			return;
		}
		$.post(basePath + "/profile/trainingMerge.shtml", $("#trainingForm").serialize());
	}
	
	//言语能力
	var languageForms = $("form[languageId]");
	if(languageForms.length>0) {
		for(var i = 0;i<languageForms.length;i++){
			var form = $(languageForms[i]);
			var id = form.attr("languageId");
			$.post(basePath + "/profile/languageMerge.shtml", $("#languageForm"+id).serialize());
		}
	}
	
	//英语能力
	if($("#languageToeflForm").length>0){
		if(!Language.toefl.validator()){
			$("#savingBox").hide();
			alert("语言能力未填写完整");
			return;
		}
		$.post(basePath + "/profile/languageToeflUpdate.shtml", $("#languageToeflForm").serialize());
	}
	
	//工作经验
	var experienceForms = $("form[experienceId]");
	if(experienceForms.length>0) {
		for(var i = 0;i<experienceForms.length;i++){
			var form = $(experienceForms[i]);
			var id = form.attr("experienceId");
			if(!Experience.validator(id)) {
				$("#savingBox").hide();
				alert("工作经历未填写完整");
				return;
			}
			$.post(basePath + "/profile/experienceMerge.shtml", $("#experienceForm"+id).serialize());
		}
	}
	
	//求职意向
	if($("#intentionForm").length>0) {
		if(!intentionValidator()){
			$("#savingBox").hide();
			alert("求职意向未填写完整");
			return ;
		}
		$.post(basePath + "/profile/intentionUpdate.shtml", $("#intentionForm").serialize());
	}
	
	//附件信息
	if($("#additionalForm").length>0){
		$.post(basePath + "/profile/additionalUpdate.shtml", $("#additionalForm").serialize());
	}
	
	//IT技能
	if($("#itSkillForm").length>0){
		$.post(basePath + "/profile/additionalUpdate.shtml", $("#additionalForm").serialize());
	}
	Resume.status = true;
	$("#savingBox").hide();
	window.location=basePath+"/profile/complete.shtml";
}
