<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
		var userCount = $("#userCount").val(); //实际搜索出来的用户数量
		
        var account = 0; //关注数量
        function attention(tid,friendType){
            var action = "attention";
				$.post(basePath + "/AjaxServlet", {
					"targetId" : tid,
					"group" : 5,
					"action" : action
				}, function(data) {
					if(data==1 || data==2){
						setFriendTypeChecked(friendType);
						
						group(tid);
						$("#_lilf"+tid).hide();
						account = account +1;
						
						if(userCount == account) {
							loadMore();
						}
						//if(acount >= 6){
						  //loadMore();
						//}
					}
					
				});
        }
        
		function group(tid){
			var setting = {
					css:{ top:'30%',left: '28%' },
					ok : function() {
						var goupId = $("#_goupId").val();
						$.post(basePath + "/AjaxServlet", {
							targetId : tid,
							group : goupId,
							action :"changegroup"
						});
					}
				};
			$.groupDialog(setting);
		}
		
		
		function loadMore(){
		   var divRandomFriend = $("#divRandomFriend");
           $.post(basePath+"/friends/randomFriends.shtml", function(data) {
           		$("#divRandomFriend").html(data);

           		userCount = $("#userCount").val(); 
           		account = 0;
      		});
		}

		
		

		</script>
<ul>
<c:forEach items="${users}" var="friend">
<li id="_lilf${friend.uid}">
<div class="per_pic"><a href="${basePath}/profile/user.shtml?uid=${friend.uid}" target="_blank">
<c:if test="${fn:indexOf(friend.photo, 'http://') > -1}">
                        <img src="${friend.photo}" height="50" border="0" width="50"/>
                        </c:if>
                         <c:if test="${fn:indexOf(friend.photo, 'http://') == -1}">
                        <img src="${basePath}/${friend.photo}" height="50" border="0" width="50"/>
                        </c:if>
</a>
</div>
<div class="per_word">
	<p class="per_word_1" style="margin-left:3px;"><span class="p_name"><a href="${basePath}/profile/user.shtml?uid=${friend.uid}" target="_blank">${friend.name}</a></span><span class="p_area">${friend.place }</span></p> 
    <p class="per_word_5">${friend.lastPostName}</p> 
    <p class="per_word_4"><span class="p_position">${friend.friendTypeDescription }</span><span class="p_attention"><a class="p_sblue" href="###" onclick="attention(${friend.uid},${friend.friendType });">加关注</a></span></p>    
</div>
</li>
</c:forEach>
</ul>
<input type="hidden" id="userCount" value="${fn:length(users)}">
<div class="dialog" id="_group_dialog" style="position:relative; z-index:1;display: none;">

<div class="dialogcon" style="position: absolute; left:10px">

<div class="titlebar">

<h1>关注成功</h1>

<a class="close" title="关闭" href="javascript:void(0);" onclick="$.unblockUI();">关闭</a>

</div>

<div class="client">

<p></p>

<div class="g9">请设置分组

<div class="gzfyk">

<input type="hidden" value="5" id="_goupId" />

<ul id="relationList">

<li><input id="r1" type="checkbox" value="1" class="gzfyks" /><label for="r1">同行</label></li>

<li><input id="r2" type="checkbox" value="2" class="gzfyks"/><label for="r2">同事</label></li>

<li><input id="r3" type="checkbox" value="3" class="gzfyks"/><label for="r3">同乡</label></li>

<li><input id="r4" type="checkbox" value="4" class="gzfyks"/><label for="r4">同学</label></li>

<li><input id="r5" type="checkbox" value="5" class="gzfyks" checked="checked"/><label for="r5">其他</label></li>

</ul>

</div>

</div>

</div>

<div class="buttons">

<span class="normal" onclick="$.unblockUI();">取消</span>

<span class="default" id="_group_dialog_ok">保存</span>

</div>

</div>

</div>

<script type="text/javascript">

	$(function(){

		 $("#relationList>li>input").click(function(){
			 $("#relationList input").attr("checked",false);

			 $("#_goupId").val($(this).val());
			 $(this).attr("checked",true);
		 });
	});

	//关注时，根据所关注的朋友类型设置为该类型的朋友为选中状态
	function setFriendTypeChecked(friendType) {
		$("#friendType").val(friendType);
		
		if(friendType == 0) {
			$("#relationList input").attr("checked",false);
			$("#r5").attr("checked",true);
			$("#_goupId").val($("#r5").val());
			return;
		}
		
		$("#relationList input").attr("checked",false);
		$("#r"+friendType).attr("checked",true);
		$("#_goupId").val($("#r"+friendType).val());
	}

</script>
