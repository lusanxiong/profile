$(document).ready(function() {
	$("div.block").mouseover(function() {
		$(this).addClass("bg_gray");
		$("div.block > span").hide();
		var duid = $(this).attr("duid");
		if(duid != ""){
			$("#stg"+duid).hide();
			$("#etg"+duid).show();
		}
	});

	$("div.block").mouseleave(function() {
		$(this).removeClass("bg_gray");
		var duid = $(this).attr("duid");
		if(duid != ""){
			$("#etg"+duid).hide();
			$("#stg"+duid).show();
		}
	});
	
    $("#spCalling").click(function(){
		
		var callings = new Array();	
		var foc = $("#_jfoc").val();
		if(foc!=""){
			callings[0] = new Array(foc, $("#spCalling").html());
		}
		CallingDialog.init(callings,1,setJobCaling);
		CallingDialog.show();
	});
    
    $("#spLocation").click(function(){
		var locations = new Array();
		var loc = $("#_jloc").val();
		if(loc!=""){
			locations[0] = new Array(loc, $("#spLocation").html());
		}
		AddressDialog.init(locations,1,setJobLocation);
		AddressDialog.show();
	});
});

function allChk(ck){
	var cked = $(ck).attr("checked");
	$("input[name='_ckTid']").each(function(){
	   if(cked == "checked"){
 	       $(this).attr("checked",true);
	   }else{
		   $(this).removeAttr("checked"); 
	   }
 });  
}

function kFocus(k){
	
	if($(k).val() == "输入职位名称或朋友名字" ){
        $(k).val("");
     }
}

function kBlur(k){
	if($(k).val() == ""){
        $(k).val("输入职位名称或朋友名字");
     }
}


function unattention(tid){
	var action="unattention";
	$.post(basePath + "/AjaxServlet", {
		"targetId" : tid,
		"action" : action
	}, function(data) {
		if(data==0){
			$("#_li"+tid).fadeOut();
		}
		else{
			alert("取消关注失败.");
		}
	});
}



function delFans(tid){
	var action="delfans";
	$.post(basePath + "/AjaxServlet", {
		"targetId" : tid,
		"group" : 0,
		"action" : action
	}, function(data) {
		if(data==0){
			$("#_li"+tid).fadeOut();
		}
		else{
			alert("移除粉丝失败.");
		}
	});
}

var setJobCaling = function(calling) {
	var spCalling = "";
	var len = calling.length;
	for ( var i = 0; i < len; i++) {
		spCalling += calling[i][1];
	}
	if(spCalling != ""){
	    $("#_intPost").val(spCalling); 
	    $("#spCalling").html(spCalling);
	    $("#_jfoc").val(calling[0][0])
	}

}


var setJobLocation = function(locationArr){
	var spLocation = "";
	var len = locationArr.length;
    for(var i=0; i<len; i++){
    	spLocation += locationArr[i][1];
    }
    if(spLocation != ""){
       $("#_intCity").val(spLocation);
       $("#spLocation").html(spLocation);
       $("#_jloc").val(locationArr[0][0]);
    }
}


function searchFriend(){
	
	submitSearch();
}

function searchFriendByLabel(labelId){
	var labelName = $("#"+labelId+" >p>span");
	$("#_keyword").val(labelName.html());
	
	submitSearch();
}


function submitSearch(){
	if($("#_keyword").val() == "输入职位名称或朋友名字")
		$("#_keyword").val("");
    document.thisForm.submit();
}

function attention(tid){
	var action = "attention";
	$.post(basePath + "/AjaxServlet", {
		"targetId" : tid,
		"group" : 5,
		"action" : action
	}, function(data) {
		if(data==1 || data==2 || data==100){
			group(tid,"5");
			showAttentioned(tid);
		}else if(data==3){
			alert("自己不能关注自己.");
		}
	});
}



function batchAttention(){
	var tids = "";
	$("input[name='_ckTid']:checkbox:checked").each(function(){
		if(tids != "")
			tids = tids + ",";
		var fflag = $(this).attr("fflag");
		if(fflag == "-1"){
		    tids = tids + $(this).val();
		}else{
			$(this).removeAttr("checked"); 
		}
	 });  
	if(tids==""){
	   alert("请选择要关注的朋友！");
	   return;
	}
	
	$.blockUI({ 
		message:jQuery($("#_group_dialog")),
		css: { top:'30%',left: '30%' }
    });
	$("#_titleMsg").html("正在提交请求。。。");
	
	var action = "batchattention";
	$.post(basePath + "/AjaxServlet", {
		"targetIds" : tids,
		"group" : 5,
		"action" : action
	}, function(data) {
		if(data=="1" || data=="2"){
			var tidds = tids.split(",");
			for(var i=0;i<tidds.length;i++){
				showAttentioned(tidds[i]);
			}
			$("#_titleMsg").html("关注成功，请选择分组！");
			$("#_group_dialog_ok").click(function(){
				var gpp = $("#_goupId").val();
				var action = "batcheditgroup";
				$.post(basePath + "/AjaxServlet", {
					"targetIds" : tids,
					"group" : gpp,
					"action" : action
				}, function(data) {
					if(data=="0"){
						$.unblockUI();
					}
				});
			});
		}else if(data==3){
			$("#_titleMsg").html("关注失败！");
		}
	});
	
}


