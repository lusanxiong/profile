package com.job528.profile.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.job528.ejb.entity.Friend;
import com.job528.ejb.entity.Relationship;
import com.job528.lucene.bean.SearchUserCondition;
import com.job528.lucene.bean.UserInfo;
import com.job528.lucene.bean.UserPager;
import com.job528.lucene.search.ISearchUser;
import com.job528.profile.model.MyEducation;
import com.job528.profile.model.MyMessage;
import com.job528.profile.model.MyResume;
import com.job528.profile.service.IFriendService;
import com.job528.profile.service.IMessageService;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.IRelationshipService;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.vo.Follower;
import com.job528.profile.vo.UserSearchCondition;
import com.job528.util.AreaUtil;
import com.job528.util.Pager;
import com.job528.util.StrUtils;
import com.job528.util.StringUtil;
import com.job528.util.log.MyLog;

public class FriendService implements IFriendService {

	private static final MyLog log = MyLog.getLogger(FriendService.class);
	private IRelationshipService relationshipService;
	private IUserProfileService userProfileService;
	private IMyResumeService resumeService;
	private IMessageService messageService;
	private ISearchUser searchUserService;

	/**
	 * 随机获取可能认识的朋友
	 */
	@Override
	public List<UserInfo> getMayKnowFriendWithRandom(Integer count,
			MyResume resume) {
		
		UserPager userPage = this.getMayBeFriendNoGroup(resume, 1, 6,true);
		if (userPage == null)
			return Collections.emptyList();
		return userPage.getUserInfo();

	}

	
	
	
	@Override
	public Pager<Follower> getMyFollows(Integer userId, Integer groupId,
			Integer pageIndex, Integer pageSize) {
		Pager<Follower> friendsPager = new Pager<Follower>();
		List<Follower> list = new ArrayList<Follower>();
		try {
			com.job528.ejb.entity.Pager<Friend> friendPager = relationshipService
					.getAttentionByGroupId(userId, groupId, pageIndex, pageSize);
			if(friendPager == null || friendPager.getCount() <= 0)
				return friendsPager;
			friendsPager.setTotalSize(friendPager.getCount());
			friendsPager.setPageSize(pageSize);
			friendsPager.setPageNo(pageIndex);
			for(Friend frd : friendPager.getList()){
				Follower friend = new Follower();
				friend.setFriend(frd);
				UserInfo userInfo = this.searchUserService.getUserInfoById(frd.getUserId());
				friend.setUserInfo(userInfo);
				list.add(friend);
			}
			
		}catch (Exception e) {
			log.error("getMyFollows err:", e);
		}
		friendsPager.setList(list);
		return friendsPager;
	}
	
	@Override
	public Pager<Follower> getOtherFollows(Integer userId, Integer targetId, Integer pageIndex,Integer pageSize){
		Pager<Follower> friendsPager = new Pager<Follower>();
		List<Follower> list = new ArrayList<Follower>();
		try {
			com.job528.ejb.entity.Pager<Friend> friendPager = relationshipService
					.getAttentionByGroupId(targetId, 0, pageIndex, pageSize);
			if(friendPager == null || friendPager.getCount() <= 0)
				return friendsPager;
			friendsPager.setTotalSize(friendPager.getCount());
			friendsPager.setPageSize(pageSize);
			friendsPager.setPageNo(pageIndex);
			for(Friend frd : friendPager.getList()){
				Follower friend = new Follower();
				
				UserInfo userInfo = this.searchUserService.getUserInfoById(frd.getUserId());
				friend.setUserInfo(userInfo);
				int flag = relationshipService.getRelationshipFlag(userId, frd.getUserId());
				frd.setFlag(flag);	
				friend.setFriend(frd);
				list.add(friend);
			}
			
		}catch (Exception e) {
			log.error("getOtherFollows err:", e);
		}
		friendsPager.setList(list);
		return friendsPager;
	}
	
