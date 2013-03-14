package com.job528.profile.action;


import java.util.List;


import com.job528.profile.model.MyLanguage;
import com.job528.profile.model.MyResume;
import com.job528.profile.vo.Language;
import com.job528.profile.vo.LanguageAbility;
import com.job528.profile.vo.Resume;
import com.job528.util.StringUtil;

public class LanguageOldAction extends ResumeAction {
	


	private LanguageAbility languageAbility;
	
	
	public String execute() {
		
		String did = this.getParameter("did");
		if(StringUtil.isValidStr(did)){
			resumeService.delMyLanguageById(Integer.parseInt(did));
		}else if(StringUtil.isValidStr(this.getParameter("languageTyep"))){
			MyLanguage myLanguage = new MyLanguage();
			myLanguage.setLanguageTyep(Integer.parseInt(this.getParameter("languageTyep")));
			myLanguage.setListenAndSpeak(Integer.parseInt(this.getParameter("listenAndSpeak")));
			myLanguage.setLiteracy(Integer.parseInt(this.getParameter("literacy")));
			myLanguage.setMastery(Integer.parseInt(this.getParameter("mastery")));
			myLanguage.setMyUserId(getUserId());
			myLanguage.setResId(this.getLoginResume().getMyResume().getResId());
			myLanguage.setChEn(0);
			if(StringUtil.isValidStr(this.getParameter("languageId"))){
				myLanguage.setLanguageId(Integer.parseInt(this.getParameter("languageId")));
			}
			resumeService.addorUpdateDateMyLanguage(myLanguage);
		}else if(StringUtil.isValidStr(this.getParameter("engLevel"))){
			Resume resume = getLoginResume();
			MyResume myResume = resume.getMyResume();
			myResume.setEngLevel(Integer.parseInt(this.getParameter("engLevel")));
			myResume.setJapanLevel(Integer.parseInt(this.getParameter("japanLevel")));
			myResume.setToefl(Integer.parseInt(this.getParameter("toefl")));
			myResume.setGmat(Integer.parseInt(this.getParameter("gmat")));
			myResume.setGre(Integer.parseInt(this.getParameter("gre")));
			myResume.setIelts(Integer.parseInt(this.getParameter("ielts")));
			resumeService.updateResume(myResume,false);
			resume.setMyResume(myResume);
			setLoginResume(resume);
		}
		
		languageAbility = new LanguageAbility();
		List<MyLanguage> languages = resumeService.getLanguageByUserId(this.getUserId());
		if(languages != null && languages.size() > 0){
			for (MyLanguage myLanguage : languages) {
				Language language = new Language();
				language.setMyLanguage(myLanguage);
				languageAbility.getLanguages().add(language);
			}
		}
		
		MyResume myResume = this.getLoginResume().getMyResume();
		languageAbility.setMyResume(myResume);
		return SUCCESS;
	}
	
	
	public LanguageAbility getLanguageAbility() {
		return languageAbility;
	}




	public void setLanguageAbility(LanguageAbility languageAbility) {
		this.languageAbility = languageAbility;
	}
	
}
