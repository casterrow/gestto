package com.github.destto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 20, 2015
 * @version 1.0
 */
public class BaseUtil {
	/**配置文件后缀**/
	private static final String PROPERTIES = ".properties";
	/**国际化配置前缀，lang_**.properties**/
	private static final String i18n = "lang";

	/**
	 * 加载配置文件
	 * @author casterrow@163.com, Stephen Lau
	 * @since Oct 20, 2015
	 * @version 1.0
	 * @param propsName 配置文件名称
	 * @return Properties
	 */
	public static Properties loadProperties(String propsName){
		
		try (InputStream is = BaseUtil.class.getClassLoader()
				.getResourceAsStream(propsName + PROPERTIES)) {
			Properties props = new Properties();
			props.load(is);
			return props;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 加载国际化配置文件，提供简体中文，繁体中文和英文。
	 * @author casterrow@163.com, Stephen Lau
	 * @since Oct 21, 2015
	 * @version 1.0
	 * @return ResourceBundle
	 */
	public static ResourceBundle loadI18n() {
		ResourceBundle resource = ResourceBundle.getBundle(i18n, Locale.getDefault());
		return resource == null ? ResourceBundle.getBundle(i18n, Locale.US) : resource;
	}
}
