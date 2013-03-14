package com.job528.profile.model;

public class Smile {

	private String name;
	private String path;
	
	public Smile() {
	}
	public Smile(String name,String path) {
		this.name = name;
		this.path = path;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
