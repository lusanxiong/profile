package com.job528.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

/**
 * @author Sunday
 * Sep 14, 2011 1:50:20 PM
 */
public class FileHelper {
	private final static Logger log = Logger.getLogger(FileHelper.class);

	public static boolean saveFile(File file,String root,String fileName){
		new File(root).mkdirs();
		File diskFile = new File(root,fileName);
		return save(file, diskFile);
	}
	
	public static boolean saveFile(File file,String fileName){
		File diskFile = new File(fileName);
		return save(file, diskFile);
	}
	
	private static boolean save(File file,File diskFile){
		boolean result = false;
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream(diskFile);
			
			byte [] buffer = new byte[1024];
			int length = 0;
			
			while((length=is.read(buffer))>0){
				os.write(buffer,0, length);
			}
			result = true;
		} catch (FileNotFoundException e) {
			log.error("保存文件时，无法找到文件：",e);
		} catch (IOException e) {
			log.error("保存文件时，出现IO异常：",e);
		} finally {
			if(null != os){
				try {
					os.flush();
					os.close();
				} catch (IOException e) {
					log.error("关闭OutputStream出现异常：",e);
				} finally {
					if(null != is){
						try {
							is.close();
						} catch (IOException e) {
							log.error("关闭InputStream出现异常：",e);
						}
					}
				}
			}
		}
		return result;
	}
	
	
	 public static StringBuffer readFileByLines(String fileName) {
		 StringBuffer resultString = new  StringBuffer();
    
		File file = new File(fileName);
		InputStreamReader read = null;
		try {
			read = new InputStreamReader(new FileInputStream(file), "utf-8");
			BufferedReader reader = new BufferedReader(read);
			String line;
			while ((line = reader.readLine()) != null) {
				resultString.append(line);
			}
		} catch (UnsupportedEncodingException e) {
			log.error("readFileByLines UnsupportedEncodingException err:", e);
		} catch (FileNotFoundException e) {
			log.error("readFileByLines FileNotFoundException err:", e);
		} catch (IOException e) {
			log.error("readFileByLines IOException err:", e);
		}
		finally {
	         if (read != null) {
	             try {
	            	 read.close();
	             } catch (IOException e) {
	             	log.error("readFileByLines reader.close err:", e);
	             }
	         }
	     }
		return resultString;
	 } 
       

	
	/**
	 * 获取文件的后缀名 
	 * @param fileName
	 * @return
	 */
	public static String getExt(String fileName){
		if(null != fileName && !"".equals(fileName)){
			return fileName.substring(fileName.lastIndexOf("."));
		}
		return "";
	}
	
	/**
	 * 判断文件是否存在
	 * @param filePath
	 * @return
	 */
	public static boolean exists(String filePath){
		return new File(filePath).exists();
	}
	
	
	public static void writeFile(String fileName, String writeString) {
		try {
			File f = new File(fileName);
			if (!f.exists()) {
				if (!f.getParentFile().exists())
					f.getParentFile().mkdirs();
				f.createNewFile();
			} else
				f.delete();
			// if(f.exists())f.delete();
			f.createNewFile();

			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			long fileLength = randomFile.length();

			randomFile.seek(fileLength);
			// System.out.println(sb.toString());
			// String s2 = sb.toString().replaceAll("\\s","");
			randomFile.write(writeString.getBytes("utf-8"));
			// randomFile.write(sb.toString().getBytes());
			randomFile.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
