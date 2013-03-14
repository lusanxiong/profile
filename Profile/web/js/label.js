var Label = {};

Label.add = function(){
	var labelTip = $("#labelTip");
	var labelNameObj = $("#labelName");
	var labelName = $.trim(labelNameObj.val());
	var labelMore=$("#labelMore");
	if(isEmpty(labelNameObj) || labelName.length>10 || !Label.isValidLable(labelName)){
		$("#labelSpan").removeClass("label_input").addClass("label_input_h");
		labelTip.show();
		setTimeout(function(){
			labelTip.hide();
		},2000);
		return;
	}
	
	Label.addAjax(labelName,function(xml){
		var xml = $(xml);
		var resultCode = xml.find("resultCode").text();
		if(resultCode==0) {
			var html = xml.find("html").text();
			labelNameObj.val("");
			$("#labelContainer").append($.trim(html));
		}else if(resultCode==1){
			var labelId = xml.find("labelId").text();
			var myLabel = $("span[myLabelId='"+labelId+"']");
			myLabel.removeClass("label_hover_3").addClass("label_hover_4");
			setTimeout(function(){
				myLabel.removeClass("label_hover_4").addClass("label_hover_3");
			},500);
		}else if(resultCode==-100){
			
			$("#labelSpan").removeClass("label_input").addClass("label_input_h");
			labelMore.show();
			setTimeout(function(){
				labelMore.hide();
			},2000);
			return;
		}
	})
}

Label.add2 = function(labelName) {
	var labelMore=$("#labelMore");
	Label.addAjax(labelName,function(xml){
		var xml = $(xml);
		var resultCode = xml.find("resultCode").text();
		if(resultCode==0) {
			var html = xml.find("html").text();
			$("#labelContainer").append($.trim(html));
		}else if(resultCode==1){
			var labelId = xml.find("labelId").text();
			var myLabel = $("span[myLabelId='"+labelId+"']");
			myLabel.removeClass("label_hover_3").addClass("label_hover_4");
			setTimeout(function(){
				myLabel.removeClass("label_hover_4").addClass("label_hover_3");
			},500);
		}else if(resultCode==-100){
			
			$("#labelSpan").removeClass("label_input").addClass("label_input_h");
			labelMore.show();
			setTimeout(function(){
				labelMore.hide();
			},2000);
			return;
		
       }
	})
}

Label.addAjax = function(labelName,callback){
	$.ajax({
		type : "POST",
		url : basePath + "/setting/addLabel.shtml",
		data : "labelName="+labelName,
		dataType : "xml",			
		success : function(xml) {
			callback(xml);
		}
	});
}

Label.del = function(obj) {
	var labelObj = $(obj);
	var labelId = labelObj.attr("labelId");
	$.post(basePath + "/setting/delLabel.shtml","id="+labelId,function(){
		$("span[myLabelId='"+labelId+"']").hide();
	});
}

Label.next = function() {
	$.ajaxSetup ({cache: false});
	$("#hotLabelContainer").load(basePath + "/setting/nextLabel.shtml");
}

Label.isValidLable = function(val){
	var reg = /^[\u4e00-\u9fa5a-zA-Z0-9]+$/;
	return reg.test(val);
}



