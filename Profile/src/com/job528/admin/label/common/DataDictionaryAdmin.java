package com.job528.admin.label.common;

/**
 * 后台公用数据字典类
 * 
 * @author:sanxionglu
 * 
 */
public class DataDictionaryAdmin {
	  
	 
	/*
	 * 标签来源分类
	 */
	public enum LabelSourceType {
		SYSTME_LABEL(0), //系统标签
		USER_LABEL(1), //用户标签
		ALL_LABEL(2); //所有标签
		
		private int type;
		private LabelSourceType(int type) {
			this.type = type;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.type);
		}
	}
	
	/**
	 * 自定义RESULT返回类型
	 * @param args
	 */
	public enum ActionResult {
		JSON_SUCCESS("jsonSuccess"); //返回json格式时
		
		private String name;
		private ActionResult(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return String.valueOf(name);
		}
		
	 
	}
	
}
