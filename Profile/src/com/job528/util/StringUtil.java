/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.job528.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.job528.util.log.MyLog;



public class StringUtil {
	private static final MyLog log = MyLog.getLogger(StringUtil.class);
	
	
	private static String regex_Integer= "^\\d+$";
    /**
     * @param str
     * @return
     */
    public static String convertStringIfNull(String str) {
        return null == str ? StringConstants.EMPTY_STRING : str;
    }

    /**
     * 判断是否是有效的字符串，空串为无效串
     * 
     * @param str
     * @return
     */
    public static boolean isValidStr(String str) {
        return null != str && 0 < str.trim().length();
    }

    /**
     * 将字符串的换行替换成HTML的换行符??
     * 
     * @param str
     * @return
     */
    public static String formatHtmlString(String str) {

        return str.replaceAll("\r\n", "<BR/>");
    }

    /**
     * 将数组中的字符，连成以,号分隔的形式 如果 obj 为null，并不抛出异常，直接返回为空
     * 
     * @param obj
     * @return
     */
    public static String joinStr(Object[] obj) {
        if (null == obj)
            return null;

        StringBuffer buffer = new StringBuffer();

        if (0 < obj.length)
            buffer.append(obj[0]);

        for (int m = 1; m < obj.length; m++) {
            buffer.append(StringConstants.COMMA).append(obj[m]);
        }

        return buffer.toString();
    }

    /**
     * 根据字符串转换为布尔值
     * 
     * @param str
     * @return
     */
    public static boolean getBooleanValue(String str) {
        return isValidStr(str) ? str.toLowerCase().trim().equals(StringConstants.TRUE) : false;
    }

    public static int getIntValue(String str, int defaultValue) {
    	if(!StringUtil.isValidStr(str))
    		return defaultValue;
    	Pattern pat = Pattern.compile(regex_Integer);
		Matcher mat = pat.matcher(str);
		while (mat.find()){
			defaultValue = Integer.parseInt(str);
		}

        return defaultValue;
    }

    public static BigDecimal getBigDecimal(String param) {
        if (StringUtil.isValidStr(param)) {
            try {
                return new BigDecimal(param);
            } catch (NumberFormatException e) {
            	log.error("StringUtil getBigDecimal NumberFormatException",e);
            }
        }

        return new BigDecimal(-1);
    }

    public static String describe(Object[] values) {
        StringBuffer buff = new StringBuffer();

        for (int m = 0; m < values.length; m++) {
            buff.append(values[m]).append(", ");
        }

        return buff.toString();
    }
    /**
     * 把一个二进制的字符串转换成long类型的数??added by xieyanhui
     * 
     * @param value 二进制字符串
     * @return long
     */
    public static long getBinaryStrToLong(String value) {
		long result = 0;
        if (null == value || (null != value && value.equals(""))){
        	log.error("StringUtil binaryStrToLong Exception：the paramter is null or empty");
            return result;
        }
		long mul = 1;
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(value);
		if (isNum.matches()) {
			int length = value.length();
			for (int i = length - 1; i >= 0; i--) {
				result += mul * (value.charAt(i) == '1' ? 1 : 0);
				mul *= 2;
			}
		} else {
			log.error("StringUtil binaryStrToLong Exception：the paramter is not a number string!");
		}
		return result;
	}
    
    public static long getStrTolong(String value) {
        long result = 0;
        if (null == value || (null != value && value.equals("")))
            return result;

        try {
            result = Long.parseLong(value);
        } catch (Exception e) {
        	log.error("StringUtil getStrTolong Exception",e);
        }
        return result;
    }

    public static double getStrTodouble(String value) {
        double result = 0;
        if (null == value || (null != value && value.equals("")))
            return result;
        try {
            result = Double.parseDouble(value);
        } catch (Exception e) {
        	log.error("StringUtil getStrTodouble Exception",e);
        }
        return result;
    }

