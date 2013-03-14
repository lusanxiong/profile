var AddressDialog = {};

AddressDialog.locations =  new Array();
AddressDialog.count = 3;
AddressDialog.callback = null;

AddressDialog.init = function(locations,count, callback){
	if(locations != null){
		this.locations = locations;
	}
	this.count = count;
	this.callback = callback;
	$("#_add_apt_count").html(this.count);
	$("#_add_box_ok").click(function() {
		AddressDialog.hide();	
	}); 
}

AddressDialog.initSelect = function(){
	var llen = this.locations != null ? this.locations.length : 0;
	var ht = "";
	for(var i=0; i<llen; i++){
	    var loc = this.locations[i];
	    if(loc[i] != ""){
	       ht += "<li id='_chooseCity_li_"+ loc[0] +"'> <input onclick='AddressDialog.unSelect(this);' checked='checked' value='" + loc[0] + "' type='checkbox'>" + loc[1] + "</li>";
	    }
	}
	$("#_add_selected_ul").html(ht);
}

AddressDialog.select = function(t){
	var sl = new Array();
	sl[0] = $(t).attr("id").replace("_lk_","");
	sl[1] = $(t).attr("value");
	var llen = this.locations != null ? this.locations.length : 0;
	if($(t).attr("checked") == "checked"){
	   if(this.count==1){
		   if(llen > 0){
			   $("#_lk_"+this.locations[0][0]).removeAttr("checked"); 
		   }
	       this.locations.length = 0;
	       llen = 0;
	       
	   }
	   if(llen >= this.count){
		  $(t).removeAttr("checked"); 
		  alert("最多只能选择" + this.count + "项！");
		  return;
	   }
	   this.locations.push(sl);   
	}else{
	   var rl = new Array();
	   for(var i=0; i<llen; i++){
	       if(this.locations[i][0] !== sl[0]){
	    	   rl.push(this.locations[i]);
	       }
	   }
	   this.locations = rl;   
	}
	this.initSelect();
}

AddressDialog.selectCity = function(a){
	var llen = this.locations != null ? this.locations.length : 0;
	if(llen >= this.count){
		if(this.count==1){
			this.locations.pop();
		}else{
		   alert("最多只能选择" + this.count + "项！");
	       return;
		}
	}
	
	var city = $(a).attr("id").replace("_l_","");
	for(var i=0; i<this.locations.length; i++){
	    if(city == this.locations[i][0])
	    	return;
	}
	var sl = new Array();
	sl[0] = city;
	sl[1] = $(a).html();
	this.locations.push(sl);

	this.initSelect();
}


AddressDialog.unSelect = function(t){
	var llen = this.locations != null ? this.locations.length : 0;
	var newArr = new Array();
	if(llen <=0)
		return;
	for(var i=0; i<llen; i++){
		var loc = this.locations[i];
		if($(t).val() != loc[0]){
			newArr.push(loc);
		}
	}
	this.locations = newArr;
	this.initSelect();
}

AddressDialog.show = function(){
	$.blockUI({ 
		message:jQuery("#_add_box")
		//css: { top:'1%',left: '15%' }
    });
	AddressDialog.initSelect();
}

AddressDialog.showArea = function(a){
	var city = $(a).attr("id").replace("_l_","");
	var areaArr = new Array();
	areaArr.push(new Array(city,0,$(a).html(),'',0));
	for(var i=0; i<addressCount; i++){
	    var ad = address[i];
	    if(ad[1] == city){
	    	areaArr.push(ad);
	    }
	}
	var l = areaArr.length;

	if(l < 2){
		AddressDialog.selectCity(a);
		return;
	}
	
	var area_div = $("#_add_child_box");
	var p = $(a).position();
	var las = "<ul>";
	
	for(var j=0; j<l; j++){
		var ck = false;
		var llen = this.locations != null ? this.locations.length : 0;
		
		for(var i=0; i<llen; i++){
			if(this.locations[i][0] == areaArr[j][0]){
				ck = true;
				break;
			}
		}
		if(j==0){
			las += "<li class='popdiv_areaTitle2'>";
		}else{
			las += "<li class='jobSortTitle'>";
		}
		
		las += "<input id='_lk_" + areaArr[j][0] + "'";
		if(ck==true){
			las += " checked='checked'";
		}
		las += " type='checkbox' onclick='AddressDialog.select(this);' value='" + areaArr[j][2] + "'>" + areaArr[j][2];
		las += "</li>";

	}
	
	
	las += "</ul>";
	$(area_div).html(las);
	$(area_div).css("left",p.left);
	$(area_div).css("top",p.top);
	$(area_div).show();
	$(a).after(area_div);
	
	$(area_div).mouseleave(function() {
		$(this).hide();	
	}); 
}

AddressDialog.hide = function(){
    $.unblockUI();
    this.callback(AddressDialog.locations);
}
