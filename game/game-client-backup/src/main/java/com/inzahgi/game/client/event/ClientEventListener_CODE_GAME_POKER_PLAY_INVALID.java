package com.inzahgi.game.client.event;

import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_GAME_POKER_PLAY_INVALID extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		
		SimplePrinter.printNotice("Out pokers' format is invalid");
		
		if(lastPokers != null) {
			SimplePrinter.printNotice(lastSellClientNickname + "[" + lastSellClientType + "] played:");
			SimplePrinter.printPokers(lastPokers);
		}

		pushToServer(channel, ServerEventCode.CODE_GAME_POKER_PLAY_REDIRECT);
	}

}
