<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%
	menu = "job";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>个人搜索器</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css">
        <link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css">
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="${basePath}/js/jquery.js"></script>
		<script type="text/javascript">
	    <!--
	          var add = function(){
	            window.location.href = "editSearcher.shtml";
	          }
		 -->
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
              <div class="basic_l"><span>个人搜索器</span></div>
              <div class="basic_r" style="display:none"><span>English</span></div>
              </div>    
<table width="769" cellspacing="1" bgcolor="e9edf1" style="  font-size:12px;">
<tr>
<td width="250" height="28" align="center" bgcolor="#f3f7f9">搜索器名称</td>
<td width="150" height="28" align="center" bgcolor="#f3f7f9">职位订阅状态</td>
<td width="100" height="28" align="center" bgcolor="#f3f7f9">更新时间</td>
<td width="300" height="28" align="center" bgcolor="#f3f7f9">操作</td>
</tr>


<c:set value="0" var="sCount"></c:set>
<c:forEach items="${searchers}" var="searcher">
<c:set value="${sCount+1}" var="sCount"></c:set>
<tr>
<td width="400" height="28" align="center" bgcolor="#FFFFFF">
<a href="#" class="blues">${searcher.mySearcher.searcherName}</a></td>
<td width="150" height="28" align="center" bgcolor="#FFFFFF">
${searcher.orderSumary}
</td>
<td width="100" height="28" align="center" bgcolor="#FFFFFF">${searcher.upDateTime}</td>
<td width="150" height="28" align="center" bgcolor="#FFFFFF"><span><a href="${basePath}/jobs/?sid=${searcher.mySearcher.id}" class="blues">立即搜索</a></span>　　<span><a href="editSearcher.shtml?sid=${searcher.mySearcher.id}" class="blues">修改</a></span>　<span><a href="delSearcher.shtml?sid=${searcher.mySearcher.id}" class="blues">删除</a></span></td>
</tr>
</c:forEach>



</table>
<div class="clew_2_box">
<div class="clew_2">
您最多可建立
<span class="font_hilite">3</span>
个职位搜索器，您已建立
<span class="font_hilite">${sCount}</span>
个职位搜索器。
</div>
<c:if test="${sCount<3}">
<div><input type="button" value="添加个人搜索器" id="btnSearch" class="job_but" onclick="add()"/></div> 		
</c:if>						
</div>
			</div><div class="clear"></div>
			
			</div>
			
		</div>
		<!--求职 E-->

		<!-- S地区 -->
		<%@include file="/common/address_dialog.jsp"%>
		<%@include file="/common/calling_dialog.jsp"%>

		<!-- E地区 -->

		<!--版权 S-->
		<%@include file="/common/footer.jsp"%>



	</body>
</html>