    /**
     * 比较两个字符串是否相
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static boolean StringEquals(String str1, String str2) {
        if ((null == str1 || 0 == str1.length()) && (null == str2 || 0 == str2.length())) {
            return true;
        }
        return null != str1 && null != str2 && str1.equals(str2);
    }

    /**
     * 比较两个字符串是否相
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static boolean StringEquals1(String str1, String str2) {
        if ((null == str1 || 0 == str1.length()) && (null != str2 && 0 < str2.length())
            || (null != str1 && 0 < str1.length()) && (null == str2 || 0 == str2.length())) {
            return false;
        }
        if (null == str1 && null == str2) {
            return true;
        }
        return str1.equals(str2);
    }

    /**
     * 比较两个日期是否相等
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static boolean DateEquals1(Date date1, Date date2) {
        if ((null == date1) && (null != date2) || (null != date1) && (null == date2)) {
            return false;
        }
        if (null == date1 && null == date2) {
            return true;
        }

        return 0 == date1.compareTo(date2);
    }

    /**
     * 比较两个字符串是否相
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static boolean StringEquals2(String str1, String str2) {
        if (null == str1 && null == str2) {
            return false;
        }
        return StringEquals(str1, str2);
    }

    public static String toZeroIfNull(String str) {
        return null == str ? "00:00" : str;
    }
    
    /**
     * 四舍五入保留N 为小
     * 
     * add by shengwei.zuo 2010-1-19
     * 
     * @param x
     * @param n
     * @return
     */
    public static double Baoliu(double x,int n){ 
	    double p= Math.pow(10, n); 
	    return Math.round( x * p ) / p; 
    } 
    
    /**
     * 替换特殊字符
     * @param srcStr
     * @return
     */
    public static String replaceSpecialStr(String srcStr){
    	srcStr = srcStr.replaceAll("\r\n", "<br/>&nbsp;&nbsp;");
    	srcStr = srcStr.replaceAll("\n\r", "&nbsp;&nbsp;<br/>");
    	srcStr = srcStr.replaceAll("\r", "<br/>");
    	srcStr = srcStr.replaceAll("\n", "&nbsp;&nbsp;");
    	srcStr = srcStr.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
    	return srcStr;
    }
    
    /**
     * 删除字符串最后一个字
     * @param srcStr
     * @param charToDelete
     */
    public static String deleteLastChar(String srcStr,char charToDelete){
    	if(isValidStr(srcStr) && srcStr.lastIndexOf(charToDelete) == srcStr.length() - 1){
    		srcStr = srcStr.substring(0, srcStr.length() - 1);
    	}
    	return srcStr;
    }
    
    /**

     * 提供精确的小数位四舍五入处理,舍入模式采用ROUND_HALF_EVEN    add by shengwei.zuo  2010-6-4

     * @param v 四舍五入的数

     * @param scale 小数点后保留几位

     * @return 四舍五入后的结果

     */

    public static double roundDouble(double v,int scale)

    {
        return roundBaseFun(v, scale, BigDecimal.ROUND_HALF_EVEN);
    }
    
    
    /**

     * 提供精确的小数位四舍五入处理  

     * @param v ????四舍五入的数??

     * @param scale 小数点后保留几位

     * @param round_mode 指定的舍入模??

     * @return 四舍五入后的结果

     */

    public static double roundBaseFun(double v, int scale, int round_mode)
    {
       if(scale<0)
    	   
       {
    	   
           throw new IllegalArgumentException("The scale must be a positive integer or zero");
           
       }
       
       BigDecimal b = new BigDecimal(Double.toString(v));

       return b.setScale(scale, round_mode).doubleValue();

    }
    
    
	/**
    	 * 根据数组转换成sql条件的stringBuffer
    	 * @param buffer
    	 * @param params
    	 * @param field
    	 */
    	public static void compositeHSql(StringBuffer buffer, Object[] params, String field) {

            if (null != params) {
                if (1 == params.length) {
                    buffer.append(StringConstants.AND).append(field).append("  = ? ");

                } else if (1 < params.length) {

                    buffer.append(StringConstants.AND).append(field).append(StringConstants.SPACE)
                        .append(" in ( ? ");
                    for (int m = 1; m < params.length; m++) {
                        buffer.append(" , ? ");
                    }

                    buffer.append(" ) ");

                }
                buffer.append(StringConstants.SPACE);
            }
        }
    	
    	
    public static long setStringToLong(String strVal){
    	BigDecimal  sumRmbSl =  new  BigDecimal(strVal);  
    	return sumRmbSl.longValue();
    }
    
