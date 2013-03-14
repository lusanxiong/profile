
$(document).ready(function(){
	
	var tbInfo = $("#tbInfo");
	var btnEditInfo = $("#btnEditInfo");
	
	
	var tbEditInfo = $("#tbEditInfo");
	
	var btnCancelInfo = $("#btnCancelInfo");
	
	var tbIt = $("#tbIt");
	var btnEditIt = $("#btnEditIt");
	
	
	var tbEditIt = $("#tbEditIt");
	
	var btnCancelIt = $("#btnCancelIt");
	$("#selComputerLevel").val($("#computerLevel").val());
	
	
	$(btnEditInfo).click(function(){
	    $(tbInfo).hide("slow");
	    $(tbEditInfo).show("slow");
	});
	
	
	
	$(btnCancelInfo).click(function(){
	    $(tbInfo).show("slow");
	    $(tbEditInfo).hide("slow");
	});
	
	
	$(btnEditIt).click(function(){
	    $(tbIt).hide("slow");
	    $(tbEditIt).show("slow");
	});
	
	
	
	$(btnCancelIt).click(function(){
	    $(tbIt).show("slow");
	    $(tbEditIt).hide("slow");
	});
	
	
});
	 
	 
	 


