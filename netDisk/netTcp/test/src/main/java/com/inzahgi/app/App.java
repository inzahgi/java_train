package com.inzahgi.app;

import com.inzahgi.app.handler.FileClientHandler;
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

        EmbeddedChannel clientChannel = new EmbeddedChannel(
                new LengthFieldBasedFrameDecoder(8192, 0, 4),
                new LengthFieldPrepender(4),
                new StringEncoder(CharsetUtil.UTF_8),
                new StringDecoder(CharsetUtil.UTF_8),
                new FileClientHandler()
        );
    }
}
