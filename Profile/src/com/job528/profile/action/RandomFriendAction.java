package com.job528.profile.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.job528.common.DataDictionary.FriendType;
import com.job528.lucene.bean.UserInfo;
import com.job528.profile.model.MyEducation;
import com.job528.profile.model.MyResume;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.service.IFriendService;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.vo.Experience;
import com.job528.profile.vo.HotFamousUserInfoDTO;



public class RandomFriendAction extends ResumeAction {
	private static final long serialVersionUID = 1L;
	private IFriendService friendService;
	private IMyResumeService resumeService;
	private IUserProfileService userProfileService;
	
	//给好友分类
	private List<Map<Integer,FriendType>> friendList = new ArrayList<Map<Integer,FriendType>>(10);
	
	//好友的用户ID
	private List<Integer> userIdList = new ArrayList<Integer>(10);
	
	//我的用户ID
	int myUserId = 0;
	
	private List<UserInfo> users;
	public String execute() {
		users = friendService.getMayKnowFriendWithRandom(6, this.getLoginResume().getMyResume());
		myUserId = this.getUserId(); //我的用户ID
		//System.out.println("myUserId=="+myUserId);
		if(users== null || users.size() == 0 ) {
			users = getHotFamousUser();
			return SUCCESS;
		}
		
		/*for(UserInfo u : users) {
			PrintBean.PrintBeanProperty(u);
			System.out.println("place=="+u.getPlace());
		}*/
		
		
		//获取可能认识的人(好友)的用户ID
		userIdList = new ArrayList<Integer>(users.size());
		int size = users.size();
		for(int i=0; i<size; i++) {
			if(users.get(i) == null) continue;
			
			userIdList.add(users.get(i).getUid());
		}
		
		//获取已经被关注的用户ID
		List<Integer> attentionUsers = resumeService.getAttenationUsers(myUserId, userIdList); 
		for(Integer userid : attentionUsers) {
			if(userid == null) continue;
			for(UserInfo u : users) {
				
				//已经被关注的好友
				if(userid == u.getUid()) {
					users.remove(u);
					break;
				}
			}
		}
		
		//过滤当前用户
		for(UserInfo u : users) {
			if(u == null) continue;
			if(users.size()==1 && u.getUid() == myUserId) {
				users = getHotFamousUser();
				return SUCCESS;
			}
		}
	
		if(users.size() == 0) {
			users = getHotFamousUser();
			return SUCCESS;
		}
		
		//将好友的所担任的职务设置到好友的信息中
		setPostToFriendInfo();
		
		//将好友的所属分类设置到好友的信息中
		setFriendTypeToFriendInfo();
		
		return SUCCESS;
	}
	
	/**
	 * 将好友的所担任的职务设置到好友的信息中去
	 */
	public void setPostToFriendInfo() {
		
		//获取好友最近一次工作所担任的职务
		List<Experience> list = resumeService.getUsersLastWorkExp(userIdList);
		if(list == null || list.size() ==0) return;
		
		List<UserInfo> userInfoList = new ArrayList<UserInfo>();
		
		int size = users.size();
		for(int i=0; i<size; i++) {
			if(users.get(i) == null) continue;
			UserInfo u = users.get(i);
			
			for(Experience e : list) {
				if(e == null) continue;
				
				MyWorkExp w = e.getMyWorkExp();
				if(w == null) continue;
				
				if(w.getMyUserId() == u.getUid()) {
					u.setLastPostName(e.getPost());
					break;
				}
			}
			userInfoList.add(u);
		}
		
		users = userInfoList;
	}
	
