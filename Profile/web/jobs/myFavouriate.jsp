<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%menu = "job";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>我收藏的职位</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
        <link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="${basePath}/js/jquery.js"></script>
        <script type="text/javascript" >
        
         function sendApply(){

	if(!sel()){

		alert("请先选择要应聘的职位");

		return false;

	}

	document.thisForm.action="http://www.528.cn/personal/center/util/my_apply_online.do";

	document.thisForm.target="_blank";

	document.thisForm.submit();

}



function sel(){

 for(var i=0;i<document.thisForm.elements.length;i++){

    var e=document.thisForm.elements[i];

    if(e.name=='posId'&&e.checked==true) return true;

  }

  return false;

}


function delFav(){

  var favIds = "";

  for(var i=0;i<document.thisForm.elements.length;i++){

    var e=document.thisForm.elements[i];

    if(e.name=="posId" && e.checked==true){

       if(favIds!="")

          favIds += ",";

       favIds += $(e).attr("favId");

    }

  }

  if(favIds==""){

     alert("请选择要删除的职位！");

  }else{

     $("#favIds").val(favIds);

     document.thisForm.action="myFavouriate.shtml";

	 document.thisForm.submit();

  }

}

function goPage(p){
  $("#page").val(p);
  document.thisForm.action="myFavouriate.shtml";
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
              <div class="basic_l"><span>搜藏的职位</span></div>
              </div>
    <form name="thisForm" method="post">
<input type="hidden" id="page" name="page"/>
<input type="hidden" id="favIds" name="favIds"/>
    
      <table width="769" border="0" cellpadding="0" cellspacing="1" bgcolor="#e0e8ec" style="font-size:12px; float:left">
  <tr style="background-color:#f3f7f9;">
    <td width="30" height="30" >&nbsp;</td>
    <td width="90" height="30" align="left" class="jobs_me">收藏日期</td>
    <td width="155" height="30" align="left"  class="jobs_me">应聘岗位</td>
    <td width="180" height="30" align="left"  class="jobs_me">企业名称</td>
    <td width="65" height="30" align="center" class="jobs_me">工作地点</td>
    <td width="65" height="30" align="center" class="jobs_me">工作年限</td>
    <td width="65" height="30" align="center" class="jobs_me">最低学位</td>
  </tr>
  <c:forEach items="${favPager.list}" var="favouriate">
  <tr>
    <td height="30" align="center" valign="middle" bgcolor="#FFFFFF"><label>
      <input name="posId" type="checkbox" name="checkbox" value="${favouriate.position.posId}" favId="${favouriate.myFavouriate.id}" />
    </label></td>
    <td height="30" bgcolor="#FFFFFF" class="jobs_me">${favouriate.favouriateDate}</td>
    <td height="30" bgcolor="#FFFFFF" class="jobs_me"><a href="${job528Domain}/resume/util/p${favouriate.position.posId}.html" class="ls" target="_blank">${favouriate.position.posName}</a></td>
    <td height="30" bgcolor="#FFFFFF" class="jobs_me"><a href="${job528Domain}/resume/util/${favouriate.memInfo.memId}.html" class="ls" target="_blank">${favouriate.memInfo.memName}</a></td>
    <td height="30" align="center" bgcolor="#FFFFFF" class="jobs_me">${favouriate.jobLocation}</td>
    <td height="30" align="center" bgcolor="#FFFFFF" class="jobs_me">${favouriate.workYear}</td>
    <td height="30" align="center" bgcolor="#FFFFFF" class="jobs_me">${favouriate.degree}</td>
  </tr>
  </c:forEach>
  <c:if test="${favPager.totalPages<=0}">	
						<tr>
							<td colspan="7" style="background-color:#FFFFFF;height:30px;" >
								<div style="text-align: center"><font style="color:#999;font-size:14px;">你最近没有收藏任何职位！</font></div>
							</td>
						</tr>
						</c:if>
  </table>
  </form>
     <div class="jobs_an">
     
     <c:if test="${favPager.totalPages > 1}">
     <c:if test="${page > 1}"><span class="jobs_aniu" onclick="goPage(${page-1});">上一页</span></c:if>
      <c:if test="${page <= 1}"><span class="jobs_aniu" style="cursor: text;" onclick="alert('已经是第一页了！');">上一页</span></c:if>
	 
	 <c:if test="${page < favPager.totalPages}">
	 <span class="jobs_aniu" onclick="goPage(${page+1});">下一页</span>
	 </c:if>
	 
	  <c:if test="${page >= favPager.totalPages}">
	 <span class="jobs_aniu" style="cursor: text;" onclick="alert('已经是最后一页了！');">下一页</span>
	 </c:if>
	 
	 </c:if>
     
      <c:if test="${favPager.totalPages>0}">	
	 <span class="jobs_aniu" onclick="delFav();">删除职位</span>
	 <span class="jobs_aniu" onclick="sendApply();">应聘职位</span>
	 </c:if>
	 </div>
      </div>

  
  <div class="clear"></div>
</div>
<!--求职 E-->

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
	</body>
</html>
