package com.inzahgi.game.client.event;

import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_PVE_DIFFICULTY_NOT_SUPPORT extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		SimplePrinter.printNotice("The current difficulty coefficient is not supported, please pay attention to the following.\n");
		get(ClientEventCode.CODE_SHOW_OPTIONS_PVE).call(channel, data);
	}



}
