package com.job528.profile.action;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.job528.profile.model.MyResume;
import com.job528.profile.vo.Resume;
import com.job528.util.CompressImage;
import com.job528.util.FileHelper;
import com.job528.util.StringUtil;
import com.job528.util.Config;
import com.job528.util.exception.ImageException;

/**
 * 头像上传
 * @author Sunday
 *
 */
@SuppressWarnings("serial")
public class UploadHeadAction extends ResumeAction{
	private File image;
	private String imageFileName;
	
	 
	public String execute() throws Exception{
		if(!isLogin()) {
			return LOGIN;
		}
		String ext = FileHelper.getExt(getImageFileName()).toLowerCase();
		if(!(Config.format.jpg.equals(ext) || Config.format.jpeg.equals(ext) || Config.format.png.equals(ext))){
			return INPUT;
		}
		if(image.length()>(1024*1024*Config.image.size)){
			return INPUT;
		}
		
		String uuid = getUserId()+""; //StringUtil.getUUID();
		String timeFolder = StringUtil.getFormatDate("yyyy-MM-dd");
		String savePath = Config.image.headDir + "/" + timeFolder ;
		String root = StringUtil.getRootPath(request)+ savePath;
		String fileName = uuid+"_l"+ext; //原图
		String tFileName = uuid+"_t"+ext; //小图
		String mFileName = uuid+"_m"+ext; //中图
		
		boolean result = FileHelper.saveFile(image, root, fileName);
		try {
			CompressImage.compress(image, root, tFileName, Config.image.headThumbnail, true, ext);
			CompressImage.compress(image, root, mFileName, Config.image.headMiddle, true, ext);
			result = true;
		} catch (ImageException e) {
			e.printStackTrace();
			result = false;
		}
		File sourceFile = new File(root+"/"+fileName);
		if(sourceFile.exists()) {
			sourceFile.delete(); //删除原图
		}
		if(result){
			BufferedImage img = ImageIO.read(image);
			int temp = Math.min(img.getWidth(), img.getHeight());
				
			if(temp>Config.image.cutSize) {
				String midPath = savePath+"/"+mFileName;
				BufferedImage buf = ImageIO.read(new File(root, mFileName));
				int width = buf.getWidth();
				int height = buf.getHeight();
				request.setAttribute("srcpath", midPath);
				request.setAttribute("width", width);
				request.setAttribute("height", height);
				return "cut"; //to cut page
			}
			String photoName = savePath+"/"+tFileName;
			updateHeadImage(photoName);
			return writeText("<script>opener.Photo.reset('"+photoName+"');window.close();</script>");
		}else{
			return INPUT;
		}
	}
	
	/**
	 * 更新头像
	 * @param photoName
	 */
	private void updateHeadImage(String photoName){
		Resume resume = getLoginResume();
		MyResume myResume = resume.getMyResume();
		myResume.setPhotoName(photoName);
		resumeService.updateResume(myResume,true);
		resume.setMyResume(myResume);
		setLoginResume(resume);
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
