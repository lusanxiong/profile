function findLabel() {
	var page = 1;
	$("#page").val(page);
	document.thisForm.submit();
}

function goPage(page){
	$("#page").val(page);
	document.thisForm.submit();
}

function changeSelected(){
	var labelTypeSelValue = $("#labelTypeSel").val();
	$("#labelType").val(labelTypeSelValue);
	findLabel();
}


function delLabel(labelId){		
		if(!window.confirm('是否要删除该标签?')){return;}
		$.ajax({
			type:"POST",
			dataType:"json",
		    url: basePath + "/admin/adminLabel!delLabel.shtml",
		    data : "labelId="+labelId,
		    success: function(msg) {
		     var pageNo = $("#pageNo").val();
		     goPage(pageNo);
		    }
		})			   			   
}

function modifyLabel(labelId,labelSource,isDisplay) {
	
     
	if($("#"+labelId+"_value_labelName").css("display") == 'none') {
		
		display(labelId,labelSource,isDisplay);

	}else {
	    var labelName = $("#"+labelId+"_labelName").val();
        var labelSort=$("#"+labelId+"_labelSort").val();
        
        var labelSource = $("#"+labelId+"_labelSource").val();
        var isDisplay = $("#"+labelId+"_isDisplay").val();
        
		if(!infoValidator(labelName,labelSort)){
	            return;
	  	}
	  				         
		//修改标签		
		$.ajax({
			type:"POST",
			dataType:"json",
		    url: basePath + "/admin/adminLabel!updateLabel.shtml",
		    data : "labelId="+labelId+"&labelName="+labelName+"&labelSort="+labelSort+"&labelSource="+labelSource+"&isDisplay="+isDisplay,
		    success: function(msg) {
		    if(msg.iFlag==true){
		      var pageNo = $("#pageNo").val();
		      goPage(pageNo);
		    }else{
		       alert("你修改的标签已存在!");
		       var pageNo = $("#pageNo").val();
		       goPage(pageNo);
		    }
		    
		    }
		})		
		
	}
					
}

function display(labelId,labelSource,isDisplay) {
$("#"+labelId+"_value_labelName").css({display:""});
$("#"+labelId+"_value_labelSource").css({display:""});
$("#"+labelId+"_value_labelSort").css({display:""});
$("#"+labelId+"_value_isDisplay").css({display:""});
      
$("#"+labelId+"_text_labelName").css({display:"none"});
$("#"+labelId+"_text_labelSource").css({display:"none"});
$("#"+labelId+"_text_labelSort").css({display:"none"});
$("#"+labelId+"_text_isDisplay").css({display:"none"});

 $("#"+labelId+"_labelSource").val(labelSource);
 $("#"+labelId+"_isDisplay").val(isDisplay);
 
 $("#"+labelId+"_modifyBtn").html("保存");
}

function infoValidator(labelName,labelSort){
     if(labelName==""){
          alert("请输入标签名称");
          return false;
       }
     var ln = labelName.length;
     if(ln>10){
    	 alert("标签名称不能超过10位!");
    	 return false;
     }
     if(labelSort==""){
    	 return true;
     }else if(!isNumber(labelSort)){
        alert("排名请填写数字！");
        return false;
       }
       
 return true;

}

function isNumber(number){
  var reg = /^[0-9]+$/;
return reg.test(number);
}

/*全选*/
function selectAll(){
if ($('#checkAll').attr('checked')) {   
   $("input[name='labelId']").attr('checked',true);   
} else {   
    $("input[name='labelId']").attr('checked',false);   
}                  

}

/*批量选择删除*/
function delSelect(){
if(!select()){
 alert('请至少选择一项后再操作!');
 return false;
}
if (confirm("是否要删除你选择的标签!")) { 
//jquery获取复选框值进行遍历  

 var labelIdStr="";
     
 $('input[name="labelId"]:checked').each(function() {
               labelIdStr+=$(this).val()+",";                        
                       
       });  
                         
    deleteLabel(labelIdStr);     
 } 
}

function select(){
var n=$("input:checked").length;
if(n==0){
     return false;
  }
return true;
}

function deleteLabel(labelIdStr){
	  $.ajax({ 
			type:"POST",
			dataType:"json",
		    url: basePath + "/admin/adminLabel!delBatchLabel.shtml",
		    data : "labelIdStr="+labelIdStr,
		    success: function(msg) {
		    //分页刷新
		   //取到删除的个数
	 	   var delLabelCount = labelIdStr.split(",").length-1;
		   if(delLabelCount < 0) {
		   	  delLabelCount = 0;
		   }
		    var currentPageLabelCount=$("#currentPageLabelCount").val();
	 	    var pageNo = $("#pageNo").val();
	 	    if(currentPageLabelCount - delLabelCount == 0) {
	 	    	pageNo = pageNo - 1;
	 	    }
	 	    goPage(pageNo);
		    
		}})			  
}



function addLabel(){
	  var labelName = $("#inputLabel").val();
	  var labelSource = $("#inputSource").val();
	  var labelIsdisplay = $("#inputDisplay").val();
	  var labelSort = $("#inputSort").val();
       
		if(!infoValidator(labelName,labelSort)){
	            return;
	  	}
		//增加标签	
		$.ajax({
			type:"POST",
			dataType:"json",
		    url: basePath + "/admin/adminLabel!addLabel.shtml",
		    data : "labelName="+labelName+"&labelSort="+labelSort+"&labelSource="+labelSource+"&isDisplay="+labelIsdisplay,
		    success: function(msg) {	    
	 	    if(msg.count==0){
                 goPage(1);
             }else if(msg.count==500){
                alert("添加标签失败");
                goPage(1);
             }else{
               	alert("你添加的标签已存在");
               	goPage(1);
              }
		    }
		})		
			  

}