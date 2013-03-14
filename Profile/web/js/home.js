$(function(){    
      var resumeState = $("#resumeState");
      $.post(basePath+"/AjaxServlet", {
						"action" : "resumeper"
	  			}, function(data) {
	  			
	  			var json = eval(data);
	  	var status = json[0];	
	  	var per = parseInt(status.per);
	  	if(per == 100){
	  		$("#divTootip").html("您的简历很完整，记得及时更新信息，时常刷新简历哦，以便于企业和朋友更好的搜索到您。");
	  	}else{
	  		var start = "您还有";
	  		var mid = "";
	  		var end = "没有填写，请尽快完善自己的个人简历，以便于企业和朋友更好的搜索到您。";
	  		if(status.eduinfo == "0"){
	  			mid = "<a href='profile/education.shtml' class='sblue'>教育经历</a>";
	  		}
	  		if(status.workexeinfo == "0"){
	  			if(mid != "")
	  				mid += "、";
	  			mid += "<a href='profile/experience.shtml' class='sblue'>工作经验</a>";
	  		}
	  		if(status.traininfo == "0"){
	  			if(mid != "")
	  				mid += "、";
	  			mid += "<a href='profile/training.shtml' class='sblue'>培训经历</a>";
	  		}
	  		
	  		if(status.englevel == "0"){
	  			if(mid != "")
	  				mid += "、";
	  			mid += "<a href='profile/language.shtml' class='sblue'>语言能力</a>";
	  		}
	  		if(status.jobseeking == "0"){
	  			if(mid != "")
	  				mid += "、";
	  			mid += "<a href='profile/intentions.shtml' class='sblue'>意向职位</a>";
	  		}
	  		if(status.otherskill == "0"){
	  			if(mid != "")
	  				mid += "、";
	  			mid += "<a href='profile/additional.shtml' class='sblue'>相关技能</a>";
	  		}
	  		$("#divTootip").html(start+mid+end);
	  	}
	  	
		var width = per * 147 / 100;
		$("#resumeStatePer").html(per + "%");
		$(resumeState).css("width",width);
	  });
	  
      //可能认识的人
	  var divRandomFriend = $("#divRandomFriend");
      $.post(basePath+"/friends/randomFriends.shtml", function(data) {
        $("#divRandomFriend").html(data);
      });
      
      //谁看过我
  	  $.post(basePath+"/user/UserAccessHistory!getUserAccessHistoryInfo.shtml",function(data) {
		$("#userAccessHistoryInfoDiv").html(data);
	  });
	  
    });
    
    var showJobState = function(show){
       if(show==0){
          $("#divJobState").hide();
       }else{
          $("#divJobState").show();
       }
    }
    
    var changeJobState = function(state){
       var jobStateIndex = state.selectedIndex;  
       
       $.post(basePath+"/AjaxServlet", {
						"action" : "changejobstate","jobState":jobStateIndex
	  			}, function(data) {
		   $("#jobState").html("<br>" + state.options[jobStateIndex].text);
		   $("#divJobState").hide();
	  });
    }
