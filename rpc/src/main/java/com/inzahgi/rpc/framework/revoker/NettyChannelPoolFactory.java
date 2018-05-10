package com.inzahgi.rpc.framework.revoker;

import com.google.common.collect.Lists;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class NettyChannelPoolFactory {

    private static final Logger logger = LoggerFactory.getLogger(NettyChannelPoolFactory.class);

    private static final NettyChannelPoolFactory channelPoolFactory = new NettyChannelPoolFactory();

    private static final int channelConnectSize = 15;

    private NettyChannelPoolFactory(){

    }

    public void initChannelPoolFactory(){

    }


    public Channel registerChannel(final InetSocketAddress socketAddress){

        try{
            EventLoopGroup group = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.remoteAddress(socketAddress);

            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline cp = socketChannel.pipeline();
                            cp.addLast(new LineBasedFrameDecoder(1024));
                            cp.addLast(new StringDecoder());
                            cp.addLast(new NettyClientInvokeHandler());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect(socketAddress).sync();
            final Channel newChannel = channelFuture.channel();
            final CountDownLatch connectedLatch = new CountDownLatch(1);

            final List<Boolean> isSuccessHolder = Lists.newArrayListWithCapacity(1);

            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture cf) throws Exception {
                    if(cf.isSuccess()){
                        isSuccessHolder.add(Boolean.TRUE);
                    }else {
                        cf.cause().printStackTrace();
                        isSuccessHolder.add(Boolean.FALSE);
                    }
                    connectedLatch.countDown();
                }
            });
            connectedLatch.await();
            if(isSuccessHolder.get(0)){
                return newChannel;
            }

        }catch (Exception e){
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        return null;
    }

    public static NettyChannelPoolFactory channelPoolFactoryInstance() {
        return channelPoolFactory;
    }






}
