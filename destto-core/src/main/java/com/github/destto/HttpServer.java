package com.github.destto;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 
 * @author Stephen Liu
 * @since 2015年10月28日
 * @version 1.0
 */
public final class HttpServer {

	/**
	 * 启动netty服务。
	 * @author Stephen Liu
	 * @since 2015年10月28日
	 * @version 1.0
	 * @param port
	 */
	private static void startup (int port) {
		ServerBootstrap server = null;
		try {
			server = new ServerBootstrap();
			server.group(new NioEventLoopGroup(), new NioEventLoopGroup())
			.channel(NioServerSocketChannel.class).localAddress(port);
			server.bind().sync().channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int port = 80;
		if (args!=null && args.length>0) {
			port = Integer.parseInt(args[0]);
		}
		startup(port);
	}
}
