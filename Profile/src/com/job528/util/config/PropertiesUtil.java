package com.job528.util.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	public PropertiesUtil(){}
	private static Properties props = new Properties(); 
	static{
		try {
			//getContextClassLoader线程加载器可以实现动态加载Properties属性文件 
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key){
		if(props.containsKey(key)) {
			return props.getProperty(key).trim();
		}
		
		return null;
	}

    public static void updateProperties(String key,String value) {    
            props.setProperty(key, value); 
    } 
}
