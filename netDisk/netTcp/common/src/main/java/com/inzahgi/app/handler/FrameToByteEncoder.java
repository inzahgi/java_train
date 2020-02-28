package com.inzahgi.app.handler;

import com.inzahgi.app.entity.Frame;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;


public class FrameToByteEncoder extends MessageToByteEncoder<Frame>  {

    @Override
    protected void encode(ChannelHandlerContext ctx, Frame msg, ByteBuf out) throws Exception {

        if(msg == null){
            return;
        }
        byte[] nameAr = msg.getName().getBytes(CharsetUtil.UTF_8);
        //读取消息的长度
        int dataLength = 4 + 8 +8 + nameAr.length + 8;
        if(msg.getData() != null){
            dataLength += msg.getData().length;
        }
        //先将消息长度写入，也就是消息头
        out.writeInt(dataLength);
        //消息体中包含我们要发送的数据
        out.writeInt(msg.getCode());
        out.writeLong(msg.getLength());
        out.writeLong(msg.getStart());
        out.writeInt(nameAr.length);
        out.writeBytes(nameAr);
        if(msg.getData() != null) {
            out.writeInt(msg.getData().length);
            out.writeBytes(msg.getData());
        }else {
            out.writeInt(0);
        }
    }

}
