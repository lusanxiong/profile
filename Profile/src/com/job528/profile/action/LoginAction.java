package com.job528.profile.action;

import java.util.Map;

import com.job528.profile.LoginInfo;
import com.job528.profile.model.MyResume;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.vo.Resume;


public class LoginAction extends ResumeAction {
	
	private int result;
	private IUserProfileService userProfileService; 
	public String execute() {
		String  loginName = request.getParameter("loginName");
    	String pwd = request.getParameter("pwd");
		
//    	Map<Integer, ?> resultMap = resumeService.login(loginName, pwd, "");
//    	result = Integer.parseInt(resultMap.get(1).toString());
//		
//		
//		if(result == 0){
//			int userId = Integer.parseInt(resultMap.get(2).toString());
//    		String myUserName = resultMap.get(3).toString();
//    		int memberClass = Integer.parseInt(resultMap.get(4).toString());
//    		int resumeStatus = Integer.parseInt(resultMap.get(5).toString());
//    		String email = resultMap.get(6).toString();
//    		String rtn_str = resultMap.get(7).toString();
//    		String perName = resultMap.get(8).toString();
//    		int engResumeFlag = Integer.parseInt(resultMap.get(9).toString());
//    		int checkFlag = Integer.parseInt(resultMap.get(10).toString());
//    		int resID = Integer.parseInt(resultMap.get(11).toString());
//			this.request = getRequest();
//			LoginInfo loginInfo = new LoginInfo(getRequest(), getHttpResponse());
			//loginInfo.setLoginUserId(userId);
//    		Resume resume = new Resume();	
//    		MyResume myResume = resumeService.getResumeByUserId(userId);
//    		resume.setMyResume(myResume);
//            this.setLoginResume(resume);
            
            //更新微博信息
            //userProfileService.updateProfile(myResume);
        	
//		}
    	
		return this.SUCCESS;
	}
	public IUserProfileService getUserProfileService() {
		return userProfileService;
	}
	public void setUserProfileService(IUserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}
	
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	
	
}
