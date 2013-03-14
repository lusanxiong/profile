<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <%@include file="/common/taglib.jsp"%> 
	<%@include file="/common/meta.jsp"%>
<script type="text/javascript" src="${basePath}/js/jquery-1.7.2.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="" name="recommendPositionForm" id="recommendPositionForm">
	<input type="text" name="recommendUserId" value="25"/>
	<input type="text" name="recommendJobName" value="java软件工程师"/>
	<input type="text" name="positionId" value="123456"/>
	<input type="text" name="recommendUserName" value="卢三雄"/>
	<input type="text" name="recommendTargetUsersId" value="1;2;3;4;5"/>
</form>

<script type="text/javascript">
test();
function test() {
	alert(0);
	$.ajax({
		type : "POST",
		dataType : "json",
		url : basePath + "/friends/recommendPosition.shtml",
		data :  $("#recommendPositionForm").serialize(),
		success : function(msg) {
			 alert(1);
			 alert(msg);
			 try {
				 msg = eval("("+msg+")");
				}catch(e) {}
			 alert(msg);
			 var obj = msg.result;
			  
			 alert(obj);
			 alert(obj.flag);
	    }
		});
}
</script>
</body>
</html>