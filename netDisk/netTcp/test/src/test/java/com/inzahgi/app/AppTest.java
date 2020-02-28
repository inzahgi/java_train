package com.inzahgi.app;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSON;
import com.inzahgi.app.entity.Frame;
import com.inzahgi.app.handler.ByteToFrameDecoder;
import com.inzahgi.app.handler.FileClientHandler;
import com.inzahgi.app.handler.FileServerHandler;
import com.inzahgi.app.handler.FrameToByteEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void codecReqTest(){

        EmbeddedChannel clientChannel = new EmbeddedChannel(
                new ByteToFrameDecoder(),
                new FrameToByteEncoder(),
                new FileClientHandler()
        );


        Frame frame = new Frame(Frame.TYPE.INVAILD, 5, 1, "1.txt", new byte[]{0x11, 0x12});
        System.out.println("out = " + JSON.toJSONString(frame));
        clientChannel.writeOutbound(frame);
        clientChannel.flushOutbound();
        //printOutBuf(clientChannel);


        EmbeddedChannel serverChannel = new EmbeddedChannel(
                new ByteToFrameDecoder(),
                new FrameToByteEncoder(),
                new FileServerHandler()
        );

        ByteBuf buf = clientChannel.readOutbound();
        buf = buf.markReaderIndex();
        System.out.println(ByteBufUtil.prettyHexDump(buf));
        buf = buf.resetReaderIndex();
        serverChannel.writeInbound(buf);

    }


    @Test
    public void codecRespTest(){
        EmbeddedChannel clientChannel = new EmbeddedChannel(
                new ByteToFrameDecoder(),
                new FrameToByteEncoder(),
                new FileServerHandler()
        );


        Frame frame = new Frame(Frame.TYPE.INVAILD, 5, 1, "1.txt", new byte[]{0x11, 0x12});
        System.out.println("out = " + JSON.toJSONString(frame));
        clientChannel.writeOutbound(frame);
        clientChannel.flushOutbound();
        //printOutBuf(clientChannel);


        EmbeddedChannel serverChannel = new EmbeddedChannel(
                new ByteToFrameDecoder(),
                new FrameToByteEncoder(),
                new FileClientHandler()
        );

        ByteBuf buf = clientChannel.readOutbound();
        buf = buf.markReaderIndex();
        System.out.println(ByteBufUtil.prettyHexDump(buf));
        buf = buf.resetReaderIndex();
        serverChannel.writeInbound(buf);
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


    private void printInBuf(EmbeddedChannel channel){
        System.out.println("-----------------");
        while (true){
            ByteBuf byteBuf = (ByteBuf) channel.readInbound();
            if(byteBuf == null){
                break;
            }
            System.out.println(ByteBufUtil.prettyHexDump(byteBuf));
        }
        System.out.println("-----------------");
    }
}
