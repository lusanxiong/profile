package com.job528.profile.service.impl;

import java.util.List;

import com.job528.ejb.entity.Label;
import com.job528.ejb.entity.LabelResult;
import com.job528.ejb.label.bean.LabelDao;
import com.job528.profile.service.ILabelService;

public class LabelServiceImpl implements ILabelService {
	
	private LabelDao labelDao;

	public LabelDao getLabelDao() {
		return labelDao;
	}

	public void setLabelDao(LabelDao labelDao) {
		this.labelDao = labelDao;
	}

	@Override
	public Integer deleteLabel(Integer id, Integer userId) {
		return labelDao.deleteLabel(id, userId);
	}

	@Override
	public List<Label> getHotLabel() {
		return labelDao.getHotLabel();
	}

	@Override
	public LabelResult saveLabel(Label label, Integer userId) {
		return labelDao.saveLabel(label, userId);
	}
	
	@Override
	public List<Label> getLabelById(Integer userId){
		return labelDao.getLabelById(userId);
	}

	@Override
	public List<Label> getNextLabel() {
	
		return labelDao.getNextLabel();
	}
	
	

}