    public static double setStringToDouble(String strVal){
    	BigDecimal  sumRmbSl =  new  BigDecimal(strVal);  
    	return sumRmbSl.doubleValue();
    }
    
    public static int setStringToInt(String strVal){
    	BigDecimal  sumRmbSl =  new  BigDecimal(strVal);  
    	return sumRmbSl.intValue();
    }

	@SuppressWarnings("unchecked")
	public static String getWebRootFilePath(Class cls){
		try {
			String clsPath = getPathFromClass(cls);
			String[] rootFilePaths =  clsPath.split("WEB-INF");
			return rootFilePaths[0] + "WEB-INF\\";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 获取 basePath
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request){
		return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	}
	
	/**
	 * 获取一个类的class文件所在的绝对路径.
	 * 只要是在本程序中可以被加载的类,都可以定位到它的class文件的绝对路径
	 * @param cls 一个对象的Class属性
	 * @return    这个类的class文件位置的绝对路径,如果没有这个类的定义,则返回null
	 */
	@SuppressWarnings("unchecked")
	public static String getPathFromClass(Class cls) throws IOException {
		String path = null;
		if (cls == null) {
			throw new NullPointerException();
		}
		URL url = getClassLocationURL(cls);
		if (url != null) {
			path = url.getPath();
			if ("jar".equalsIgnoreCase(url.getProtocol())) {
				try {
					path = new URL(path).getPath();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				int location = path.indexOf("!/");
				if (location != -1) {
					path = path.substring(0, location);
				}
			}
			File file = new File(path);
			path = file.getCanonicalPath();
		}
		return path;
	}
	
	
	@SuppressWarnings("unchecked")
	private static URL getClassLocationURL(final Class cls) {
		if (cls == null)
			throw new IllegalArgumentException("null input: cls");
		URL result = null;
		final String clsAsResource = cls.getName().replace('.', '/').concat(".class");
		final ProtectionDomain pd = cls.getProtectionDomain();

		if (pd != null) {
			final CodeSource cs = pd.getCodeSource();
			if (cs != null)
				result = cs.getLocation();

			if (result != null) {
				if ("file".equals(result.getProtocol())) {
					try {
						if (result.toExternalForm().endsWith(".jar")
								|| result.toExternalForm().endsWith(".zip"))
							result = new URL("jar:".concat(result.toExternalForm()).concat("!/")
									.concat(clsAsResource));
						else if (new File(result.getFile()).isDirectory())
							result = new URL(result, clsAsResource);
					} catch (MalformedURLException ignore) {
						ignore.printStackTrace();
					}
				}
			}
		}

		if (result == null) {
			final ClassLoader clsLoader = cls.getClassLoader();
			result = clsLoader != null ? clsLoader
					.getResource(clsAsResource) : ClassLoader
					.getSystemResource(clsAsResource);
		}
		return result;
	}
    
	/**
	 * 获取uuid
	 * @author Sunday
	 * @return UUID String
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}
	
	/**
	 * 获取指定格式的当前日期
	 * @author Sunday
	 * @param format
	 * @return String
	 */
	public static String getFormatDate(String format){
		 return formatDate(format,new Date());
	}
	
	/**
	 * 根据是指定格式,格式化指定的日期
	 * @param format
	 * @param date
	 * @return String
	 */
	public static String formatDate(String format,Date date) {
		 return new SimpleDateFormat(format).format(date);
	}
	
	/**
	 * 获取工程的WebRoot路径,最后不带斜杠
	 * @author Sunday
	 * @param request
	 * @return String 例如：D:\soft_path\Tomcat6.0.29\webapps\microblog
	 */
	public static String getRootPath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath("");
	}
	
	/**
	 * 获取classes目录的绝对路径
	 * 
	 * @return
	 */
	public static String getClassesPath() {
		return StringUtil.class.getResource("/").getPath().substring(1);
	}
	
	/**
	 * 将字符串转换为Integer类型 , 小于0 或非数字将 返回 i值
	 * @param s
	 * @param i
	 * @return
	 */
	public static int toInteger(String s,int i) {
		int result = i;
		try {
			result = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			result = i;
		}
		return result;
	}
	
	/**
	 * 将字符串转发为BigInteger ,小于0 或非数字将 返回 i值
	 * @param s
	 * @param i
	 * @return
	 */
	public static BigInteger toBigInteger(String s , long i){
		BigInteger b = null;
		try {
			long temp = Long.valueOf(s);
			b = BigInteger.valueOf(temp);
		} catch (NumberFormatException e) {
			b = BigInteger.valueOf(i);
		}
		return b;
	}
	
	/**
	 * 是否无效, 注意无效为true
	 * @param id
	 * @return 无效 true 有效 false
	 */
	public static boolean isInvalid(BigInteger id) {
		return id.compareTo(BigInteger.valueOf(1))<0;
	}
	
	/**
	 * 去空格,该方法永远不会返回null
	 * @param s
	 * @return String
	 */
	public static String trim(String s) {
		if(null == s) {
			return "";
		}
		return s.trim();
	}
	
	/**
	 * 是不是Email
	 * @param input 需要验证的字符串
	 * @return 是 true; 否 false
	 */
	public static boolean isEmail(String input){
		if(!isEmpty(input)){
			input = input.trim();
			String regex = "[a-zA-Z0-9][a-zA-Z0-9_\\.]*[a-zA-Z0-9]@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
			return Pattern.matches(regex, input.trim());
		}
		else{
			return false;
		}
	}
	
	/**
	 * 判断是否为空字符串 null or "" 返回true
	 * @param s
	 * @return boolean
	 */
	public static boolean isEmpty(String s) {
		return s==null?true:"".equals(s.trim())?true:false;
	}
	
	/**
	 * 获取格式化时间
	 * @param d
	 * @return
	 */
	public static String getFormatDate(Date date){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		long now = c.getTimeInMillis();
		c.setTime(date);
		long old = c.getTimeInMillis();
		long temp = (now - old) / 1000; //秒
		temp = temp==0 ? 1:temp;
		if(temp<60) {  //秒
			return temp+"秒前";
		}
		if(temp<(60*60)) { //分钟
			long i = (temp%60)>0?1:0;
			return ((temp/60)+i)+"分钟前";
		}
		if(temp<(60*60*60*12)) {
			return "今天 " + formatDate("HH:mm:ss", date);
		}
		return formatDate("yyyy-MM-dd HH:mm:ss", date);
	}
	
	/**
	 * 取指定长度的字符串 一个中文按两个字符计算
	 * @param s
	 * @return
	 */
	public static String getChinessStr(String s, int len) {

		if (len >= s.getBytes().length) {
			return s;
		}
		int nums = 0;
		len -= 3;

		StringBuffer sb = new StringBuffer();
		char[] temp;
		temp = s.toCharArray();
		String str = "";		
		for (int i = 0; i < temp.length; i++) {
			str = String.valueOf(temp[i]);
			if (str.getBytes().length > 1)
				nums += 2;
			else
				nums++;
			sb.append(str);
			if (nums >= len)
				break;
		}
		return sb.toString();
	}
	
	/**
	 * 获取字符长度，英文字符两个按一个计算
	 * @param str
	 * @return 字符串长度
	 */
	public static int getChineseLength(String str) {
		if(null == str || "".equals(str.trim())){
			return 0;
		}
		float num = 0;
		str = str.trim();
		char[] temp = str.toCharArray();
		String s = "";
		for(char c : temp){
			s = String.valueOf(c);
			if(s.getBytes().length>1){
				num+=1.0;
			}
			else{
				num+=0.5;
			}
		}
		return Math.round(num);
	}
	
	public static void main(String[] args) {
		System.out.println(getChineseLength("测试test"));
	}
}
