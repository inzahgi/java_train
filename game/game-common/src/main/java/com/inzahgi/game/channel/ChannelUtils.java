package com.inzahgi.game.channel;

import com.inzahgi.game.entity.ClientTransferData;
import com.inzahgi.game.entity.DataProtoc;
import com.inzahgi.game.entity.ServerTransferData;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.enums.GameEventCode;
import com.inzahgi.game.enums.ServerEventCode;

import com.inzahgi.game.utils.MsgUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

public class ChannelUtils {

	public static void pushToClientForGame(Channel ch, GameEventCode gameCode, byte[] msgData, String playload){
		DataProtoc.Data out = MsgUtils.buildForGame(gameCode.getCode(), msgData, playload);
		ch.writeAndFlush(out);
	}

	public static void pushToClientForCtrl(Channel ch, CtrlEventCode ctrlCode, byte[] msgData, String playload){
		DataProtoc.Data out = MsgUtils.buildForCtrl(ctrlCode.getCode(), msgData, playload);
		ch.writeAndFlush(out);
	}






	public static void pushToClient(Channel channel, ClientEventCode code, String data) {
		pushToClient(channel, code, data, null);
	}
	
	public static void pushToClient(Channel channel, ClientEventCode code, String data, String info) {
		if(channel != null) {
			ClientTransferData.ClientTransferDataProtoc.Builder clientTransferData = ClientTransferData.ClientTransferDataProtoc.newBuilder();
			if(code != null) {
				clientTransferData.setCode(code.toString());
			}
			if(data != null) {
				clientTransferData.setData(data);
			}
			if(info != null) {
				clientTransferData.setInfo(info);
			}
			channel.writeAndFlush(clientTransferData);
		}
	}
	
	public static ChannelFuture pushToServer(Channel channel, ServerEventCode code, String data) {
		ServerTransferData.ServerTransferDataProtoc.Builder serverTransferData = ServerTransferData.ServerTransferDataProtoc.newBuilder();
		if(code != null) {
			serverTransferData.setCode(code.toString());		
		}
		if(data != null) {
			serverTransferData.setData(data);
		}
		return channel.writeAndFlush(serverTransferData);
	}
	
}
