package com.job528.taglib;

import java.io.IOException;
import java.io.Writer;

import org.apache.log4j.Logger;
import org.apache.struts2.components.Component;

import com.job528.util.StringFilter;
import com.opensymphony.xwork2.util.TextUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 自定义标签
 * @author Sunday
 */
public class Text extends Component {
	private static final Logger log = Logger.getLogger(Text.class);
	private String value;
	private boolean mark; //是否转义单引号
	private String basePath;
	public Text(ValueStack stack) {
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
		String text = (String) getStack().findValue(this.value, String.class);
		try {
			if(null != text){
				text = TextUtils.htmlEncode(text);
				text = StringFilter.filterURL(text);
//				text = StringFilter.filterAtme(text); //不过滤@
				text = StringFilter.filterSimle(getBasePath(), text);
				if(isMark()) {
					text = StringFilter.filterSingleMark(text);
				}
				writer.write(text);
			}
		} catch (IOException e) {
			log.error("[自定义标签] 输出微博文字异常.");
		}
		return super.start(writer);
	}

	// ----------------------------
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public String getBasePath() {
		return basePath;
	}
	
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
}
