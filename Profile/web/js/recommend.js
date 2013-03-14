var loading = "<img src='"+basePath+"/images/loading.gif' style='margin-top: 5px; margin-buttom: 5px;'/>";
var recommendJob = function(){
	var fIds = "";
	$('input[type="checkbox"][name="ckFriends"]:checked').each(
            function() {
            	if(fIds != "")
            		fIds = fIds + ",";
            	fIds= fIds + $(this).val();   
            }
        );
	if(fIds == ""){
		$("#spReMsg").html("请选择粉丝！");
		return;
	}
	var posId = $("#recommendPosId").val();
	var memId = $("#recommendMemId").val();

    $.post(basePath + "/AjaxServlet", {"tragetIds":fIds, "posId":posId,"memId":memId,"action":"recommendjob"},
		function(data) {
		   if(data==1){
			   $("#spReMsg").html("推荐成功！");
			   $.unblockUI();
		   }else{
			   $("#spReMsg").html("推荐失败！");
		   }
	});
	
}

var recommend = function(posId,memId){	
	$.blockUI({ 
		message:jQuery($("#divRecommend")),
		css: { top:'30%',left: '30%' }
    });
	$("#spReMsg").html("请选择粉丝！");
	$("#recommendPosId").val(posId);
	$("#recommendMemId").val(memId);
	loadFriendPage(1,1);
}


var loadFriend = function(group){
	
	for(var i=1; i<=4; i++){
	   $("#g"+i).removeClass();
	   if(group==i){
	      $("#g"+i).addClass("hhover");
	   }
	}
	loadFriendPage(group,1);
}



var loadFriendPage = function(group,page){
	$("#divFriends").html(loading);
	$.post(basePath + "/friends/loadFriends.shtml", {"g":group,"page":page},
			function(data) { 		 
				 $("#divFriends").html(data);
				 var pageCount = parseInt($("#txtFrdPages").val());
				 if(pageCount > 1 && page < pageCount){
				    $("#liMoreFrd").show();
				    $("#liMoreFrd").off("click");
				    $("#liMoreFrd").on("click",function(){
				    	loadFriendPage(group, parseInt(page) + 1);	
				    });
				 }else{
					 $("#liMoreFrd").hide();
				 }
	});	
}


var closeRecommend = function(){
	$("#divRecommend").hide();
	$.unblockUI();	
}


//应聘				
function r_open(val){				
	window.open(mainWeb + "/personal/center/util/my_apply_online.do?posId="+val,"","width=500,height=350");			
}