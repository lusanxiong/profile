package com.job528.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsSpringTestCase;
import org.apache.struts2.StrutsTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.job528.profile.action.recommendPosition.RecommendPostionToFriendAction;
import com.job528.util.web.DateConverter;
import com.job528.util.webwork.GenericAction;
import com.opensymphony.xwork2.ActionProxy;

@RunWith(SpringJUnit4ClassRunner.class)  //使用spring junit运行器
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"}) //加载配置文件
public class TestAction extends StrutsSpringTestCase{
	
	public RecommendPostionToFriendAction recommendPostionToFriendAction;
	static {
		ConvertUtils.register(new DateConverter(), Date.class);
	}
	
	@Test
	public void testExecute() {
		
	   MockHttpServletResponse response = new MockHttpServletResponse(); 
	   MockHttpServletRequest request = new MockHttpServletRequest(); 
	   MockHttpSession session = new MockHttpSession();
	   request.setSession(session);
	   ServletActionContext.setResponse(response);
	   request.setParameter("test", "lusanxiong");
	   ServletActionContext.setRequest(request);
	   
	   System.out.println("============");
	  //RecommendPostionToFriendAction action = new RecommendPostionToFriendAction();
	   recommendPostionToFriendAction.recommendPositionToFriend();
	}

	public RecommendPostionToFriendAction getRecommendPostionToFriendAction() {
		return recommendPostionToFriendAction;
	}

	public void setRecommendPostionToFriendAction(
			RecommendPostionToFriendAction recommendPostionToFriendAction) {
		this.recommendPostionToFriendAction = recommendPostionToFriendAction;
	}
	
	
	
	 
}
