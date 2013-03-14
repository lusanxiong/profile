
var Experience = {}

Experience.edit = function(id){
	//$("#experienceContainer"+id).load(basePath+"/profile/experienceEdit.shtml","id="+id);
	$.post(basePath+"/profile/experienceEdit.shtml","id="+id,function(data){
		$("#experienceContainer"+id).html(data);
		var description = $("#description").val();
		
		if(typeof(description) != 'undefined') {
			description = description.replace(/<br\/>/g,"\r\n");
		}
		$("#description").val(description);
	})
}

Experience.back = function(id,action){
	if("add"==action) {
		$("#experienceAddContainer").html("").hide();
	}else {
		$("#experienceContainer"+id).load(basePath+"/profile/experienceShow.shtml","id="+id);
	}
}

Experience.del = function(id){
	if(confirm("你确定要删除该项工作经历吗?")){
		$.post(basePath+"/profile/experienceDel.shtml","id="+id,function(){
			$("#experienceContainer"+id).hide();
		});
	}
}

Experience.add = function() {
	if(!$.trim($("#experienceAddContainer").html())) {
		$("#experienceAddContainer").load(basePath+"/profile/experienceAdd.shtml").show();
	}else {
		$("#experienceAddContainer").show();
	}
}

Experience.validator = function(id) {
	var form = $("#experienceForm"+id);
	
	var beginDateObj = form.find("#beginDate");
	var beginDate = $.trim(beginDateObj.val());
	if(!isFormatDate(beginDate)) {
		Resume.showMsg(beginDateObj, "请填写正确的入职时间");
		return false;
	}
	
	var endDateObj = form.find("#endDate");
	var endDate =  $.trim(endDateObj.val());
	if(endDate && !isFormatDate(endDate)) {
		Resume.showMsg(endDateObj, "请填写正确的离职时间");
		return false;
	}
	
	var memNameObj = form.find("#memName");
	var memName =  $.trim(memNameObj.val());
	if(!memName) {
		Resume.showMsg(memNameObj, "请填写公司名称");
		return false;
	}
	
	var jobFunctionIdObj = form.find("#jobFunctionId");
	var jobFunctionId =  $.trim(jobFunctionIdObj.val());
	
	var otherPositionObj = form.find("#otherPosition");
	var otherPosition =  $.trim(otherPositionObj.val());
	
	if((!jobFunctionId) && (!otherPosition)) {
		Resume.showMsg(jobFunctionIdObj, "请选择担任的职务，或填写其他职务");
		return false;
	}
 	 
	var descriptionObj = form.find("#description");
	var description =  $.trim(descriptionObj.val());
	if(!description) {
		Resume.showMsg(descriptionObj, "请填写工作描述");
		return false;
	}
	
	//把textarea中的手动换行符\n全部替换成br
	if(typeof(description) != 'undefined') {
		description = description.replace(/\n/g,"<br/>");
		$("#description").val(description);
	}
	
	return true;
}

Experience.saveStatus = true;
Experience.save = function(id,action) {
	
	if(!Experience.validator(id)){
		return;
	}
	
	if(!Experience.saveStatus){
		return;
	}
	Experience.saveStatus = false;
	$.post(basePath + "/profile/experienceMerge.shtml", $("#experienceForm"+id).serialize(),function(){
		if("add"==action){
			$("#experienceAddContainer").html("").hide();
			//$("#experienceContainer").load(basePath+"/profile/experienceAll.shtml");
			$.post(basePath+"/profile/experienceAll.shtml",function(data){
				$("#experienceContainer").html(data);
			});
		}else {
			$("#experienceContainer"+id).load(basePath+"/profile/experienceShow.shtml","id="+id);
		}
		Experience.saveStatus=true;
	});
}