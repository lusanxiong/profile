var JobDialog = new Object();
JobDialog.box =  "<div style='position: relative;'id='dialogBox'>"
              +"<div style='position: absolute;width:220px; height:100px; border:1px solid #ccc; background-color:#FFF; overflow:hidden; color:#666'>"
              +"<div style='width:186px; float:left;padding:16px 0 8px 15px; display:inline'>"
              +"<img src='../images/success.gif' height='30px' /></div>"
              +"<div style='width:186px; line-height:18px; float:left; margin-left:16px; display:inline;' id='divMessage'></div>"
              +"</div>"
              +"</div>";

JobDialog.show = function(message){
    $("#divMessage").html(message);
	$.blockUI({
		overlayCSS:{backgroundColor:'white'}, 
        message:this.box, 
        css: {top:'200px'} 
    });
}

JobDialog.hide =  function(message,timeOut){
	$("#divMessage").html(message);
	setTimeout($.unblockUI,timeOut);
}
