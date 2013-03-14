package com.job528.ejb.entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Pager<E> implements Serializable{

	private Integer count;
	private List<E> list;
	
	public Pager() {
	}
	
	public Pager(Integer count,List<E> list) {
		this.count = count;
		this.list = list;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
}
