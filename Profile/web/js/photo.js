
var Photo = {};

Photo.shield = function(){
	var photoflag = $("#photoShieldBtn").attr("photoflag");
	$.post(basePath + "/profile/photoShield.shtml", "photoflag="+photoflag,function(data){
		if(data==1) {
			$("#photoShieldBtn").attr("photoflag","2").html("显示");
		}else{
			$("#photoShieldBtn").attr("photoflag","1").html("屏蔽");
		}
	},"text");
}
Photo.edit = function() {
	var left, top;
	left = ($(window).width()-750)/2 - 75;
	top = ($(window).height()-540)/2;
	window.open(basePath+'/profile/photoShow.shtml','','top='+top+',left='+left+',width=750,height=540,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
}

Photo.reset = function(src) { //CutHeadAction 回调该函数
	var t = new Date().getTime();
	src = basePath+src + "?t="+t;
	$("#resumePhoto").attr("src",src);
}