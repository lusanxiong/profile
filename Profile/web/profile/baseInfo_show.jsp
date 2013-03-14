<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
$(function(){
	$("#baseInfoEditBtn").click(function(){
		$("#baseInfoContainer").load(basePath+"/profile/baseInfoEdit.shtml");
	});
});
</script>
<div class="resume_left" style="width:570px;">
   	<table  cellpadding="0" cellspacing="1" width="100%">
    <tr>
      <th  align="right" valign="middle" nowrap="nowrap"> 姓名： </th>
      <td width="180"  align="left" valign="middle" nowrap="nowrap"> ${resume.myResume.perName}</td>
      <th  align="right" valign="middle" nowrap="nowrap"> 性 别： </th>
      <td width="180"  align="left" valign="middle" nowrap="nowrap">
      	${resume.myResume.sex==1?"男":"女"}
        </td>
    </tr>
    <tr>
       <th  align="right" valign="middle" nowrap="nowrap"> 出生日期： </th>
      <td  align="left" valign="middle" nowrap="nowrap"> ${resume.birthDay} </td>
      <th  align="right" valign="middle" nowrap="nowrap"> 民 族： </th>
      <td  align="left" valign="middle"> ${resume.myResume.nationality} </td>
    </tr>
    <tr>
      <th  align="right" valign="middle" nowrap="nowrap"> 身 高： </th>
      <td  align="left" valign="middle"> ${resume.myResume.height}&nbsp;厘米 </td>
      <th  align="right" valign="middle" nowrap="nowrap"> 婚姻状况： </th>
      <td  align="left" valign="middle"> ${resume.maritalStatus} </td>
    </tr>
    <tr>
      <th  align="right" valign="middle"
													nowrap="nowrap"> 证件类型： </th>
      <td  align="left" valign="middle" nowrap="nowrap">${resume.cardType}
      （证件号：${resume.myResume.idcardNum}）</td>
      <th  align="right" valign="middle" nowrap="nowrap"> 最高学历： </th>
      <td  align="left" valign="middle" nowrap="nowrap"> ${resume.myResume.degreeScript} </td>
    </tr>
    <tr>
      <th  align="right" valign="middle" nowrap="nowrap"> 户 籍： </th>
      <td  align="left" valign="middle" nowrap="nowrap"> ${resume.homeTown} </td>
      <th  align="right" valign="middle"
													nowrap="nowrap"> 现工作地： </th>
      <td  align="left" valign="middle" nowrap="nowrap"> ${resume.location} </td>
    </tr>
    <tr>
      <th  align="right" valign="middle" nowrap="nowrap"> 电子邮箱： </th>
      <td  align="left" valign="middle" nowrap="nowrap"><p> ${resume.myResume.email} </p></td>
      <th  align="right" valign="middle" nowrap="nowrap"> 求职状态： </th>
      <td  align="left" valign="middle" nowrap="nowrap"> ${resume.jobState} </td>
    </tr>
    <tr>
      <th  align="right" valign="middle" nowrap="nowrap"> 手机号码： </th>
      <td  align="left" valign="middle" nowrap="nowrap"> ${resume.myResume.mobileNum} </td>
      <th  align="right" valign="middle" nowrap="nowrap"> 家庭电话： </th>
      <td  align="left" valign="middle" nowrap="nowrap"> ${resume.myResume.relationPhone} </td>
    </tr>
    <tr>
      <th  align="right" valign="middle" nowrap="nowrap"> 个人主页： </th>
      <td  align="left" valign="middle"> ${resume.myResume.homepage} </td>
      <th  align="right" valign="middle" nowrap="nowrap"> QQ/MSN： </th>
      <td  align="left" valign="middle"> ${resume.myResume.imnum} </td>
    </tr>
    <tr>
      <th  align="right" valign="middle" nowrap="nowrap"> 通讯地址： </th>
      <td  align="left" colspan="3" valign="middle"> ${resume.myResume.address} </td>
    </tr>
    <tr>
      <th  align="right" valign="middle" nowrap="nowrap"> <p> 自我评价： </p>
      </th>
      <td  colspan="3" align="left" valign="middle"> ${resume.myResume.selfDescription} </td>
    </tr>
    <tr>
      <th  align="right" valign="middle"
													nowrap="nowrap"> <p> 关 键 词： </p>
      </th>
      <td  colspan="3" align="left" valign="middle"> ${resume.myResume.selfKeyWord}</td>
    </tr>
</table>
                                </div>
                                <div class="resume_right" style="width:150px;">
                                <span style="clear:both;padding:0px auto;">
                                <c:if test="${fn:indexOf(resume.myResume.photoName, 'http://') > -1}">
			                        <img id="resumePhoto" src="${resume.myResume.photoName}" width="120" height="120" />
			                    </c:if>
			                    <c:if test="${fn:indexOf(resume.myResume.photoName, 'http://') == -1}">
			                        <img id="resumePhoto" src="${basePath}${resume.myResume.photoName}" width="120" height="120" />
			                    </c:if>
                                
                <p class="photo_fun"> <a class="photo_but1" href="javascript:void(0);" onclick="Photo.edit();">编辑</a> 
                   <a class="photo_but2" id="photoShieldBtn" onclick="Photo.shield()" photoflag="${resume.myResume.photoflag==1?2:1}" href="javascript:void(0);">${resume.myResume.photoflag==1?"显示":"屏蔽"}</a> </p>                
                </span>
                <a href="javascript:void(0);" id="baseInfoEditBtn" class="new_FB_a_1" style="padding-left:50px; *padding-left:0px; margin-top:10px;"><img src="../images/resume/btn_modify.gif" /></a> </div>                          
                 