	@Override
	public Pager<Follower> getFans(Integer userId,
			Integer pageIndex, Integer pageSize) {
		Pager<Follower> friendsPager = new Pager<Follower>();
		List<Follower> list = new ArrayList<Follower>();
		try {
			com.job528.ejb.entity.Pager<Friend> friendPager = relationshipService.getFansByGroupId(userId, 0, pageIndex, pageSize);
			if(friendPager == null || friendPager.getCount() <= 0)
				return friendsPager;
			friendsPager.setTotalSize(friendPager.getCount());
			friendsPager.setPageSize(pageSize);
			friendsPager.setPageNo(pageIndex);
			for(Friend frd : friendPager.getList()){
				Follower friend = new Follower();
				UserInfo userInfo = this.searchUserService.getUserInfoById(frd.getUserId());
				friend.setUserInfo(userInfo);
				friend.setFriend(frd);
				list.add(friend);
			}
			
		}catch (Exception e) {
			log.error("getFans err:", e);
		}
		friendsPager.setList(list);
		return friendsPager;
	}
	
	@Override
	public Pager<Follower> getOtherFans(Integer userId, Integer targetId, Integer pageIndex, Integer pageSize){
		Pager<Follower> friendsPager = new Pager<Follower>();
		List<Follower> list = new ArrayList<Follower>();
		try {
			com.job528.ejb.entity.Pager<Friend> friendPager = relationshipService.getFansByGroupId(targetId, 0, pageIndex, pageSize);
			if(friendPager == null || friendPager.getCount() <= 0)
				return friendsPager;
			friendsPager.setTotalSize(friendPager.getCount());
			friendsPager.setPageSize(pageSize);
			friendsPager.setPageNo(pageIndex);
			for(Friend frd : friendPager.getList()){
				Follower friend = new Follower();
				friend.setFriend(frd);
				UserInfo userInfo = this.searchUserService.getUserInfoById(frd.getUserId());
				friend.setUserInfo(userInfo);
				int flag = relationshipService.getRelationshipFlag(userId, frd.getUserId());
				frd.setFlag(flag);
				list.add(friend);
			}
			
		}catch (Exception e) {
			log.error("getOtherFans err:", e);
		}
		friendsPager.setList(list);
		return friendsPager;
	}
	
	@Override
	public Pager<Follower> searchFriends(Integer userId,UserSearchCondition ucondition,
			Integer pageIndex, Integer pageSize) {
		Pager<Follower> friendsPager = new Pager<Follower>();
		List<Follower> list = new ArrayList<Follower>();

		SearchUserCondition condition = new SearchUserCondition();
		condition.setKeyWord(ucondition.getKeyword());
		condition.setPage(pageIndex);
		condition.setPageSize(pageSize);
		condition.setHomeTown(ucondition.getHomeCity());
	    
		if(!StrUtils.isNull(ucondition.getCalling())){
		List<String> callings = new ArrayList<String>();
		callings.add(ucondition.getCalling());
		condition.setCallings(callings);
		}
		
		if(!StrUtils.isNull(ucondition.getCompany())){
		List<String> companys = new ArrayList<String>();
		companys.add(ucondition.getCompany());
		condition.setCompanys(companys);
		}
		
		if(!StrUtils.isNull(ucondition.getSchool())){
			List<String> schools = new ArrayList<String>();
			schools.add(ucondition.getSchool());
			condition.setSchools(schools);
		}
		
		if(!"".equals(ucondition.getIntPost())){
			List<String> callings = new ArrayList<String>();
			callings.add(ucondition.getIntPost());
			condition.setCallings(callings);
		}
		
		//现居住地 作为搜索条件
		String place = ucondition.getPlace() != null ? ucondition.getPlace() : "";
		if( !"".equals(place.trim()) ) {
			condition.setPlace(place);
		}
		
		//个人标签做为搜索条件
		String userLabel = ucondition.getUserLabel();
		if(!"".equals(userLabel)) {
			condition.setUserLabel(userLabel);
		}
		
		//condition.setHomeTown("北京");
		try {
			UserPager userPage = this.searchUserService.searchUser(condition);
			if(userPage != null && userPage.getUserInfo() != null){
				friendsPager.setTotalSize(userPage.getTotalSize());
				friendsPager.setPageSize(pageSize);
				friendsPager.setPageNo(pageIndex);
				for(UserInfo userInfo : userPage.getUserInfo()){
					Follower friend = new Follower();
					friend.setUserInfo(userInfo);
					Friend  frd = relationshipService.getRelationshipByUserId(userId, userInfo.getUid());
					friend.setFriend(frd);
					list.add(friend);
				}
			}
		} catch (Exception e) {
			log.error("searchFriends err:", e);
		}
		
		
		friendsPager.setList(list);
		return friendsPager;
	}
	
	
	
