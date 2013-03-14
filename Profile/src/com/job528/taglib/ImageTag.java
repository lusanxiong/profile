package com.job528.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;
/**
 * 自定义标签
 * @author Sunday
 */
@SuppressWarnings("serial")
public class ImageTag extends ComponentTagSupport {

	private String value;
	private String basePath;
	
	@Override
	protected void populateParams() {
		super.populateParams();
		Image img = (Image)component;
		img.setValue(value);
		img.setBasePath(basePath);
	}
	
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		setBasePath((String)request.getAttribute("basePath"));
		return new Image(stack);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
}