function batchUnAttention(){
	var tids = "";
	$("input[name='_ckTid']:checkbox:checked").each(function(){
		if(tids != "")
			tids = tids + ",";
		tids = tids + $(this).val();
	 });  
	if(tids==""){
	   alert("请选择要取消关注的朋友！");
	   return;
	}
	
	var action = "batchunattention";
	$.post(basePath + "/AjaxServlet", {
		"targetIds" : tids,
		"action" : action
	}, function(data) {
		if(data=="0"){
			var tidds = tids.split(",");
			for(var i=0;i<tidds.length;i++){
				$("#_li"+tidds[i]).fadeOut();
			}
		}
		else{
			alert("取消关注失败！");
		}
	});
	
}



function batchdelfans(){
	var tids = "";
	$("input[name='_ckTid']:checkbox:checked").each(function(){
		if(tids != "")
			tids = tids + ",";
		tids = tids + $(this).val();
	 });  
	if(tids==""){
	   alert("请选择要移除的粉丝！");
	   return;
	}
	
	var action = "batchdelfans";
	$.post(basePath + "/AjaxServlet", {
		"targetIds" : tids,
		"action" : action
	}, function(data) {
		if(data=="0"){
			var tidds = tids.split(",");
			for(var i=0;i<tidds.length;i++){
				$("#_li"+tidds[i]).fadeOut();
			}
		}else{
			alert("移除粉丝失败！");
		}
	});
}



function group(tid,gp){
	$("#_titleMsg").html("取消保存，则默认为'其他'分组");
	$("#_goupId").val(gp);
	$("input[name='_grp_frd']:checkbox").each(function(){
		 $(this).removeAttr("checked"); 
		 if(gp==$(this).val()){
		   $(this).attr("checked",true);
		 }
	 }); 
	
	var setting = {
			css:{ top:'30%',left: '28%' },
			ok : function() {
				var goupId = $("#_goupId").val();
				$.post(basePath + "/AjaxServlet", {
					targetId : tid,
					group : goupId,
					action :"changegroup"
				}, function(data) {
					$("#stg"+tid).html(getGroupById(goupId));
				});
			}
		};
	$.groupDialog(setting);
	
}

function showAttentioned(tid){
	try{
	    $("#_attf"+tid).removeClass().addClass("thhy");
	    $("#_attf"+tid).html("已关注");
	    
	    $("#_att_frd_hot").hide();
 	    $("#_atted_frd_hot").show();
 	    
 	    $("#_f_add"+tid).hide();
 	    $("#_f_each"+tid).show();
	}catch(err){
		alert(err);
	}
	$("#_ckTidId"+tid).removeAttr("checked"); 
	$("#_ckTidId"+tid).attr("fflag","0");
}


function sendMyMsg(p){
	$("#_messsage_userName").html(p.userName);
	var setting = {
		css:{ top:'30%',left: '28%' },
		ok : function() {
			var text = $("#_message_text");
			var userId = p.userId;
			var content = $.trim(text.val());
			if (content == "") {
				$.colorTip(text);
				return;
			}
			var target = $("#_message_wordsTip");
			if (!validateLength(content, target)) {
				$.colorTip(target);
				return;
			}
			var param = {
				targetId : userId,
				message : content,
				success:function(data){
				}
			};
			PM.sendMessage(param);
			$.unblockUI();
		}
	};
	$.messageDialog(setting);
}



function batchSendPrivateMsg(userName){
	$("#_messsage_userName").html(userName);
	var setting = {
		css:{ top:'30%',left: '28%' },
		ok : function() {
			var text = $("#_message_text");
			var content = $.trim(text.val());
			if (content == "") {
				$.colorTip(text);
				return;
			}
			var target = $("#_message_wordsTip");
			if (!validateLength(content, target)) {
				$.colorTip(target);
				return;
			}
			batchSendMsg(content);
			$.unblockUI();
		}
	};
	$.messageDialog(setting);
}

function batchSendMsg(message){
	var tids = "";
	$("input[name='_ckTid']:checkbox:checked").each(function(){
		if(tids != "")
			tids = tids + ",";
		tids = tids + $(this).val();
	 });  
	if(tids==""){
	   alert("请选择要发私信的朋友！");
	   return;
	}
	var action = "batchsendprivatemessage";
	$.post(basePath + "/AjaxServlet", {
		"targetIds" : tids,
		"message": message,
		"action" : action
	}, function(data) {
	});
}


function goPage(page){
	$("#page").val(page);
	submitSearch();
}

function delCondition(id){
	$("#"+id + "_").hide();
	$("#"+id+"_cs").hide();
	$("#"+id).val("");
	submitSearch();
}


function setCondition(v){
	var id = $(v).attr("cid");
	var txt = $(v).html();
	$("#"+id).val(txt);
	submitSearch();
}

function getGroupById(id){
	if(id=="1"){
		return "同行";
	}else if(id=="2"){
		return "同事";
	}else if(id=="3"){
		return "同乡";
	}else if(id=="4"){
		return "同学";
	}else if(id=="5"){
		return "其他";
	}else{
		return "未分组";
	}
}