	/**
	 * 获取用户的学校信息
	 * @param user
	 * @param userId
	 * @return
	 */
	private List<String> getUserScools(UserInfo user, Integer userId) {
		List<String> schools = new ArrayList<String>();

		if (user != null && user.getSchool()!= null) {
			String schArr[] = user.getSchool().split(",");
			for (String sch : schArr) {
				if (sch != null && sch != "") {
					schools.add(sch);
				}
			}
		} else {
			List<MyEducation> educations = resumeService.getEducationByUserId(userId);
			if (educations != null && educations.size() > 0) {
				for (MyEducation education : educations) {
					schools.add(education.getSchoolName());
				}
			}	
		}
		return schools;
	}
	
	
	/**
	 * 获取用户工作过的公司
	 * @param user
	 * @param userId
	 * @return
	 */
	private List<String> getUserWorkCompany(UserInfo user,Integer userId){
        List<String> companies = new ArrayList<String>();
		
		if(user != null && user.getWorkCompany() != null){
			String comArr[] = user.getWorkCompany().split(",");
			for(String com : comArr){
				if(com != null && com != ""){
					companies.add(com);
				}
			}
		} else {
			return userProfileService.getWorkCompanyNames(userId);
		}
		return companies;
	}
	

	/**
	 * 获取用户工作过的行业
	 * @param user
	 * @param userId
	 * @return
	 */
	private List<String> getUserCalllings(UserInfo user,Integer userId){
		List<String> callings = new ArrayList<String>();
		
		if(user != null && user.getWorkCalling() != null){
			String callingArr[] = user.getWorkCalling().split(",");
			for(String call : callingArr){
				if(call != null && call != ""){
					callings.add(call);
				}
			}
		} else {
			Map<Integer, String> callingMap = userProfileService
					.getWorkCallingNames(userId);
			if (!callingMap.isEmpty()) {
				for (Map.Entry<Integer, String> entry : callingMap.entrySet()) {
					callings.add(entry.getValue());
				}
			}
		}
		
		return callings;
	}
	
	
	/**
	 * 获取我关注的用户Id
	 * @param myId
	 * @return
	 */
	public List<Integer> getMyAttentionUserId(Integer myId) {
		List<Integer> outUserIds = new ArrayList<Integer>();
		com.job528.ejb.entity.Pager<com.job528.ejb.entity.Friend> fIdPage = relationshipService
				.getAttentionByGroupId(myId, 0, 1, 100);
		if (fIdPage != null && fIdPage.getList() != null) {

			for (com.job528.ejb.entity.Friend frd : fIdPage.getList()) {
				outUserIds.add(frd.getUserId());
			}
		}
		return outUserIds;
	}
	
	
	@Override
	public UserPager getMayBeFriendNoGroup(MyResume resume, Integer pageIndex,
			Integer pageSize, boolean random) {
		SearchUserCondition condition = new SearchUserCondition();
		condition.setPage(pageIndex);
		condition.setPageSize(pageSize);
		condition.setOutUserIds(this.getMyAttentionUserId(resume.getMyUserId()));
		
		UserInfo user = this.searchUserService.getUserInfoById(resume.getMyUserId());

		// 同行

		List<String> callings = this.getUserCalllings(user, resume.getMyUserId());
		if(!callings.isEmpty())
		    condition.setCallings(callings);

		// 同事
		List<String> companys = this.getUserWorkCompany(user, resume.getMyUserId());
		if (!companys.isEmpty())
			condition.setCompanys(companys);
		

		// 同乡
		if (StringUtil.isValidStr(resume.getHometown().trim())) {
			condition.setHomeTown(resume.getHometown().trim());
		}

		// 同学
		List<String> schools = this.getUserScools(user, resume.getMyUserId());
		if(!schools.isEmpty())	
			condition.setSchools(schools);
		
		try {	
			if(random){
				return searchUserService.searchUserWithRandom(condition);
			}
            return searchUserService.searchUserByCondition(condition);
		} catch (Exception e) {
			log.error("lucene error", e);
			return null;
		}
	}
	
	

