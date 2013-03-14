package com.job528.util;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.log4j.Logger;

public class Cut {
	private final static Logger log = Logger.getLogger(Cut.class);
	private String srcpath;
	private String subpath;
	private int x;
	private int y;
	private int width;
	private int height;
	
	/** */
	/**
	 * 对图片裁剪，并把裁剪完成的新图片保
	 */
	public boolean cut(){

		FileInputStream is = null;
		ImageInputStream iis = null;

			try {
				is = new FileInputStream(srcpath);
				Iterator<ImageReader> it = ImageIO
						.getImageReadersByFormatName("jpg");
				ImageReader reader = (ImageReader) it.next();
				iis = ImageIO.createImageInputStream(is);
				reader.setInput(iis, true);
				ImageReadParam param = reader.getDefaultReadParam();
				Rectangle rect = new Rectangle(x, y, width, height);
				param.setSourceRegion(rect);
				BufferedImage bi = reader.read(0, param);
				File file = new File(subpath); 
				// 保存新图
				ImageIO.write(bi, "jpg", file);
				return true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				log.error("剪切用户头像出现异常："+e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				log.error("剪切用户头像出现异常："+e.getMessage());
			} finally {
				if (is != null)
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
						log.error("剪切用户头像出现异常："+e.getMessage());
					}
				if (iis != null)
					try {
						iis.close();
					} catch (IOException e) {
						e.printStackTrace();
						log.error("剪切用户头像出现异常："+e.getMessage());
					}
			}
			return false;
	}
	
	public void cut2() {
		BufferedImage tag = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	    tag.getGraphics().setColor(Color.white);  //图片过小，则补白,必须与下面代码一起使用
	    tag.getGraphics().fillRect(0,0,width,height);
	  
//	    ImageReader
	}
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getSrcpath() {
		return srcpath;
	}

	public void setSrcpath(String srcpath) {
		this.srcpath = srcpath;
	}

	public String getSubpath() {
		return subpath;
	}

	public void setSubpath(String subpath) {
		this.subpath = subpath;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
