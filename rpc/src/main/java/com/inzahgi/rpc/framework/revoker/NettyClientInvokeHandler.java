package com.inzahgi.rpc.framework.revoker;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyClientInvokeHandler extends SimpleChannelInboundHandler<String> {

    public NettyClientInvokeHandler(){

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client active");
//        ByteBuf firstMessage = Unpooled.buffer(1024);
//        byte[] array = (new String("sayHello\n")).getBytes();
//        tempBuf.writeBytes(array);
//        ctx.writeAndFlush(tempBuf);
//        tempBuf.release();
//        ByteBuf firstMessage = Unpooled.buffer(1024);
////                                    for(int i = 0; i < firstMessage.capacity()-1; i++){
////                                        firstMessage.writeByte('h');
////                                    }
//        firstMessage.writeBytes("hello world".getBytes());
//        firstMessage.writeByte('\n');
//        ctx.writeAndFlush(firstMessage);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println("read0: " + s);
//        ByteBuf resBuf = Unpooled.buffer(1024);
//        resBuf.writeBytes(s.getBytes());
        RevokerResponseHolder.putResultValue(s);
        //resBuf.release();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


}
