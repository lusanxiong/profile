package com.job528.lucene;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.Random;

import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.job528.lucene.search.ISearchPosition;
import com.job528.lucene.search.ISearchUser;
import com.job528.util.StringUtil;
import com.job528.util.log.MyLog;

public class LuceneManager {
	private static final MyLog log = MyLog.getLogger(LuceneManager.class);
	private static String SEARCH_USER_WEBSERVICE_URL = "SEARCH_USER_WEBSERVICE_URL";
	private static String SEARCH_POSITION_WEBSERVICE_URL = "SEARCH_POSITION_WEBSERVICE_URL";
	private static String SET_FILE_NAME = "set.properties";
	
	private ISearchUser searchUserService;
    private ISearchPosition searchPositionService;
	private static LuceneManager instance;
	public static LuceneManager getInstance(){
		if(instance == null){
			instance = new LuceneManager();
		}
		return instance;
	}
	private LuceneManager(){
		
		String path = StringUtil.getWebRootFilePath(LuceneManager.class) + SET_FILE_NAME;
		
		String searchUserWebServiceUrl = "";
		String searchPositionWebServiceUrl = "";
		try {
			Properties props = new Properties();
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			props.load(in);
			searchUserWebServiceUrl = props.getProperty(SEARCH_USER_WEBSERVICE_URL);
			searchPositionWebServiceUrl = props.getProperty(SEARCH_POSITION_WEBSERVICE_URL);
			in.close();
		} catch (FileNotFoundException e) {
			log.error("get lucene web service url set error!", e);
		} catch (IOException e) {
			log.error("get lucene web service url set error!", e);
		} 
		
		try {
			//Service serviceUserModel = new ObjectServiceFactory().create(ISearchUser.class);
			Service servicePositionModel = new ObjectServiceFactory().create(ISearchPosition.class);
			//searchUserService = (ISearchUser) new XFireProxyFactory().create(serviceUserModel,searchUserWebServiceUrl);
			searchPositionService = (ISearchPosition) new XFireProxyFactory().create(servicePositionModel,searchPositionWebServiceUrl);
		} catch (MalformedURLException e) {
			log.error("get lucene web service error!", e);
		}
	}
	
	
	
//	public ISearchUser getSearchUserService() {
//		return searchUserService;
//	}
//	public void setSearchUserService(ISearchUser searchUserService) {
//		this.searchUserService = searchUserService;
//	}
	public ISearchPosition getSearchPositionService() {
		return searchPositionService;
	}
	public void setSearchPositionService(ISearchPosition searchPositionService) {
		this.searchPositionService = searchPositionService;
	}
	public static void main(String args[]){
		Random r = new Random();
		int n2 = r.nextInt(4);
		
		System.out.print(n2 + 1);
	}
	
	
}
