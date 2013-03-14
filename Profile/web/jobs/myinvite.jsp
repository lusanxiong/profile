<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%menu = "job";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>来自企业的邀请</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
        <link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${basePath}/js/jquery.js"></script>
        
		<script type="text/javascript">
		function winopen(id){
		    window.open("${job528Domain}/personal/center/util/my_memreply.do?pubid="+id,"","width=500,height=300,top=95,left=3");
	    }
	    
	    function delApply(){

  var inIds = "";

  for(var i=0;i<document.thisForm.elements.length;i++){

    var e=document.thisForm.elements[i];

    if(e.name=='applyId'&&e.checked==true){

       if(inIds!="")

          inIds += ",";

       inIds += $(e).val();

    }

  }

  if(inIds==""){

     alert("请选择要删除的职位！");

  }else{

     $("#inIds").val(inIds);

     document.thisForm.action="myInvite.shtml";

	 document.thisForm.submit();

  }

}



function goPage(p){

  $("#page").val(p);

  document.thisForm.action="myInvite.shtml";

  document.thisForm.submit();

}


	    
	    
		</script>
	</head>
	<body>
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->
		<!--求职 S-->
<div class="job_box">
<%@include file="/common/left.jsp"%>
  <div class="job_left">
  <div class="basic">
  <div class="basic_l"><span>企业的邀请</span></div>
  </div>
  <form name="thisForm" method="post">
  <input type="hidden" id="inIds" name="inIds"/>
  <input type="hidden" id="page" name="page"/>
  <table width="769" border="0" cellpadding="0" cellspacing="1" bgcolor="#e0e8ec" style="font-size:12px; float:left">
  <tr style="background-color:#f3f7f9;">
    <td width="30" height="30" >&nbsp;</td>
    <td width="90" height="30" align="left"   class="jobs_me">邀请日期</td>
    <td width="155" height="30" align="left"  class="jobs_me">应聘岗位</td>
    <td width="180" height="30" align="left"  class="jobs_me">企业名称</td>
    <td width="65" height="30" align="center" class="jobs_me">工作地点</td>
    <td width="65" height="30" align="center" class="jobs_me">面试通知</td>
    <td width="65" height="30" align="center" class="jobs_me">面试回复</td>
  </tr>
   <c:forEach items="${appPage.list}" var="ApplyJob">
  <tr>
 
    <td height="30" align="center" valign="middle" bgcolor="#FFFFFF"><label>
      <input type="checkbox" name="applyId" id="applyId" value="${ApplyJob.applyId}" />
    </label></td>
    <td height="30" bgcolor="#FFFFFF" class="jobs_me">${ApplyJob.applyDate}</td>
    <td height="30" bgcolor="#FFFFFF" class="jobs_me"><a href="${job528Domain}/resume/util/p${ApplyJob.posId}.html" class="ls" target="_blank">${ApplyJob.posName}</a></td>
    <td height="30" bgcolor="#FFFFFF" class="jobs_me"><a href="${job528Domain}/resume/util/${ApplyJob.memId}.html" class="ls" target="_blank">${ApplyJob.memName}</a></td>
    <td height="30" align="center" bgcolor="#FFFFFF" class="jobs_me">${ApplyJob.jobLocation}</td>
    <td height="30" align="center" bgcolor="#FFFFFF" class="jobs_me">
    <c:if test="${ApplyJob.memMemo != null && ApplyJob.memMemo != ''}">
    <a href="javascript:javascript:winopen(${ApplyJob.applyId})" style="cursor:hand ">
    <img alt="查看面试通知" src="../images/mail4_ico.gif" border="0"></a>
    </c:if>
    
    </td>
    <td height="30" align="center" bgcolor="#FFFFFF" class="jobs_me">
    <a onClick="javascript:window.open('${job528Domain}/personal/center/util/my_invitenote.do?pubid=${ApplyJob.applyId}','','width=500,height=400,top=95,left=3')" style="cursor:hand "><img alt="面试回复" src='../images/mail4_ico.gif' border="0"></a>
    </td>
  </tr>
  </c:forEach>
 
 <c:if test="${appPage.totalPages<=0}">	
						<tr>
							<td colspan="7" style="background-color:#FFFFFF;height:30px;" >
								<div style="text-align: center"><font style="color:#999;font-size:14px;">你最近没有收到企业的邀请！</font></div>
							</td>
						</tr>
						</c:if>
  </table>
  </form>
  <c:if test="${appPage.totalPages>0}">
     <div class="jobs_an">
	 <span class="jobs_aniu" onclick="delApply();">删除职位</span>
	 </div>
	 </c:if>
      </div>
      

  
  <div class="clear"></div>
</div>
<!--求职 E-->

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
