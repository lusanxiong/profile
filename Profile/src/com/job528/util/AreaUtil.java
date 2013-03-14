package com.job528.util;

import java.util.HashMap;
import java.util.Map;

import com.job528.util.web.InitServlet;

public class AreaUtil {
	
	public static String ADDRESS_AREA = "_address_area";
	public static String ADDRESS_CITY = "_address_city";
	public static String ADDRESS_PROVINCE = "_address_province";

	public static Map<String, Area> getAddress(String addressId){
		
		if(StrUtils.isNull(addressId))
			return null;
		
	    Area tempArea = null;
	    Area areaArea = null;
	    Area cityArea = null;
	    Area provinceArea = new Area();
		if(InitServlet.areaMap.containsKey(addressId)){
			tempArea = InitServlet.areaMap.get(addressId);
			areaArea = new Area();
			areaArea.setId(addressId);
			areaArea.setName(tempArea.getName());
			areaArea.setPid(tempArea.getPid());
			addressId = tempArea.getPid();
		}
		if(InitServlet.cityMap.containsKey(addressId)){
			tempArea = InitServlet.cityMap.get(addressId);
			cityArea = new Area();
			cityArea.setId(addressId);	
			cityArea.setName(tempArea.getName());
			cityArea.setPid(tempArea.getPid());
			addressId = tempArea.getPid();
		}
		if(InitServlet.provinceMap.containsKey(addressId)){
			tempArea = InitServlet.provinceMap.get(addressId);
			provinceArea = new Area();
			provinceArea.setId(addressId);
			provinceArea.setName(tempArea.getName());
			provinceArea.setPid("0");
		}
		
		Map<String, Area> address = new HashMap<String, Area>(3);
		if(areaArea != null){
		   address.put(ADDRESS_AREA, areaArea);
		}
		if(cityArea != null){
			address.put(ADDRESS_CITY, cityArea);
		}
		
		if(provinceArea != null){
			address.put(ADDRESS_PROVINCE, provinceArea);
		}

		return address;
	}
	

	public static String getAddressById(String addressId) {

		if (StrUtils.isNull(addressId))
			return "";

		Area tempArea = null;

		if (InitServlet.areaMap.containsKey(addressId)) {
			tempArea = InitServlet.areaMap.get(addressId);
			return tempArea.getName();
		}
		if (InitServlet.cityMap.containsKey(addressId)) {
			tempArea = InitServlet.cityMap.get(addressId);
			return tempArea.getName();
		}
		if (InitServlet.provinceMap.containsKey(addressId)) {
			tempArea = InitServlet.provinceMap.get(addressId);
			return tempArea.getName();
		}

		return "";
	}
	
	
	/**
	 * 获取完整的地址，省,市,区
	 * @param addressId
	 * @return
	 */
	public static String getPCAById(String addressId) {

		if (StrUtils.isNull(addressId))
			return "";

		StringBuilder address = new StringBuilder();
		//address.append(" ");
		
		Area tempArea = null;

		if (InitServlet.areaMap.containsKey(addressId)) {
			tempArea = InitServlet.areaMap.get(addressId);
			address.insert(0, tempArea.getName());
			addressId = tempArea.getPid();
		}
		
		if (InitServlet.cityMap.containsKey(addressId)) {
			tempArea = InitServlet.cityMap.get(addressId);
			if(address.length() > 0)
				   address.insert(0,",");
			address.insert(0,tempArea.getName());
		
			addressId = tempArea.getPid();
		}
		
		if (InitServlet.provinceMap.containsKey(addressId)) {
			tempArea = InitServlet.provinceMap.get(addressId);
			if(address.length() > 0)
				   address.insert(0,",");
			address.insert(0,tempArea.getName());
		}
		
		return address.toString();
	}
	
	
	public static void main(String args[]){
		
		
	}
	
}
