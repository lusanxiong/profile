package com.job528.util.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job528.util.StringUtil;


public class CookieUtils {
	/**
     * Returns the specified cookie, or <tt>null</tt> if the cookie
     * does not exist. Note: because of the way that cookies are implemented
     * it's possible for multiple cookies with the same name to exist (but with
     * different domain values). This method will return the first cookie that
     * has a name match.
     *
     * @param request the servlet request.
     * @param name the name of the cookie.
     * @return the Cookie object if it exists, otherwise <tt>null</tt>.
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie cookies[] = request.getCookies();
        // Return null if there are no cookies or the name is invalid.
        if (cookies == null || name == null || name.length() == 0) {
            return null;
        }
        // Otherwise, we  do a linear scan for the cookie.
        Cookie cookie = null;
        for (int i = 0; i < cookies.length; i++) {
            // If the current cookie name matches the one we're looking for, we've
            // found a matching cookie.
        	cookie = cookies[i];
        	// LOG.info("ServerName = " + request.getServerName() + " , Domain = " + cookies[i].getDomain() + " , name = " + name + " , " + cookies[i].getValue());
        	// LOG.info("name = " + cookie.getName() + " , value = " +  cookie.getValue() + " , path = " + cookie.getPath());
            // if (cookie.getName().equals(name) && "/".equals(cookie.getPath())) {
            if (cookie.getName().equals(name)) {
            	return cookie;
                // The best matching cookie will be the one that has the correct
                // domain name. If we've found the cookie with the correct domain name,
                // return it. Otherwise, we'll keep looking for a better match.
            	// FIXME 暂不校是否属于同一个域  
            	/*
                if (request.getServerName().equals(cookies[i].getDomain())) {
                	return cookies[i];
                }
                */
            }
        }
        return null;
    }
    
    /**
     * 取cookie中<code>name</code>对应的值
     * @param request the servlet request.
     * @param name the name of the cookie.
     * @return the value if it exists, otherwise <tt>null</tt>.
     */
    public static String getCookieValue(HttpServletRequest request, String name){    	
    	Cookie cookie = getCookie(request, name);
    	return (cookie != null) ? cookie.getValue() : null;
    }

    /**
     * Deletes the specified cookie.
     *
     * @param request the servlet request.
     * @param response the servlet response.
     * @param cookie the cookie object to be deleted.
     * @param path the path.
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, Cookie cookie, String path){
        if (cookie != null) {
            // Invalidate the cookie
        	if (!StringUtil.isValidStr(path)) {
                path = "/";
            }
            cookie.setPath(path);
            cookie.setValue("");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
    
    /**
     * Stores a value in a cookie. This cookie will persist for the amount
     * specified in the <tt>saveTime</tt> parameter.
     *
     * @see #setCookie(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,String,String)
     * @param request the servlet request.
     * @param response the servlet response.
     * @param name a name to identify the cookie.
     * @param value the value to store in the cookie.
     * @param maxAge the time (in seconds) this cookie should live.
     * @param domain the domain.
     * @param path the path.
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int maxAge, String domain, String path){
        // Check to make sure the new value is not null (appservers like Tomcat
        // 4 blow up if the value is null).
        if (value == null) {
            value = "";
        }
        if (!StringUtil.isValidStr(path)) {
            path = "/";
        }
        Cookie cookie = new Cookie(name, value);        
        // maxAge大于0时cookie的maxAge
        if(maxAge > 0){
        	cookie.setMaxAge(maxAge);
        }
        cookie.setPath(path);
        // domain不为空则cookie的domain
        if(StringUtil.isValidStr(domain)){
        	cookie.setDomain(domain);
        }        
        response.addCookie(cookie);
    }
    
  
    /**
     * 取cookie中<code>name</code>对应的值
     * type判断是否需要utf-8解码
     * @param request the servlet request.
     * @param name the name of the cookie.
     * @return the value if it exists, otherwise <tt>null</tt>.
     */
    public static String  getCookieValue(HttpServletRequest request,String name ,int type){
		
		try {
			String value = CookieUtils.getCookieValue(request,name);
			if(type == 1){
				return  value;
			}else{//type=2
				return URLDecoder.decode(value,"UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
