<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${basePath}/js/baseInfo_edit.js"></script>
<script language="javascript" type="text/javascript" src="${basePath}/js/addressdialog.js"></script>
<script language="javascript" type="text/javascript" src="${basePath}/js/baseinfo.js"></script>
  <div class="resume_left">
    <form id="baseInfoForm" method="post">
	<input type="hidden" name="resId" value="${resume.myResume.resId}"/>
       <table  cellpadding="0" cellspacing="1" width="100%">
       
        <tr>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span>姓 名： </th>
          <td width="228"  align="left" valign="middle" nowrap="nowrap"><input name="perName" id="perName" type="text" value="${resume.myResume.perName}" class="resume_profile_wbk" style="width:110px;" /></td>
          <th  align="right" valign="middle" nowrap="nowrap"><span class="font_hilite">*</span>性 别： </th>
  <td width="228"  align="left" valign="middle"
													nowrap="nowrap"><label>
              <c:if test="${resume.myResume.sex != 2}">
                <span class="resume_radio"><input name="sex" type="radio" value="1" checked="checked"/></span>
                <span class="radio_name">男</span>
                 <span class="resume_radio"><input type="radio" name="sex" value="2" /></span>
                女 </c:if>
              <c:if test="${resume.myResume.sex == 2}">
                 <span class="resume_radio"><input name="sex" type="radio" value="1" /></span>
                男
                 <span class="resume_radio"><input type="radio" name="sex" value="2" checked="checked" /></span>
                女 </c:if>
            </label></td>
        </tr>
        <tr>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span>出生日期： </th>
          <td  align="left" valign="middle" nowrap="nowrap"><input type="text" size="7" class="resume_profile_wbk" name="birthday" id="birthday" value="${resume.birthDay}" onFocus="WdatePicker({isShowClear:false,readOnly:true})" style="width:110px;" />
            <span style="margin-left: 5px">
            <img src="${basePath}/images/date_book.gif" width="14" height="16" onclick="WdatePicker({el:'birthday'})"/> </span></td>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span>民 族： </th>
          <td  align="left" valign="middle"><label>
              <c:if test="${resume.myResume.nationality == '汉族' || resume.myResume.nationality == ''}">
               <span class="resume_radio"> <input name="nationality" type="radio" value="汉族" checked="checked" /></span>
                <span class="radio_name">汉族</span>
                <span class="resume_radio"><input name="nationality" id="cnNationality" type="radio"/></span>
                <input  name="cNationality" id="txtNationality" type="text"  class="resume_profile_wbk" style="width:50px;" />
              </c:if>
              <c:if test="${resume.myResume.nationality != '汉族' && resume.myResume.nationality != ''}">
               <span class="resume_radio"> <input name="nationality" type="radio" value="汉族" /></span>
                <span class="radio_name">汉族</span>
                <span class="resume_radio"><input name="nationality" id="cnNationality" type="radio"  value="${resume.myResume.nationality}"  checked="checked" /></span>
                <input name="cNationality" id="txtNationality" type="text"  class="resume_profile_wbk" style="width:50px;" value="${resume.myResume.nationality}"/>
              </c:if>
            </label>
            <span class="n_tishi">（如：回族）</span> </td>
        </tr>
        <tr>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span>身 高： </th>
          <td  align="left" valign="middle"><label>
              <input name="height" type="text"
															class="resume_profile_wbk" id="height" value="${resume.myResume.height}"
															size="2" style="width:110px;"  />
              厘米<span class="n_tishi">（如:170厘米）</span> </label></td>
          <th  align="right" valign="middle" nowrap="nowrap"> 婚姻状况： </th>
          <td  align="left" valign="middle"><select name="maritalStatus">
              <option  
                                                        
              <c:if test="${resume.myResume.maritalStatus ==0}">
                                                         selected="selected" </c:if>
              
                                                        value="0">
															未婚
														
              </option>
              <option
														  
              <c:if test="${resume.myResume.maritalStatus ==1}">
                                                        selected="selected" </c:if>
              
														value="1">
															已婚
														
              </option>
              <option
														  
              <c:if test="${resume.myResume.maritalStatus ==2}">
                                                        selected="selected" </c:if>
              
														value="2">
															离异
														
              </option>
              <option
														  
              <c:if test="${resume.myResume.maritalStatus ==3}">
                                                        selected="selected" </c:if>
              
														value="3">
															保密
														
              </option>
            </select></td>
        </tr>
        <tr>
          <th  align="right" valign="middle"	nowrap="nowrap"> <span class="font_hilite">*</span>证件类型： </th>
          <td  align="left" valign="middle" nowrap="nowrap"><label>
              <select name="cardType" id="cardType">
					<option
					  <c:if test="${resume.myResume.cardType ==1}">
                                              selected="selected" 
                                              </c:if>
					value="1">
						身份证
					</option>
					<option
					 <c:if test="${resume.myResume.cardType ==2}">
                                              selected="selected" 
                                              </c:if>
					value="2">
						驾证
					</option>
					<option
					 <c:if test="${resume.myResume.cardType ==3}">
                                              selected="selected" 
                                              </c:if>
					value="3">
						军官证
					</option>
					<option
					  <c:if test="${resume.myResume.cardType ==4}">
                                              selected="selected" 
                                              </c:if>
					value="4">
						护照
					</option>
					<option
					  <c:if test="${resume.myResume.cardType ==5}">
                                              selected="selected" 
                                              </c:if>
					value="5">
						其他
					</option>
				</select>
            </label>
            </td>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span> 证件编号： </th>
          <td  align="left" valign="middle" nowrap="nowrap">
          <label>
              <input type="text" name="idcardNum" id="idcardNum" maxlength="20" class="resume_profile_wbk" style="width:110px;" value="${resume.myResume.idcardNum}"/>
            </label>
          </td>
        </tr>
        <tr>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span> 最高学历： </th>
          <td  align="left" valign="middle" nowrap="nowrap"><select name="degreeId" id="degreeId" style="width:67px;">
              <option
														
              <c:if test="${resume.myResume.degreeId ==10}">
                                                        selected="selected" </c:if>
              
														value="10">
															初中
														
              </option>
              <option
														 
              <c:if test="${resume.myResume.degreeId ==20}">
                                                        selected="selected" </c:if>
              
														value="20">
															高中
														
              </option>
              <option
														  
              <c:if test="${resume.myResume.degreeId ==25}">
                                                        selected="selected" </c:if>
              
														value="25">
															中技
														
              </option>
              <option
														 
              <c:if test="${resume.myResume.degreeId ==30}">
                                                        selected="selected" </c:if>
              
														value="30">
															中专
														
              </option>
              <option
														 
              <c:if test="${resume.myResume.degreeId ==40}">
                                                        selected="selected" </c:if>
              
														value="40">
															大专
														
              </option>
              <option
														  
              <c:if test="${resume.myResume.degreeId ==50}">
                                                        selected="selected" </c:if>
              
														value="50">
															本科
														
              </option>
              <option
														  
              <c:if test="${resume.myResume.degreeId ==55}">
                                                        selected="selected" </c:if>
              
														value="55">
															MBA
														
              </option>
              <option
														
														 
              <c:if test="${resume.myResume.degreeId ==60}">
                                                        selected="selected" </c:if>
              
														value="60">
															硕士
														
              </option>
              <option 
														  
              <c:if test="${resume.myResume.degreeId ==70}">
                                                        selected="selected" </c:if>
              
														value="70">
															博士
														
              </option>
              <option
														 
              <c:if test="${resume.myResume.degreeId ==90}">
                                                        selected="selected" </c:if>
              
														value="90">
															不限
														
              </option>
            </select></td>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span>户 籍： </th>
          <td  align="left" valign="middle" nowrap="nowrap"><input type="hidden" name="hometown" id="hometown" value="${resume.myResume.hometown}"/>
            <input type="button" class="resume_profile_select"	value="${resume.homeTown}" id="_hometown" /></td>
        </tr>
        
        <tr>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span>现工作地： </th>
          <td  align="left" valign="middle" nowrap="nowrap"><p>
              <input type="hidden" name="location" id="location" value="${resume.myResume.location}"/>
              <input type="button" class="resume_profile_select" value="${resume.location}" id="_location"/>
            </p></td>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span>求职状态： </th>
          <td  align="left" valign="middle" nowrap="nowrap">
          	<select name="flother" class="personal_resumes" onchange="changeJobState(this);">
				<option value="0" <c:if test="${resume.myResume.flother == '0'}">selected="selected"</c:if>>
					目前正在找工作
				</option>
				<option value="1" <c:if test="${resume.myResume.flother == '1'}">selected="selected"</c:if>>
					半年内无换工作的计划
				</option>
				<option value="2" <c:if test="${resume.myResume.flother == '2'}">selected="selected"</c:if>>
					一年内无换工作的计划
				</option>
				<option value="3" <c:if test="${resume.myResume.flother == '3'}">selected="selected"</c:if>>
					观望有好的工作在考虑
				</option>
				<option value="4" <c:if test="${resume.myResume.flother == '4'}">selected="selected"</c:if>>
					我暂时不想找工作
				</option>
			</select>
          </td>
        </tr>
        
        
        
        <tr>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span>联系电话： </th>
          <td colspan="3"  align="left" valign="middle" nowrap="nowrap"><span class="n_tishi">（手机号码或家庭电话请至少填写一项）</span></td>
        </tr>
        <tr>
          <th  align="right" valign="middle" nowrap="nowrap">手机号码： </th>
          <td  align="left" valign="middle" nowrap="nowrap"><input type="text" name="mobileNum" id="mobileNum"
														class="resume_profile_wbk" style="width:110px;"  value="${resume.myResume.mobileNum}"/></td>
          <th  align="right" valign="middle" nowrap="nowrap"> 家庭电话： </th>
          <td  align="left" valign="middle" nowrap="nowrap"><input type="text" name="relationPhone" id="relationPhone"
														class="resume_profile_wbk" style="width:110px;"  value="${resume.myResume.relationPhone}"/></td>
        </tr>
        <tr>
          <th  align="right" valign="middle" nowrap="nowrap"> 个人主页： </th>
          <td  align="left" valign="middle"><label>
              <input type="text" name="homepage" id="homepage"
															class="resume_profile_wbk" style="width:110px;"  value="${resume.myResume.homepage}"/>
            </label></td>
          <th  align="right" valign="middle" nowrap="nowrap"> <span class="font_hilite">*</span>电子邮箱： </th>
          <td  align="left" valign="middle"><input type="text" name="email" id="email"
														class="resume_profile_wbk" style="width:110px;"  value="${resume.myResume.email}"/></td>
        </tr>
        <tr>
           <th  align="right" valign="middle" nowrap="nowrap"> QQ/MSN： </th>
          <td  align="left" valign="middle"><input type="text" name="imnum" id="imnum"
														class="resume_profile_wbk" style="width:110px;"  value="${resume.myResume.imnum}"/></td>
          <th  align="right" valign="middle" nowrap="nowrap"> 邮 编： </th>
          <td  align="left" valign="middle"><input type="text" name="zipCode" id="zipCode"
														class="resume_profile_wbk" style="width:110px;"  value="${resume.myResume.zipCode}"/></td>
        </tr>
        <tr>
          <th  align="right" valign="middle" nowrap="nowrap"> 通讯地址： </th>
          <td colspan="3"  align="left" valign="middle">
          	<input name="address" type="text" size="30" class="resume_profile_wbk" style=" width:434px;" value="${resume.myResume.address}"/>
          </td>
        </tr>
        <tr>
          <th  align="right" valign="middle" nowrap="nowrap"> <p> 自我评价： </p>
          </th>
          <td colspan="3" align="left" valign="middle"><label>
              <textarea id="selfDescription" name="selfDescription" rows="4" class="resume_profile_textarea" style=" width:437px;">${resume.myResume.selfDescription}
            </textarea>
            </label></td>
        </tr>
        <tr>
          <th height="0" align="right" valign="middle"
													nowrap="nowrap"> <p> 关 键 词： </p>
          </th>
          <td height="0" colspan="3" align="left" valign="middle"><input type="text" id="selfKeyWord" name="selfKeyWord" rows="1" class="resume_profile_wbk" value="${resume.myResume.selfKeyWord}" style=" width:434px;">
            <br />
            <span class="n_tishi">请输入代表你个人的关键字，限10个,用空格隔开。如行业、业绩、特长等，<br/>每词不超过6个汉字（12个英文字母）。</span> </td>
        </tr>
    </table>
    </form>
                              </div>
                                <div class="resume_right"><a href="javascript:void(0);" id="baseInfoSave" class="new_FB_a_1"><img src="../images/resume/btn_save.gif" /></a><a href="javascript:void(0);" id="baseInfoBack" class="new_FB_a_1"><img src="../images/resume/btn_reback.gif" /></a> </div>                          
 