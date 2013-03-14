package com.job528.profile.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.job528.profile.dao.IIpAddressDao;
import com.job528.profile.model.IpAddress;
import com.job528.profile.service.IIpAddressService;
import com.job528.util.IP.IpUtil;

public class IpAddressService implements IIpAddressService{
	private IIpAddressDao iPAddressDao;

	@Override
	public void batchInsertIpAddress(List<IpAddress> ipList) {
		iPAddressDao.batchWriteIpAddress(ipList);
	}

	public IIpAddressDao getiPAddressDao() {
		return iPAddressDao;
	}

	public void setiPAddressDao(IIpAddressDao iPAddressDao) {
		this.iPAddressDao = iPAddressDao;
	}

	@Override
	public String findCityNameByIP(String ipAddress) {
		if(ipAddress == null || ipAddress.equals("")) return "";
		BigDecimal ipValue = IpUtil.convertIpValue(ipAddress);
		String city = iPAddressDao.findCityByIp(ipValue);
		
		return (city!=null ? city : "");
	}
	
}
