package com.inzahgi.game.client;

import com.inzahgi.game.client.handler.DefaultChannelInitializer;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.print.SimpleWriter;
import com.inzahgi.game.utils.StreamUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.nico.noson.Noson;
import org.nico.noson.entity.NoType;


import java.io.IOException;
import java.net.URL;
import java.util.List;

public class GameClient {

	public static int id = -1;

	public static String serverAddress;

	public static int port;

	public static void main(String[] args) throws InterruptedException, IOException {
		//解析参数
		if(args != null && args.length > 0) {
			//成对解析
			for(int index = 0; index < args.length; index = index + 2) {
				if(index + 1 < args.length) {
					//获取指定端口
					if(args[index].equalsIgnoreCase("-p") || args[index].equalsIgnoreCase("-port")) {
						port = Integer.valueOf(args[index + 1]);
					}
					//获取指定服务器ip
					if(args[index].equalsIgnoreCase("-h") || args[index].equalsIgnoreCase("-host")) {
						serverAddress = args[index + 1];
					}
				}
			}
		}

		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap()
					.group(group)
					.channel(NioSocketChannel.class)
					.handler(new DefaultChannelInitializer());
			SimplePrinter.printNotice("Connecting to " + serverAddress + ":" + port);
			Channel channel = bootstrap.connect(serverAddress, port).sync().channel();
			channel.closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}

	}

}
