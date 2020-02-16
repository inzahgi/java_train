package com.inzahgi.app.handler;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.ssl.SslHandler;

import java.io.RandomAccessFile;

public class FileClientHandler extends SimpleChannelInboundHandler<String> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        RandomAccessFile raf = null;
        long length = -1;
        try{
            raf = new RandomAccessFile(s, "r");
            length = raf.length();
        }catch (Exception e){
            ctx.writeAndFlush("ERR: " + e.getClass().getSimpleName() + " : " + e.getMessage() + "\n");
            return;
        }finally {
            if(length < 0 && raf != null){
                raf.close();
            }
        }

        ctx.write("OK : " + raf.length() + "\n");
        if(ctx.pipeline().get(SslHandler.class) == null){
            ctx.write(new DefaultFileRegion(raf.getChannel(), 0, length));
        }else{
            ctx.writeAndFlush("\n");
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();

        if(ctx.channel().isActive()){
            ctx.writeAndFlush("ERR" +
                    cause.getClass().getSimpleName() + ": " +
                    cause.getMessage() + '\n').addListener(ChannelFutureListener.CLOSE);
        }
    }

}
