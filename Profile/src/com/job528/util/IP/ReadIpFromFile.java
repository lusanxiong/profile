package com.job528.util.IP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.job528.common.Constants;
import com.job528.profile.model.IpAddress;
import com.job528.profile.service.IIpAddressService;
import com.job528.util.config.PropertiesUtil;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * 从IP库文件中读取记录
 * @author lusanxiong
 *
 */
public class ReadIpFromFile {
	private static ApplicationContext context;
	
	static  {
		if(context == null) {
			context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		}
		System.out.println("context=="+context);
		 
	}
	
	/**
	 * 每次从IP地址文件中读取10000行
	 */
	public static void readFile() {
		final int readFileLineNumber = 10000; //每次从文件中读取的行数
		
		File file = new File(PropertiesUtil.getValue("ipAddressFileDic")); //获取到IP地址文件
		
		Charset charset = Charset.forName("GBK");
		InputStreamReader fis = null;
		BufferedReader br = null;
		
		List<IpAddress> ipList = new ArrayList<IpAddress>();
		IpAddress ip = null;
		try {
			FileInputStream in = new FileInputStream(file);
			fis = new InputStreamReader(in,charset);	
			br = new BufferedReader(fis);
			
			String lineText = "";
			
			long s_time = System.currentTimeMillis();
			int lineNum = 0;
			
			
			String startIp = "";
			String endIp = "";
			String ipLocation = "";
			String province = "";
			String country = "";
			String city = "";
			while( (lineText=br.readLine()) != null) {
				if(lineText.trim().equals("")) break;
				
				startIp = lineText.substring(0, 16).trim();
				endIp = lineText.substring(16,32).trim();
				ipLocation = lineText.substring(32,lineText.length()).trim();
				province = getProvince(ipLocation).trim();
				country = getCountry(ipLocation).trim();
				city = getCity(ipLocation).trim();
				
				if(city.equals("")) continue;
				ip = new IpAddress();
				ip.setArea("");
				ip.setCity(city);
				ip.setCountry(country);
				ip.setEndIp(endIp);
				ip.setEndIpValue(IpUtil.convertIpValue(endIp));
				ip.setIpLocation(ipLocation);
				ip.setProvince(province);
				ip.setStartIp(startIp);
				ip.setStartIpValue(IpUtil.convertIpValue(startIp));
				
				ipList.add(ip);
				//System.out.println("startIp=="+startIp+"==endIp=="+endIp+"==ipLocation==="+ipLocation+"=province="+province+"=country="+country+"=city="+city);
				lineNum = lineNum + 1;
				System.out.println("lineNum="+lineNum);
				
				if(lineNum > readFileLineNumber) {
					batchInsertIpAddress(ipList);
					ipList = new ArrayList<IpAddress>();
					lineNum = 0;
				}
			}
			
			if(ipList.size() > 0) {
				System.out.println("ipList.size================"+ipList.size());
				batchInsertIpAddress(ipList);
			}
			
			System.out.println("speed time=="+(System.currentTimeMillis()-s_time));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)
					fis.close();
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static String getProvince(String ipLocation) {
		if(ipLocation == null) return "";
		
		String province = "";
		int len = ipLocation.indexOf("省");
		
		province = getZX_city(ipLocation,len);
		if(!province.equals("")) {
			return province;
		}
		
		if( len> -1) {
			province = ipLocation.substring(0, len+1);
			return province;
		}
		
		return ipLocation;
	}
	private static String getCity(String ipLocation) {
		if(ipLocation == null) return "";
		
		String city = "";
		int len = ipLocation.indexOf("市");
		int len2 = ipLocation.indexOf("省");
		
		city = getZX_city(ipLocation,len);
		if(!"".equals(city)) {
			return city;
		}
		
		if(len2 > len) {
			return city;
		}
		
		if( len> -1 && len2 > -1) {
			city = ipLocation.substring(len2+1, len+1);
			return city;
		}
		
		return city;
	}
	
	//得到直辖市
	private static String getZX_city(String ipLocation,int len) {
		String[] zx_city = new String[]{"北京市","上海市","天津市","重庆市"};//直辖市
		for(int i=0; i<zx_city.length; i++) {
			//System.out.println("zx=="+zx_city[i]);
			if(ipLocation.indexOf(zx_city[i]) > -1) {
				return ipLocation.substring(0,len+1);
			}
		}
		return "";
	}
	
	
	private static String getCountry(String ipLocation) {
		if(ipLocation == null) return "";
		
		String country = "";
		int len = ipLocation.indexOf("  CZ88.NET");
		if( len> -1) {
			country = ipLocation.substring(0, len+1);
			return country;
		}
		return ipLocation;
	}
	
	/**
	 * 批量插入IP地址到528库中
	 * @param ipList
	 */
	public static void batchInsertIpAddress(List<IpAddress> ipList) {
		IIpAddressService ipAddressService = (IIpAddressService)context.getBean("ipAddressService");
		ipAddressService.batchInsertIpAddress(ipList);
		
		System.out.println("ipAddressService=="+ipAddressService);
	}
	
	public static void main(String[] args) {
		//long s_time = System.currentTimeMillis();
		readFile();
		
		//System.out.println("s_time="+(System.currentTimeMillis()-s_time));
		//String endIp = getCity("61.234.40.77    61.234.40.200   广西南宁市 教育网(全省通用)");
	    //System.out.println("endIp=="+endIp);
		
		//batchInsertIpAddress();
		/*String ip = "255.255.255.255";
		BigDecimal bd = convertIpValue(ip);
		//BigInteger b = new BigInteger(ipL);
		//System.out.println(100/1000);
		System.out.println("bd=="+bd.toString());
		
		long l = 256*256*256;
		System.out.println(l);*/
	}
}
