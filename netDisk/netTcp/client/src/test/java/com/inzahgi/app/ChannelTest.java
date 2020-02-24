package com.inzahgi.app;

import com.alibaba.fastjson.JSON;
import com.inzahgi.app.entity.Frame;
import com.inzahgi.app.handler.FileClientHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.junit.Test;

public class ChannelTest {

    @Test
    public void outChannelTest(){

        EmbeddedChannel channelOut = new EmbeddedChannel(
                new LengthFieldBasedFrameDecoder(8192, 0, 4),
                new LengthFieldPrepender(4),
                new StringEncoder(CharsetUtil.UTF_8),
                new StringDecoder(CharsetUtil.UTF_8),
                new FileClientHandler()
        );

        Frame frame = new Frame(Frame.TYPE.INFO, 0, 0, "1.txt", null);
        channelOut.writeOutbound(JSON.toJSONString(frame));
        //channel.flushOutbound();
        printOutBuf(channelOut);

    }


    private void printOutBuf(EmbeddedChannel channel){
        System.out.println("-----------------");
        while (true){
            ByteBuf byteBuf = (ByteBuf) channel.readOutbound();
            if(byteBuf == null){
                break;
            }
            System.out.println(ByteBufUtil.prettyHexDump(byteBuf));
        }
        System.out.println("-----------------");
    }
}
