package com.job528.admin.label.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.job528.admin.label.service.IAdminLabelService;
import com.job528.ejb.admin.sysLabel.bean.SysLabelDao;
import com.job528.ejb.admin.dto.LabelDTO;
import com.job528.ejb.entity.Label;
import com.job528.util.Pager;



public class AdminLabelServiceImpl implements IAdminLabelService {
	private SysLabelDao sysLableDao;


	public SysLabelDao getSysLableDao() {
		return sysLableDao;
	}

	public void setSysLableDao(SysLabelDao sysLableDao) {
		this.sysLableDao = sysLableDao;
	}
	

	@Override
	public boolean delLabel(int labelId) {
		return sysLableDao.delLabel(labelId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<List<LabelDTO>> getLabelInfo(int pageNo, int pageSize, int type) {

		com.job528.ejb.entity.Pager<Label> list = sysLableDao.getLabelInfo(pageNo, pageSize, type);
		if(list == null) return null; 
		
		Pager  p = new Pager();

		List<LabelDTO> result = new ArrayList<LabelDTO>();
		for(Label label : list.getList()) {
			LabelDTO dto = new LabelDTO();
            dto.setId(label.getId());
            dto.setLabelName(label.getLabelName());
            dto.setLabelSource(label.getLabelSource());
            dto.setIsDisplay(label.getIsDisplay());
            dto.setLabelSort(label.getLabelSort());
            dto.setCreateDate(label.getCreateDate());
			result.add(dto);
		}
		p.setList(result);
		p.setTotalSize(list.getCount());	
		return p;
 
	}

	@Override
	public boolean updateLabel(Label label,int labelId) {
		
		return sysLableDao.updateSysLabel(label, labelId);
	}

	@Override
	public boolean delBacthLabel(String labelIdStr) {
		
		return sysLableDao.delBacthLabel(labelIdStr);
	}

	@Override
	public Integer saveSysLabel(Label label) {
		return sysLableDao.saveSysLabel(label);
	}

	 
	
	
}