	@Override
	public Integer attentionFriend(Integer userId, Integer targetId,
			Integer group) {
		Relationship relationShip = new Relationship();
		relationShip.setGroupId(group);
		relationShip.setIsRead(0);
		relationShip.setJoinDate(new Date());
		relationShip.setOtherUserId(targetId);
		relationShip.setUserId(userId);
		relationShip.setFlag(1);
		int result = relationshipService.saveRelationship(relationShip);
		if (result == 0) {
			MyMessage message = new MyMessage();
			message.setContent("");
			message.setIsRead(false);
			message.setSendId(userId);
			message.setTargetId(targetId);
			message.setType(0);
			messageService.sendMessage(message);
		}
		return result;
	}

	
	public Integer batchAttentionFriend(String targetIds,Integer userId,Integer group){
		int result = 0;
		
		if(StrUtils.isNull(targetIds))
			return result;
		
		String tids[] = targetIds.split(",");
		for(String tid : tids){
			result = this.attentionFriend(userId, Integer.parseInt(tid), group);
		}
		
		return result;
	}
	
	@Override
	public Integer unAttentionFriend(Integer userId, Integer targetId) {
		Relationship relationShip = new Relationship();
		relationShip.setGroupId(0);
		relationShip.setIsRead(0);
		relationShip.setJoinDate(new Date());
		relationShip.setOtherUserId(targetId);
		relationShip.setUserId(userId);
		relationShip.setFlag(1);
		int result = relationshipService.deleteRelationship(relationShip);
//		if (result == 0) {
//			MyMessage message = new MyMessage();
//			message.setContent("");
//			message.setIsRead(false);
//			message.setSendId(userId);
//			message.setTargetId(targetId);
//			message.setType(1);
//			messageService.sendMessage(message);
//		}
		return result;
	}

	@Override
	public Integer changeFriendGroup(Integer userId, Integer targetId,
			Integer group) {
		return relationshipService.updateGroupId(userId, targetId, group);

	}
	
	@Override
	public Integer batchEditFriendGroup(String targetIds,Integer userId,Integer group){
        int result = 0;
		if(StrUtils.isNull(targetIds))
			return result;
		String tids[] = targetIds.split(",");
		for(String tid : tids){
			result = this.changeFriendGroup(userId, Integer.parseInt(tid), group);
		}
		return result;
	}

