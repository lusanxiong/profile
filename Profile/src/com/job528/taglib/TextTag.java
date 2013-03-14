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
public class TextTag extends ComponentTagSupport {

	private String value;
	private boolean mark; //是否转义单引号
	private String basePath;
	
	@Override
	protected void populateParams() {
		super.populateParams();
		Text tag = (Text)component;
		tag.setValue(value);
		tag.setMark(mark);
		tag.setBasePath(basePath+"/biaoqing/");
	}
	
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		setBasePath((String)request.getAttribute("basePath"));
		return new Text(stack);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
}

