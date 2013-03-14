var BaseInfo = new Object();

BaseInfo.getHomeTown = function(locationArr){
    var hometown = "";
    var _hometown = "";
    for(var i=0; i<locationArr.length; i++){
    	hometown += locationArr[i][0];
    	_hometown += locationArr[i][1];
    }
    $("#hometown").val(hometown);
	$("#_hometown").val(_hometown);
}

BaseInfo.getLocation = function(locationArr){
    var location = "";
    var _location = "";
    for(var i=0; i<locationArr.length; i++){
    	location += locationArr[i][0];
    	_location += locationArr[i][1];
    }
    $("#location").val(location);
	$("#_location").val(_location);
}

$(document).ready(function(){
	var locations = new Array();
	
	$("#_hometown").click(function(){
		locations[0] = new Array($("#hometown").val(), $("#_hometown").val());
		AddressDialog.init(locations,1,BaseInfo.getHomeTown);
		AddressDialog.show();
	});
	
	$("#_location").click(function(){
		locations[0] = new Array($("#location").val(), $("#_location").val());
		AddressDialog.init(locations,1,BaseInfo.getLocation);
		AddressDialog.show();
	});
	
	$("#txtNationality").blur(function(){
		    var nationality = $(this).val();
			if(nationality != null && nationality != ""){
		       $("#cnNationality").val(nationality);	
			}
	});
	
	$("#btnCancel").on("click",function(){
		$("#divEditInfo").hide();
		$("#divShowInfo").show();
		$("#btnSave").val("修改");
	});
	
	
	$("#btnSave").on("click",function(){
		$("#divEditInfo").show();
		$("#divShowInfo").hide();
		
		if($("#btnSave").val() == "保存"){
		    if($.trim($("#perName").val())==""){
		    	$("#_bsSubmitMsg").html("请填写名字！");
		        return;
		    } 
		    if($("#birthday").val() == ""){
		    	$("#_bsSubmitMsg").html("请填写生日！");
		        return;
		    } 
		    if($("#height").val() == ""){
		    	$("#_bsSubmitMsg").html("请填写身高！");
		        return;
		    }
		    
		    if($("#idcardNum").val() == ""){
		    	$("#_bsSubmitMsg").html("请填写证件编号！");
		        return;
		    }
		    
		    if($("#hometown").val() == ""){
		    	$("#_bsSubmitMsg").html("请填写户 籍！");
		        return;
		    }
		    
		    if($("#location").val() == ""){
		    	$("#_bsSubmitMsg").html("请填写现工作地！");
		        return;
		    }
		    
		    var mobile = $.trim($("#mobileNum").val());
		    var relationPhone = $.trim($("#relationPhone").val());
		    if(mobile == "" && relationPhone == ""){
		    	$("#_bsSubmitMsg").html("手机号码或家庭电话请至少填写一项！");
		        return;
		    } 
//		    if(!valEmail($.trim($("#email").val()))){
//		        return;
//		    }
		    var frmBaseInfo = document.frmBaseInfo;
		    frmBaseInfo.submit();
		}
		$("#btnSave").val("保存");
	});
});

var valEmail = function(email){
    var re = /^[0-9a-zA-Z_\.\-]+@[0-9a-zA-Z_\-]+(\.[0-9a-zA-Z_\-]+)+$/;
    if(email == ""){
       $("#_bsSubmitMsg").html("请输入电子邮箱！");
       return false;
    }

    if(!re.test(email)){
       $("#_bsSubmitMsg").html("电子邮箱格式不正确！");
       return false;
    }

	$.post(basePath + "/AjaxServlet", {
		"email" : email,
		"action" : "verificatemail"
	  }, function(data) {
     	 if(data == "1"){
           $("#_bsSubmitMsg").html("此电子邮箱已被注册！");
           return false;
		 }
    });
	
	return true;
}
	 
	 
	 


