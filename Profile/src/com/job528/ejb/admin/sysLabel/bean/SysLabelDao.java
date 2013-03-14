package com.job528.ejb.admin.sysLabel.bean;



import com.job528.ejb.entity.Label;
import com.job528.ejb.entity.Pager;

public interface SysLabelDao {
	/**
	 * 添加系统标签
	 * @param label
	 * @return 0-添加成功 ，100-标签已存在 ，500-添加失败
	 */
  public Integer saveSysLabel(Label label);
  
  
  /**
   * 修改系统标签 
   * @param label labelId
   * @return 
   */
  public boolean updateSysLabel(Label label,int labelId);
  
  /**
   * 删除标签
   * @param labelId
   * @return
   */
  public boolean delLabel(int labelId);
  /**
   * 分页查询标签
   * @param pageNo
   * @param pageSize
   * @param type
   * @return
   */
  public Pager<Label> getLabelInfo(Integer pageIndex,Integer pageSize,int type);
  
  /**
   * 批量删除标签
   * @param labelIdStr
   * @return
   */
  public boolean delBacthLabel(String labelIdStr);
}
