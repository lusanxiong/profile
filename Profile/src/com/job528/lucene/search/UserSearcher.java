package com.job528.lucene.search;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.job528.util.config.SetPropertiesUtil;

public class UserSearcher extends IndexSearcher {

	private static UserSearcher intance;
	private static String filePath;

	public UserSearcher(Directory path) throws CorruptIndexException,
			IOException {
		super(path);
	}
	
	public static UserSearcher getIntance(){
		if(intance == null){
			filePath = SetPropertiesUtil.getValue("userIndexPath");
			FSDirectory directory;
			try {
				directory = FSDirectory.open(new File(filePath));
				try {
					intance = new UserSearcher(directory);
				} catch (CorruptIndexException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return intance;
	}

}
