package com.job528.profile.service;

import java.util.List;

import com.job528.ejb.entity.Label;
import com.job528.ejb.entity.LabelResult;

public interface ILabelService {

	/**
	 * 保存标签
	 * @param label 
	 * @param userId 当前用户id 从cookie中取
	 * @return(0:已存在标签，1:添加标签成功 ,-1:添加标签失败)
	 */
	public LabelResult saveLabel(Label label,Integer userId);
	
	
		
	/**
	 * 删除用户自己的标签
	 * @param 用户userId
	 * @param id
	 */
	public Integer deleteLabel(Integer id,Integer userId);

	/**
	 * 查询热门标签
	 * @return List<Lable>
	 */
	public List<Label> getHotLabel();
	
	/**
	 * 查询用户个人标签
	 * @param userId
	 * @return List<Lable>
	 */
	public List<Label> getLabelById(Integer userId);
   
	
	/**
	 *  查询所有标签
	 * @return List<Lable>
	 */
	public List<Label> getNextLabel();

}
