$(function(){
	$("#uploadBtn").click(function(){
		if($("#showImageDiv").is(":visible")){
			return ;
		}
		$("#uploadDiv").show();
	});

	$("#smileBtn").click(function(){
		if($("#smileDiv").is(":visible")){
			return ;
		}
		var offset = $(this).offset();
		var top = offset.top;
		var left = offset.left;
		top = top + 28;
		doShowSmile(top,left,$("#texts"));
	});

	$("#topicBtn").click(function(){
		$("#texts").topic();
	});

	$("#publishBtn").click(function(){
		publishWeibo();
	});
	
	$("#secondNav>li>a").click(function(){
		$("#secondNav>li").each(function(){
			var img = $(this).find("img");
			var src = img.attr("src");
			img.attr("src",src.replace("_2","_1"));
		});
		var image = $(this).children();
		var src = image.attr("src"); 
		image.attr("src",src.replace("_1","_2"));
	});
	
	$("#weiboBtn,#myWeiboBtn").on("click",function(){
		var userId = $("#moreWeiboBtn").attr("userId");
		var type = $(this).attr("type");
		var weiboDiv = $("#weiboDiv");
		
		$("#moreWeiboBtn").attr("type",type).html(Loading.more).off("click").on("click",function(){
			loadMoreWeibo($(this));
		});

		weiboDiv.html(Message.loading);
		Weibo.getWeiboList({
			pageIndex:1,
			userId:userId,
			type:type,
			success:function(msg){
				if($.trim(msg)==""){
					$("#moreLoadDiv").hide();
					$("#job_list_box").hide();
					weiboDiv.html('<font id="noWeiboTip" style="color:#999;font-size:14px;" >你还没有分享你的新鲜事哦,赶快分享吧~~</font>').show();
					return ;
				}
				$("#moreLoadDiv").show();
				$("#moreWeiboBtn").attr("pageIndex","2");
				$("#job_list_box").hide();
				weiboDiv.show();
				weiboDiv.html(msg);
			}
		});
	});
	
	$("#jobBtn").on("click",function(){
		$("#job_list_box").show();
		$("#weiboBtn").removeClass();
		$("#jobBtn").removeClass().addClass("ahover");
		$("#weiboDiv").hide();
		$("#moreLoadDiv").hide();
	});
	
	$("#moreWeiboBtn").on("click",function(){
		loadMoreWeibo($(this));
	});

	
	
	$("#imageFile").change(function(){
		var filePath = $(this).val();
		if(filePath && filePath.endWith(".gif|.jpg|.png|.jpeg") ){
			$("#uploadForm").submit();

			$("#showImageBox").hide();
			$("#uploadingBox").show();
			$("#showImageDiv").show();
		}else{
			alert(Message.invalidFormat);
			return ;
		}
	});

	$("#deleteImageBtn").click(function(){
		resetForm();
	});


	$(document).click(function(e){
		closeUploadDiv(e);
		closeSmileDiv(e);
	});
	
	$("#texts").on("keyup",function(){
		validateLength($.trim($(this).val()),$("#wordsTip"));
	});
	
	/*$("#_forward_dialog_texts").on("keyup",function(){
		validateLength($.trim($(this).val()),$("#_forward_dialog_wordsTip"));
	});*/
	
	$("#_forward_dialog_smile").on("click",function(){
		
		showComentSmile($(this),$("#_forward_dialog_texts"));
	});
	
	$(window).on("scroll",function (){
		$("#smileDiv").hide();
	}); 
	
	$("#texts").focus();
});

function forwardWeibo(p){
	$("#_forward_dialog_check").attr("checked",false);//还原checkbox
	$("#_forward_dialog_check2").attr("checked",false);//还原checkbox
	var obj = $("#_forward_dialog_texts");
	
	if (p.fuserName) {
		$("#_forward_dialog_check2").parent().show();
		obj.val("//" + p.userName + "：" + p.texts);
	} else {
		$("#_forward_dialog_check2").parent().hide();
		obj.val(""); // 清空转发文字
	}
	var setting = {
			userName:p.userName,
			fuserName:p.fuserName,
			content:p.contentTarget.html(),
			forwardId:p.forwardId,
			sourceId:p.sourceId,
			validate:function(){
				var texts = $.trim(obj.val());
				if(texts==""){
					texts="转发微博。"
				}
				var target = $("#_forward_dialog_wordsTip");
				if(!validateLength(texts,target)) {
					$.colorTip(target);
					return false;
				}
				p.texts = texts;
				return true;
			},
			ok:function(){
				doForwardWeibo(p);
			}};
	$.forwardDialog(setting);
}

