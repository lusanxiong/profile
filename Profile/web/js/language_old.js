var delLanguage = function(id){
    if(confirm("你确定要删除？")){
    	window.location.href = "language.shtml?did=" + id;
    }
}

var editLanguage = function(id){
    $("#tbEditLUG").show();
    $("#tbAdd").hide();
    var language = eval("[" + $("#lj"+id).val() + "]");
    initLanguage(language[0]);
}

var initLanguage = function(language){
	$("#languageId").val(language.languageId);
	$("#languageTyep").val(language.languageTyep);
	$("#mastery").val(language.mastery);
	$("#literacy").val(language.literacy);
	$("#listenAndSpeak").val(language.listenAndSpeak);
}

var save = function(){
	
    document.frmLanguage.submit();
}

var cancel = function(){
	$("#languageId").val("");
	$("#tbEditLUG").hide();
	$("#tbAdd").show();
}

var addLG = function(){
	$("#tbAdd").hide();
	$("#tbEditLUG").show();
}


var editLL = function(){
	$("#tbEditLL").show();
	$("#tbInfoLL").hide();
}

var saveLL = function(){
	var message = $("#_bsSubmitMsg");
	var toefl = $.trim($("#toefl").val());
	var gre = $.trim($("#gre").val());
	var gmat = $.trim($("#gmat").val());
	var ielts = $.trim($("#ielts").val());
	
	if(toefl == ""){
		$("#toefl").val("0")
	}else{
	    if(!isNumber(toefl)){
	    	message.html("toefl分数请填写数字！");
	    	return;
	    }
	}
	if(gre == ""){
		$("#gre").val("0")
	}else{
	    if(!isNumber(gre)){
	    	message.html("gre分数请填写数字！");
	    	return;
	    }
	}
	
	if(gmat == ""){
		$("#gmat").val("0")
	}else{
	    if(!isNumber(gmat)){
	    	message.html("gmat分数请填写数字！");
	    	return;
	    }
	}
	
	if(ielts == ""){
		$("#ielts").val("0")
	}else{
	    if(!isNumber(ielts)){
	    	message.html("ielts分数请填写数字！");
	    	return;
	    }
	}
	document.frmLL.submit();
}


function isNumber(number){
     var reg = /^[0-9]+$/;
    return reg.test(number);
 }