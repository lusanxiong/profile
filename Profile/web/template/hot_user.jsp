<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<% 
String dPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<div class="hot_people_top">
                      		<div class="word">活跃人物</div>
                            <div class="button">
                            <span class="img1"><img src="../images/hot_l.gif" width="18" height="16" onclick="getNextHotUser(#prve#)"></span>
                            <span class="img2"><img src="../images/hot_r.gif" width="19" height="16" onclick="getNextHotUser(#next#)"></span>
                            </div>
                      </div>
<div class="hot_people_cer">
	<div class="left">
	<a href="<%=dPath%>/profile/user.shtml?uid=#uid#" target="_blank" class="ble">
	<img src="#head#" height="68" width="68"></a>
	</div>
	<div class="right">
		<p class="name"><a href="<%=dPath%>/profile/user.shtml?uid=#uid#" target="_blank" class="ble">#name#</a></p>
		<p class="icon">
			<img src="#sex#" width="14" height="17">
		</p>
		<p class="button" id="_att_frd_hot">
			<img src="<%=dPath%>/images/hot_concern.gif" width="71" height="17" onclick="attention(#uid#);">
		</p>
		<p class="button" id="_atted_frd_hot" style="color:#ADABAB;display:none;">
			已关注
		</p>
	</div>
	<div class="hot_people_con">
		<p class="address">
			&nbsp;#place#
		</p>
		<p class="school">
			&nbsp;#school#
		</p>
		<p class="dsiscipline">
			&nbsp;#speciality#
		</p>
	</div>
	<div class="hot_people_dw">
		<div class="block1">
			<div class="yw">
				<a href="<%=dPath%>/friends/otherfollow.shtml?uid=#uid#" target="_blank" class="ble">#num1#</a>
			</div>
			<div class="zw">
				关注
			</div>
		</div>
		<div class="line"></div>
		<div class="block1">
			<div class="yw">
				<a href="<%=dPath%>/friends/otherfans.shtml?uid=#uid#" target="_blank" class="ble">#num2#</a>
			</div>
			<div class="zw">
				粉丝
			</div>
		</div>
		<div class="line"></div>
		<div class="block1">
			<div class="yw">
				<a href="<%=dPath%>/profile/user.shtml?uid=#uid#" target="_blank" class="ble">#num3#</a>
			</div>
			<div class="zw">
				动态
			</div>
		</div>
	</div>

	<div class="hot_people_dws"></div>
</div>
<div class="clear"></div>
<script type="text/javascript">
var hotIds = new Array(#hids#);

$(document).ready(function() {
    $.post(basePath + "/AjaxServlet", {"action":"getrelationflag","otherUserId":#uid#},function(data) {
    	if(data != "0" && data != "5"){
    	   $("#_att_frd_hot").hide();
    	   $("#_atted_frd_hot").show();
    	}
	});
});

function setFlag(flag){
    	
}

function getNextHotUser(next){
  var otherUserId = hotIds[next];
  var url = basePath + "/html/hot_user" + next + ".jsp";
  $.post(url, {"otherUserId":otherUserId,"hid":next},
     function(data) {    	
        $("#_hotUserShow").html(data);
     });
}
</script>