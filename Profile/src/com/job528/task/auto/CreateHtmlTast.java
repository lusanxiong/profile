package com.job528.task.auto;


import java.util.TimerTask;
import com.job528.util.Config;
import com.job528.util.FileHelper;
import com.job528.util.MyFileReader;

public class CreateHtmlTast extends TimerTask{
	
	@Override
	public void run() {

		String root = "D:\\Workspaces\\Profile\\web";
		String userName = "luoricheng";
			//把#userName#的所有内容换成userName  返回一个包括整个模板的内容String
	     String content = new MyFileReader().readFileToString(root+Config.template.invite).replace("#userName#",userName);
	     String fileName =root+"\\temp.html";
	     this.buildFile(content,fileName);
	    
	}
	
	protected void buildFile(String content,String fileName){
		 //读取的文件生成保存到另一个路径
		 FileHelper fh = new FileHelper();	
		 fh.writeFile(fileName, content);
	}
	
}
