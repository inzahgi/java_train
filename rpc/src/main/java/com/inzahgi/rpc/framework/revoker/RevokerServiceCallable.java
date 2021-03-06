package com.inzahgi.rpc.framework.revoker;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Callable;

public class RevokerServiceCallable implements Callable<String> {

    private static final Logger logger = LoggerFactory.getLogger(RevokerServiceCallable.class);

    private Channel channel;

    private InetSocketAddress socketAddress;
    private String requestStr;

    public static RevokerServiceCallable of(InetSocketAddress inetSocketAddress, String requestStr){
        return new RevokerServiceCallable(inetSocketAddress, requestStr);
    }

    public RevokerServiceCallable(InetSocketAddress socketAddress, String requestStr) {
        this.socketAddress = socketAddress;
        this.requestStr = requestStr;
    }

    @Override
    public String call() throws Exception {

        try{
            channel = NettyChannelPoolFactory.channelPoolFactoryInstance().registerChannel(socketAddress);
            System.out.println("send to server : " + requestStr);
            ChannelFuture channelFuture = channel.writeAndFlush(
                            Unpooled.copiedBuffer((requestStr + "\n").getBytes()));
            channelFuture.syncUninterruptibly();

            return RevokerResponseHolder.getValue(requestStr);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            channel.close();
        }
        return null;
    }











}
