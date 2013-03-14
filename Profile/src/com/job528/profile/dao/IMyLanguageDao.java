package com.job528.profile.dao;

import java.util.List;

import com.job528.profile.model.MyLanguage;

public interface IMyLanguageDao {
	
	public List<MyLanguage> getMyLanguageByUserId(Integer userId);
	
	public List<MyLanguage> getMyLanguageById(Integer id,Integer userId);
	
	
    public void delMyLanguageById(Integer languageId);
	
	
	public void upDateMyLanguage(MyLanguage myLanguage);
}
