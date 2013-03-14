
$(document).ready(function(){
	
	
	var btnSave = $("#btnSave");
	var btnCancel = $("#btnCancel");
	var btnAdd = $("#btnAdd");
	var tbAdd = $("#tbAdd");
	
	var divInfo = $("#divInfo");
	var tbSave = $("#tbSave");
	
	var message = $("#_bsSubmitMsg");
	var frmExperience = document.frmExperience;
	
	
	$(btnSave).click(function(){
		
		var bdreg=/^[0-9]{4}-[0-9]{2}(-[0-9]{1,2}){0,1}$/;
		var beginDate = $("#beginDate").val();
		var endDate = $("#endDate").val();
		var memName = $("#memName").val();
		var description = $("#description").val();
		
		//把textarea中的手动换行符\n全部替换成br
		if(typeof(description) != 'undefined') {
			description = description.replace(/\n/g,"<br/>");
			$("#description").val(description);
		}
		
		var leftReason = $("#leftReason").val();
		if(beginDate==""||endDate==""){
			message.html("在职时间不为空！");
		   return;
		}
		if(!bdreg.test(beginDate)){
			message.html("请选择正确的在职时间");
			return;
		}
		if(endDate != "至今"){
			if(!bdreg.test(endDate)){
				message.html("请选择正确的在职时间");
				return;
			}
		}
		if(memName==""){
			message.html("公司名称不为空！");
		   return;
		}
		
		if(description==""){
			message.html("工作描述不为空！");
			return;
		}
		
		if(description.length < 100 || description.length > 2000){
			message.html("工作描述在(100-2000)个字！当前字数:"+description.length);
			return;
		}
		
		if(leftReason.length > 50 || leftReason.length < 1) {
			message.html("离职原因在(1-50)个字！当前字数:"+leftReason.length);
			return;
		}
		
		frmExperience.submit();
	});
	
	$(btnAdd).click(function(){
	    $(tbSave).show("slow");
	    $(divInfo).hide("slow");
	    $(tbAdd).hide();
	});
	
	
	$(btnCancel).click(function(){
	    $(divInfo).show("slow");
	    $(tbSave).hide("slow");
	    $("#eid").val("");
	    $(tbAdd).show();
	});
	
	$("#spCalling").click(function(){
			
			var callings = new Array();
			if($("#jobFunctionId").val() != "")
			{
			   callings[0] = new Array($("#jobFunctionId").val(), $("#spCalling").html());
			}
			
			CallingDialog.init(callings,1,setJobCaling);
			CallingDialog.show();
		});
	
	$("#btnEditWEInfo").click(function(){
		var _bsSubmitMsg1 = $("#_bsSubmitMsg1");
		var workedYear = $("#workedYear").val();
		var workedComNumber = $("#workedComNumber").val();
		var workedMonth = $("#workedMonth").val();

		if(workedYear == ""||workedMonth==""||workedComNumber==""){
			_bsSubmitMsg1.html("请填写准确的信息！");
		   return;
		}
		if(!workedYear.isNumber()||!workedMonth.isNumber()||!workedComNumber.isNumber()){
			_bsSubmitMsg1.html("请填写准确的信息！");
			 return;
		}
		
		$.post(basePath+"/AjaxServlet", { "action" : "editwepinfo","workedYear":workedYear,"workedMonth":workedMonth,"workedComNumber":workedComNumber
		 }, function(data) {
			 _bsSubmitMsg1.html("修改成功！");
		});
				
	});
	
});


var editWorkExp = function(id){
	var workExps = eval("[" + $("#ej"+id).val() + "]");
	var workExp = workExps[0];
	$("#tbSave").show("slow");
	$("#divInfo").hide("slow");
	$("#tbAdd").hide();
	$("#eid").val(workExp.id);
	$("#beginDate").val(workExp.beginDate);
	$("#endDate").val(workExp.endDate);
	$("#memName").val(workExp.memName);
	$("#memType").val(workExp.memType);
	
	$("#jobFunctionId").val(workExp.jobFunctionId);
	$("#spCalling").html($("#spCalling"+workExp.id).html());
	$("#memCalling").val(workExp.memCalling);
	$("#otherPosition").val(workExp.otherPosition);
	
	var description = workExp.description;
	if(typeof(description) != 'undefined') {
		description = description.replace(/<br\/>/g,"\r\n");
	}
	//$("#description").html(description);
	$("#description").val(description);
	$("#leftReason").html(workExp.leftReason);
}	

var setJobCaling = function(calling) {
	$("#jobFunctionId").val(calling[0][0]);
	$("#spCalling").html(calling[0][1]);
}
	 
	 


