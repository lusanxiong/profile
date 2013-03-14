package com.job528.profile.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.job528.ejb.user.bean.UserProfileDao;
import com.job528.profile.LoginInfo;
import com.job528.profile.dao.IMyEducationDao;
import com.job528.profile.dao.IMyLanguageDao;
import com.job528.profile.dao.IMyResumeDao;
import com.job528.profile.dao.IMyTrainingDao;
import com.job528.profile.dao.IMyWorkExpDao;
import com.job528.profile.model.MyEducation;
import com.job528.profile.model.MyLanguage;
import com.job528.profile.model.MyResume;
import com.job528.profile.model.MyTraining;
import com.job528.profile.model.MyUsers;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.util.ResumeUtil;
import com.job528.profile.vo.Experience;
import com.job528.profile.vo.Resume;
import com.job528.util.StrUtils;

public class MyResumeService implements IMyResumeService {
	
	private IMyResumeDao resumeDao;
	private IMyWorkExpDao workExpDao;
	private IMyEducationDao educationDao;
	private IMyTrainingDao trainingDao;
	private IMyLanguageDao languageDao;
	private UserProfileDao userProfileDao;
	

	@Override
	public List<MyEducation> getEducationByUserId(Integer userId) {
		return educationDao.getMyEducationByUserId(userId);
	}
	
	@Override
	public List<MyEducation> getEducationById(Integer id,Integer userId){
		return educationDao.getMyEducationById(id, userId);
	}

	@Override
	public MyResume getResumeByUserId(Integer userId) {
		return resumeDao.getResumesByuserId(userId);
	}
	
	
	
	@Override
	public List<MyTraining> getTrainingByUserId(Integer userId) {
		return trainingDao.getMyTrainingByUserId(userId);
	}
	
	@Override
	public List<MyTraining> getTrainingById(Integer id,Integer userId){
		return trainingDao.getMyTrainingById(id, userId);
	}

	@Override
	public List<MyWorkExp> getWorkExpByUserId(Integer userId) {
		return workExpDao.getMyWorkExpByUserId(userId);
	}
	
	@Override
	public List<MyWorkExp> getWorkExpById(Integer id,Integer userId) {
		return workExpDao.getMyWorkExpById(id, userId);
	}
	
	@Override
	public List<MyLanguage> getLanguageByUserId(Integer userId) {
		return languageDao.getMyLanguageByUserId(userId);
	}
	
	@Override
	public List<MyLanguage> getLanguageById(Integer id,Integer userId) {
		return languageDao.getMyLanguageById(id, userId);
	}
	
	@Override
	public void addOrUpdateEducation(MyEducation myEducation) {
		educationDao.addOrSave(myEducation);
		
	}

	@Override
	public void deleteEducation(MyEducation myEducation) {
		educationDao.delelte(myEducation);
		
	}
	
	@Override
	public void addOrUpdateTraining(MyTraining myTraining) {
		trainingDao.addOrSave(myTraining);
		
	}

	@Override
	public void deleteTraining(MyTraining myTraining) {
		trainingDao.delelte(myTraining);
		
	}
	
	@Override
	public void updateResume(MyResume myResume,boolean upDateWeibo) {
		resumeDao.saveOrUpdate(myResume);
		if(upDateWeibo){
			String headImg = "/" + ResumeUtil.defaultHeadImg;
    		if(myResume.getPerName() != null && myResume.getPerName() != ""){
    			headImg = myResume.getPhotoName();
    		}
    		userProfileDao.mergeUserProfile(myResume.getPerName(), headImg, myResume.getMyUserId());
		}
	}
	
	@Override
	public void deleteWorkExp(MyWorkExp myWorkExp) {
		workExpDao.delelte(myWorkExp);
	}
	
	@Override
	public void saveOrUpdate(MyWorkExp myWorkExp){
		workExpDao.saveOrUpdate(myWorkExp);
	}

