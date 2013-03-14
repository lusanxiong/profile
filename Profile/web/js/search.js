$(function(){  
      var _show = false;
      $("#hkeyWord").keyup(function(){
          var keyWord = $.trim($(this).val());
          $("#_sp").html("搜<span>“"+keyWord+"”</span>相关职位>>");
          $("#_sf").html("搜<span>“"+keyWord+"”</span>相关用户>>");
          if(keyWord==""){
        	  $("#_hSearch").hide();
          }else if($("#_hSearch").css("display")=="none"){
             $("#_hSearch").show();
             $("#_sf").addClass("hover");
          }
      }); 
      
      $("#hkeyWord").keydown(function(event){
    	  if(event.keyCode==13){
    		  search("sf");
    	  }
      }); 
      
      $("#hkeyWord").blur(function(){
    	  if(!_show){
    	    $("#_hSearch").hide();
    	  }
      }); 
      
      $("#hkeyWord").focus(function(){
    	  var keyWord = $.trim($(this).val());
    	  if(keyWord!=""){
    		  $("#_hSearch").show();
    		  $("#_sf").addClass("hover");
          }
      }); 
      
      
      $("#_sf").mouseenter(function(){	
    	  _show = true;
    	  $(this).addClass("hover");
    	  $("#_sp").removeClass("hover");
      });
      
      $("#_sf").mouseleave(function(){	
    	  _show = false;
      });
      
      $("#_sp").mouseenter(function(){	
    	  _show = true;
    	  $(this).addClass("hover");
    	  $("#_sf").removeClass("hover");
      });
      
      $("#_sp").mouseleave(function(){	
    	  _show = false;
      });
      
      $("#_sf").click(function(){	
    	  search("sf");
      });
      
      $("#_sp").click(function(){	
    	  search("sp");
      });
      
      $("#_imgS").click(function(){	
    	  search("sf");
      });
      
      var search = function(t){
    	  if($.trim($("#hkeyWord").val())=="")
    		  return;
    	  var _frmSearch = document._frmSearch;
    	  if(t=="sf"){
    		  _frmSearch.action = basePath + "/friends/"; 
    	  }else{
    		  _frmSearch.action = basePath + "/jobs/";
    	  }
    	  _frmSearch.submit();
      }

  })
  
  
  