package com.job528.util.webwork;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job528.common.DataDictionary.SessionAttrName;
import com.job528.profile.LoginInfo;
import com.job528.util.StringUtil;
import com.job528.util.log.MyLog;


/**
 */
@SuppressWarnings("serial")
public class LoginFilter implements Filter, Serializable {
	private static final MyLog log = MyLog.getLogger(LoginFilter.class);
	
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
    	String[] ingoreURL = {"/js","/images","/css","taglib.jsp","login.jsp","test2.jsp","sinaWeiboCallBack.jsp",
    			"regUserSynWeibo.shtml","LoginSynWeibo.shtml","LoginSynWeibo.shtml",
    			"logOut.shtml","sessionPrint.jsp","callback.jsp","home.shtml","tencentToken.shtml"}; //忽略列表，代表访问此路径下不需要登录
    	
    	//如果未登陆,提示先登陆
        if (request instanceof HttpServletRequest) {
        	String userId = "";
        	HttpServletRequest  req = (HttpServletRequest)request;
        	
        	//如果是忽略列表的路径，则不需要登录
        	for(int i=0; i<ingoreURL.length; i++) {
        		if(req.getRequestURI().indexOf( ingoreURL[i]) > -1) {
        			chain.doFilter(request, response);
        			return;
        		}
        	}
        	
        	
        	Cookie[] cookies = req.getCookies();
        	if(null!=cookies){
        		String userIdKey = LoginInfo.LOGIN_USER_ID;
        		for(int i=0;i<cookies.length;i++){
        			if(cookies[i].getName().indexOf(userIdKey) > -1){
        				userId = cookies[i].getValue();
        				break;
        			}
        		}
        	}
        	
        	//登录未超时
        	if(StringUtil.isValidStr(userId)){
        		chain.doFilter(request, response);
        	}else{
        		System.out.println("url=="+req.getRequestURI());
        		
        		//登录超时，跳转到登录页
        		//req.setAttribute("errorMessage", "您未登录，请先登录！");
       		 	HttpServletResponse rep = (HttpServletResponse)response; 
       		 	//req.getRequestDispatcher("/login.html").forward(request, response);
       		 	
       		 	//记录用户上次访问的页面URL,登录后跳回用户上次访问的URL
   		 		HttpSession session = req.getSession();
   		 		session.setAttribute(SessionAttrName.USER_OPEN_HISTORY_URL.toString(), req.getRequestURI());
       		 		
       		    rep.sendRedirect(StringUtil.getBasePath(req)+"/login.jsp");
        	}

        } else {
            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig arg0) throws ServletException {

    }

}
