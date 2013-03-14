
function baseInfoValidator() {
	var perNameObj = $("#perName");
	var perName= $.trim(perNameObj.val());
	if ( perName == "") {
		Resume.showMsg(perNameObj, "请输入姓名 ")
		return false;
	}

	var birthdayObj = $("#birthday");
	var birthday = $.trim(birthdayObj.val());
	if (birthday == "") {
		Resume.showMsg(birthdayObj, "请填写生日 ")
		return false;
	}

	if (!isDate(birthday)) {
		Resume.showMsg(birthdayObj, "请填写正确的生日 ")
		return false;
	}
	
	var nationalityObj = $($("input[name='nationality']").get(1));
	if(nationalityObj.is(":checked")){
		var txtNationality = $.trim($("#txtNationality").val());
		if(!txtNationality){
			Resume.showMsg(nationalityObj, "请填写名族 ")
			return false;
		}
	}

	var heightObj = $("#height");
	var height = $.trim(heightObj.val());
	if (height == "") {
		Resume.showMsg(heightObj, "请填写身高 ")
		return false;
	}

	if (!isNumByLength(height,3)) {
		Resume.showMsg(heightObj, "请填写正确的身高 ")
		return;
	}

	var cardType = $.trim($("#cardType").val());
	if(cardType==1) {
		var idcardNumObj = $("#idcardNum");
		var idcardNum = $.trim(idcardNumObj.val());
		if (idcardNum == "") {
			Resume.showMsg(idcardNumObj, "请填写证件编号 ")
			return false;
		}
	}

	var hometownObj = $("#hometown");
	var hometown = $.trim(hometownObj.val());
	if (hometown == "") {
		Resume.showMsg(hometownObj, "请填写户籍 ")
		return false;
	}

	var locationObj = $("#location");
	var location = $.trim(locationObj.val());
	if (location == "") {
		Resume.showMsg(locationObj, "请填写现工作地")
		return false;
	}

	var mobileObj = $("#mobileNum");
	var mobile = $.trim(mobileObj.val());
	var relationPhoneObj = $("#relationPhone");
	var relationPhone = $.trim(relationPhoneObj.val());
	if (mobile == "" && relationPhone == "") {
		Resume.showMsg(mobileObj, "手机号码或家庭电话至少填写一项")
		return false;
	}

	if (mobile!="" && !isMobile(mobile)) {
		Resume.showMsg(mobileObj, "请填写正确的手机号码")
		return false;
	}
	
	if(relationPhone!="" && !isTelNumber(relationPhone)) {
		Resume.showMsg(relationPhoneObj, "请填写正确的家庭电话")
		return false;
	}
	
	var emailObj = $("#email");
	var email = $.trim(emailObj.val());
	if(!email){
		Resume.showMsg(mobileObj, "请填写电子邮箱")
		return false;
	}
	if(!isEmail(email)) {
		Resume.showMsg(mobileObj, "请填写正确的电子邮箱")
		return false;
	}
	return true;
}

$(function() {
	$("#baseInfoBack").click(function() {
		$("#baseInfoContainer").load(basePath + "/profile/baseInfoShow.shtml");
	});

	$("#baseInfoSave").click(function() {

		if(!baseInfoValidator()) {
			return ;
		}
	
		$.post(basePath + "/profile/baseInfoUpdate.shtml", $("#baseInfoForm").serialize(),function(){
			$("#baseInfoContainer").load(basePath + "/profile/baseInfoShow.shtml");
		});
		
	});

});