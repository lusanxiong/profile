
$(document).ready(function(){
	
	var tbInfo = $("#tbInfo");
	var btnEdit = $("#btnEdit");
	
	var frmSave = document.frmSave;
	var tbEdit = $("#tbEdit");
	var btnSave = $("#btnSave");
	var btnCancel = $("#btnCancel");
	
	
	
	$(btnEdit).click(function(){
	    $(tbInfo).hide("slow");
	    $(tbEdit).show("slow");
	});
	
	
	$(btnSave).click(function(){
		var jobFunction1 = $("#jobFunction1").val();
		var jobFunction2 = $("#jobFunction2").val();
		var jobFunction3 = $("#jobFunction3").val();
		
		var message = $("#_bsSubmitMsg");
		
		if(jobFunction1 == "0" && jobFunction2 == "0" && jobFunction3 == "0"){
			message.html("请选择岗位类别！");
	        return;
		}
		
		var jobSeeking1 = $("#jobSeeking1").val();
		var jobSeeking2 = $("#jobSeeking2").val();
		var jobSeeking3 = $("#jobSeeking3").val();
		
		if(jobSeeking1 == "" && jobSeeking2 == "" && jobSeeking3 == ""){
			message.html("请填写寻求职位！");
	        return;
		}
		
		var jobLocation1 = $("#jobLocation1").val();
		var jobLocation2 = $("#jobLocation2").val();
		var jobLocation3 = $("#jobLocation3").val();
		if(jobLocation1=="0"&&jobLocation2=="0"&&jobLocation3=="0"){
			message.html("请选择工作地点！");
	        return;
		}
		
		frmSave.submit();
	});
	
	$(btnCancel).click(function(){
	    $(tbInfo).show("slow");
	    $(tbEdit).hide("slow");
	});
	
	$("#selSalary").val($("#salary").val());
	
	$("#spLocation").click(function(){
		var locations = new Array();
		for(var i=0; i<3; i++){
		   var jobLocationId = $("#jobLocation" + (i+1)).val();
		   var jobLocation =  $("#jobLocation" + (i+1)).attr("lname")
		   if(jobLocationId != "" && jobLocationId != "0"){
		      locations[i] = new Array(jobLocationId, jobLocation);
		   }
		}
		
		AddressDialog.init(locations,3,setJobLocation);
		AddressDialog.show();
	});
	
	
	$("#spCalling").click(function(){
		var callings = new Array();
		for(var i=0; i<3; i++){
			   var jobFunctionId = $("#jobFunction" + (i+1)).val();
			   var jobFunction =  $("#jobFunction" + (i+1)).attr("jname")
			   if(jobFunctionId != "" && jobFunctionId != "0"){
				   callings[i] = new Array(jobFunctionId, jobFunction);
			   }
			}
		CallingDialog.init(callings,3,setJobCaling);
		CallingDialog.show();
	});
	
	
	
});


var setJobLocation = function(locationArr){
	var spLocation = "";
	var len = locationArr.length;
    for(var i=0; i<len; i++){
    	$("#jobLocation" + (i+1)).val(locationArr[i][0]);
    	$("#jobLocation" + (i+1)).attr("lname",locationArr[i][1]);
    	spLocation += locationArr[i][1] + "  ";
    }
    for(j=len; j<3; j++){
    	$("#jobLocation" + (j+1)).val(0);
    	$("#jobLocation" + (j+1)).attr("lname","");
    }
    $("#spLocation").html(spLocation);
}

var setJobCaling = function(calling) {
	var spCalling = "";
	var len = calling.length;
	for ( var i = 0; i < len; i++) {
		$("#jobFunction" + (i + 1)).val(calling[i][0]);
		$("#jobFunction" + (i + 1)).attr("jname", calling[i][1]);
		spCalling += calling[i][1] + "  ";
	}
	for (j = len; j < 3; j++) {
		$("#jobFunction" + (j + 1)).val(0);
		$("#jobFunction" + (j + 1)).attr("jname", "");
	}
	
	$("#spCalling").html(spCalling);

}
	 
	 
	 


