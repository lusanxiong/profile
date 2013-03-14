package com.job528.service;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.job528.ejb.entity.Weibo;
import com.job528.profile.model.IpAddress;

import edu.emory.mathcs.backport.java.util.Arrays;

/*
 * 输出Bean的工具类，
 */
public class PrintBean {
	
	/*
	 * 打印Bean的属性值
	 */
	public static void PrintBeanProperty(Object obj) {
		Class<?> beanClass = obj.getClass();
		Field[] fields = beanClass.getDeclaredFields();
		
		String class_name = beanClass.getName(); 
		System.out.println("类===="+class_name+"====属性值如下===========");
		
		StringBuilder sb = new StringBuilder();
		for(Field field : fields) {
			String name = field.getName();
			
			//System.out.println("name="+name);
			try {
				PropertyDescriptor pd = new PropertyDescriptor(name, beanClass);
				Method method = pd.getReadMethod();
				
				sb.append(name+"="+method.invoke(obj)).append("\n");
			} catch (IntrospectionException e1) {
				e1.printStackTrace();
			}catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}  
		}
		
		System.out.println(sb.toString());
	}
	
	public static void PrintBeanMethod(Object obj) {
		Class<?> beanClass = obj.getClass();
		Field[] fields = beanClass.getDeclaredFields();
		
		String class_name = beanClass.getName(); 
		System.out.println("类===="+class_name+"====方法如下===========");
		
		Method[] methods = beanClass.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
		}
		
	}
	
	public static void PrintSetMethod(Object obj) {
		Class<?> beanClass = obj.getClass();
		
		String class_name = beanClass.getName(); 
		String class_simpleName = beanClass.getSimpleName();
		String objSimpleName = class_simpleName.substring(0,1).toLowerCase();
		objSimpleName = objSimpleName + class_simpleName.substring(1,class_simpleName.length()-1);
		System.out.println("类===="+class_name+"====方法如下===========");
		
		Method[] methods = beanClass.getDeclaredMethods();
		for(Method m : methods) {
			if(m.getName().startsWith("get")) {
				continue;
			}
			System.out.println(objSimpleName+"."+m.getName()+"(\"\")");
		}
	}
	
	public static void PrintRequestField(Object obj) {
		Class<?> beanClass = obj.getClass();
		Field[] fields = beanClass.getDeclaredFields();
		
		String class_name = beanClass.getName(); 
		System.out.println("类===="+class_name+"====属性值如下===========");
		
		StringBuilder sb = new StringBuilder();
		
		int[] len = new int[fields.length];
		for(int i=0; i<fields.length; i++) {
			String name = fields[i].getName();
			len[i] = name.length();
		}
		
		for(int i=0; i<len.length; i++) {
			for(int j=i+1; j<len.length; j++) {
				if(len[i] > len[j]) {
					int temp = len[i];
					len[i]=len[j];
					len[j]=temp;
				}
			}
		}

		int maxLen = len[len.length-1];
		
		
		
		for(Field field : fields) {
			String name = field.getName();
			
			int spaceLen = maxLen - name.length();
			StringBuilder spaceSb = new StringBuilder();
			for(int i=0; i<spaceLen; i++) {
				spaceSb.append(" ");
			}
			System.out.println("String "+name+spaceSb.toString()+"= "+"request.getParameter(\""+name+"\");");
		}
		
		
	}
	
	public static void main(String[] args) {
		/*Weibo wb = new Weibo();
		wb.setIp("12");
		wb.setCommentNumber(123456);
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map m = new HashMap<String,String>();
		m.put("111", "222");
		m.put("1111", "2222");
		list.add(m);*/
		//wb.setList(list);
		//PrintBeanProperty(wb);
		
		PrintRequestField(new IpAddress());
	}
}
