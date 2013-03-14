<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>个人简历</title>
	    <%@include file="/common/taglib.jsp"%>
		<%@include file="/common/meta.jsp"%>
		<script type="text/javascript" src="${basePath}/js/resume.js"></script>
		<script type="text/javascript" src="${basePath}/js/validator.js"></script>
		<script type="text/javascript" src="${basePath}/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${basePath}/js/address.js?t=<%=new Date().getTime()%>"></script>
		<script type="text/javascript" src="${basePath}/js/calling.js"></script>
		<script type="text/javascript" src="${basePath}/js/callingdialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/language.js"></script>
		<script type="text/javascript" src="${basePath}/js/experience.js"></script>
		<script type="text/javascript" src="${basePath}/js/photo.js"></script>
		<link href="${basePath}/css/inc.css" rel="stylesheet" type="text/css" />
		<link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
        <link href="../css/resume.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
        	$(function(){
            	var openImg = "../images/resume/btn_expand.gif";
            	var shrinkImg = "../images/resume/btn_away.gif";
				$("a[targetId]").click(function(){
					var img = $(this).find(":first-child");
					var targetId = $(this).attr("targetId");
					var targetObj = $("#"+targetId); 
					var display = targetObj.css("display");
					if(display=="none") {
						targetObj.css("display","block");
						img.attr("src",shrinkImg)
					}else {
						targetObj.css("display","none");
						img.attr("src",openImg)
					}
				});
            });
        </script>
	</head>

	<body style="font-family:Arial,Helvetica,sans-serif,'微软雅黑', '宋体'; font-size:12px;">
		<!--头部 S-->
		<%@include file="/common/header.jsp"%>
		<!--头部 E-->
        <!-- 简历中心 S -->
        <div class="resume">
        	<div class="resume_top">
            	<span class="rt_left"></span>
                <span class="rt_mid"></span>
                <span class="rt_right"></span>           
            </div>
            <div class="resume_con">
            <!-- 简历助手 S -->
            	<div class="helper_detail">
            	<div class="resume_helper">
                	<span class="rh_title">简历助手</span>
                    <p class="r_complete">简历完整度：</p>
                    <div class="r_percentage"><div class="an_percentage"><span class="yellow" style="width:${score}%"></span></div><span class="an_numeber">${score}%</span></div>                    
                      <ul class="rh_detail">
       					<li><a href="#baseInfo" class="fun_1">个人信息</a>${baseInfoFlag?"<span></span>":'' }</li>
       					<li><a href="#education" class="fun_2">教育经历</a>${educationFlag?"<span></span>":'' }</li>
       					<li><a href="#train" class="fun_5">培训经历</a>${trainingFlag?"<span></span>":'' }</li>
       					<li><a href="#language" class="fun_6">语言能力</a>${languageFlag?"<span></span>":'' }</li>
       					<li><a href="#work" class="fun_3">工作经验</a>${experienceFlag?"<span></span>":'' }</li>
       					<li><a href="#jobIntention" class="fun_4">求职意向</a>${intentionFlag?"<span></span>":'' }</li>
       					<li><a href="#addedInformation" class="fun_7">附加信息</a><span></span></li>
        			</ul>  
                    <p class="resume_help_bot"><span class="resume_save"><label><input onclick="Resume.saveAll();" type="button" /></label></span><a href="http://www.528.cn/personal/center/util/my_previewresume.do" target="_blank" class="n_previewResume">[预览] </a></p>    
                    <p id="savingBox" style="display: none" class="resume_saving">保存中...</p>                             
                </div>
     			 <p class="resume_clew_txt"> 个人信息，教育经历，工作经验，求职意向四项填写完整，简历即基本完整，才可用于投递。建议优先完善这些内容。 </p>
               </div>
            <!-- 简历助手 E -->
            <!-- 简历内容 S -->
            	<div class="resume_detail">
                	<span class="resume_chinese">
      					<h1>我的中文简历</h1>
      					<div id="settingContainer">
						<%@include file="setting_show.jsp"%>
						</div>
    				</span>
                    <div class="edit_title">
    				<div id="settingEditContainer" style="display:none;" class="edit_top">
   					</div>
                    </div>
                    <div class="resume_box">
                    <!-- 个人信息 S -->
                     <dl>
      					<dt>
        					<span class="item_name">个人信息</span>
         					<p class="advert"> 注意： <span class="font_hilite">*</span> 表示必填信息 </p>
        					<span class="dt_left"><a name="baseInfo" id="baseInfo"></a></span>
        					<p class="resume_fun_box" style="display:none"> <a href="javascript:void(0);"><img src="../images/resume/btn_expand.gif" /></a> </p>
        					<p class="resume_fun_box"> 
	        					<a href="javascript:void(0);" targetId="baseInfoBox">
	        						<img src="../images/resume/btn_away.gif" />
	        					</a>
        					</p>
                          </dt>
      					<dd id="baseInfoBox">
                        	<div class="info_table" id="baseInfoContainer">
                        	<%@include file="baseInfo_show.jsp"%>
                        	</div>                   
                        </dd>
      				</dl>
                    <!-- 个人信息 E -->
                    <!-- 教育经历  S -->
                    <dl>
      					<dt>
        					<span class="item_name">教育经历</span>
        <span class="dt_left"><a name="education" id="education"></a></span>
        <p class="resume_fun_box" style="display:none"> <a href="javascript:void(0);"><img src="../images/resume/btn_expand.gif" /></a> </p>
        <p class="resume_fun_box"> <a href="javascript:void(0);" targetId="educationBox"><img src="../images/resume/btn_away.gif" /></a> </p>
                          </dt>
      					<dd id="educationBox">
                        	<div class="info_table" id="educationContainer">
                        		<%@include file="education_show.jsp"%>
                        	</div> 
                        	<div class="info_table" id="educationEditContainer" style="display: none"></div>                        
                        </dd>
      				</dl>
                    <!-- 教育经历 E -->
                     <!-- 培训经历  S -->
                    <dl>
      					<dt>
        					<span class="item_name">培训经历</span>
        <span class="dt_left"><a name="train" id="train"></a></span>
        <p class="resume_fun_box" style="display:none"> <a href="javascript:void(0);"><img src="../images/resume/btn_expand.gif" /></a> </p>
        <p class="resume_fun_box"> <a href="javascript:void(0);" targetId="trainingBox"><img src="../images/resume/btn_away.gif" /></a> </p>
                          </dt>
      					<dd id="trainingBox">
                        	<div class="info_table" id="trainingContainer">
                        	<%@include file="training_show.jsp"%>
                        	</div> 
                        	<div class="info_table" id="trainingEditContainer" style="display: none">
                        	</div>                         
                        </dd>
      				</dl>
                    <!-- 培训经历 E -->
                    <!-- 语言能力 S -->
                     <dl>
      					<dt>
        					<span class="item_name">语言能力</span>
        <span class="dt_left"><a name="language" id="language"></a></span>
        <p class="resume_fun_box" style="display:none"> <a href="javascript:void(0);"><img src="../images/resume/btn_expand.gif" /></a> </p>
        <p class="resume_fun_box"> <a href="javascript:void(0);" targetId="languageBox"><img src="../images/resume/btn_away.gif" /></a> </p>
                          </dt>
      					<dd id="languageBox">
      						<div id="languageContainer">
                        		<%@include file="language_container.jsp"%>
                        	</div>
                        	<div class="info_table" id="languageAddContainer">
                        	</div>
                              <!-- 英语日语等级 S -->
                              <div class="info_table" id="lanuageToeflContainer">
                              <%@include file="language_toefl_show.jsp" %>
                              </div>
                              <!-- 英语日语等级 E -->                                      
                        </dd>
      				</dl>
                    <!-- 语言能力 E -->
                    <!-- 工作经验 S -->
                    <dl>
      					<dt>
        					<span class="item_name">工作经验</span>
        <span class="dt_left"><a name="work" id="work"></a></span>
        <p class="resume_fun_box" style="display:none"> <a href="javascript:void(0);"><img src="../images/resume/btn_expand.gif" /></a> </p>
        <p class="resume_fun_box"> <a href="javascript:void(0);" targetId="experienceBox"><img src="../images/resume/btn_away.gif" /></a> </p>
                          </dt>
      					<dd id="experienceBox">
                        <div class="info_table work_table" id="workContainer"> 
                           <%@ include file="work_show.jsp"%>	
        				</div>
        				<div class="info_table" id="experienceContainer">
        					<%@ include file="experience_container.jsp"%>
                        </div>
                           <!-- 工作经验点修改 S -->
                         
                           <!-- 工作经验点修改 E -->
                           	<p class="add_info"><input type="button" onclick="Experience.add();" value="增加信息" class="resume_addInfo"/>
                              </p>
                            <div class="info_table" id="experienceAddContainer"></div>
                        </dd>
                       </dl>
                    <!-- 工作经验 E -->
                     <!-- 求职意向 S -->
            	 <dl>
      					<dt>
        					<span class="item_name">求职意向</span>
        <span class="dt_left"><a name="jobIntention" id="jobIntention"></a></span>
        <p class="resume_fun_box" style="display:none"> <a href="javascript:void(0);"><img src="../images/resume/btn_expand.gif" /></a> </p>
        <p class="resume_fun_box"> <a href="javascript:void(0);" targetId="intentionBox"><img src="../images/resume/btn_away.gif" /></a> </p>
                          </dt>
      					<dd id="intentionBox">
                        	<div class="info_table" id="intentionContainer">
                        	<%@include file="intention_show.jsp"%>
                        	</div>
                          </dd>
                          </dl>
            <!-- 求职意向 E -->
            <!-- 附加信息 S -->
            <dl>
      					<dt>
        					<span class="item_name">附加信息</span>
        <span class="dt_left"><a name="addedInformation" id="addedInformation"></a></span>
        <p class="resume_fun_box" style="display:none"> <a href="javascript:void(0);"><img src="../images/resume/btn_expand.gif" /></a> </p>
        <p class="resume_fun_box"> <a href="javascript:void(0);" targetId="additionalBox"><img src="../images/resume/btn_away.gif" /></a> </p>
                          </dt>
      					<dd id="additionalBox">
                    <!-- 相关技能 S -->
                        	<div class="info_table" id="additionalContainer">
                        	<%@include file="additional_show.jsp"%>
                        	</div>
                     <!-- 相关技能 E -->
                     <!-- 计算机能力 S -->
                    		<span class="item_name_2"><h1>IT技能</h1></span>
                        	<div class="info_table info_table_it" id="itSkillContainer">
                        	<%@include file="itSkill_show.jsp"%>
                        	</div>
                     <!-- 计算机能力 E -->
                        </dd>
             </dl>
            <!-- 附加信息 E -->
                    </div>
                </div>
            <!-- 简历内容 E -->
            </div>
            <div class="resume_bot">
            	<span class="rb_left"></span>
                <span class="rb_mid"></span>
                <span class="rb_right"></span>               
            </div>
        </div>
        <%@include file="/common/address_dialog.jsp"%>
        <%@include file="/common/calling_dialog.jsp"%>
        <!-- 简历中心 E -->
	</body>
</html>