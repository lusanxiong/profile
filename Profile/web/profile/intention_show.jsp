<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
$(function(){
	$("#intentionEditBtn").click(function(){
		$("#intentionContainer").load(basePath+"/profile/intentionEdit.shtml");
	});
});
</script>
 <div class="resume_left">
 <table width="100%" border="0" cellspacing="1" cellpadding="0">
  <tr>
    <th width="81"  align="right" nowrap="nowrap"> 发展方向： </th>
    <td width="516" align="left" valign="middle" style="padding:5px;" colspan="3">&nbsp;${intention.myResume.careerDirection} </td>
  </tr>
  <tr>
    <th width="81"  align="right" nowrap="nowrap"> 岗位类别： </th>
    <td valign="middle" align="left" colspan="3" >&nbsp;${intention.calling1} ${intention.calling2} ${intention.calling3} </td>
  </tr>
  <tr>
    <th width="81"  align="right" valign="middle" nowrap="nowrap"> 意向职位： </th>
    <td align="left" valign="middle">${intention.post}</td>
    <th width="81"  align="right" valign="middle" nowrap="nowrap"> 工作地点： </th>
    <td align="left" valign="middle">${intention.jobLocation1} ${intention.jobLocation2} ${intention.jobLocation3}</td>
  </tr>
  <tr>
    <th width="81"  align="right" valign="middle" nowrap="nowrap"> 工资待遇： </th>
    <td align="left" valign="middle">${intention.salary} ${intention.myResume.houseNeeded?"要求提供住房":""}</td>
    <th width="81"  align="right" valign="middle" nowrap="nowrap"> 到岗时间： </th>
    <td align="left" valign="middle">${intention.toPost} </td>
  </tr>
  <tr>
    <th width="81"  align="right" valign="middle" nowrap="nowrap"> 其他要求： </th>
    <td align="left" valign="middle" colspan="3"><span
															style="width: 495px; margin:0 5px; float: left; display: inline;">${intention.myResume.otherRequirement}</span></td>
  </tr>
</table></div>
                                <div class="resume_right"><a href="javascript:void(0);" id="intentionEditBtn" class="new_FB_a_1"><img src="../images/resume/btn_modify.gif" /></a></div>
                        