package com.job528.util.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.job528.lucene.LuceneManager;
import com.job528.util.StringUtil;

public class SetPropertiesUtil {
	
	public SetPropertiesUtil(){}
	private static Properties props = new Properties(); 
	static{
		try {
			//getContextClassLoader线程加载器可以实现动态加载Properties属性文件 
			String path = StringUtil.getWebRootFilePath(SetPropertiesUtil.class) + "set.properties";
			System.out.println("path=="+path);
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			props.load(in);
			
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
    
    
    public static void main(String[] args) {
    	String indexPath = getValue("userIndexPath");
    	System.out.println("indexPath=="+indexPath);
    }
    
}
