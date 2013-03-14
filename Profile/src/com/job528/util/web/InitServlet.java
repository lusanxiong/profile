package com.job528.util.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.job528.util.Area;
import com.job528.util.Job;
import com.job528.util.StrUtils;
import com.job528.util.log.MyLog;



/**
 * 初始化基础数据
 * 
 * @author fanglinpeng
 * 
 */
public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = 542702089198710993L;
    private static final com.job528.util.log.MyLog log = MyLog.getLogger(InitServlet.class);
    
    private static String _id = "id";
    private static String _name = "name";
    private static String _citys = "citys";
    private static String _areas = "areas";
    private static String _jobs = "jobs";
  
    
    public static Map<String, Area> areaMap = new HashMap<String, Area>();

   
    
    public static Map<String, Area> provinceMap = new HashMap<String, Area>();
    
    
    /**
     * 省份、城市对应关系
     */
    public static Map<String, Area> cityMap = new HashMap<String, Area>();
    
    
    /**
     * 行业类别
     */
    public static Map<String, Job> callingMap = new HashMap<String, Job>();
    
    
    /**
     * 岗位类别
     */
    public static Map<String, Job> jobMap = new HashMap<String, Job>();
    

    public InitServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html; charset=utf8");
    }

    public void init() throws ServletException {
    	initBaseDate();
        
     
    }

    /**
     * 基础数据初始化
     */
	private void initBaseDate() {
		String jobPath = getServletContext().getRealPath("/xml/job.xml");
		String addressPath = getServletContext().getRealPath("/xml/address.xml");
		SAXReader reader = new SAXReader();
    	Document xmlDoc;
    	Element root;
		try {
			
			xmlDoc = reader.read(new File(addressPath));
			root = xmlDoc.getRootElement();
			for(Iterator i = root.elementIterator(); i.hasNext();){   
				Element province = (Element) i.next(); 
				initAddressMap(provinceMap,province,"0");	
			}
		} catch (DocumentException e) {
			log.error("read address.xml error!", e);
		}
		
		try{
			xmlDoc = reader.read(new File(jobPath));
			root = xmlDoc.getRootElement();
			for(Iterator i = root.elementIterator(); i.hasNext();){   
				Element calling = (Element) i.next(); 
				initJobMap(callingMap,calling,"0");
			}
			
		} catch (DocumentException e) {
			log.error("read job.xml error!", e);
		}
	}
    
    private static void initJobMap(Map<String, Job> map, Element element, String pid){
    	String name = "";
		String id = "";
		for (Iterator j = element.elementIterator(); j.hasNext();) {	
			Element node = (Element) j.next();
			if (node.getName().equals(_id)) {
				id = node.getText();
			}
			if (node.getName().equals(_name)) {
				name = node.getText();
			}
			if (node.getName().equals(_jobs)) {
				for(Iterator i = node.elementIterator(); i.hasNext();){   
					Element job = (Element) i.next(); 
					initJobMap(jobMap,job,id);
				}
			}
		}
		
		if (!StrUtils.isNull(id) && !StrUtils.isNull(name)) {
			if(!map.containsKey(id)){
				Job job = new Job();
				job.setId(id);
				job.setPid(pid);
				job.setName(name);
			    map.put(id, job);
		    }
		}
    }
	
	
    private static void initAddressMap(Map<String, Area> map, Element element, String pid){
    	String name = "";
		String id = "";
		for (Iterator j = element.elementIterator(); j.hasNext();) {		
			Element node = (Element) j.next();
			if (node.getName().equals(_id)) {
				id = node.getText();
			}
			if (node.getName().equals(_name)) {
				name = node.getText();
			}
			if (node.getName().equals(_citys)) {
				for(Iterator i = node.elementIterator(); i.hasNext();){   
					Element city = (Element) i.next(); 
					initAddressMap(cityMap,city,id);
					
				}
			}
			if(node.getName().equals(_areas)){
				for(Iterator i = node.elementIterator(); i.hasNext();){   
					Element area = (Element) i.next(); 
					initAddressMap(areaMap,area,id);
					
				}
			}
		}
		if (!StrUtils.isNull(id) && !StrUtils.isNull(name)) {
			if(!map.containsKey(id)){
				Area area = new Area();
				area.setId(id);
				area.setPid(pid);
				area.setName(name);
			    map.put(id, area);
		    }
		}
		
    }
    
	public static void main(String args[]) {
		String addressPath = "E:\\workspace\\528\\UserSearch\\WebRoot\\WEB-INF\\XML\\address.xml";
		
		String jobPath =  "E:\\workspace\\528\\UserSearch\\WebRoot\\WEB-INF\\XML\\job.xml";

		try {
			SAXReader reader = new SAXReader();
			Document xmlDoc;
			Element root;
			xmlDoc = reader.read(new File(jobPath));
			root = xmlDoc.getRootElement();
			for (Iterator i = root.elementIterator(); i.hasNext();) {
				Element calling = (Element) i.next(); 
				initJobMap(callingMap,calling,"0");
			}
		} catch (DocumentException e) {
			log.error("read address.xml error!", e);
		}
		
		
//		System.out.print(provinceMap.size());
//		System.out.print(cityMap.size());
//		System.out.print(areaMap.size());
		
		System.out.print(callingMap.size());
		System.out.print(jobMap.size());
	}
 
}
