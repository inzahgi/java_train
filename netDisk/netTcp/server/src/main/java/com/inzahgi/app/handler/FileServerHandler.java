package com.inzahgi.app.handler;

import com.alibaba.fastjson.JSON;
import com.inzahgi.app.entity.Frame;
import com.inzahgi.app.util.FileSimulateUtil;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.ssl.SslHandler;

import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Type;

public class FileServerHandler extends SimpleChannelInboundHandler<Frame> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //super.channelActive(ctx);
        System.out.println("line ");
       // Frame frame = new Frame(Frame.TYPE.INFO, 0, 0, "HELLO: connect success!!",null);
       //ctx.writeAndFlush(JSON.toJSONString(frame));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Frame frame) throws Exception {
        System.out.println("line = 28 " + frame.toString());

        switch (frame.getCode()){
            case Frame.TYPE.NAME_REQ:
                frame.setCode(Frame.TYPE.NAME_RESP);
                ctx.writeAndFlush(JSON.toJSONString(frame));
                break;
            case Frame.TYPE.NAME_RESP:
                checkFile(ctx, frame);
                break;
            case Frame.TYPE.FILE_REQ:
                writeFile(ctx, frame);
                break;
            case Frame.TYPE.FILE_RESP:
                break;
            case Frame.TYPE.INVAILD:
                break;
                default:
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

    private void checkFile(ChannelHandlerContext ctx, Frame frame) throws Exception{
        Frame newFrame = new Frame(frame);
        File file = new File(frame.getName());
        if(file.exists()){
            if(file.length() != frame.getLength()){
                newFrame.setLength(file.length());
            }
        }else {
            newFrame.setLength(0);
            newFrame.setStart(0);
        }
        ctx.writeAndFlush(JSON.toJSONString(newFrame));

    }

//    private void writeFile(ChannelHandlerContext ctx, Frame frame) throws Exception{
//        RandomAccessFile raf = null;
//        long length = -1;
//        try{
//            raf = new RandomAccessFile(frame.getName(), "rw");
//            length = raf.length();
//        }catch (Exception e){
//            ctx.writeAndFlush("ERR: " + e.getClass().getSimpleName() + " : " + e.getMessage() + "\n");
//            return;
//        }finally {
//            if(length < 0 && raf != null){
//                raf.close();
//            }
//        }
//
//        raf.write(frame.getData());
//        Frame respF = new Frame(Frame.TYPE.FILE_RESP, frame.getLength(), frame.getStart(), "OK", null);
//        ctx.writeAndFlush(respF);
//        //respF.setData(null);
//        //respF.setCode(Frame.TYPE.FILE_RESP);
//        //ctx.write("OK : " + raf.length() + "\n");
////        if(ctx.pipeline().get(SslHandler.class) == null){
////            ctx.write(new DefaultFileRegion(raf.getChannel(), 0, length));
////        }else{
////            ctx.writeAndFlush("\n");
////        }
//    }



    private void writeFile(ChannelHandlerContext ctx, Frame frame) throws Exception {
        FileSimulateUtil.write(frame.getData(), (int)frame.getStart(), (int)frame.getLength());
        Frame respF = new Frame(Frame.TYPE.FILE_RESP, frame.getLength(), frame.getStart(), "OK", null);
        ctx.writeAndFlush(JSON.toJSONString(respF));
    }
}
