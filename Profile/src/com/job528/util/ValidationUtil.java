package com.job528.util;

import java.util.Collection;
import java.util.Map;


public class ValidationUtil {
	

	@SuppressWarnings("unchecked")
	public static boolean isEmpty(Object obj) {
		if (obj instanceof String) {
			return isEmpty((String)obj);
		} else if (obj instanceof Collection) {
			return isEmpty((Collection)obj);
		} else if (obj instanceof Map) {
			return isEmpty((Map)obj);
		}else if (obj instanceof Object[]) {
			return isEmpty((Object[])obj);
		} else {
			return isNull(obj);
		}		
	}
	

	public static boolean isEmpty(String strObject) {
		return (strObject == null || strObject.trim().equals(""));
	}


	@SuppressWarnings("unchecked")
	public static boolean isEmpty(Collection c) {
		return (c == null || c.size() == 0);
	}
	

	@SuppressWarnings("unchecked")
	public static boolean isEmpty(Map map) {
		return (map == null || map.size() == 0);
	}
	

	public static boolean isEmpty(Object objArray[]) {		
		return (objArray == null || objArray.length == 0);
	}
	

	public static boolean isNull(Object obj) {
		return (obj == null);
	}
	

	public static boolean isValidEmailAddress(String email) {
		String regex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[_A-Za-z-]+)";
		return email.matches(regex);
	}

	public static void main(String args[]){
		System.out.print("ValidationUtil:aaaaa@163.com" + ValidationUtil.isValidEmailAddress("aaaaa@163.com"));
	}
}
