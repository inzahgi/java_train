package com.inzahgi.game.client.event;

import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_GAME_LANDLORD_CYCLE extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		SimplePrinter.printNotice("No player takes the landlord, so redealing cards.");
		
	}

}
