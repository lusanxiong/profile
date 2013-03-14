package com.job528.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;

/**
 * 文件读取来
 * 
 * @author sunday
 * 
 */
public class MyFileReader {

	private static final Logger log = Logger.getLogger(MyFileReader.class);

	/**
	 * 读取文件，将内容以String形式返回
	 * 
	 * @param path
	 *            文件所在路径
	 * @return 文件内容utf-8
	 * 
	 */
	public String readFileToString(String path)  {
		InputStreamReader read = null;
		StringBuffer sb = null;
		BufferedReader br = null;
		FileInputStream fis = null;

		File file = new File(path);

		if (file.exists()) {
			sb = new StringBuffer();
			try {
				fis = new FileInputStream(file);
				read = new InputStreamReader(fis, "UTF-8");
				br = new BufferedReader(read);
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
					sb.append("\n");
				}
			} catch (IOException e) {
				log.error("读取文件IO流错误:" + e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
				try {
					if (read != null) {
						read.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			  }	
			}
		}
		return null == sb ? "" : sb.toString();
	}
}