function doForwardWeibo(p) {
	var checkBox = $("#_forward_dialog_check");
	var checkBox2 = $("#_forward_dialog_check2");
	var commentFlag = checkBox.attr("checked")?1:0; //1同时评论给作者
	var fcommentFlag = checkBox2.attr("checked")?1:0; //1同时评论给原文作者
	Weibo.publish({
		"texts":p.texts,
		"imagePath":"",
		"sourceId":p.sourceId,
		"forwardId":p.forwardId,
		"commentFlag":commentFlag,
		"fcommentFlag":fcommentFlag,
		"success":function(msg){
			if(msg==500){
				alert(Message.text500);
			}
			else if(msg==404) {
				alert(Message.text404);
			}
			else{
				$("#weiboDiv").prepend(msg);
				$("#weiboDiv>dl:first").hide().fadeIn("slow");
				checkBox.attr("checked",false);
				$("#_forward_dialog_texts").val("");
				validateLength("",$("#_forward_dialog_wordsTip"));
			}
		}
	});
}

function getWeibo(weiboId) {
	var p = {
		weiboId:weiboId,
		success:function(msg){
			if(msg==500){
				alert(Message.text500);
			}
			else if(msg==400){
				alert(Message.text400);
			}
			else if(msg==404){
				alert(Message.text404);
			}
			else {
				$("#weiboDiv").prepend(msg);
			}
		}	
	};
	Weibo.getWeibo(p);
}

function publishWeibo(){

	var texts = $.trim($("#texts").val());
	if(texts==""){
		$.colorTip($("#texts"));
		return ;
	}
	if(!validateLength(texts,$("#wordsTip"))) {
		$.colorTip($("#wordsTip"));
		return ;
	}
	if("#请在这里输入自定义话题#"==texts){
		$.colorTip($("#texts"));
		return ;
	}
	var imagePath = $.trim($("#imagePath").val());
	$("#texts").attr("readOnly",true);
	$("#publishBtn").removeClass("share_dw_button").addClass("share_dw_buttons");
	$("#publishBtn").off("click");
	Weibo.publish({
		"texts":texts,
		"imagePath":imagePath,
		"commentFlag":0,
		"forwardId":0,
		"success":function(msg){
			if(msg==500){
				alert(Message.text500);
			}
			else if(msg==404) {
				alert(Message.text404);
			}
			else{
				$("#noWeiboTip").hide();
				$("#weiboDiv").prepend(msg);
				$("#weiboDiv>dl:first").hide().fadeIn("slow");
				$("#publishOK").show();
				setTimeout(function(){$("#publishOK").hide();},1000);
			}
			resetForm();
			validateLength("",$("#wordsTip"));
			$("#texts").val("");
			$("#imagePath").val("");
			$("#texts").attr("readOnly",false);
			$("#publishBtn").removeClass("share_dw_buttons").addClass("share_dw_button");
			$("#publishBtn").on("click",function(){
				publishWeibo();
			});
			
 
			var image = $("#weiboBtn").find("img");
			var src = image.attr("src");
			
			$("#secondNav>li").each(function(){
				var img = $(this).find("img");
				var src = img.attr("src");
				img.attr("src",src.replace("_2","_1"));
			});

			image.attr("src",src.replace("_1","_2"));
			if(src.indexOf("_1")>0){ //如果不在微博选项卡,则切换选项效果
				$("#weiboBtn").click();
			}
		}
	});
 }

function deleteWeibo(weiboId) {
	var setting = {
		title : Dialog.weibo.confirmTitle,
		content : Dialog.weibo.confirmContent,
		css:{ top:'25%',left: '30%' },
		ok : function() {
			doDeleteWeibo(weiboId);
		}
	};
	$.confirmDialog(setting);
}

function deleteComment(commentId) {
	var setting = {
			title:Dialog.comment.confirmTitle,
			content:Dialog.comment.confirmContent,
			css:{ top:'25%',left: '30%' },
			ok:function(){
				doDeleteComment(commentId);
		    }};
	$.confirmDialog(setting);
}

function callback(msg){
	var msg  = $.parseJSON(msg);
	if(msg.flag==0){
		$("#imagePath").val(msg.src);
		$("#uploadImage").attr("src",basePath + msg.src);
		$("#showImageBox").show();
		$("#uploadingBox").hide();
		var texts = $.trim($("#texts").val());
		if(texts==""){
			$("#texts").val(Message.shareImage);
		}
	}
	else{
		resetForm();
		alert(msg.msg);
	}
}

function resetForm() {
    $("#uploadForm").resetForm();
	$("#imagePath").val("");
	var texts = $.trim($("#texts").val());
	if(Message.shareImage==texts){
		$("#texts").val("");
		$("#texts").focus();
    }
	$("#showImageDiv").hide();
}

function closeUploadDiv(e){
	if($(e.target).closest("#uploadDiv").length>0){
		return ;
    } 
	var parentId = $(e.target).parent().attr("id");
	var parentId2 = $(e.target).parent().parent().attr("id");
	if(parentId=="uploadBtn" || parentId2=="uploadBtn"){
		return ;
	}else {
		$("#uploadDiv").hide();
	} 
}