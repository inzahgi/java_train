package com.inzahgi.game.client.event;

import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_CLIENT_KICK extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		
		SimplePrinter.printNotice("As a result of long time do not operate, be forced by the system to kick out of the room\n");
		
		get(ClientEventCode.CODE_SHOW_OPTIONS).call(channel, data);
	}

}
