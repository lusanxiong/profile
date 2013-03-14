package com.job528.util.IP;

import java.math.BigDecimal;

import edu.emory.mathcs.backport.java.util.Arrays;

public class IpUtil {
	
	/**
	 * 把IP地址字段转换成 数值
	 * @param args
	 */
	public static BigDecimal convertIpValue(String ip) {
		if(ip == null || "".equals(ip)) return new BigDecimal("0");
		
		StringBuilder sb = new StringBuilder();
		char[] ips = ip.toCharArray();
		for(int i=0; i<ips.length; i++) {
			char c = ips[i];
			
			if('.' == c) {
				c = ';';
			}
			sb.append(c);
		}
		
		ip = sb.toString();
		
		String[] ipAddress = new String[4];
		ipAddress = ip.split(";");
		System.out.println("ip[]=="+Arrays.asList(ipAddress));
		
		//BigInteger bi = new BigInteger("256");
		//bi = bi.multiply(new BigInteger("256")).multiply(new BigInteger("256")).add(new BigInteger(val));
		
		//long first = Integer.parseInt(ipAddress[0].trim()) *(256*256*256);
		long second = Integer.parseInt(ipAddress[1].trim())*(256*256);
		long three = Integer.parseInt(ipAddress[2].trim()) *(256);
		long four = Integer.parseInt(ipAddress[3].trim());
		
		BigDecimal bi = new BigDecimal(String.valueOf(256*256*256));
		bi = bi.multiply(new BigDecimal(ipAddress[0].trim())).add(new BigDecimal(String.valueOf(second)))
		    .add(new BigDecimal(String.valueOf(three))).add(new BigDecimal(String.valueOf(four)));
		
		return bi;
	}
	
}
