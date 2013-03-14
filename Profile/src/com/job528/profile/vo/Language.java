package com.job528.profile.vo;

import com.job528.profile.model.MyLanguage;
import com.job528.profile.util.ResumeUtil;
import com.job528.util.JsonUtils;

public class Language extends BaseVO {

	private MyLanguage myLanguage;
	
	
	private String language;
	private String mastery;
	private String literacy;
	
	private String listenAndSpeak;
	
	
	public MyLanguage getMyLanguage() {
		
		return myLanguage;
	}

	public void setMyLanguage(MyLanguage myLanguage) {
		this.myLanguage = myLanguage;
	}
	
	public String getLanguage() {
		if(myLanguage.getLanguageTyep() != null)
		language = ResumeUtil.getLanguageById(myLanguage.getLanguageTyep().toString());
		return language;
	}

	public String getMastery() {
		if(myLanguage.getMastery() != null)
		mastery = ResumeUtil.getLanguageLevelById(myLanguage.getMastery().toString());
		return mastery;
	}

	public String getLiteracy() {
		if(myLanguage.getLiteracy() != null)
		literacy = ResumeUtil.getLanguageLevelById(myLanguage.getLiteracy().toString());
		return literacy;
	}

	public String getListenAndSpeak() {
		if(myLanguage.getListenAndSpeak() != null)
		listenAndSpeak = ResumeUtil.getLanguageLevelById(myLanguage.getListenAndSpeak().toString());
		return listenAndSpeak;
	}

	
	public String getJsonString(){
		return JsonUtils.getJsonString4JavaPOJO(this.myLanguage);
	}
	
	
	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}

}
