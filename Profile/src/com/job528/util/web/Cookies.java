package com.job528.util.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author keane
 * 
 * 
 */

public class Cookies {

	public int maxAge;

	public String path;

	public Cookies() {
		maxAge = 24 * 60 * 60;
		path = "/";
	}

	Cookie[] cookie_get = {};

	/**
	 * Put cookie to the client
	 * 
	 * @param response
	 * @param name
	 * @param value
	 */
	public void putCookie(HttpServletResponse response, String name, String value, String domain) {
		try {
			Cookie cookie = new Cookie(name, encode(value));
			cookie.setMaxAge(24 * 60 * 60);
			cookie.setPath("/");
			if ((domain != null) && (domain != "")) {
				cookie.setDomain(domain);
			}
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * get cookie from client
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public String getCookie(HttpServletRequest request, String name) {
		if (cookie_get == null || cookie_get.length == 0) {
			cookie_get = request.getCookies();
		}
		String returnStr;
		returnStr = null;
		try {
			for (int i = 0; cookie_get != null && i < cookie_get.length; i++) {
				cookie_get[i].setPath(path);
				if (cookie_get[i].getName().equals(name)) {
					cookie_get[i].setMaxAge(24 * 60 * 60);
					returnStr = cookie_get[i].getValue();
					break;
				}
			}
			return decode(returnStr);
		} catch (Exception e) {
			return decode(returnStr);
		}
	}

	/**
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param name
	 *            String
	 */
	public void removeCookie(HttpServletResponse response, String name, String domain) {
		putCookie(response, name, null, domain);
	}

	/**
	 * 
	 * @param value
	 *            String
	 * @return String
	 */
	private static String decode(String value) {
		String result = "";
		if (!isEmpty(value)) {
			try {
				result = java.net.URLDecoder.decode(value, "utf-8");
			} catch (UnsupportedEncodingException ex) {

			}
		}
		return result;
	}

	/**
	 * 
	 * @param value
	 *            String
	 * @return String
	 */
	private static String encode(String value) {
		String result = "";
		if (!isEmpty(value)) {
			try {
				result = java.net.URLEncoder.encode(value, "utf-8");
			} catch (UnsupportedEncodingException ex) {

			}
		}
		return result;
	}

	/**
	 * 
	 * @param value
	 *            String
	 * @return boolean
	 */
	private static boolean isEmpty(String value) {
		if (value == null || value.trim().equals(""))
			return true;
		else
			return false;
	}

}
