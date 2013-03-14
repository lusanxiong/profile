package com.job528.profile.vo;

import java.util.ArrayList;
import java.util.List;

import com.job528.profile.model.MyResume;
import com.job528.profile.util.ResumeUtil;

/**
 * 语言能力
 * @author flp
 *
 */
public class LanguageAbility extends BaseVO {
	private List<Language> languages = new ArrayList<Language>();
	private MyResume myResume;	
	private String englishLevel;
	private String englishLevelStr;
	private String japanLevel;
	private String japanLevelStr;
	 
	
	public String getEnglishLevel() {
		englishLevel = ResumeUtil.getEnglishLevelById(myResume.getEngLevel().toString());
		return englishLevel;
	}

	public String getJapanLevel() {
		japanLevel = ResumeUtil.getJapanLevelById(myResume.getJapanLevel().toString());
		return japanLevel;
	}
	
	
	
	public String getEnglishLevelStr() {
		englishLevelStr = " <option value=\""+myResume.getEngLevel()+"\" selected=\"selected\">"+getEnglishLevel()+"</option>";
		return englishLevelStr;
	}

	public String getJapanLevelStr() {
		japanLevelStr = " <option value=\""+myResume.getJapanLevel()+"\" selected=\"selected\">"+getJapanLevel()+"</option>";
		return japanLevelStr;
	}

	public MyResume getMyResume() {
		return myResume;
	}

	public void setMyResume(MyResume myResume) {
		this.myResume = myResume;
	}
	
	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	
	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}

}
