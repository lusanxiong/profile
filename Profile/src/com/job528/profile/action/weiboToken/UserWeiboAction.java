package com.job528.profile.action.weiboToken;

import java.util.List;

import com.job528.common.DataDictionary.SessionAttrName;
import com.job528.profile.service.IWeiboTokenService;
import com.job528.profile.vo.UserWeiboInfoDTO;
import com.job528.util.webwork.GenericAction;

/**
 * 用户微博信息Action
 * @author lusanxiong
 *
 */
public class UserWeiboAction extends GenericAction {
	private static final long serialVersionUID = 1L;
	private IWeiboTokenService weiboTokenService;
	
	//返回结果
	private List<UserWeiboInfoDTO> userWeiboList;
	
	/**
	 * 查询用户微博同步信息
	 */
	public String getUserWeiboSynInfo() {
		int userid = this.getLoginInfo().getLoginUserId(); //当前登录用户
		
		userWeiboList = weiboTokenService.getUserWeiboInfoList(userid);
		/*for(UserWeiboInfoDTO w : userWeiboList) {
			//PrintBean.PrintBeanProperty(w);
		}*/
		
		return SUCCESS;
	}
	

	public IWeiboTokenService getWeiboTokenService() {
		return weiboTokenService;
	}

	public void setWeiboTokenService(IWeiboTokenService weiboTokenService) {
		this.weiboTokenService = weiboTokenService;
	}

	public List<UserWeiboInfoDTO> getUserWeiboList() {
		return userWeiboList;
	}

	public void setUserWeiboList(List<UserWeiboInfoDTO> userWeiboList) {
		this.userWeiboList = userWeiboList;
	}
	
	
}
