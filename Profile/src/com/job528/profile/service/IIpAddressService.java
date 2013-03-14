package com.job528.profile.service;

import java.util.List;

import com.job528.profile.model.IpAddress;

/**
 * IP地址转换服务类
 * @author lusanxiong
 *
 */
public interface IIpAddressService {
	
	/**
	 * 从文本文件中读取IP地址信息存入数据库
	 */
	public void batchInsertIpAddress(List<IpAddress> list);
	
	/**
	 * 根据IP地址查找所在城市名称
	 * 
	 * @param ipAddress;
	 * @return cityName
	 */
	public String findCityNameByIP(String ipAddress);
}
