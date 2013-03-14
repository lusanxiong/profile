package com.job528.taglib;

import java.io.IOException;
import java.io.Writer;

import org.apache.log4j.Logger;
import org.apache.struts2.components.Component;

import com.job528.util.Config;
import com.opensymphony.xwork2.util.ValueStack;

/**
 *@author tanggh
 */
public class Image extends Component {
	private static final Logger log = Logger.getLogger(Image.class);
	private String value;
	private String basePath;
	
	public Image(ValueStack stack) {
		super(stack);
	}

	@Override
	public boolean start(Writer writer) {
		if (this.value == null) {
			this.value = "top";
		} else if (altSyntax()) {
			if ((this.value.startsWith("%{")) && (this.value.endsWith("}"))) {
				this.value = this.value.substring(2, this.value.length() - 1);
			}
		}
		String imagePath = (String) getStack().findValue(this.value, String.class);
		if(imagePath == null || "".equals(imagePath.trim())){
			imagePath = Config.image.DEFAULT_HEAD_IMAGE; // 设置为默认头像
		}
		imagePath = imagePath.trim();
		if(!imagePath.startsWith("http://")){
			imagePath = basePath + imagePath;
		}
		try {
			writer.write(imagePath);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("[自定义标签] 输出用户头像异常.");
		}
		System.out.println("Image.start() : "+imagePath);
		return super.start(writer);
	}
	
	
	//------------------------------
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
	
}
