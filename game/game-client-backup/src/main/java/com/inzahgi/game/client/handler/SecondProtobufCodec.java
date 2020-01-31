package com.inzahgi.game.client.handler;

import java.util.List;

import com.inzahgi.game.entity.ClientTransferData.ClientTransferDataProtoc;

import com.google.protobuf.MessageLite;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

public class SecondProtobufCodec extends MessageToMessageCodec<ClientTransferDataProtoc, MessageLite> {

	@Override
	protected void encode(ChannelHandlerContext ctx, MessageLite msg, List<Object> out) throws Exception {
		out.add(msg);
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ClientTransferDataProtoc msg, List<Object> out) throws Exception {
		out.add(msg);
	}

}
