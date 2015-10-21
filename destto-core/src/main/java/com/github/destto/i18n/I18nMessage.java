package com.github.destto.i18n;

import java.util.Locale;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 21, 2015
 * @version 1.0
 */
public interface I18nMessage {

	/**
	 * 
	 * @author casterrow@163.com, Stephen Lau
	 * @since Oct 21, 2015
	 * @version 1.0
	 * @param key
	 * @param args
	 * @return
	 */
	String getMessage(String key, Object... args);
	
	/**
	 * 
	 * @author casterrow@163.com, Stephen Lau
	 * @since Oct 21, 2015
	 * @version 1.0
	 * @param locale
	 * @param key
	 * @param args
	 * @return
	 */
	String getMessage(Locale locale, String key, Object... args);
}
