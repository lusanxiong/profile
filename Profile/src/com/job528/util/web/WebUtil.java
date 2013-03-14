/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.job528.util.web;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.job528.util.StringConstants;
import com.job528.util.StringUtil;
import com.job528.util.collections.FormatMap;
import com.job528.util.log.MyLog;
import com.opensymphony.xwork2.ActionContext;


/**
 *  MyOA
 * @version 0.1
 *  at 2006-7-10 11:39:22
 * :provide common operations on web objects , such as request, cookie, session , and so on.
 */
public class WebUtil implements Serializable {
	private static final MyLog log = MyLog.getLogger(WebUtil.class);
	
	public static final String DOMAIN_CN=".528.cn";
	public static final String DOMAIN_COM_CN=".528.com.cn";

    public static Object getBean(ServletContext servletContext, String beanName) {
        WebApplicationContext context = WebApplicationContextUtils
            .getRequiredWebApplicationContext(servletContext);

        return context.getBean(beanName);

    }

    public static Map getParameterMap(HttpServletRequest request) {
        FormatMap paraMap = new FormatMap();

        if (null == request)
            return paraMap;

        // 加字符格式化，乱码问题 
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
        	log.error(e);
        }

        request.getParameterMap();

        // paraMap.putAll(map);
        //
        Enumeration names = request.getParameterNames();

        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            
            String[] values = request.getParameterValues(name);
            
            if (1 == values.length) {
                if (StringUtil.isValidStr(values[0]))
                    paraMap.put(name, values[0]);
                else
                    paraMap.put(name, "");
            } else
                paraMap.put(name, values);
        }

        //paraMap.put(ParamConstants.REQUEST_URI, request.getRequestURI());
        //paraMap.put(ParamConstants.REQUEST_URL, getRequestURL(request));

        //paraMap.put(ParamConstants.USER_IP, request.getRemoteAddr());

        //paraMap.put(ParamConstants.SESSION_ID, request.getSession().getId());

        return paraMap;
    }

    public static List getSafeList(HttpServletRequest request, String paramName) {
        Object obj = request.getAttribute(paramName);

        if (null == obj)
            return Collections.EMPTY_LIST;

        return (List) obj;
    }

    /**
     * 
     * @param request
     * @return
     */
    public static String getRequestURL(HttpServletRequest request) {
        StringBuffer requestURL = new StringBuffer();

        Enumeration enumParam = request.getParameterNames();
        while (enumParam.hasMoreElements()) {
            String name = (String) enumParam.nextElement();

            String[] values = request.getParameterValues(name);

            requestURL.append("&").append(name).append("=").append(values[0]);
        }

        if (0 < requestURL.length()) {
            requestURL.deleteCharAt(0);

            requestURL.insert(0, "?");
        }

        requestURL.insert(0, request.getRequestURI());

        return requestURL.toString();
    }

    /**
     * 
     * @param req
     */
    public static void saveURL(HttpServletRequest req) {
        StringBuffer requestURL = new StringBuffer(req.getRequestURI());
        requestURL.append('?');
        requestURL.append(req.getQueryString());

        req.getSession().setAttribute(ParamConstants.FORWARD_PAGE, requestURL.toString());

    }

    public static String getParameter(HttpServletRequest request, String param) {
        String ret = request.getParameter(param);

        return null == ret ? StringConstants.EMPTY_STRING : ret.trim();
    }

    /**
     * 
     * @param request
     * @param param
     * @param isChinese
     * @return
     */
    public static String getParameter(HttpServletRequest request, String param, boolean isChinese) {
        String ret = getParameter(request, param);

        // if (isChinese && !ret.equals(""))
        // return toChineseStr(ret);
        return ret;
    }

    public static BigDecimal getParameterBigDecimal(HttpServletRequest request, String param) {
        String inputStr = getParameter(request, param);
        return StringUtil.getBigDecimal(inputStr);
    }

    public static int getParameterInt(HttpServletRequest request, String param) {
        String inputStr = getParameter(request, param);
        return Integer.parseInt(inputStr);
    }

    public static int getParamIntSafely(HttpServletRequest request, String param) {
        String str = request.getParameter(param);
        if (StringUtil.isValidStr(str))
            return 0;

        return Integer.parseInt(str);
    }

    public static double getParamDoubleSafely(HttpServletRequest request, String param) {
        String str = request.getParameter(param);
        if (StringUtil.isValidStr(str))
            return 0;
        return Double.parseDouble(str);
    }

    public static boolean getParameterBoolean(HttpServletRequest request, String param) {
        String inputStr = getParameter(request, param);

        return inputStr.equals(StringConstants.TRUE) ? true : false;
    }


    public static String toChineseStr2(String strOrigin) {
        if (StringUtil.isValidStr(strOrigin)) {
            try {
                return new String(strOrigin.trim().getBytes("ISO8859_1"), "GBK");
            } catch (Exception e) {
            	log.error(e);
            }
        }

        return StringConstants.EMPTY_STRING;
    }


    public static String getErrorForward(HttpServletRequest request, String message) {
        // log.error(message);
        return forward(request, message, GlobalForward.FORWARD_TO_ERROR);
    }

    public static String forward(HttpServletRequest request, String messgae, String forward) {
        request.setAttribute(ParamConstants.MESSAGE, messgae);

        return forward;
    }

    public static String getIpAddr(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	}
    

    
    /**
	 * get domain 
	 * @param request
	 * @return
	 */
	public static String getDomain(HttpServletRequest request){
		String path = request.getServerName();
		if (path.contains(DOMAIN_COM_CN.substring(1))) {
			return DOMAIN_COM_CN;
		}else if(path.contains(DOMAIN_CN.substring(1))) {
			return DOMAIN_CN;
		}
		return "";
	}
    
    
    @SuppressWarnings("unchecked")
	public static Map getSession() {
		return ActionContext.getContext().getSession();
	}

    public static void putSession(Object key, Object value) {
		getSession().put(key, value);
	}

	public static Object getFromSession(Object key) {
		return getSession().get(key);
	}
}
