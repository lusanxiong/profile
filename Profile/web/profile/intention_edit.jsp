<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${basePath}/js/intention_edit.js"></script>
<script type="text/javascript" src="${basePath}/js/addressdialog.js"></script>
<script type="text/javascript" src="${basePath}/js/intentions.js"></script>
<div class="resume_left">
     <form method="post" id="intentionForm">
     <table width="100%" border="0" cellspacing="1" cellpadding="0">
        <tr>
          <th width="83"  align="right" nowrap="nowrap"><span class="font_hilite">*</span>岗位类别： </th>
          <td  align="center" ><input type="hidden" name="resId" value="${intention.myResume.resId}"/>
            <input type="hidden" id="jobFunction1" name="jobFunction1" value="${intention.myResume.jobFunction1}" jname="${intention.calling1}"/>
            <input type="hidden" id="jobFunction2" name="jobFunction2" value="${intention.myResume.jobFunction2}" jname="${intention.calling2}"/>
            <input type="hidden" id="jobFunction3" name="jobFunction3" value="${intention.myResume.jobFunction3}" jname="${intention.calling3}"/>
            <span id="spCalling" style="background: url(${basePath}/images/resume_profile_select.gif); width:145px; height: 22px; line-height: 22px; text-align: left; padding-left: 6px; padding-right: 27px; overflow: hidden; float: left; margin-left: 5px;cursor: pointer">${intention.calling1} ${intention.calling2} ${intention.calling3}</span></td>
        </tr>
        <tr>
          <th width="83"  align="right" nowrap="nowrap"><span class="font_hilite">*</span>意向职位： </th>
          <td  ><span
																		style="float: left; margin-left: 5px; display: inline">
            <input
																			name="jobSeeking1" id="jobSeeking1" type="text" size="20"
																			class="resume_profile_wbk" style="width:152px;" value="${intention.myResume.jobSeeking1}"/>
            </span> <span
																		style="float: left; margin-left: 5px; display: inline">
            <input
																			name="jobSeeking2" id="jobSeeking2" type="text" size="20"
																			class="resume_profile_wbk" style="width:152px;"  value="${intention.myResume.jobSeeking2}"/>
            </span> <span
																		style="float: left; margin-left: 5px; display: inline">
            <input
																			name="jobSeeking3" id="jobSeeking3" type="text" size="20"
																			class="resume_profile_wbk" style="width:152px;" value="${intention.myResume.jobSeeking3}"/>
            </span></td>
        </tr>
        <tr>
          <th width="83" height="29" align="right" nowrap="nowrap"><span class="font_hilite">*</span>工作地点： </th>
          <td  align="center" ><input type="hidden" id="jobLocation1" name="jobLocation1" value="${intention.myResume.jobLocation1}" lname="${intention.jobLocation1}"/>
            <input type="hidden" id="jobLocation2" name="jobLocation2" value="${intention.myResume.jobLocation2}" lname="${intention.jobLocation2}"/>
            <input type="hidden" id="jobLocation3" name="jobLocation3" value="${intention.myResume.jobLocation3}" lname="${intention.jobLocation3}"/>
            <span
																		style="background: url(${basePath}/images/resume_profile_select.gif); width: 145px; height: 22px; line-height: 22px; text-align: left; padding-left: 6px; padding-right: 27px; overflow: hidden; float: left; margin-left: 5px; display: inline; cursor: pointer"  id="spLocation" >${intention.jobLocation1} ${intention.jobLocation2} ${intention.jobLocation3}</span></td>
        </tr>
        <tr>
          <th width="83"  align="right" nowrap="nowrap"><span class="font_hilite">*</span>工资待遇： </th>
          <td  align="center" ><input type="hidden" id="salary" value="${intention.myResume.salary}"/>
            <span
																		style="float: left; margin-left: 5px; display: inline">
            <select name="salary" id="selSalary">
              <option value="0"> 面议 </option>
              <option value="1"> 1500以下 </option>
              <option value="2"> 2000-2999 </option>
              <option value="3"> 3000-4499 </option>
              <option value="4"> 4500-5999 </option>
              <option value="5"> 6000-7999 </option>
              <option value="6"> 8000-9999 </option>
              <option value="7"> 10000-14999 </option>
              <option value="8"> 15000-19999 </option>
              <option value="9"> 20000-29999 </option>
              <option value="10"> 30000-49999 </option>
              <option value="11"> 50000及以上 </option>
            </select>
            </span> <span
																		style="float: left; margin-left: 5px; margin-top:4px;">
            <c:if test="${intention.myResume.houseNeeded == false}">
              <input name="houseNeeded" type="checkbox"/>
            </c:if>
            <c:if test="${intention.myResume.houseNeeded == true}">
              <input name="houseNeeded" type="checkbox" checked="checked"/>
            </c:if>
            </span> <span style="float: left; margin-left: 5px; line-height: 20px;"> 要求提供住房 </span></td>
        </tr>
        <tr>
          <th width="83"  align="right" nowrap="nowrap" ><span class="font_hilite">*</span>到岗时间： </th>
          <td  align="center" ><span style="float: left; margin-left: 5px;margin-top:4px;"> <input name="checkinDate" type="radio"
																	    
            <c:if test="${postType == 0}"> checked="checked" </c:if>
            value="随时到岗"/> </span> <span style="float: left; margin-left: 5px; line-height: 20px; ">随时到岗</span> <span style="float: left; margin-left: 5px; margin-top:5px;"> <input name="checkinDate" id="checkinDateD"
																	     
            <c:if test="${postType == 1}"> checked="checked" </c:if>
            type="radio"/> </span> <span style="float: left; margin-left: 5px;"> <input type="text" class="resume_profile_wbk" size="7" 
																	 
            <c:if test="${postType == 1}"> value="${intention.myResume.checkinDate}" </c:if>
            onFocus="WdatePicker({onpicked:pickedFunc});" id="dgDate" name="dgDate"/> </span> <span style="margin-left: 5px; float: left;cursor: pointer"> <img src="${basePath}/images/date_book.gif" width="14" height="16" onclick="WdatePicker({el:'dgDate',onpicked:pickedFunc})"/> </span> <span
																		style="margin-left: 5px; float: left; line-height: 20px;">以后</span> <span style="float: left; margin-left: 5px; margin-top:5px;"> <input name="checkinDate" id="checkinDateY" 
																	   
            <c:if test="${postType == 2}"> checked="checked" </c:if>
            type="radio" value="半"/> </span> <span style="float: left; margin-left: 5px;">
            <select name="checkinDateScale" id="checkinDateScale" onchange="checkinDateScaleChange(this.value);">
              <option value="半">半</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option value="8">8</option>
              <option value="9">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
            </select>
            </span> <span
																		style="margin-left: 5px; float: left; line-height: 20px;">个月以内</span>
            <script>
																		function pickedFunc(){
																		    $dp.$('checkinDateD').value=$dp.cal.getDateStr();
																		
																		}
																		function checkinDateScaleChange(v){
																		    $("#checkinDateY").val(v);   
																		}
																	</script></td>
        </tr>
        <tr>
          <th width="83"  align="right" nowrap="nowrap"> 发展方向： </th>
          <td  ><p
																		style="width: 490px; float: left; margin: 5px; display: inline">
              <textarea cols="58" name="careerDirection" rows="5" class="resume_profile_tblocks">${intention.myResume.careerDirection}</textarea>
            </p>
            <p
																		style="width: 480px; line-height: 18px; float: left; margin-left: 13px; display: inline; text-align:left; color:#8b8a8a;"> 限500个中文字，输入您对自己的简短评价。请简明扼要的说明您最大的优势是什么？<br/>避免使 用一些空洞老套的话。 </p></td>
        </tr>
        <tr>
          <th width="83"  align="right" nowrap="nowrap"> 其他要求： </th>
          <td  ><p
																		style="width: 490px; float: left; margin:0 0 0 5px; display: inline">
              <textarea cols="58" name="otherRequirement" rows="5" class="resume_profile_tblocks">${intention.myResume.otherRequirement}</textarea>
            </p></td>
        </tr>
      </table>
      </form>
      </div>
<div class="resume_right"><a href="javascript:void(0);" id="intentionSave" class="new_FB_a_1"><img src="../images/resume/btn_save.gif" /></a><a href="javascript:void(0);" id="intentionBack" class="new_FB_a_1"><img src="../images/resume/btn_reback.gif" /></a></div>