	/**
	 * 将好友的所属分类设置到好友的信息中
	 */
	private void setFriendTypeToFriendInfo() {
		setFriendType();
		//System.out.println("friendList=="+friendList);
		List<UserInfo> userInfoList = new ArrayList<UserInfo>();
		
		int size = users.size();
		for(int i=0; i<size; i++) {
			if(users.get(i) == null) continue;
			UserInfo u = users.get(i);
			
			for(Map<Integer,FriendType> m : friendList) {
				if(m == null) continue;
				
				for(Map.Entry<Integer, FriendType> e : m.entrySet()) {
					if(e.getKey() == null) continue;
					
					if(u.getUid() == e.getKey().intValue()) {
						u.setFriendType(Integer.parseInt(e.getValue().toString()));
						u.setFriendTypeDescription(FriendType.getDescription(e.getValue()));
					}
				}
			}
			if(u.getUid() == myUserId) continue; //过滤用户自已
			
			userInfoList.add(u);
		}
		
		users = userInfoList;
		
		//给用户排序，按好友类型降序排序
		sortUsers();
	}
	
	/**
	 * 将列表中的用户信息按好友的类型来排序
	 */
	private void sortUsers() {
		Collections.sort(users, 
			new Comparator<UserInfo>()  {
				public int compare(UserInfo u1, UserInfo u2) {
					//按照好友分类降序排列
					int value = FriendType.getFriendTypeSortValue(u2.getFriendType()) 
					            - FriendType.getFriendTypeSortValue(u1.getFriendType());
					
					return value;
				}
			});
	}
	
	/**
	 * 将搜索出来的好友进行分类
	 * 
	 * @return
	 */
	private void setFriendType() {
		userIdList.add(myUserId);
		
		//获取好友所在公司
		List<MyWorkExp> companyList = resumeService.getUsersWorkExp(userIdList);
		
		//判断是否是我的同事
		if(userIdList.size() > 1) {
			isContainMyWorker(companyList);
		}
		
		//判断是否是我的同学
		if(userIdList.size() > 1) {
			isContainMyClassMate(userIdList);
		}
		
		//判断是否是我的同行
		if(userIdList.size() > 1) {
			isContainMyOccupation(companyList);
		}
		
		//判断是否是我的老乡
		if(userIdList.size() > 0) {
			isContainMyFollower(userIdList);
		}
	}
	
	/**
	 *判断是否包含我的同事
	 */
	private void isContainMyWorker(List<MyWorkExp> companyList) {
		if(companyList==null || companyList.size()==0) return;
		
		List<String> myCompanys = new ArrayList<String>(10);
		
		//得到我工作过的公司名称
		for(MyWorkExp e : companyList) {
			if(e == null) continue;
			if(e.getMyUserId() == null) continue;
			
			if(myUserId == e.getMyUserId().intValue()) {
				myCompanys.add(e.getMemName());
			}
		}
		
		//如果我呆过的公司为空
		if(myCompanys == null || myCompanys.size() == 0) {
			return;
		}
		
		
		//判断与我是否是同一公司
		for(MyWorkExp e : companyList) {
			String friendCompany = e.getMemName();
			
			for(String c : myCompanys) {
				if(friendCompany.equalsIgnoreCase(c)) {
					Map<Integer, FriendType> m = new HashMap<Integer,FriendType>();
					m.put(e.getMyUserId(), FriendType.WORKER);
					friendList.add(m);
					
					//移除已经分类的好友
					if(e.getMyUserId().intValue() != myUserId) {
						userIdList.remove(e.getMyUserId());
					}
				}
			}
		}
	}
	
	/**
	 * 判断是否是我的同学
	 * @return
	 */
	public void isContainMyClassMate(List<Integer> userIds) {
		List<MyEducation> list = resumeService.getUsersLastEducation(userIds);
		
		if(list == null || list.size() == 0) return;
		
		//得到我的学校名称
		String mySchoolName = "";
		for(MyEducation e : list) {
			if(e == null ) continue;
			if(e.getMyUserId() == null) continue;
			
			if(myUserId == e.getMyUserId().intValue()) {
				mySchoolName = e.getSchoolName();
				break;
			}
		}

		if(mySchoolName == null || mySchoolName.equals("")) return;
		
		//获取与是同学校的好友
		for(MyEducation e : list) {
			if(e == null ) continue;
			if(e.getMyUserId() == null) continue;
			
			if(mySchoolName.equals(e.getSchoolName())) {
				Map<Integer, FriendType> m = new HashMap<Integer,FriendType>();
				m.put(e.getMyUserId(), FriendType.CLASSMATE);
				friendList.add(m);
				
				//移除已经分类的好友
				if(e.getMyUserId().intValue() != myUserId) {
					userIdList.remove(e.getMyUserId());
				}
			}
		}
	}
	
