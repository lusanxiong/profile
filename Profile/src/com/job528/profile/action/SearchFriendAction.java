package com.job528.profile.action;

import java.util.ArrayList;
import java.util.List;
import com.job528.profile.model.MyEducation;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.service.IFriendService;
import com.job528.profile.util.JobUtil;
import com.job528.profile.vo.Follower;
import com.job528.profile.vo.UserSearchCondition;
import com.job528.util.Pager;
import com.job528.util.StrUtils;

public class SearchFriendAction extends ResumeAction {
	  
    private IFriendService friendService; 
    
	private Pager<Follower> friends = new Pager<Follower>();
	private List<String> comps;
	private List<String> schools;
	private List<String> calls;
	private UserSearchCondition ucondition;
	private String showCondition = "";
	
	public String execute() {
		int userId = this.getUserId();
		
		ucondition = new UserSearchCondition();
		this.setUserSearchCondition();
		this.initSearchInfo(userId);
		
		showCondition = this.ckConditioin(ucondition);
		friends = friendService.searchFriends(userId, ucondition, this.getPage(), 20);
		return SUCCESS;
	}
	
	private void initSearchInfo(int userId){
			List<MyWorkExp> workExps = resumeService.getWorkExpByUserId(userId);
			if(workExps != null && workExps.size() > 0){
				comps = new ArrayList<String>();
				calls = new ArrayList<String>();
				for(MyWorkExp wexp : workExps){
					String comp = wexp.getMemName();
					String calling = JobUtil.getCallingById(wexp.getMemCalling().toString());
					if(!StrUtils.isNull(comp) && !comps.contains(comp.trim())){
						comps.add(comp);
					}
					if(!StrUtils.isNull(calling) && !calls.contains(calling)){
						calls.add(calling);
					}
				}
			}
			
			List<MyEducation> educations = resumeService.getEducationByUserId(userId);
			if(educations != null && educations.size() >0){
				schools = new ArrayList<String>();
				for(MyEducation edu : educations){
					String school = edu.getSchoolName();
					if(!StrUtils.isNull(school) && !schools.contains(school)){
						schools.add(school);
					}
				}
			}
	}
	
	
	
	private void setUserSearchCondition(){
		String keyWord = this.getRequestValue("keyword","");
		String intCity = this.getRequestValue("intCity","");  
		String intPost = this.getRequestValue("intPost","");
		
		String calling = this.getRequestValue("calling","");
		String company = this.getRequestValue("company","");
		String school = this.getRequestValue("school","");
		String homeProvince = this.getRequestValue("homeProvince","");
		String homeCity = this.getRequestValue("homeCity","");
		String place = this.getRequestValue("intCity", ""); //现居住地
		
		String userLabel = StrUtils.toUTF8(this.getRequestValue("labelName", ""));//个人标签
		
 
		String tag = request.getParameter("tag");
		
		if(tag !=null && !tag.trim().equals("")) {
			keyWord = StrUtils.toUTF8(tag);
 
		}
		
		ucondition.setKeyword(keyWord);
		ucondition.setIntCity(intCity);
		ucondition.setIntPost(intPost);
		ucondition.setCalling(calling);
		ucondition.setCompany(company);
		ucondition.setHomeCity(homeCity);
		ucondition.setHomeProvince(homeProvince);
		ucondition.setSchool(school);
		ucondition.setPlace(place);
		ucondition.setUserLabel(userLabel);
		
	}
	
	
	public Pager<Follower> getFriends() {
		return friends;
	}

	public void setFriends(Pager<Follower> friends) {
		this.friends = friends;
	}

	
	public IFriendService getFriendService() {
		return friendService;
	}
	
	public void setFriendService(IFriendService friendService) {
		this.friendService = friendService;
	}

	public String getKeyword(){
		if(StrUtils.isNull(ucondition.getKeyword()))
			return "输入职位名称或朋友名字";
		return ucondition.getKeyword();
	}

	public UserSearchCondition getUcondition() {
		return ucondition;
	}


	public void setUcondition(UserSearchCondition ucondition) {
		this.ucondition = ucondition;
	}


	public String getShowCondition() {
		return showCondition;
	}


	public void setShowCondition(String showCondition) {
		this.showCondition = showCondition;
	}

	

	private String ckConditioin(UserSearchCondition ucondition){
		if(ucondition == null)
			return null;
		
		String exp =  "<span class=\"all\" id=\"$id_\">$name</span><span class=\"cas\" id=\"$id_cs\"><img src=\"../images/search_friends_ca.gif\" width=\"13\" height=\"13\" onclick=\"delCondition('$id')\"/></span>";
	    StringBuilder conString = new StringBuilder();
	    
	    
	    
	    if(!StrUtils.isNull(ucondition.getIntPost())){
	    	conString.append(exp.replace("$id", "_intPost").replace("$name", ucondition.getIntPost()));
	    }
	    
	    if(!StrUtils.isNull(ucondition.getIntCity())){
	    	conString.append(exp.replace("$id", "_intCity").replace("$name", ucondition.getIntCity()));
	    }
	    
	    if(!StrUtils.isNull(ucondition.getKeyword())){
	    	conString.append(exp.replace("$id", "_keyword").replace("$name", ucondition.getKeyword()));
	    }
	    
	    
	    if(!StrUtils.isNull(ucondition.getCalling())){
	    	conString.append(exp.replace("$id", "_calling").replace("$name", ucondition.getCalling()));
	    }
	    
	    if(!StrUtils.isNull(ucondition.getCompany())){
	    	conString.append(exp.replace("$id", "_company").replace("$name", ucondition.getCompany()));
	    }
	    
	    if(!StrUtils.isNull(ucondition.getHomeProvince())){
	    	conString.append(exp.replace("$id", "_homeProvince").replace("$name", ucondition.getHomeProvince()));
	    }
	    
	    
	    if(!StrUtils.isNull(ucondition.getHomeCity())){
	    	conString.append(exp.replace("$id", "_homeCity").replace("$name", ucondition.getHomeCity()));
	    }
	    
	    if(!StrUtils.isNull(ucondition.getSchool())){
	    	conString.append(exp.replace("$id", "_school").replace("$name", ucondition.getSchool()));
	    }
	    
	    if(!StrUtils.isNull(ucondition.getUserLabel())){
	    	conString.append(exp.replace("$id", "_labelName").replace("$name", ucondition.getUserLabel()));
	    }
	    
	    
	    return conString.toString();
	}


	public List<String> getComps() {
		return comps;
	}


	public void setComps(List<String> comps) {
		this.comps = comps;
	}


	public List<String> getSchools() {
		return schools;
	}


	public void setSchools(List<String> schools) {
		this.schools = schools;
	}


	public List<String> getCalls() {
		return calls;
	}


	public void setCalls(List<String> calls) {
		this.calls = calls;
	}
	
	                                                            
	
	
}
