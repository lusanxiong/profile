<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp"%>
<%menu = "friend";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>标签管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<link href="${basePath}/css/css.css" rel="stylesheet" type="text/css" />
        <link href="${basePath}/css/hqerve.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${basePath}/js/jquery.js"></script>	
		<script type="text/javascript" src="${basePath}/js/my.jquery.js"></script>
		<script type="text/javascript" src="${basePath}/js/jquery.blockUI.js"></script>
		<script type="text/javascript" src="${basePath}/js/dialog.js"></script>
		<script type="text/javascript" src="${basePath}/js/general.js"></script>
		<script type="text/javascript" src="${basePath}/admin/label/adminLabel.js"></script>
	 	
	</head>
	<body>
	       <div>
	        <span >
	                          标签名称：<input type="text" name="inputLabel" id="inputLabel" />&nbsp;&nbsp;&nbsp;
	                          标签来源: <select id="inputSource">
            	        <option value="0" >系统标签</option>
            	        <option value="1" >用户标签</option>      	   	
                      </select>&nbsp;&nbsp;&nbsp; 
                                   是否显示标签  : <select id="inputDisplay">
            	             <option value="0" >不显示</option>
            	             <option value="1" >显示</option>     	   	
                           </select>&nbsp;&nbsp;&nbsp; 
                                  标签排名：<input type="text" name="inputSort" id="inputSort" /><br />
                                  
              <label><input type="button" name="addLabel" value="添加标签" onclick="addLabel();"/> </label>                  
	        </span> 
	      </div>
			<form action="adminLabel!getLabelInfo.shtml" method="post" name="thisForm">
            <div style="text-align:left;padding-top:10px;">标签来源分类:
            <select style="width:120px;" id="labelTypeSel" name="labelTypeSel" onchange="changeSelected();" >
            	<option value="2" >全部</option>
            	<option value="0" >系统标签</option>
            	<option value="1" >用户标签</option>            	
            	
            </select>&nbsp;&nbsp;
           <!--  <input type="button" value="查询" onclick="findLabel();" />--> 
            </div>
            <div style="margin-bottom:30px;"></div>
            <div style="margin-top:30px;">
            <table >
            <tr>
                <td><span ><label>
							<input name="chkall1" type="checkbox" id="checkAll" onclick="selectAll()"/>
						</label>
					</span>
				</td>
                <td>序号</td>
            	<td>标签名称</td>
            	<td>标签来源</td>
            	<td>是否显示</td>
            	<td>排序值</td>
            	<td>创建日期</td>
            	<td>操作</td>
            </tr>
            
            <c:forEach items="${labelList.list}" var="label" varStatus="i">
            	  <tr>
            	    <td>
            	         <span > 
            	               <label>
								  <input name="labelId" type="checkbox" id="kid" value="${label.id}"/>
								</label>
					      </span>
					</td>
            	    <td>${(labelList.pageNo-1)*10+i.count}</td>
            	  	<td><div  id="${label.id}_text_labelName">${label.labelName}</div> 
            	  		<div id="${label.id}_value_labelName" style="display:none" ><input type="text" style="border:1"  name="labelName"  id="${label.id}_labelName" value="${label.labelName}" /></div></td>
            	    <td> 
            	    <div id="${label.id}_text_labelSource">
            	    <c:if test="${label.labelSource==0}">系统</c:if>
            	    <c:if test="${label.labelSource==1}">用户</c:if>
            	    </div>
            	    <div id="${label.id}_value_labelSource" style="display:none">
            	     <select id="${label.id}_labelSource">
            	        <option value="0" >系统标签</option>
            	        <option value="1" >用户标签</option>      	   	
                      </select>
            	    </div>
            	    </td>
            	    
            	    <td> 
            	    <div id="${label.id}_text_isDisplay">
            	    <c:if test="${label.isDisplay==0}">不显示</c:if>
            	    <c:if test="${label.isDisplay==1}">显示</c:if>
            	    </div>
            	    <div id="${label.id}_value_isDisplay" style="display:none">
            	     <select id="${label.id}_isDisplay" >
            	        <option value="0" >不显示</option>
            	        <option value="1" >显示</option>     	   	
                      </select>
            	    </div>
            	    </td>
            	    
            	    
            	    <td><div id="${label.id}_text_labelSort">${label.labelSort}</div>
            	    	<div id="${label.id}_value_labelSort" style="display:none" >
            	    	<input type="text" style="border:1" name="labelSort" id="${label.id}_labelSort" value="${label.labelSort}"  />
            	    	</div>
            	    </td>
            	    <td>${label.createDate}</td>
            	    <td><!--  <a href="javascript:void(0);" onclick="delLabel(${label.id});">删除</a>-->
            	        <a href="javascript:void(0);" id="${label.id}_modifyBtn" onclick="modifyLabel('${label.id}','${label.labelSource}','${label.isDisplay}')">修改</a>
            	    </td>
            	  </tr>
            	  <input type="hidden" name="${label.id}_hidden" id="${label.id}_hidden" value="show" />
             </c:forEach> 
             <input type="hidden" id="currentPageLabelCount" name="currentPageLabelCount" value="${fn:length(labelList.list)} " /> 
             </table>
             </div>
     
            
		    <span class="rs_input"><a href="javascript:void(0);" onclick="delSelect()">删除所选中标签</a></span>
           
             <input type="hidden" name="page" id="page" value="${page}"/>
             <input type="hidden" name="labelType" id="labelType" value="${labelType}"/>
             <input  type="hidden"  name="pageNo" id="pageNo" value="${labelList.pageNo}"/>
             <input  type="hidden" name="pageSize" id="pageSize" value="${label.pageSize}"/>
             </form>
             <c:if test="${labelList.totalPages>1}">
                <div class="search_but" style="float:left;">
              
            <span class="left">
            <c:if test="${page<=1}"><img src="${basePath}/images/search_but_l.gif" width="28" height="21" /></c:if>
             <c:if test="${page>1}"><img src="${basePath}/images/search_but_lr.gif" width="28" height="21" onclick="goPage(${page-1})"/></c:if>
            </span>
            <span class="lefts" style=" display:none"><img src="${basePath}/images/search_but_lr.gif" width="28" height="21" /></span>
             ${labelList.pagerString}
            <c:if test="${labelList.pageNo>=labelList.totalPages}"><img src="${basePath}/images/search_but_rr.gif" width="28" height="21" /></c:if>
            <c:if test="${labelList.pageNo<labelList.totalPages}"><img src="${basePath}/images/search_but_r.gif" width="28" height="21" onclick="goPage(${page+1})"/></c:if>
            </div>
            </c:if>
			<div class="clear"></div>
	  <script type="text/javascript">
			selectedLabelSource();
			function selectedLabelSource() {
				var labelType='${labelType}';
				$("#labelTypeSel").val(labelType);
			}
	  </script>
	</body>
</html>