	@Override
	public Pager<UserInfo> getMyFans(Integer userId,
			Integer groupId, Integer pageIndex, Integer pageSize) {
		Pager<UserInfo> users = new Pager<UserInfo>();
		users.setPageSize(pageSize);
		users.setPageNo(pageIndex);

		try {

			com.job528.ejb.entity.Pager<com.job528.ejb.entity.Friend> fIdPage = relationshipService.getFansByGroupId(userId, groupId, pageIndex, pageSize);
			if (fIdPage != null && fIdPage.getList() != null) {
				users.setTotalSize(fIdPage.getCount());
				List<Integer> friendIds = new ArrayList<Integer>();
				for(com.job528.ejb.entity.Friend frd: fIdPage.getList()){
					friendIds.add(frd.getUserId());
				}

				SearchUserCondition condition = new SearchUserCondition();
				condition.setUserIds(friendIds);
				condition.setPage(pageIndex);
				condition.setPageSize(pageSize);
				UserPager userPager = this.searchUserService.searchUserByCondition(condition);
				if (userPager != null) {
					List<UserInfo> list = new ArrayList<UserInfo>();
					for (UserInfo user : userPager.getUserInfo()) {
						list.add(user);
					}

					users.setList(list);
				}
			}
		} catch (Exception e) {
			log.error("getMyFans err:", e);
		}

		return users;
	}
	
	
	@Override
	public Follower getHotUser(Integer userId) {
		Friend friend=relationshipService.getRelationshipByUserId(userId, 2670729);
		if(friend != null){
			Follower follow = new Follower();
			follow.setFriend(friend);
			UserInfo user = this.searchUserService.getUserInfoById(2670729);
			follow.setUserInfo(user);
			return follow;
		}
		return null;
	}

	@Override
	public List<Follower> getTopHotUser(Integer top){
		List<Friend> friends = userProfileService.getHotUsers(10, 2670729);
		if(friends != null && friends.size() >0){
			List<Follower> follows = new ArrayList<Follower>(friends.size());
			for(int i=0; i<friends.size(); i++){
				Friend frd = friends.get(i);
				int userId =frd.getUserProfile().getUserId();
				Follower follow = new Follower();
				follow.setFriend(frd);
				UserInfo userInfo = this.searchUserService.getUserInfoById(userId);
				
				if(userInfo == null){
					MyResume resume = resumeService.getResumeByUserId(userId);
					if(resume != null){
						userInfo = new UserInfo();
						userInfo.setName(resume.getPerName());
						userInfo.setSex(resume.getSex());
						userInfo.setPhoto(resume.getPhotoName());
						String place = AreaUtil.getPCAById(resume.getLocation());
						userInfo.setPlace(place);
					}
				}
				follow.setUserInfo(userInfo);
				follows.add(follow);
			}
			return follows;
		}
		return null;
	}
	
	public Integer getRelationFlag(Integer userId,Integer otherUserId){
		if(userId <=0 || otherUserId <= 0)
			return -1;
		return relationshipService.getRelationshipFlag(userId, otherUserId);
	}
	
	public IRelationshipService getRelationshipService() {
		return relationshipService;
	}

	public void setRelationshipService(IRelationshipService relationshipService) {
		this.relationshipService = relationshipService;
	}

	public IUserProfileService getUserProfileService() {
		return userProfileService;
	}

	public void setUserProfileService(IUserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public IMyResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(IMyResumeService resumeService) {
		this.resumeService = resumeService;
	}

	public IMessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

	public ISearchUser getSearchUserService() {
		return searchUserService;
	}

	public void setSearchUserService(ISearchUser searchUserService) {
		this.searchUserService = searchUserService;
	}




	@Override
	public Integer batchUnAttentionFriend(String targetIds, Integer userId) {
        int result = 0;
		if(StrUtils.isNull(targetIds))
			return result;
		String tids[] = targetIds.split(",");
		for(String tid : tids){
			result = this.unAttentionFriend(userId, Integer.parseInt(tid));
		}
		return result;
	}

	
	@Override
	public Integer batchDelFans(String targetIds,Integer userId){
        int result = 0;
		if(StrUtils.isNull(targetIds))
			return result;
		String tids[] = targetIds.split(",");
		for(String tid : tids){
			result = this.unAttentionFriend(Integer.parseInt(tid),userId);
		}
		return result;
	}
	
}
