package com.inzahgi.game.server.handler;

import java.util.List;

import com.inzahgi.game.entity.ServerTransferData;
import com.inzahgi.game.entity.ServerTransferData.ServerTransferDataProtoc;

import com.google.protobuf.MessageLite;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

public class SecondProtobufCodec extends MessageToMessageCodec<ServerTransferData.ServerTransferDataProtoc, MessageLite> {

	@Override
	protected void encode(ChannelHandlerContext ctx, MessageLite msg, List<Object> out) throws Exception {
		out.add(msg);
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ServerTransferData.ServerTransferDataProtoc msg, List<Object> out) throws Exception {
		out.add(msg);
	}


}
