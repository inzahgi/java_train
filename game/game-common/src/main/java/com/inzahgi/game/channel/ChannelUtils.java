package com.inzahgi.game.channel;

import com.inzahgi.game.entity.ClientTransferData;
import com.inzahgi.game.entity.DataProtoc;
import com.inzahgi.game.entity.ServerTransferData;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.enums.GameEventCode;

import com.inzahgi.game.utils.MsgUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

public class ChannelUtils {

	public static ChannelFuture pushForGame(Channel ch, GameEventCode gameCode, byte[] msgData, String playload){
		DataProtoc.Data out = MsgUtils.buildForGame(gameCode.getCode(), msgData, playload);
		return ch.writeAndFlush(out);
	}

	public static ChannelFuture pushForCtrl(Channel ch, CtrlEventCode ctrlCode, byte[] msgData, String playload){
		DataProtoc.Data out = MsgUtils.buildForCtrl(ctrlCode.getCode(), msgData, playload);
		return ch.writeAndFlush(out);
	}


	
}
