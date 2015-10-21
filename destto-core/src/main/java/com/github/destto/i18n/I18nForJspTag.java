package com.github.destto.i18n;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *在JSP页面使用国际化标签
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 21, 2015
 * @version 1.0
 */
public class I18nForJspTag extends SimpleTagSupport {
	/**国际化信息key**/
	private String key;
	
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("");
	}
}
