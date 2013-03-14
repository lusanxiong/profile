package com.job528.admin.label.service;

import java.util.List;


import com.job528.ejb.admin.dto.LabelDTO;
import com.job528.ejb.entity.Label;
import com.job528.util.Pager;



public interface IAdminLabelService {
	/**
	 * 分页获取标签
	 * @param pageNo
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public Pager<List<LabelDTO>> getLabelInfo(int pageNo,int pageSize,int type);
	
	/**
	 * 删除标签
	 * @param labelId
	 * @return true代表成功，false代表失败
	 */
	public boolean delLabel(int labelId);
	
	/**
	 * 
	 * @param label
	 * @param labelId
	 * @return true更新标签成功  ，false 更新标签失败
	 */
	public  boolean updateLabel(Label label,int labelId);
	
	/**
	 * 批量删除标签
	 * @param labelIdStr
	 * @return
	 */
	public boolean delBacthLabel(String labelIdStr);
	
	/**
	 * 添加标签
	 * @param label
	 * @return 0-添加成功 ，100-标签已存在 ，500-添加失败
	 */
	public Integer saveSysLabel(Label label);
}
