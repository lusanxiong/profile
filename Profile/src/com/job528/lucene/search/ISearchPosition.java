package com.job528.lucene.search;


import com.job528.lucene.bean.Condition;
import com.job528.lucene.bean.Pager;

public interface ISearchPosition { 
	
	public Pager searchIndex(Condition condition, Pager pager) throws Exception;
	
//	public void updateMemIndex(String filepath, List<MemSearchBean> list);
//	
//	public void deleteMemIndex(String filepath, List<String> posIDList);
//	
//	public void addMemIndex(String filepath, List<MemSearchBean> list);
	
}