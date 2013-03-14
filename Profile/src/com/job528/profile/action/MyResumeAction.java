package com.job528.profile.action;



import java.util.ArrayList;
import java.util.List;

import com.job528.profile.model.MyEducation;
import com.job528.profile.model.MyLanguage;
import com.job528.profile.model.MyTraining;
import com.job528.profile.model.MyUsers;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.util.ResumeUtil;
import com.job528.profile.vo.Education;
import com.job528.profile.vo.Experience;
import com.job528.profile.vo.Intention;
import com.job528.profile.vo.Language;
import com.job528.profile.vo.LanguageAbility;
import com.job528.profile.vo.Resume;
import com.job528.profile.vo.Training;
import com.job528.util.StringUtil;

public class MyResumeAction extends ResumeAction {

	private static final long serialVersionUID = 1L;
	private Resume resume;
	private List<Education> educations;
	private List<Training> trainingList;
	private LanguageAbility languageAbility;
	private Intention intention;
	private List<Experience> experiences;
	private String computerLevel;
	private MyUsers account;
	private boolean baseInfoFlag;
	private boolean intentionFlag;
	private boolean trainingFlag;
	private boolean languageFlag;
	private boolean educationFlag;
	private boolean experienceFlag;

	public String execute() {
		if(!isLogin()){
			return LOGIN;
		}
		resume = getLoginResume();
		if(null != resume.getMyResume()) {
			baseInfoFlag = true;
		}
		
		//计算机等级
		computerLevel = ResumeUtil.getComputerLevelById(this.resume.getMyResume().getComputerLevel().toString());

		//培训经历
		List<MyTraining>  myTrainings = resumeService.getTrainingByUserId(this.getUserId());
		if(myTrainings != null && myTrainings.size() > 0){
			
			trainingFlag = true;
			
			trainingList = new ArrayList<Training>(1);
			for(MyTraining myTraining : myTrainings){
				Training training = new Training();
				training.setMyTraining(myTraining);
				trainingList.add(training);
			}
		}
		
		//语言能力
		List<MyLanguage> languages = resumeService.getLanguageByUserId(this.getUserId());
		languageAbility = new LanguageAbility();
		languageAbility.setMyResume(resume.getMyResume());
		if(languages != null && languages.size() > 0){
			languageFlag = true;
			
			for (MyLanguage myLanguage : languages) {
				Language language = new Language();
				language.setMyLanguage(myLanguage);
				languageAbility.getLanguages().add(language);
			}
		}
		
		//求职意向
		intention = new Intention();
		intention.setMyResume(resume.getMyResume());
		if(StringUtil.isValidStr(intention.getCalling1()) || StringUtil.isValidStr(intention.getCalling3()) ||StringUtil.isValidStr(intention.getCalling3())){
			intentionFlag = true;
		}
		
		//教育经历
		List<MyEducation> list = resumeService.getEducationByUserId(this.getUserId());
		if(list != null && list.size() >0){
			educationFlag = true;
			educations = new ArrayList<Education>(1);
			for(MyEducation myEducation: list){
				Education education = new Education();
				education.setMyEducation(myEducation);
				educations.add(education);
			}
		}
		
		//工作经验
		List<MyWorkExp> workExps = resumeService.getWorkExpByUserId(this.getUserId());
		if (workExps != null && workExps.size() > 0) {
			experienceFlag = true;
			experiences = new ArrayList<Experience>(2);
			for (MyWorkExp workExp : workExps) {
				Experience experience = new Experience();
				experience.setMyWorkExp(workExp);
				experiences.add(experience);
			}
		}
		
		//简历公开、联系方式设置
		account = resumeService.getAccountInfoByUserId(this.getUserId());
		
		return SUCCESS;
	}
	

	
	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public IMyResumeService getResumeService() {
		return resumeService;
	}
	
	public void setResumeService(IMyResumeService resumeService) {
		this.resumeService = resumeService;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public List<Training> getTrainingList() {
		return trainingList;
	}

	public void setTrainingList(List<Training> trainingList) {
		this.trainingList = trainingList;
	}

	public LanguageAbility getLanguageAbility() {
		return languageAbility;
	}

	public void setLanguageAbility(LanguageAbility languageAbility) {
		this.languageAbility = languageAbility;
	}

	public Intention getIntention() {
		return intention;
	}

	public void setIntention(Intention intention) {
		this.intention = intention;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public String getComputerLevel() {
		return computerLevel;
	}

	public void setComputerLevel(String computerLevel) {
		this.computerLevel = computerLevel;
	}

	public MyUsers getAccount() {
		return account;
	}

	public void setAccount(MyUsers account) {
		this.account = account;
	}



	public boolean isBaseInfoFlag() {
		return baseInfoFlag;
	}



	public void setBaseInfoFlag(boolean baseInfoFlag) {
		this.baseInfoFlag = baseInfoFlag;
	}



	public boolean isIntentionFlag() {
		return intentionFlag;
	}



	public void setIntentionFlag(boolean intentionFlag) {
		this.intentionFlag = intentionFlag;
	}



	public boolean isTrainingFlag() {
		return trainingFlag;
	}



	public void setTrainingFlag(boolean trainingFlag) {
		this.trainingFlag = trainingFlag;
	}



	public boolean isLanguageFlag() {
		return languageFlag;
	}



	public void setLanguageFlag(boolean languageFlag) {
		this.languageFlag = languageFlag;
	}



	public boolean isEducationFlag() {
		return educationFlag;
	}



	public void setEducationFlag(boolean educationFlag) {
		this.educationFlag = educationFlag;
	}



	public boolean isExperienceFlag() {
		return experienceFlag;
	}



	public void setExperienceFlag(boolean experienceFlag) {
		this.experienceFlag = experienceFlag;
	}



	/*public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}*/
	
	
}
