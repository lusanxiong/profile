
//记录用户访问历史记录
function recordUserAccessHistory(uid) {
	if(uid == '') return;
	
	$.post(basePath+"/user/UserAccessHistory!recordUserAccessHistory.shtml",
		   {"uid":uid});
}

//查询用户访问历史记录
function getUserAccessHistoryInfo() {
	$.post(basePath+"/user/UserAccessHistory!getUserAccessHistoryInfo.shtml",function(data) {
		$("#userAccessHistoryInfoDiv").html(data);
	});
}