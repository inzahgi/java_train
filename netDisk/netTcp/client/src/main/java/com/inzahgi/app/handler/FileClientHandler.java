package com.inzahgi.app.handler;

import com.alibaba.fastjson.JSON;
import com.inzahgi.app.entity.Frame;
import com.inzahgi.app.util.FileSimulateUtil;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.ssl.SslHandler;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileClientHandler extends SimpleChannelInboundHandler<Frame> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Frame frame) throws Exception {
        System.out.println("line = 20 " + frame.toString());

        switch (frame.getCode()){
            case Frame.TYPE.INFO:
                System.out.println(frame.getName());
            case Frame.TYPE.NAME_REQ:
                break;
            case Frame.TYPE.NAME_RESP:
               sendFile(ctx, frame);
                break;
            case Frame.TYPE.FILE_REQ:
                break;
            case Frame.TYPE.FILE_RESP:
                sendFile(ctx, frame);

                break;
            case Frame.TYPE.INVAILD:
                System.out.println("invaild req close channel!!");
                ctx.channel().close();
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
//
//    private void sendFile(ChannelHandlerContext ctx, Frame frame){
//
//        RandomAccessFile raf = null;
//        long length = -1;
//        try{
//            raf = new RandomAccessFile(frame.getName(), "r");
//            length = raf.length();
//        }catch (Exception e){
//            e.printStackTrace();
//            ctx.writeAndFlush("ERR: " + e.getClass().getSimpleName() + " : " + e.getMessage() + "\n");
//            return;
//        }finally {
//            if(length < 0 && raf != null){
//                try {
//                    raf.close();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        //ctx.write("OK : " + raf.length() + "\n");
//        frame.setCode(Frame.TYPE.FILE_REQ);
//        frame.setLength(length);
//
//        int bufLen = 1024*1024;
//        byte[] buf = new byte[bufLen];
//        try {
//                raf.readFully(buf, (int) frame.getStart(), bufLen);
//                //frame.setStart(frame.getStart());
//                frame.setData(buf);
//                ctx.writeAndFlush(JSON.toJSONString(buf));
//
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }

    public void sendFile(ChannelHandlerContext ctx, Frame frame){

        if(frame.getLength() == frame.getStart() && frame.getLength() != 0){
            finishFile(ctx, frame);
        }
        Frame newF = new Frame(frame);
        newF.setLength(10240L);
        newF.setCode(Frame.TYPE.FILE_REQ);

        int bufLen = 16;
        byte[] buf = null;

        buf = FileSimulateUtil.read((int)frame.getStart(), bufLen);
        newF.setData(buf);
        ctx.writeAndFlush(newF);
    }

    private void finishFile(ChannelHandlerContext ctx, Frame frame){
        Frame newF = new Frame(frame);
        newF.setCode(Frame.TYPE.FINISH);
        ctx.writeAndFlush(newF).channel().close();
    }

}
