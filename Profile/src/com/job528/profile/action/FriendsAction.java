package com.job528.profile.action;

import com.job528.lucene.bean.UserInfo;
import com.job528.profile.service.IFriendService;
import com.job528.util.Pager;
import com.job528.util.StringUtil;

public class FriendsAction extends ResumeAction {
    private IFriendService friendService;
	private int groupId;

	private Pager<UserInfo> userPage;
	public String execute() {
		groupId = StringUtil.isValidStr(this.getParameter("g")) ? Integer
				.valueOf(this.getParameter("g"))
				: 0;
		
		userPage = friendService.getMyFans(this.getUserId(), 0, this.getPage(), 8);
		
		return SUCCESS;
	}

	
	
	public int getGroupId() {
		return groupId;
	}



	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public Pager<UserInfo> getUserPage() {
		return userPage;
	}



	public void setUserPage(Pager<UserInfo> userPage) {
		this.userPage = userPage;
	}



	public IFriendService getFriendService() {
		return friendService;
	}

	public void setFriendService(IFriendService friendService) {
		this.friendService = friendService;
	}
}
