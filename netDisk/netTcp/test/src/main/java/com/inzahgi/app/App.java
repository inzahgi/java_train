package com.inzahgi.app;

import com.alibaba.fastjson.JSON;
import com.inzahgi.app.entity.Frame;
import com.inzahgi.app.handler.ByteToFrameDecoder;
import com.inzahgi.app.handler.FileClientHandler;
import com.inzahgi.app.handler.FrameToByteEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import sun.awt.EmbeddedFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );



    }



}
