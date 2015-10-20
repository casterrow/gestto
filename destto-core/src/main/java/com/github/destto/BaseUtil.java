package com.github.destto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 20, 2015
 * @version 1.0
 */
public class BaseUtil {
	
	private static final String PROPERTIES = ".properties";

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
}
