package com.job528.profile.dao;

import java.math.BigDecimal;
import java.util.List;

import com.job528.profile.model.IpAddress;

/**
 * IP地址转换服务工具类
 * @author lusanxiong
 *
 */
public interface IIpAddressDao {
	
	/**
	 * 一次性存入多个IP地址相关信息
	 */
	public void batchWriteIpAddress(List<IpAddress> ipList);
	
	/**
	 * 查询IP地址数值所映射的城市
	 * 
	 * @param ipValue:由IP地址段转换成的数值。
	 */
	public String findCityByIp(BigDecimal ipValue);
}
