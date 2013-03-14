package com.job528.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.job528.util.exception.ImageException;

/**
 * 图片压缩类
 * @author Blizzard
 */
public class CompressImage {
	
	
	/**
	 * 压缩图片
	 * @param inputFile 源图片file类型
	 * @param outputPath 输出路径，包含文件名
	 * @param isRatio 是否等比压缩
	 * @param root 输出图片的路径
	 * @param fileName 图片名称
	 * @param max 预算值
	 * @param type 图片类型 jpg,gif,png
	 */
	public static void compress(File inputFile, String root,String fileName, double max,boolean isRatio,String ext) throws ImageException {
	   double ratio = 1.0;
	   int widthdist = 0;
	   int heightdist = 0;
	   
	   try {
	    BufferedImage img = ImageIO.read(inputFile);
	    if(isRatio){  //等比压缩
		    int width = img.getWidth();
		    int height = img.getHeight();
		    
		    int refer = width > height ? width:height;
		    if(refer>max) {  //如果原图大于预算尺寸，则计算压缩比例
		    	ratio = max/refer;
		    }else{
		    	FileHelper.saveFile(inputFile, root, fileName); //如果图片小于预算值, 则不进行压缩,直接保存原图
		    	return ;
		    }
		    widthdist  = (int) Math.floor(width  * ratio); //计算后的宽度
		    heightdist = (int) Math.floor(height * ratio); //计算后的高度
	    } else { //非等比压缩，即压缩为固定尺寸
	    	widthdist = (int)max;
	    	heightdist = (int)max;
	    }
	    BufferedImage tag = new BufferedImage(widthdist,heightdist,BufferedImage.TYPE_INT_RGB);
	    Graphics g = tag.getGraphics();
	    g.setColor(Color.white);  //图片过小，则补白,必须与下面代码一起使用
	    g.fillRect(0,0,widthdist,heightdist);
	    g.drawImage(img.getScaledInstance(widthdist, heightdist,BufferedImage.SCALE_SMOOTH), 0, 0, null);
	    
	    
	    File littleFile = new File(root,fileName);
	    
	    if(Config.format.gif.equals(ext)) {
	    	ImageIO.write(tag, "GIF", littleFile);
	    }
	    if(Config.format.jpg.equals(ext) || Config.format.jpeg.equals(ext)) {
	    	ImageIO.write(tag, "JPEG", littleFile);
	    }
	    if(Config.format.png.equals(ext)){
	    	ImageIO.write(tag, "PNG", littleFile);
	    }
	    
	    img.flush();
	    tag.flush();
 
	    /*
	    File littleFile = new File(outputPath);
	    ImageIO.write(tag, "JPEG", littleFile);
	    */
	    
	    /*  高质量 jpg 压缩
	    File littleFile2 = new File(root,fileName);
	    FileOutputStream newimage=new FileOutputStream(littleFile2); //输出到文件流 
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage); 
        JPEGEncodeParam jep=JPEGCodec.getDefaultJPEGEncodeParam(tag); 
        
        jep.setQuality(1.0f, true); //压缩质量 
        encoder.encode(tag, jep); 
        */
	    
	    /* 第三方库 ,压缩gif
	    File littleFile3 = new File(outputPath);
	    FileOutputStream output=new FileOutputStream(littleFile3);
	    GIFEncoder encoder = new GIFEncoder(tag);
	    encoder.Write(output);
	    */
	    
	   } catch (IOException e) {
	     	throw new ImageException("压缩图片出现异常!",e);
	   }
	}
	
	/**
	 * 重载上面方法
	 * @param inputFile 源图片路径String
	 * @param outputPath 输出路径，包含文件名
	 * @param isRatio 是否等比压缩
	 * @param root 输出图片的路径
	 * @param fileName 图片名称
	 * @param max 预算值
	 * @param type 图片类型 .jpg,.gif,.png
	 */
	public static void compress(String inputPath, String root,String fileName, double max,boolean isRatio,String type) throws ImageException{
		compress(new File(inputPath), root,fileName , max,isRatio,type);
	}
	
	public static void main(String[] args) throws Exception {
		 long  s = System.currentTimeMillis();
		 File file = new File("f:/qq15.gif");
		 compress(file, "f:/","qq_bak.gif",98,true,".gif");
		 long e = System.currentTimeMillis();
		 
		 System.out.println("ImageUtils.main()"+(e-s));
	}
}

















