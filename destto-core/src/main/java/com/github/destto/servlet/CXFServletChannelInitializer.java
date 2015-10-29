package com.github.destto.servlet;

import javax.servlet.ServletException;

import org.apache.cxf.transport.servlet.CXFServlet;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 29, 2015
 * @version 1.0
 */
public class CXFServletChannelInitializer extends ChannelInitializer<SocketChannel> {

	
	private final CXFServlet cxfServlet;
	
	/**
	 * 
	 * @throws ServletException
	 */
	public CXFServletChannelInitializer() throws ServletException {
		CXFServletContext servletContext = new CXFServletContext();
		CXFServletConfig servletConfig = new CXFServletConfig(servletContext, "cxf");
		
		//加载spring配置文件
		servletContext.addInitParameter("contextConfigLocation", "classpath:applicationContext.xml");
		cxfServlet = new CXFServlet();
		cxfServlet.init(servletConfig);
	}
	
	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		
		
	}

}
