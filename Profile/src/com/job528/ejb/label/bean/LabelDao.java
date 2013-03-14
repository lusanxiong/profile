package com.job528.ejb.label.bean;

import java.util.List;

import com.job528.ejb.entity.Label;
import com.job528.ejb.entity.LabelResult;

public interface LabelDao {
	/**
	 * 保存标签
	 * @param label 
	 * @param userId 当前用户id 从cookie中取
	 * @return
	 */
	public LabelResult saveLabel(Label label,Integer userId);
	
	
		
	/**
	 * 删除用户自己的标签(1:删除成功，-1删除失败)
	 * @param 用户userId
	 * @param id
	 */
	public Integer deleteLabel(Integer id,Integer userId);

	/**
	 * 查询热门标签
	 * @return
	 */
	public List<Label> getHotLabel();
	
	
	/**
	 * 查询用户个人标签 
	 * @param 用户的userId
	 */
	
	public List<Label> getLabelById(Integer userId);

	/**
	 * 查询所有标签
	 * @return List<Label>
	 */
	public List<Label> getNextLabel();
	
}
