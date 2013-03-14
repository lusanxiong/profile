$(document).ready(function() {
	

	$("div.block").mouseover(function() {
		$(this).addClass("bg_gray");
		$("div.block > span").hide();
		var duid = $(this).attr("duid");
		if(duid != ""){
			$("#stg"+duid).hide();
			$("#etg"+duid).show();
		}
	});

	$("div.block").mouseleave(function() {
		$(this).removeClass("bg_gray");
		var duid = $(this).attr("duid");
		if(duid != ""){
			$("#etg"+duid).hide();
			$("#stg"+duid).show();
		}
	});
});

