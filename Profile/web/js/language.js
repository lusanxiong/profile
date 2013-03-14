
var Language = {}

Language.add = function() {
	if(!$.trim($("#languageAddContainer").html())) {
		$("#languageAddContainer").load(basePath+"/profile/languageAdd.shtml").show();
	}else {
		$("#languageAddContainer").show();
	}
}

Language.edit = function(id) {
	$("#languageContainer"+id).load(basePath+"/profile/languageEdit.shtml","id="+id);
}

Language.del=function(id) {
	if(confirm("你确定要删除该项语言能力吗？")) {
		$.post(basePath+"/profile/languageDel.shtml","id="+id,function(){
			$("#languageContainer"+id).hide();
		})
	}
}
Language.saveStatus = true;
Language.save = function(id){
	if(!Language.saveStatus){
		return ;
	}
	Language.saveStatus=false;
	$.post(basePath + "/profile/languageMerge.shtml", $("#languageForm"+id).serialize(),function(){
		if(!id){ //add
			$.ajaxSetup ({cache: false});
			$("#languageContainer").load(basePath + "/profile/languageAll.shtml");
			$("#languageAddContainer").html("").hide();
		}else {
			$("#languageContainer"+id).load(basePath + "/profile/languageBack.shtml","id="+id);
		}
		Language.saveStatus=true;
	});
}

Language.back = function(id) {
	if(!id){
		$("#languageAddContainer").html("").hide();
	}else {
		$("#languageContainer"+id).load(basePath+"/profile/languageBack.shtml","id="+id);
	}
}

Language.toefl = {}

Language.toefl.edit = function(){
	$("#lanuageToeflContainer").load(basePath+"/profile/languageToeflEdit.shtml")
}

Language.toefl.validator = function() {
	var toeflObj = $("#toefl");
	var greObj = $("#gre");
	var gmatObj = $("#gmat");
	var ieltsObj = $("#ielts");
	
	var toefl = $.trim(toeflObj.val());
	var gre = $.trim(greObj.val());
	var gmat = $.trim(gmatObj.val());
	var ielts = $.trim(ieltsObj.val());
	
	if(toefl && !isNumber(toefl)){
		Resume.showMsg(toeflObj, "请输入正确的分数")
		return false;
	}
	if(gre && !isNumber(gre)){
		Resume.showMsg(greObj, "请输入正确的分数")
		return false;
	}
	if(gmat && !isNumber(gmat)){
		Resume.showMsg(gmatObj, "请输入正确的分数")
		return false;
	}
	if(ielts && !isNumber(ielts)){
		Resume.showMsg(ieltsObj, "请输入正确的分数")
		return false;
	}
	return true;
}
Language.toefl.saveStatus = true;
Language.toefl.update = function(){
	
	if(!Language.toefl.validator()){
		return;
	}
	
	if(!Language.toefl.saveStatus){
		return;
	}
	Language.toefl.saveStatus = false;
	$.post(basePath + "/profile/languageToeflUpdate.shtml", $("#languageToeflForm").serialize(),function(){
		$("#lanuageToeflContainer").load(basePath+"/profile/languageToeflShow.shtml")
		Language.toefl.saveStatus = true;
	});
}