	@Override
	public String getResumeStatePer(Integer userId,Integer type) {
		Map<Integer, ?> resultMap = resumeDao.getMyResumeSurvey(userId);
		if (resultMap != null) {
			int eduinfo = Integer.parseInt(resultMap.get(2).toString()) >= 1 ? 1 : 0;
			int workexeinfo = Integer.parseInt(resultMap.get(3).toString())  >= 1 ? 1 : 0;
			int traininfo = Integer.parseInt(resultMap.get(4).toString()) >= 1 ? 1 : 0;
			int resume = Integer.parseInt(resultMap.get(5).toString()) >= 1 ? 1 : 0;
			int englevel = Integer.parseInt(resultMap.get(6).toString()) >= 1 ? 1 : 0;
			int jobseeking = Integer.parseInt(resultMap.get(7).toString()) >= 1 ? 1 : 0;
			int otherskill = Integer.parseInt(resultMap.get(8).toString()) >= 1 ? 1 : 0;
			int interest1 = Integer.parseInt(resultMap.get(9).toString()) >= 1 ? 1 : 0;
			int workexpgr1 = Integer.parseInt(resultMap.get(10).toString()) >= 1 ? 1 : 0;
			
			double per =(double)(eduinfo + workexeinfo + traininfo + resume + englevel + jobseeking + otherskill) / 7 * 100;
			StringBuilder json = new StringBuilder();
			json.append("[{");
			json.append("\"per\":\"").append((int)per).append("\",");
			json.append("\"eduinfo\":\"").append(eduinfo).append("\",");
			json.append("\"workexeinfo\":\"").append(workexeinfo).append("\",");
			json.append("\"traininfo\":\"").append(traininfo).append("\",");
			json.append("\"resume\":\"").append(resume).append("\",");
			json.append("\"englevel\":\"").append(englevel).append("\",");
			json.append("\"jobseeking\":\"").append(jobseeking).append("\",");
			json.append("\"otherskill\":\"").append(otherskill).append("\"");
			
			json.append("}]");
			
			return json.toString();
		}
		return "[]";
	}

	@Override
	public Integer login(String loginName, String pwd, String ip,
			LoginInfo loginInfo) {
		Map<Integer, ?> resultMap = resumeDao.loginQuery(loginName, pwd, ip);
		int result = Integer.parseInt(resultMap.get(1).toString());
		if(result == 0){
			String userId = resultMap.get(2).toString();
			String myUserName = resultMap.get(3).toString();
			String memberClass = resultMap.get(4).toString();
			String resumeStatus = resultMap.get(5).toString();
			String email = resultMap.get(6).toString();
			String rtn_str = resultMap.get(7).toString();
			String perName = resultMap.get(8).toString();
			
			String engResumeFlag = resultMap.get(9).toString();
			String checkFlag = resultMap.get(10).toString();
			String resId = resultMap.get(11).toString();
			
			Resume resume = new Resume();
    		MyResume myResume = this.getResumeByUserId(Integer.parseInt(userId));
    		resume.setMyResume(myResume);
    		loginInfo.setLoginUserId(userId);
    		
    		//兼容528主站登录
    		loginInfo.setCheckFlag(checkFlag);
    		loginInfo.setEngResumeFlag(engResumeFlag);
    		loginInfo.setResId(resId);
    		loginInfo.setResumeEamil(email);
    		loginInfo.setResumeMemberClass(memberClass);
    		loginInfo.setResumePassWord(pwd);
    		loginInfo.setResumePerName(perName);
    		loginInfo.setResumeResumeStatus(resumeStatus);
    		loginInfo.setResumeUserID(userId);
    		loginInfo.setResumeUserName(myUserName);
    		String headImg = "/images/people.gif";
    		String name = email;
    		if(!StrUtils.isNull(myResume.getPerName())){
    			name = myResume.getPerName();
    		}
    		
    		if(!StrUtils.isNull(myResume.getPhotoName())){
    			headImg = myResume.getPhotoName();
    		}
    		userProfileDao.mergeUserProfile(name, headImg, myResume.getMyUserId());
		}
		return result;
	}
	
