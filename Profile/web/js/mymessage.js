$(function(){
      var divRandomFriend = $("#divRandomFriend");
      $.post(basePath+"/friends/randomFriends.shtml", function(data) {
        $("#divRandomFriend").html(data);
      });
    });
    
    var showReply = function(id){
       $.blockUI({ 
		message:jQuery($("#_reply_message_dialog")),
		css: { top:'30%',left: '25%' }
       });
       var spaSender = $("#spaSender"+id).html();
       var spcSender = $("#spcSender"+id).html();
       //$("#_messsage_userName").html(spaSender);
       $("#_messsage_userName").html(spaSender);
       $("#_messsage_content").html(spcSender);
       $("#_messageId").val(id);
       $("#_reply_ok").click(function() {
    	   reply();
       });
    }
    
    var reply = function(){
        var reply_text = $("#_message_text").val();
        var messageId = $("#_messageId").val();
        $.post(basePath+"/AjaxServlet", {"action":"replymessage","id":messageId,"reply":reply_text}, 
           function(data) {
        	$("#_txtReply"+messageId).html(reply_text);
            $.unblockUI();
	    });
	    
    }
    
    var delMsg = function(id){
        $.post(basePath+"/AjaxServlet", {"action":"deletemessage","id":id}, 
              function(data) {
        	  $("#divMessage"+id).hide();
	    });
    }