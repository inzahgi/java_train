package com.inzahgi.game.client.event;

import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_GAME_POKER_PLAY_ORDER_ERROR extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		
		SimplePrinter.printNotice("Not turn you to operate, please wait other player !!");
	}

}