	@Override
	public MyUsers getAccountInfoByUserId(Integer userId) {
		return resumeDao.getMyUserByUserId(userId);
	}
	
	
	@Override
	public void updateAccountInfo(MyUsers account) {
		resumeDao.saveOrUpdateUser(account);
	}

	@Override
	public MyUsers getAccountInfoByEmail(String email) {
		return resumeDao.getMyUserByEmail(email);
	}
	
	@Override
	public void delMyLanguageById(Integer languageId) {
		languageDao.delMyLanguageById(languageId);
	}

	@Override
	public void addorUpdateDateMyLanguage(MyLanguage myLanguage) {
		languageDao.upDateMyLanguage(myLanguage);
	}
	
	
	public UserProfileDao getUserProfileDao() {
		return userProfileDao;
	}

	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}
	
	public IMyResumeDao getResumeDao() {
		return resumeDao;
	}

	public void setResumeDao(IMyResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}

	public IMyWorkExpDao getWorkExpDao() {
		return workExpDao;
	}

	public void setWorkExpDao(IMyWorkExpDao workExpDao) {
		this.workExpDao = workExpDao;
	}

	public IMyEducationDao getEducationDao() {
		return educationDao;
	}

	public void setEducationDao(IMyEducationDao educationDao) {
		this.educationDao = educationDao;
	}

	public IMyTrainingDao getTrainingDao() {
		return trainingDao;
	}

	public void setTrainingDao(IMyTrainingDao trainingDao) {
		this.trainingDao = trainingDao;
	}

	public IMyLanguageDao getLanguageDao() {
		return languageDao;
	}

	public void setLanguageDao(IMyLanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public boolean verificateMail(Integer myUserId, String email) {
		return this.resumeDao.getMyUserByEmailNotUser(myUserId, email) != null;
	}

	@Override
	public Integer login(int userId,String ip,LoginInfo logininfo) {
		MyUsers users = getAccountInfoByUserId(userId);
		if(users == null)
			return -1;
		
		String email = users.getEmail();
		if(email==null || "".equals(email))
			return -1;
		
		String pwd = users.getPassword();
		if(pwd==null || "".equals(pwd)) 
			return -1;
		
		int result = login(email, pwd, ip, logininfo);
    	return result;
    	
	}

	@Override
	public Experience getLastWorkExp(Integer userId) {
		MyWorkExp workExp = workExpDao.getLastMyWorkExp(userId);
		Experience experience = new Experience();
		experience.setMyWorkExp(workExp);
		return experience;
	}

	@Override
	public List<Experience> getUsersLastWorkExp(List<Integer> userIds) {
		if(userIds==null || userIds.size() ==0)
			return null;
		
		List<MyWorkExp> list = workExpDao.getUsersLastMyWorkExp(userIds);
		
		List<Experience> result = new ArrayList<Experience>(); 
		for(MyWorkExp we : list) {
			Experience e = new Experience();
			e.setMyWorkExp(we);
			
			result.add(e);
		}
		return result;
	}


	@Override
	public List<MyWorkExp> getUsersWorkExp(
			List<Integer> userIds) {
		if(userIds==null || userIds.size()==0) return null;
		
		List<MyWorkExp> list = workExpDao.getUsersMyWorkExpInfo(userIds);
		return list;
	}

	@Override
	public List<MyEducation> getUsersLastEducation(List<Integer> userIds) {
		if(userIds==null || userIds.size()==0) return null;
		List<MyEducation> list = educationDao.getUsersLastEducation(userIds);
		return list;
	}

	@Override
	public List<MyResume> getUsersResumeInfo(List<Integer> userIds) {
		if(userIds==null || userIds.size()==0) return null;
		
		return resumeDao.getUsersResume(userIds);
	}

	@Override
	public List<Integer> getAttenationUsers(int myUserId,List<Integer> userIds) {
		if(userIds==null || userIds.size()==0) return null;
		return resumeDao.getAttenationUsers(myUserId, userIds);
	}

	
 
	@Override
	public Integer getScore(Integer userId) {
		return resumeDao.getScore(userId);
	}


}
