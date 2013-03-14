$.extend({
	//复制到剪切板
	copyToClipboard:function(txt){
		if(window.clipboardData) {     
                 var flag = window.clipboardData.clearData();  
                 if(flag){
                	 window.clipboardData.setData("Text", txt);    
                	 alert("复制成功！")
                 }else{
                	 alert("你拒绝了浏览器安全确认，请尝试手动[Ctrl+C]复制。")
                 }
        } else if(navigator.userAgent.indexOf("Opera") != -1) {     
              window.location = txt;     
         } else if (window.netscape) {     
             try {     
                   netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");     
              } catch (e) {     
                  alert("被浏览器拒绝！\n请在浏览器地址栏输入'about:config'并回车\n然后将 'signed.applets.codebase_principal_support'设置为'true'");     
              }     
              var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);     
             if (!clip)     
                   return;     
              var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);     
              if (!trans)     
                  return;     
              trans.addDataFlavor('text/unicode');     
             var str = new Object();     
              var len = new Object();     
              var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);     
              var copytext = txt;     
              str.data = copytext;     
              trans.setTransferData("text/unicode",str,copytext.length*2);     
             var clipid = Components.interfaces.nsIClipboard;     
              if (!clip)     
                   return false;     
             clip.setData(trans,null,clipid.kGlobalClipboard);     
              alert("复制成功！")     
         }     
	},

	/**
	 * target 要被插入的dom对象, jquery类型
	 * text 要插入的文本
	 */
	insertContent:function(target,text) {
		var obj = target[0];
	    var selection = document.selection;
	    obj.focus();
	    if (obj.selectionStart) {
	        obj.value = obj.value.substr(0, obj.selectionStart) + text + obj.value.substr(obj.selectionEnd);
	    } else if (selection && selection.createRange) {
	        var sel = selection.createRange();
	        sel.text = text;
	    } else {
	        obj.value = text + obj.value;
	    }
	    obj.focus();
	},
	
	/**
	 * 闪烁提示
	 */
	colorTip:function(target){
		target.css("background-color","#FFDDDC");
		setTimeout(function(){
			target.css("background-color","");
		},300);
		target.focus();
	},
	
	stringLength:function(str){ 
		var i,sum=0; 
		for(i=0;i<str.length;i++){ 
		if((str.charCodeAt(i)>=0) && (str.charCodeAt(i)<=255)) 
		sum=sum+(0.5);  //英文字符两个算一个
		else 
		sum=sum+1;
		} 
		return Math.ceil(sum);  //取天花板数
	}
});



;(function($) {
	//重置表单插件
	$.fn.resetForm = function() {
		return this.each(function() {
			if (typeof this.reset == 'function' || (typeof this.reset == 'object' && !this.reset.nodeType)) {
				this.reset();
			}
		});
	};
	
	//预加载图片
	jQuery.fn.loadImage = function(src,minDiv,midDiv) {
			_self = $(this);
			var img = new Image();
			img.src = src;
			_self.html("<img src='"+src+"' onclick=\"MicroBlog.showMidImage('"+minDiv+"','"+midDiv+"')\" class='cursorOut' />");
			//alert(minDiv+"|"+midDiv)
			/*if($.browser.msie){ // ie
				img.onreadystatechange = function() {
				    if ( this.readyState == "complete" || img.readyState=="loaded"){
				      _self.html("<img src='"+src+"' onclick=\"MicroBlog.showMidImage('"+minDiv+"','"+midDiv+"')\" class='cursorOut' />");
				    }
			    }
		    }else { //ff and other 
		    	img.onload = function(){
		    		_self.html("<img src='"+src+"' onclick=\"MicroBlog.showMidImage('"+minDiv+"','"+midDiv+"')\" class='cursorOut' />");
		    	}
		    }*/
	};
		
	//跟滚动条滚动
	jQuery.fn.myScroll = function(p){
		//flag，标识是否隐藏 0 否，1是
		var parms = {top:0,left:0,flag:0};
		parms=$.extend(true,{},parms,p);
		
		var posX,posY;
	    if (window.innerHeight) {
	        posX = window.pageXOffset;
	        posY = window.pageYOffset;
	    }
	    else if (document.documentElement && document.documentElement.scrollTop) {
	        posX = document.documentElement.scrollLeft;
	        posY = document.documentElement.scrollTop;
	    }
	    else if (document.body) {
	        posX = document.body.scrollLeft;
	        posY = document.body.scrollTop;
	    }
	    
	    if(parms.flag==1) {  //1隐藏，说明是返回顶部
	    	$(this).show();
	    }
	    
	    if($(window).scrollTop()==0){
	    	if(parms.flag==0) {
	    	    $(this).css("top","0px");
	    		$(this).css("left","0px");
	    	}
	    	else if(parms.flag==1){
	    		$(this).hide();
	    	}
	    }else {
		    $(this).css("top",(posY-30)+"px");
		    $(this).css("left","0px");
	    }
	};
	
	/**回到顶部，滚动效果*/
	jQuery.fn.scrollTo = function(speed,top) {
		//var targetOffset = $(this).offset().top;
		var targetOffset = 0;
		if(top) targetOffset = top;
		$('html,body').stop().animate({scrollTop: targetOffset}, speed);
		return this;
	}; 
	
})(jQuery);