package com.inzahgi.game.server;

import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.server.handler.DefaultChannelInitializer;
import com.inzahgi.game.server.timer.RoomClearTask;
import com.inzahgi.game.utils.DefaultThreadFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class GameServer {

	public static void main(String[] args) throws InterruptedException {

		if(args != null && args.length > 1) {
			if(args[0].equalsIgnoreCase("-p") || args[0].equalsIgnoreCase("-port")) {
				ServerContains.port = Integer.valueOf(args[1]);
			}
		}

		EventLoopGroup parentGroup = Epoll.isAvailable() ? new EpollEventLoopGroup() : new NioEventLoopGroup();
		EventLoopGroup childGroup = Epoll.isAvailable() ? new EpollEventLoopGroup() : new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap()
			.group(parentGroup, childGroup)
			.channel(Epoll.isAvailable() ? EpollServerSocketChannel.class : NioServerSocketChannel.class)
			.localAddress(new InetSocketAddress(ServerContains.port))
			.childHandler(new DefaultChannelInitializer());

			ChannelFuture f = bootstrap .bind().sync();

			SimplePrinter.serverLog("The server was successfully started on port " + ServerContains.port);

			ScheduledExecutorService scheduledService = new ScheduledThreadPoolExecutor(1,
					new DefaultThreadFactory("cron", true));
			scheduledService.scheduleWithFixedDelay(new RoomClearTask(), 10L,3000L, TimeUnit.SECONDS);
			f.channel().closeFuture().sync();
		} finally {
			parentGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}


	}
}
