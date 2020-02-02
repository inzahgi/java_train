package com.inzahgi.game.client.handler;

import com.inzahgi.game.client.event.ClientEventListener;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientTransferData.ClientTransferDataProtoc;
import com.inzahgi.game.entity.ControlDataProtoc;
import com.inzahgi.game.entity.DataProtoc;
import com.inzahgi.game.entity.GameDataProtoc;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.enums.GameEventCode;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class TransferHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		if(msg instanceof DataProtoc.Data){
			DataProtoc.Data originData = (DataProtoc.Data) msg;
			switch (originData.getMsgType()){
				case 1:ctrlProcess(ctx, originData.getCtrlMsg());break;
				case 2:gameProcess(ctx, originData.getGameMsg());break;
				default:
			}
		}
	}

	@Override  
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {  
		if (evt instanceof IdleStateEvent) {  
			IdleStateEvent event = (IdleStateEvent) evt;  
			if (event.state() == IdleState.WRITER_IDLE) {  
				ChannelUtils.pushToServer(ctx.channel(), ServerEventCode.CODE_CLIENT_HEAD_BEAT, "heartbeat");
			}  
		}  
	} 
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if(cause instanceof java.io.IOException) {
			SimplePrinter.printNotice("The network is not good or did not operate for a long time, has been offline");
			System.exit(0);
		}
	}

	private void ctrlProcess(ChannelHandlerContext ctx, ControlDataProtoc.ControlData controlData){
		int msgCode = controlData.getMsgCode();
		String name = CtrlEventCode.getByCode(msgCode).name();
		byte[] data = controlData.getData().toByteArray();
		ClientEventListener.get(msgCode, name).call(ctx.channel(), data);

	}

	private void gameProcess(ChannelHandlerContext ctx, GameDataProtoc.GameData gameData){
		int msgCode = gameData.getMsgCode();
		String name = GameEventCode.getByCode(msgCode).name();
		byte[] data = gameData.getData().toByteArray();
		ClientEventListener.get(msgCode, name).call(ctx.channel(), data);
	}

}
