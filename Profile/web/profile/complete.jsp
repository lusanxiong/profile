<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>保存成功</title>
	    <%@include file="/common/taglib.jsp"%>
		<%@include file="/common/meta.jsp"%>
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/resume.css" rel="stylesheet" type="text/css"/>
	</head>

	<body style="font-family:Arial,Helvetica,sans-serif,'微软雅黑', '宋体'; font-size:12px;">
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->
        <!--主体S-->
<!--简历保存S-->
<div id="resumesave">
 	<div class="resumesave_top_lebg"></div>
    <div class="resumesave_top_middle"></div>
    <div class="resumesave_top_ribg"></div>
    <div class="resumesave_cont">
     	<div class="resumesave_contcc"> 
        <span class="resumesave_title">
                   <ul>
                    <li><img src="../images/resume/save.jpg" alt="" /></li>
                    <li class="sec"><img src="../images/resume/gongxi.jpg" alt="" /></li>
                    <li class="yulan"><a href="#" target="_black"><img src="../images/resume/yulan.jpg" alt="" border="0" /></a></li>
                    <li class="tishid"><img src="../images/resume/tishid.jpg" alt="" /> </li>
                    </ul>  
                    <h3>接下来你可以：</h3>      
        </span>
       <span class="resumesave_tup">
                   <ul>
                    <li class="wans"><a href="/personal/center/resume_cn/resume_cn.jsp">完善简历 </a><span>>></span> </li>  
                    <li class="work"><a href="/personal/center/util/search/my_jobsearch.jsp">找工作</a> <span>>></span></li>  
                    <li class="search"><a href="/personal/center/util/search/my_searcherlist.jsp">搜索器</a> <span>>></span></li>             
                   </ul>
       </span>                                               
</div>

    </div>   
    <div class="resumesave_bottom_lebg"></div>
    <div class="resumesave_bottom_middle"></div>
    <div class="resumesave_bottom_ribg"></div>
</div>
<!--E-->
<div id="job_jian">
 	<div class="job_jian_top_lebg"></div>
    <div class="job_jian_top_middle"></div>
    <div class="job_jian_top_ribg"></div>
    <div class="job_jian_cont">
    <span class="job_title"><img src="../images/resume/job_jian.jpg" alt="" /></span>
    <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr >
	    <td class="tdtitle">职位名称</td>
	    <td class="tdtitle">公司名称</td>
	    <td class="tdtitle">工作地点</td>
	  </tr>
	  <c:forEach items="${positionPager.list}" var="position" varStatus="con">
	    <tr>
		    <td><a class="job_focuse" href="${job528Domain}/resume/util/p${position.memSearchBean.posID}.html">${position.memSearchBean.posName}</a></td>
		    <td><a class="job_focuse" target="_blank" href="#">${position.memSearchBean.memName}</a></td>
		    <td>${position.location}</td>
	  	</tr>
	  </c:forEach>
	 <!--  <tr>
	  <td colspan="3" align="right">
	  	<span><a href="#">首页</a></span>
	   	<span><a href="#">上页</a></span>
	   	<span><a href="#">下页</a></span>
	   	<span><a href="#">末页</a></span>
	   	<span>第2页</span>
		<span>去第<input type="text" style="width:30px" name="gotoPage" id="gotoPage"/>页&nbsp;<input type="button" value="GO" onclick="go();"/></span>
	  </td></tr>   -->
	</table>
    </div>
    <div class="job_jian_bottom_lebg"></div>
    <div class="job_jian_bottom_middle"></div>
    <div class="job_jian_bottom_ribg"></div>
</div>
<br/>
<!--简历保存E-->
<!--主体E-->
        <div class="clear"></div>
       	<!--版权 S-->
		<%@include file="/common/footer.jsp"%>
		<!--版权 E-->
	</body>
</html>