<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
  <div class="personal">
    <div class="personal_top"><img src="${basePath}/images/personal_top.gif" width="205" height="10" /></div>
    <div class="personal_cer">
    <div class="personal_up">
      <div class="personal_up_left"><a href="${basePath}/profile/index.shtml">
      <c:if test="${fn:indexOf(loginResume.imgHead, 'http://') > -1}">
       <img src="${loginResume.imgHead}" width="80" height="80" />
       </c:if>
        <c:if test="${fn:indexOf(loginResume.imgHead, 'http://') == -1}">
       <img src="${basePath}${loginResume.imgHead}" width="80" height="80" />
       </c:if>
      </a>
      </div>
      <div class="personal_up_right">
        <div class="personal_name"><a href="${basePath}/profile/user.shtml?uid=${loginResume.myResume.myUserId}"><c:if test="${loginResume.myResume.perName==''}">我</c:if> ${loginResume.myResume.perName}</a></div>
        <div class="personal_area">${loginResume.provinceLocation}</div>
        <div class="personal_area">${loginResume.lastPostName}</div>
        <div class="personal_resume" id="jobState" >${loginResume.jobState}</div>
        <div class="personal_xg"><a href="javascript:showJobState(1);" class="sblue">[修改]</a></div>
      </div>
      </div>
      
      <div style=" position:relative;display:none;" id="divJobState">
      <div class="personal_qzzt" style="position: absolute; top:98px; left:-1px; _top:94px; _left:-201px;">
      <div class="personal_resume">求职状态&nbsp;&nbsp;  <a href="javascript:showJobState(0);" class="sblue">取消</a> </div>
      <div>
			<select name="jobState" class="personal_resumes" onchange="changeJobState(this);">
				<option value="0" 
				<c:if test="${loginResume.myResume.flother == '0'}">selected="selected"</c:if>
				>
					目前正在找工作
				</option>
				<option value="1" <c:if test="${loginResume.myResume.flother == '1'}">selected="selected"</c:if>>
					半年内无换工作的计划
				</option>
				<option value="2" <c:if test="${loginResume.myResume.flother == '2'}">selected="selected"</c:if>>
					一年内无换工作的计划
				</option>
				<option value="3" <c:if test="${loginResume.myResume.flother == '3'}">selected="selected"</c:if>>
					观望有好的工作在考虑
				</option>
				<option value="4">
					我暂时不想找工作
				</option>
			</select>
	  </div>
      </div>
      </div>
      
      
      <div class="personal_dw">
        <div class="personal_dw_left">
          <div class="personal_dw_yw">${userProfile.attentionNumber}</div>
          <div class="personal_dw_zw"><a href="${basePath}/friends/follow.shtml" class="blues">关注</a></div>
        </div>
        <div class="personal_dw_line"><img src="${basePath}/images/personal_line.gif" width="29" height="30" /></div>
        <div class="personal_dw_left">
          <div class="personal_dw_yw">${userProfile.fansNumber}</div>
          <div class="personal_dw_zw"><a href="${basePath}/friends/fans.shtml" class="blues">粉丝</a></div>
        </div>
        <div class="personal_dw_line"><img src="${basePath}/images/personal_line.gif" width="29" height="30" /></div>
        <div class="personal_dw_left">
          <div class="personal_dw_yw">${userProfile.weiboNumber}</div>
          <div class="personal_dw_zw"><a href="${basePath}/profile/user.shtml?uid=${loginResume.myResume.myUserId}" class="blues">动态</a></div>
        </div>
      </div>
    </div>
    <div class="personal_down"><img src="${basePath}/images/personal_dw.gif" width="205" height="10" /></div>
      
    </div>