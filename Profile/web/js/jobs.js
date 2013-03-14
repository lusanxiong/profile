$(document).ready(function(){
	
	$("#btnSearch").click(function(){
		searchJobs(1);
	});	

	$("#btnJobLocation").click(function(){
		AddressDialog.init(null,3,setJobLocation);
		AddressDialog.show();
	});
	
	$("#btnCalling").click(function(){
		CallingDialog.init(null,3,setJobCaling);
		CallingDialog.show();
	});
	
	$("#btnJobFunction").click(function(){
		CallingDialog.init(null,3,setJobFunction);
		CallingDialog.show();
	});
	
	$("#divMoreCk").click(function(){
		$("#divMore").show();
		$("#divLessCk").show();
		$(this).hide();
	});
	
	$("#divLessCk").click(function(){
		$("#divMore").hide();
		$("#divMoreCk").show();
		$(this).hide();
	});
});

var defaultSelect = "请选择";   

var setJobLocation = function(locationArr){
    var locations = "";
	var len = locationArr.length;
	for ( var i = 0; i < len; i++) {
		$("#jobLocation" + (i + 1)).val(locationArr[i][0]);
		locations += locationArr[i][1] + " ";
	}
	for (j = len; j < 3; j++) {
		$("#jobLocation" + (j + 1)).val("");
	}
	if(locations==""){
	   locations = defaultSelect;
	}
	$("#btnJobLocation").html(locations);
	$("#btnJobLocation").val(locations);
	
	
}

var setJobCaling = function(calling) {
	    var spCalling = "";
		var len = calling.length;
		for ( var i = 0; i < len; i++) {
			$("#calling" + (i + 1)).val(calling[i][0]);
			spCalling += calling[i][1] + " ";
		}
		for (j = len; j < 3; j++) {
			$("#calling" + (j + 1)).val("");
		}
		if(spCalling == ""){
		   spCalling = defaultSelect;
		}
		$("#btnCalling").html(spCalling);
		$("#btnCalling").val(spCalling);
}

var setJobFunction = function(calling) {
	
	var spCalling = "";
	var len = calling.length;
	for ( var i = 0; i < len; i++) {
		$("#jobFunction" + (i + 1)).val(calling[i][0]);
		spCalling += calling[i][1] + " ";
	}
	for (j = len; j < 3; j++) {
		$("#jobFunction" + (j + 1)).val("");
	}
	if(spCalling==""){
		spCalling = defaultSelect;
	}
	$("#btnJobFunction").html(spCalling);
	$("#btnJobFunction").val(spCalling);
    
}


var ckMoreCondition = function(){

    var liProvidesalary = $("#liProvidesalary");
	var liProperity = $("#liProperity");
	var liDegree = $("#liDegree");
	var liWorkYear = $("#liWorkYear");
	
	$(liProvidesalary).show();
	$(liProperity).show();
	$(liDegree).show();
	$(liWorkYear).show();
	
}


var bookChangerMobile = function(m){
	if($(m).attr("checked") == "checked"){
		if($(m).val()=="" || $(m).val()==null){
		   $(m).attr("checked","");
		   alert("你没有完善手机信息， 无法手机订阅！");
		}
	}
}

var bookChangerEmail = function(m){
	if($(m).attr("checked") == "checked"){
		if($(m).val()=="" || $(m).val()==null){
		   $(m).attr("checked","");
		   alert("你没有完善邮件信息， 无法邮件订阅！");
		}
	}
}

var goPager = function(pageNo, totalPage){
	if(pageNo<=0){
		return;
	}else if(pageNo > totalPage){
		return; 
	}
	searchJobs(pageNo);
}

var searchJobs = function(pageNo){
	$("#spMsg").hide();
	var loading = "<img src='"+basePath+"/images/loading.gif' alt='正在加载数据' /> <span>正在加载数据...</span>";
	$("#jobItems").html(loading);
	var keyword = $("#keyword").val();
	var keywordType = "";
	var positionPostDate = $("#positionPostDate").val();
	var txtSearcher = $("#txtSearcher").val();
	var temp = document.getElementsByName("keywordType");
    for(var i=0;i<temp.length;i++)
	{
	   if(temp[i].checked)
	    keywordType = temp[i].value;
	}
   
    var jobFunction1 = $("#jobFunction1").val();
    var jobFunction2 = $("#jobFunction2").val();
    var jobFunction3 = $("#jobFunction3").val();
    
    var jobLocation1 = $("#jobLocation1").val();
    var jobLocation2 = $("#jobLocation2").val();
    var jobLocation3 = $("#jobLocation3").val();
    
    var calling1 = $("#calling1").val();
    var calling2 = $("#calling2").val();
    var calling3 = $("#calling3").val();
    
    var ReqWorkyear = $("#ReqWorkyear").val();
    var degreeID = $("#degreeID").val();
    var properity = $("#properity").val();
    
    var providesalary  = $("#providesalary").val();
    var ckMobileOrder  = $("#ckMobileOrder").attr("checked") == "checked" ? $("#ckMobileOrder").val() : "";
    var ckEmailOrder  = $("#ckEmailOrder").attr("checked") == "checked" ? $("#ckEmailOrder").val() : "";
	$.post("search.shtml", {"keyword":keyword,
		                    "keywordType":keywordType,
		                    "positionPostDate":positionPostDate,
		                    "txtSearcher":txtSearcher,
		                    "jobFunction1":jobFunction1,
		                    "jobFunction2":jobFunction2,
		                    "jobFunction3":jobFunction3,
		                    "jobLocation1":jobLocation1,
		                    "jobLocation2":jobLocation2,
		                    "jobLocation3":jobLocation3,
		                    "calling1":calling1,
		                    "calling2":calling2,
		                    "calling3":calling3,
		                    "ReqWorkyear":ReqWorkyear,
		                    "degreeID":degreeID,
		                    "properity":properity,
		                    "providesalary":providesalary,
		                    "ckMobileOrder":ckMobileOrder,
		                    "ckEmailOrder":ckEmailOrder,
		                    "pageSize":"30",
		                    "pageNo":pageNo
		                    
		},
			function(data) {
			  $("#jobItems").html(data);
	});
	$("#txtSearcher").val("");
}


var save = function(){
    var searcherName = $.trim($("#searcherName").val());
    if(searcherName==""){
       alert("请输入搜索器名称！");
       return;
    }
    var calling = $("#btnCalling").val();
    if(calling=="" || calling=="请选择"){
       alert("请至少选择一个行业！");
       return;
    }
    var frmSearcher = document.frmSearcher;
    frmSearcher.submit();
}
	 
	 
	 


