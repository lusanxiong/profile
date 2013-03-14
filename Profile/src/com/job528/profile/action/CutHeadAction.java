package com.job528.profile.action;

import java.io.File;

import com.job528.profile.model.MyResume;
import com.job528.profile.vo.Resume;
import com.job528.util.CompressImage;
import com.job528.util.Config;
import com.job528.util.Cut;
import com.job528.util.FileHelper;
import com.job528.util.StringUtil;

@SuppressWarnings("serial")
public class CutHeadAction extends ResumeAction {
	
	@Override
	public String execute() throws Exception {
		
		int x = StringUtil.toInteger(request.getParameter("x"),0); 
		int y = StringUtil.toInteger(request.getParameter("y"),0);
		int w = StringUtil.toInteger(request.getParameter("w"),0);
		int h = StringUtil.toInteger(request.getParameter("h"),0);
		
		if(w<1 || h<1 || x<0 || y<0) {
			return SUCCESS;
		}
		String root = StringUtil.getRootPath(request);
		String srcpath = root+request.getParameter("srcpath");
		String subpath = srcpath.replace("_m", "_t");
		String photoName = request.getParameter("srcpath").replace("_m", "_t");
		
		Cut cut = new Cut(); 
		cut.setSrcpath(srcpath);
		cut.setSubpath(subpath);
		cut.setX(x);
		cut.setY(y);
		cut.setWidth(w);
		cut.setHeight(h);
		boolean result = cut.cut();

		if(w>190){
			File image = new File(subpath);
			String root2 = image.getParent();
			String tFileName = image.getName();
			String ext = FileHelper.getExt(tFileName);
			CompressImage.compress(image, root2, tFileName , Config.image.headThumbnail, true, ext);
		}
		if(result) {
			File sourceFile = new File(srcpath);
			if(sourceFile.exists()) {
				sourceFile.delete();
			}
			updateHeadImage(photoName);
		}
		
		writeText("<script>opener.Photo.reset('"+photoName+"');window.close();</script>");
		return null;
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
	
}
