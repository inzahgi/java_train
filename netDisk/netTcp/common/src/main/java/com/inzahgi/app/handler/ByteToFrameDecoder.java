package com.inzahgi.app.handler;


import com.inzahgi.app.entity.Frame;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;


import java.util.List;

public class ByteToFrameDecoder extends ByteToMessageDecoder {




    public static final int HEAD_LENGTH = 4;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        //这个HEAD_LENGTH是我们用于表示头长度的字节数。  由于Encoder中我们传的是一个int类型的值，所以这里HEAD_LENGTH的值为4
        if (in.readableBytes() < HEAD_LENGTH) {
            return;
        }
        //我们标记一下当前的readIndex的位置
        in.markReaderIndex();
        // 读取传送过来的消息的长度。ByteBuf 的readInt()方法会让他的readIndex增加4
        int dataLength = in.readInt();
        // 我们读到的消息体长度为0，这是不应该出现的情况，这里出现这情况，关闭连接。
        if (dataLength < 0) {
            ctx.close();
        }

        //读到的消息体长度如果小于我们传送过来的消息长度，则resetReaderIndex. 这个配合markReaderIndex使用的。把readIndex重置到mark的地方
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return;
        }

        //传输正常
        byte[] body = new byte[dataLength];
        in.readBytes(body);
        //将byte数据转化为我们需要的对象
        Object o = convertToObject(body);
        out.add(o);
    }

    private Object convertToObject(byte[] body) {

        int code = getInt(body, 0);
        long length = getLength(body, 4);
        long start = getLength(body, 12);
        int nameLen = getInt(body, 20);
        String name = new String(body, 24, nameLen);
        int dataLength = getInt(body, 24+ nameLen);
        byte[] data = null;
        if(dataLength != 0){
            data = new byte[dataLength];
            int offset = 28 + nameLen;
            for (int i = 0; i < dataLength; i++) {
                data[i] = body[i + offset];
            }
        }
        return new Frame(code, length, start, name, data);
    }

    private int getInt(byte[] b, int offset){
        return  ((b[offset] & 0xff) << 24)
                + ((b[1 + offset] & 0xff) << 16)
                + ((b[2 + offset] & 0xff) << 8)
                + ((b[3 + offset] & 0xff));

    }

    private long getLength(byte[] b, int offset){

        return ((b[offset] & 0xff) << 56)
                + ((b[1 + offset] & 0xff) << 48)
                + ((b[2 + offset] & 0xff) << 40)
                + ((b[3 + offset] & 0xff) << 32)
                + ((b[4 + offset] & 0xff) << 24)
                + ((b[5 + offset] & 0xff) << 16)
                + ((b[6 + offset] & 0xff) << 8)
                + ((b[7 + offset] & 0xff));
    }





}
