package com.job528.profile.action.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.jsonplugin.annotations.JSON;
import com.job528.common.DataDictionary.ActionResult;
import com.job528.ejb.entity.UserAccessHistory;
import com.job528.profile.service.IUserAccessHistoryService;
import com.job528.profile.util.DateUtil;
import com.job528.profile.vo.ExecuteResult;
import com.job528.profile.vo.UserAccessHistoryInfoDTO;
import com.job528.service.PrintBean;
import com.job528.util.webwork.GenericAction;

public class UserAccessHistoryAction extends GenericAction {
	private static final long serialVersionUID = 1L;
	
	private int uid; //输入参数 用户ID
	
	private ExecuteResult er;
	
	private List<UserAccessHistoryInfoDTO> userInfoList;
	
	private IUserAccessHistoryService userAccessHistoryService;
	
	/**
	 * 记录用户访问的历史记录
	 * 
	 * 一天只记录一次
	 * @return
	 */
	public String recordUserAccessHistory() {
		/*int accessUserId = this.getLoginInfo().getLoginUserId();
		int userId = getUid();
		
		if(userId <=0 || accessUserId <=0) {
			return paramError();
		}
		
		
		String accessUserIp = request.getRemoteAddr();
		
		UserAccessHistory u = new UserAccessHistory();
		u.setUserId(userId);
		u.setAccessUserId(accessUserId);
		u.setAccessUserIp(accessUserIp);
		er = userAccessHistoryService.addUserAccessHistory(u);*/
		 
		return ActionResult.JSON_SUCCESS.toString();
	}
	
	/**
	 * 查询用户
	 * @return
	 */
	public String getUserAccessHistoryInfo() {
		int userid = this.getLoginInfo().getLoginUserId();//当前登录用户
		userInfoList = userAccessHistoryService.getUserAccessHistoryInfo(userid);
		if(userInfoList == null) {
			userInfoList = new ArrayList<UserAccessHistoryInfoDTO>(0);
		}
		
		//将个人头像相对地址设置为web绝对地址
		String basePath = super.getBasePath();
		List<UserAccessHistoryInfoDTO> list = new ArrayList<UserAccessHistoryInfoDTO>(userInfoList.size());
		for(UserAccessHistoryInfoDTO u : userInfoList) {
			if(u == null) continue;
			String photo = u.getPhoto();
		
			if(photo.indexOf("http://") == -1) {
				photo = basePath + photo;
			}
			u.setPhoto(photo);
			
			//设置界面显示的访问日期 
			String  showAccessDate = DateUtil.getShowAccessDate(u.getAccessDate());
			u.setAccessDateStr(showAccessDate);
			
			list.add(u);
		}
		userInfoList = list;
		//request.geth
		/*for(UserAccessHistoryInfoDTO u : userInfoList) {
			PrintBean.PrintBeanProperty(u);
		}*/
		
		return SUCCESS;
	}
	
	
	
	public static void main(String[] args) {
		//String showTime = getShowAccessDate("2012-07-24 08:19:10");
		//System.out.println("showTime="+showTime);
		System.out.println("2012-07-23 15:19:10".substring(0, 4));
		System.out.println("2012-07-23 15:19:10".substring(5, 7));
		System.out.println("2012-07-23 15:19:10".substring(8, 10));
	}
	
	
	private String paramError() {
		er = new ExecuteResult(false,"参数错误!","");
		return ActionResult.JSON_SUCCESS.toString();
	}
	
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}


	@JSON(serialize=false)
	public IUserAccessHistoryService getUserAccessHistoryService() {
		return userAccessHistoryService;
	}

	public void setUserAccessHistoryService(
			IUserAccessHistoryService userAccessHistoryService) {
		this.userAccessHistoryService = userAccessHistoryService;
	}

	@JSON(name="result")
	public ExecuteResult getEr() {
		return er;
	}


	public void setEr(ExecuteResult er) {
		this.er = er;
	}
	
	@JSON(serialize=false)
	public List<UserAccessHistoryInfoDTO> getUserInfoList() {
		return userInfoList;
	}
	public void setUserInfoList(List<UserAccessHistoryInfoDTO> userInfoList) {
		this.userInfoList = userInfoList;
	}
	
	
	
}
