var CallingDialog = {};

CallingDialog.callings =  new Array();
CallingDialog.count = 3;
CallingDialog.callback;

CallingDialog.init = function(callings,count, callback){
	if(callings != null){
	    this.callings = callings;
	}
	this.count = count;
	this.callback = callback;
	$("#_call_apt_count").html(this.count);
	$("#_call_box_ok").click(function() {
		CallingDialog.hide();	
	}); 
}

CallingDialog.initSelect = function(){
	var llen = this.callings != null ? this.callings.length : 0;
	var ht = "";
	for(var i=0; i<llen; i++){
	    var loc = this.callings[i];
	    if(loc[i] != ""){
	       ht += "<li > <input onclick='CallingDialog.unSelect(this);' checked='checked' value='" + loc[0] + "' type='checkbox'>" + loc[1] + "</li>";
	    }
	}
	$("#_call_selected_ul").html(ht);
}

CallingDialog.select = function(t){
	var sl = new Array();
	sl[0] = $(t).attr("id").replace("_ck_","");
	sl[1] = $(t).attr("value");
	var llen = this.callings != null ? this.callings.length : 0;
	if($(t).attr("checked") == "checked"){
	   if(this.count==1){
		   if(llen > 0){
			   $("#_ck_"+this.callings[0][0]).removeAttr("checked"); 
		   }
	       this.callings.length = 0;
	       llen = 0;
	       
	   }
	   if(llen >= this.count){
		  $(t).removeAttr("checked"); 
		  alert("最多只能选择" + this.count + "项！");
		  return;
	   }
	   
	   this.callings.push(sl);
	}else{
	   var rl = new Array();
	   for(var i=0; i<llen; i++){
	       if(this.callings[i][0] !== sl[0]){
	    	   rl.push(this.callings[i]);
	       }
	   }
	   this.callings = rl;   
	}
	this.initSelect();
}


CallingDialog.unSelect = function(t){
	var llen = this.callings.length;
	var newArr = new Array();
	if(llen <=0)
		return;
	for(var i=0; i<llen; i++){
		var loc = this.callings[i];
		if($(t).val() != loc[0]){
			newArr.push(loc);
		}
	}
	this.callings = newArr;
	this.initSelect();
}

CallingDialog.show = function(){
	$.blockUI({ 
		message:jQuery("#_call_box")
		//css: { top:'30%',left: '25%' }
    });
	CallingDialog.initSelect();
}

CallingDialog.showCalling = function(li){
	var calArr = new Array();
	var city = $(li).attr("id").replace("_c_","");

	
	calArr.push(new Array(city,0,$(li).html(),'',0));
	for(var i=0; i<sortCount; i++){
	    var ad = sort[i];
	    if(ad[1] == city){
	    	calArr.push(ad);
	    }
	}
	var l = calArr.length;

	if(l < 2)
		return;
	
	var cal_div = $("#_call_child_box");
	var p = $(li).position();
	var las = "<ul>";
	
	for(var j=0; j<l; j++){
		var ck = false;
		
		var llen = this.callings != null ? this.callings.length : 0;
		
		for(var i=0; i<llen; i++){
			if(this.callings[i][0] == calArr[j][0]){
				ck = true;
				break;
			}
		}
		if(j==0){
			las += "<li class='popdiv_areaTitle2'>"; 
		}else{
		    las += "<li class='jobSortTitle'>";
		}
		las += "<input id='_ck_" + calArr[j][0] + "'";
		if(ck==true){
			las += " checked='checked'";
		}
		las += " type='checkbox' onclick='CallingDialog.select(this);' value='" + calArr[j][2] + "'>" + calArr[j][2];
		las += "</li>";

	}
	
	
	las += "</ul>";
	$(cal_div).html(las);
	$(cal_div).css("left",p.left);
	$(cal_div).css("top",p.top);
	$(cal_div).show();
	$(li).after(cal_div);
	
	$(cal_div).mouseleave(function() {
		$(this).hide();	
	}); 
}

CallingDialog.hide = function(){
    $.unblockUI();
    this.callback(CallingDialog.callings);
}
