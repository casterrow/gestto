package com.github.destto.servlet;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 29, 2015
 * @version 1.0
 */
public class CXFServletContext implements ServletContext {
	
	private final ResourceLoader resourceLoader;
	private final Map<String, String> initParameters = new LinkedHashMap<String, String>();

	public CXFServletContext() {
		this("", null);
	}
	
	public CXFServletContext(String resourceBasePath, ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	@Override
	public String getContextPath() {
		return null;
	}

	public ServletContext getContext(String uripath) {
		return null;
	}
	

	@Override
	public int getMajorVersion() {
		return 0;
	}

	@Override
	public int getMinorVersion() {
		return 0;
	}

	@Override
	public String getMimeType(String file) {
		return null;
	}

	@Override
	public Set<String> getResourcePaths(String path) {
		return null;
	}

	@Override
	public URL getResource(String path) throws MalformedURLException {
		return null;
	}

	@Override
	public InputStream getResourceAsStream(String path) {
		return null;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return null;
	}

	@Override
	public RequestDispatcher getNamedDispatcher(String name) {
		return null;
	}

	@Override
	public Servlet getServlet(String name) throws ServletException {
		return null;
	}

	@Override
	public Enumeration<Servlet> getServlets() {
		return null;
	}

	@Override
	public Enumeration<String> getServletNames() {
		return null;
	}

	@Override
	public void log(String msg) {
		
	}

	@Override
	public void log(Exception exception, String msg) {
		
	}

	@Override
	public void log(String message, Throwable throwable) {
		
	}

	@Override
	public String getRealPath(String path) {
		return null;
	}

	@Override
	public String getServerInfo() {
		return null;
	}

	@Override
	public String getInitParameter(String name) {
		return null;
	}
	
	public void addInitParameter(String name, String value) {
		Assert.notNull(name, "Parameter name must not be null");
		initParameters.put(name, value);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return null;
	}

	@Override
	public Object getAttribute(String name) {
		return null;
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return null;
	}

	@Override
	public void setAttribute(String name, Object object) {
		
	}

	@Override
	public void removeAttribute(String name) {
		
	}

	@Override
	public String getServletContextName() {
		return null;
	}

}
