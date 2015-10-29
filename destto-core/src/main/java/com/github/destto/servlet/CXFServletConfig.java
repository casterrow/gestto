package com.github.destto.servlet;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.util.Assert;


/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 29, 2015
 * @version 1.0
 */
public class CXFServletConfig implements ServletConfig {

	private final ServletContext servletContext;
	private final String servletName;
	private final Map<String, String> initParameters = new LinkedHashMap<String, String>();
	
	public CXFServletConfig() {
		this(null, "");
	}
	
	public CXFServletConfig(String servletName) {
		this(null, servletName);
	}
	
	public CXFServletConfig(ServletContext servletContext) {
		this(servletContext, "");
	}
	
	public CXFServletConfig(ServletContext servletContext, String servletName) {
		this.servletContext = (servletContext != null ? servletContext : new CXFServletContext());
		this.servletName = servletName;
	}
	
	@Override
	public String getServletName() {
		
		return servletName;
	}

	@Override
	public ServletContext getServletContext() {
		return servletContext;
	}
	
	public void addInitParameter(String name, String value) {
		Assert.notNull(name, "Parameter name must not be null");
		initParameters.put(name, value);
	}

	@Override
	public String getInitParameter(String name) {
		Assert.notNull(name, "Parameter name must not be null");
		return initParameters.get(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return Collections.enumeration(initParameters.keySet());
	}

}
