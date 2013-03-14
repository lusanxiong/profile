package com.job528.ejb.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WeiboResult implements Serializable {
	private Weibo weibo;
	private Weibo forwardWeibo;
	
	public Weibo getWeibo() {
		return weibo;
	}
	public void setWeibo(Weibo weibo) {
		this.weibo = weibo;
	}
	public Weibo getForwardWeibo() {
		return forwardWeibo;
	}
	public void setForwardWeibo(Weibo forwardWeibo) {
		this.forwardWeibo = forwardWeibo;
	}
	
	
}
