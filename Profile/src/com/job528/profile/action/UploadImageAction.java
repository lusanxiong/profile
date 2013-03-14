package com.job528.profile.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.job528.util.CompressImage;
import com.job528.util.FileHelper;
import com.job528.util.StringUtil;
import com.job528.util.Config;
import com.job528.util.exception.ImageException;
import com.job528.util.webwork.GenericAction;

@SuppressWarnings("serial")
public class UploadImageAction extends GenericAction{
	private File image;
	private String imageFileName;
	 
	public String execute() throws Exception{
		if(!isLogin()) {
			return writeScript("parent.callback('{\"flag\":\"500\",\"msg\":\"您已经退出登录，请重新登录！\"}');");
		}
		
		String ext = FileHelper.getExt(getImageFileName()).toLowerCase();
		if(!(Config.format.gif.equals(ext) || Config.format.jpg.equals(ext) || Config.format.jpeg.equals(ext) || Config.format.png.equals(ext))){
			return writeScript("parent.callback('{\"flag\":\"100\",\"msg\":\"上传图片格式不正确！\"}');");
		}
		if(image.length()>(1024*1024*Config.image.size)){
			return writeScript("parent.callback('{\"flag\":\"200\",\"msg\":\"上传图片尺寸过大！\"}');");
		}
		
		String uuid = StringUtil.getUUID();
		String timeFolder = StringUtil.getFormatDate("yyyy-MM-dd");
		String savePath = Config.image.imageDir + "/" + timeFolder ;
		String root = StringUtil.getRootPath(request)+ savePath;
		String fileName = uuid+"_l"+ext; //原图
		String tFileName = uuid+"_t"+ext; //小图
		String mFileName = uuid+"_m"+ext; //中图
		
		boolean result = FileHelper.saveFile(image, root, fileName);
		if(result) {
			try {
				CompressImage.compress(image, root, tFileName, Config.image.thumbnail, true, ext);
				CompressImage.compress(image, root, mFileName, Config.image.middle, true, ext);
			} catch (ImageException e) {
				e.printStackTrace();
				result = false;
			}
		}
		if(result){
			return writeScript("parent.callback('"+"{\"flag\":\"0\",\"src\":\""+savePath+"/"+tFileName+"\"}"+"');");
		}else{
			return writeScript("parent.callback('{\"flag\":\"500\",\"msg\":\"系统繁忙，请重新上传！\"}');");
		}
	}
	
	private String writeScript(String msg) throws IOException{
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print(msg);
		out.print("</script>");
		out.close();
		return null;
	}
	
	//--------------------------------------------
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
}
