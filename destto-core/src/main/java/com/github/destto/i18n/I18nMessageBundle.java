package com.github.destto.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 21, 2015
 * @version 1.0
 */
public class I18nMessageBundle implements I18nMessage {
	
	private Logger logger = LoggerFactory.getLogger(I18nMessageBundle.class);
	
	private Map<String, Properties> map = null;
	
	private I18nMessageBundle() {
		map = new HashMap<String, Properties>();
	}

	private Map<String, Properties> loadMessage() {
		map = new HashMap<String, Properties>();
        final String prefix =  "com/deppon/";
        try {
        	//加载指定位置的properties文件
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath*:" + prefix
                    + "**/server/META-INF/messages/message*.properties");
            for (Resource resource : resources) {
                String path = resource.getURL().getPath();
                String classpath = path.substring(path.lastIndexOf(prefix));
                if (logger.isInfoEnabled()) {
                    logger.info("[Framework] add message bundle: " + classpath);
                }
                //取得文件名
                //final String moduleName = classpath.replaceAll("/server/META-INF/.*$", "").replaceAll("^.*/", "");
                final String localeName = classpath.replaceAll(".*\\/message([_a-zA-Z]*)\\.properties$", "$1");
                Properties properties = new Properties();
                InputStream in = resource.getInputStream();
                try {
                    properties.load(in);
                } finally {
                    in.close();
                }
                //map.put(moduleName + localeName, properties);
                
                //一个语言类型，不同模块下的语言文件合并到一个properties中
                String locale = localeName;
                if(StringUtils.isBlank(locale)) {
                    //文件没有语言标识后缀的默认为英文
                    locale = Locale.US.toString();
                }
                if(locale.startsWith("_")) {
                    locale = locale.substring(1);
                }
                Properties p = map.get(locale);
                if(p != null) {
                    p.putAll(properties);
                    map.put(locale, p);
                } else {
                    map.put(locale, properties);
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return map;
	}

	@Override
	public String getMessage(Locale locale, String key, Object... args) {
		if(key == null) {
	    	return null;
	    }
		if(locale == null) {
		    //没有传入locale的，用服务器系统默认的locale
            locale = Locale.getDefault();
        }
        Properties properties = map.get(locale.toString());
        //得到对应语言类型的国际化信息
        if (properties != null) {
        	String value = properties.getProperty(key, key);
        	if (!value.equals(key)) {
        		//说明有配置对应key的value
        		//格式化后，返回
        		return (args == null || args.length == 0) ? value
		              : MessageFormat.format(value, args);
        	}
        }
		//没有国际化信息，返回key
		return key;
	}

	@Override
	public String getMessage(String key, Object... args) {
		return getMessage(null, key, args);
	}

}
