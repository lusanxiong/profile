package com.job528.profile.action;



import com.job528.lucene.search.ISearchUser;
import com.job528.profile.model.MyResume;
import com.job528.profile.service.IFriendService;
import com.job528.profile.service.IMessageService;
import com.job528.profile.service.IRelationshipService;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.vo.Follower;
import com.job528.util.Pager;
import com.job528.util.StringUtil;

public class FollowsAction extends ResumeAction {
	
    private IUserProfileService userProfileService;
    private IRelationshipService relationshipService;
    private IFriendService friendService;
    private ISearchUser searchUserService;
    private IMessageService messageService;

    private MyResume myResume;
	private Pager<Follower> friends = new Pager<Follower>();
	
	public String execute() {
		friends = friendService.getMyFollows(this.getUserId(), this.getGroup(), this.getPage(), 20);
		return SUCCESS;
	}

	
	public String fans(){
		messageService.deleteMessageQueue(getUserId(), 2); //删除粉丝队列, 2表示粉丝
		friends = friendService.getFans(this.getUserId(), this.getPage(), 20);
		return SUCCESS;
	}
	
	
	public String followsByUid(){
		int tid = StringUtil.getIntValue(this.getParameter("uid"), 0);
		if(getUserId()==tid) { //表示是自己浏览自己的关注页面
			return "follow";
		}
		myResume = resumeService.getResumeByUserId(tid);
		friends = friendService.getOtherFollows(this.getUserId(),tid, this.getPage(), 20);
		return SUCCESS;
	}
	
	public String fansByUid(){
		int tid = StringUtil.getIntValue(this.getParameter("uid"), 0);
		if(getUserId()==tid) { //表示是自己浏览自己的粉丝页面
			return "fans";
		}
		myResume = resumeService.getResumeByUserId(tid);
		friends = friendService.getOtherFans(this.getUserId(), tid, this.getPage(), 20);
		return SUCCESS;
	}
	
	
	
	
	public MyResume getMyResume() {
		return myResume;
	}


	public void setMyResume(MyResume myResume) {
		this.myResume = myResume;
	}


	public int getGroup(){
		return StringUtil.getIntValue(this.getParameter("gid"), 0);
	}
	
	
	public Pager<Follower> getFriends() {
		return friends;
	}

	public void setFriends(Pager<Follower> friends) {
		this.friends = friends;
	}

	

	public void setUserProfileService(IUserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public IUserProfileService getUserProfileService() {
		return userProfileService;
	}
	


	public IFriendService getFriendService() {
		return friendService;
	}
	
	public void setFriendService(IFriendService friendService) {
		this.friendService = friendService;
	}


	public ISearchUser getSearchUserService() {
		return searchUserService;
	}


	public void setSearchUserService(ISearchUser searchUserService) {
		this.searchUserService = searchUserService;
	}


	public IRelationshipService getRelationshipService() {
		return relationshipService;
	}


	public void setRelationshipService(IRelationshipService relationshipService) {
		this.relationshipService = relationshipService;
	}


	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}
	
	
}
