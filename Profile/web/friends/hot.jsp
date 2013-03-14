<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
                      <div class="hot_people_top">
                      		<div class="word">活跃人物</div>
                            <div class="button">
                            <span class="img1"><img src="${basePath}/images/hot_l.gif" width="18" height="16" /></span>
                            <span class="img2"><img src="${basePath}/images/hot_r.gif" width="19" height="16" /></span>
                            </div>
                      </div>
                      <div class="hot_people_cer">
                      <div class="left">
                      <c:if test="${fn:indexOf(hotUser.uhead, 'http://') > -1}">
                        <img src="${hotUser.uhead}" height="68" width="68"/>
                        </c:if>
                         <c:if test="${fn:indexOf(hotUser.uhead, 'http://') == -1}">
                        <img src="${basePath}/${hotUser.uhead}" height="68" width="68"/>
                        </c:if>
                      </div>
                      <div class="right">
                      <p class="name">${hotUser.userInfo.name}</p>
                      <p class="icon"><img src="${basePath}/images/hot_icon.gif" width="14" height="17" /></p>
                      <p class="button"><img src="${basePath}/images/hot_concern.gif" width="71" height="17" />				                      </p>
                      </div>
                      <div class="hot_people_con">
                      <p class="address">${hotUser.userInfo.place}</p>
                      <p class="school">${hotUser.school}</p>
                      <p class="dsiscipline">${hotUser.speciality}</p>
                      </div>
                      <div class="hot_people_dw">
                      <div class="block">
                      <div class="yw">${hotUser.follewsNum}</div>
                      <div class="zw">关注</div>
                      </div>
                      <div class="line"></div>
                      <div class="block">
                      <div class="yw">${hotUser.fansNum}</div>
                      <div class="zw">粉丝</div>
                      </div>
                      <div class="line"></div>
                      <div class="block">
                      <div class="yw">${hotUser.messageNum}</div>
                      <div class="zw">动态</div>
                      </div>
                      </div>
                      
                      <div class="hot_people_dws"></div>
                      </div>
                      <div class="clear"></div>
             
		