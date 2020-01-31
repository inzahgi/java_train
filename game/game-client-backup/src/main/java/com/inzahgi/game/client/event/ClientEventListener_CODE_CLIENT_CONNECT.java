package com.inzahgi.game.client.event;

import com.inzahgi.game.client.GameClient;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_CLIENT_CONNECT extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		SimplePrinter.printNotice("Connection to server is successful. Welcome to the game!!");
		GameClient.id = Integer.parseInt(data);
	}

}