	/**
	 *判断是否包含我的同行
	 */
	private void isContainMyOccupation(List<MyWorkExp> companyList) {
		if(companyList==null || companyList.size()==0) return;
		
		List<Integer> myCallings = new ArrayList<Integer>(10); //我所工作过的行业。
		
		//得到我工作过的行业
		for(MyWorkExp e : companyList) {
			if(e == null) continue;
			if(e.getMyUserId() == null) continue;
			
			if(myUserId == e.getMyUserId().intValue()) {
				myCallings.add(e.getMemCalling());
			}
		}
		
		//如果我呆过的行业为空
		if(myCallings == null || myCallings.size() == 0) {
			return;
		}
		
		
		//判断与我是否是同行
		for(MyWorkExp e : companyList) {
			Integer friendCalling = e.getMemCalling();
			if(friendCalling == null) continue;
			
			for(Integer calling : myCallings) {
				if(friendCalling.intValue() == calling) { //行业代码相同
					Map<Integer, FriendType> m = new HashMap<Integer,FriendType>();
					m.put(e.getMyUserId(), FriendType.OCCUPATION);
					friendList.add(m);
					
					//移除已经分类的好友
					if(e.getMyUserId().intValue() != myUserId) {
						userIdList.remove(e.getMyUserId());
					}
				}
			}
		}
	}
	
	/**
	 * 判断是否是我的老乡
	 * @return
	 */
	public void isContainMyFollower(List<Integer> userIds) {
		List<MyResume> list = resumeService.getUsersResumeInfo(userIds);
		
		if(list == null || list.size() == 0) return;
		
		//得到我的户口所在地
		String myHomeTown = this.getLoginResume().getMyResume().getHometown();  
		
		if(myHomeTown == null || myHomeTown.equals("")) return;
		
		//获取与是同乡的好友
		for(MyResume e : list) {
			if(e == null ) continue;
			if(e.getMyUserId() == null) continue;
			
			if(myHomeTown.equals(e.getHometown())) {
				Map<Integer, FriendType> m = new HashMap<Integer,FriendType>();
				m.put(e.getMyUserId(), FriendType.FELLOW);
				friendList.add(m);
				
				//移除已经分类的好友
				if(e.getMyUserId().intValue() != myUserId) {
					userIdList.remove(e.getMyUserId());
				}
			}
		}
	}
	
	private List<UserInfo> getHotFamousUser() {
		int index = new Random().nextInt(10);
		if(index == 0) {
			index = 1;
		}
		List<HotFamousUserInfoDTO> list = userProfileService.getHotFamousUserInfo(index, 6);
		List<UserInfo> result = new ArrayList<UserInfo>(list.size());
		for(HotFamousUserInfoDTO dto : list) {
			UserInfo u = new UserInfo();
			u.setUid(dto.getUserid());
			u.setPlace(dto.getNowLocationName());
			u.setName(dto.getUserName());
			u.setPhoto(dto.getPhoto());
			u.setLastPostName(dto.getUserLastPost());
			
			result.add(u);
		}
		//System.out.println("result=="+result.size());
		return result;
	}
	
	
	public List<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}

	public IFriendService getFriendService() {
		return friendService;
	}
	
	public void setFriendService(IFriendService friendService) {
		this.friendService = friendService;
	}

	public IMyResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(IMyResumeService resumeService) {
		this.resumeService = resumeService;
	}

	
	public IUserProfileService getUserProfileService() {
		return userProfileService;
	}

	public void setUserProfileService(IUserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

 
	public static void main(String[] args) {
		Integer i = 2;
		int i2 = 2;
		if(i == i2) {
			//System.out.println("===");
		}
	}
	
	
	
}
