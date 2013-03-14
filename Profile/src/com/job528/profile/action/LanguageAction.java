package com.job528.profile.action;


import java.util.List;


import com.job528.profile.model.MyLanguage;
import com.job528.profile.model.MyResume;
import com.job528.profile.vo.Language;
import com.job528.profile.vo.LanguageAbility;
import com.job528.profile.vo.Resume;
import com.job528.util.StringUtil;

public class LanguageAction extends ResumeAction {

	private static final long serialVersionUID = 1L;
	private LanguageAbility languageAbility;
	
	public String execute() {
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
	
	public String all() {
		return execute();
	}
	
	public String edit() {
		Integer id = StringUtil.toInteger(request.getParameter("id"), 0);
		languageAbility = new LanguageAbility();
		List<MyLanguage> languages = resumeService.getLanguageById(id,this.getUserId());
		if(languages != null && languages.size() > 0){
			Language language = new Language();
			language.setMyLanguage(languages.get(0)); //单条查询,最多只有一条
			languageAbility.getLanguages().add(language);
		}
		MyResume myResume = this.getLoginResume().getMyResume();
		languageAbility.setMyResume(myResume);
		return SUCCESS;
	}
	
	public String back() {
		return edit();
	}
	
	public String del() {
		Integer id = StringUtil.toInteger(request.getParameter("id"),0);
		resumeService.delMyLanguageById(id);
		return null;
	}
	
	public String add() {
		languageAbility = new LanguageAbility();
		Language language = new Language();
		language.setMyLanguage(new MyLanguage());
		languageAbility.getLanguages().add(language);
		return SUCCESS;
	}
	
	public String merge() {
		MyLanguage myLanguage = new MyLanguage();
		myLanguage.setLanguageTyep(Integer.parseInt(this.getParameter("languageTyep")));
		myLanguage.setListenAndSpeak(Integer.parseInt(this.getParameter("listenAndSpeak")));
		myLanguage.setLiteracy(Integer.parseInt(this.getParameter("literacy")));
		myLanguage.setMastery(Integer.parseInt(this.getParameter("mastery")));
		myLanguage.setMyUserId(getUserId());
		myLanguage.setResId(this.getLoginResume().getMyResume().getResId());
		myLanguage.setChEn(0);
		if(StringUtil.isValidStr(this.getParameter("id"))){
			myLanguage.setLanguageId(Integer.parseInt(this.getParameter("id")));
		}
		resumeService.addorUpdateDateMyLanguage(myLanguage);
		return SUCCESS;
	}
	
	
	public String toeflShow() {
		return toeflEdit();
	}
	
	public String toeflEdit() {
		languageAbility = new LanguageAbility();
		MyResume myResume = this.getLoginResume().getMyResume();
		languageAbility.setMyResume(myResume);
		return SUCCESS;
	}
	
	public String toeflUpdate(){
		Resume resume = getLoginResume();
		MyResume myResume = resume.getMyResume();
		myResume.setEngLevel(StringUtil.toInteger(this.getParameter("engLevel"),0));
		myResume.setJapanLevel(StringUtil.toInteger(this.getParameter("japanLevel"),0));
		myResume.setToefl(StringUtil.toInteger(this.getParameter("toefl"),0));
		myResume.setGmat(StringUtil.toInteger(this.getParameter("gmat"),0));
		myResume.setGre(StringUtil.toInteger(this.getParameter("gre"),0));
		myResume.setIelts(StringUtil.toInteger(this.getParameter("ielts"),0));
		resumeService.updateResume(myResume,false);
		resume.setMyResume(myResume);
		setLoginResume(resume);
		return null;
	}
	
	
	public LanguageAbility getLanguageAbility() {
		return languageAbility;
	}




	public void setLanguageAbility(LanguageAbility languageAbility) {
		this.languageAbility = languageAbility;
	}
	
}
