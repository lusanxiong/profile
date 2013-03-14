(function($) {
	$.confirmDialog = function(setting){
			$("#_confirm_dialog_title").html(setting.title);
			$("#_confirm_dialog_content").html(setting.content);
			$("#_confirm_dialog_ok").off("click").on("click",function(){
				$.unblockUI();
				setting.ok();
			});
			var css = { top:'25%',left: '28%' };
			css = $.extend({},css,setting.css);
			jQuery.blockUI({ 
				message:jQuery("#_confirm_dialog"),
	            css: css
	        });
	};
	
	$.forwardDialog = function(setting){
		$("#_forward_dialog_atName").html(setting.fuserName?setting.fuserName:setting.userName);
		$("#_forward_dialog_content").html(setting.content);
		//setting.content.replace(/</g,"&lt;")
		$("#_forward_dialog_userName").html(setting.userName);
		$("#_forward_dialog_fuserName").html(setting.fuserName);
		$("#_forward_dialog_ok").off("click").on("click",function(){
			if(!setting.validate()){
				return;
			}
			$.unblockUI();
			setting.ok();
		});
		var css = { top:'25%',left: '28%' };
		css = $.extend({},css,setting.css);
		jQuery.blockUI({ 
			message:jQuery("#_forward_dialog"),
	        css: css
	    });
	};
	
	$.groupDialog = function(setting){
		$("#_group_dialog_ok").off("click").on("click",function(){
			$.unblockUI();
			setting.ok();
		});
		
		var css = { top:'25%',left: '28%' };
		css = $.extend({},css,setting.css);
		jQuery.blockUI({ 
			message:jQuery("#_group_dialog"),
	        css: css
	    });
	}
	
	$.messageDialog = function(setting){
		$("#_message_text").val("");
		$("#_message_ok").off("click").on("click",function(){
			setting.ok();
		});
		var css = { top:'25%',left: '28%' };
		css = $.extend({},css,setting.css);
		jQuery.blockUI({ 
			message:jQuery("#_message_dialog"),
	        css: css
	    });
	}
	
})(jQuery);