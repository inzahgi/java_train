package com.inzahgi.game.client.event;

import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_ROOM_PLAY_FAIL_BY_INEXIST extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		
		SimplePrinter.printNotice("Play failed. Room already dissolution!");
		ClientEventListener.get(ClientEventCode.CODE_SHOW_OPTIONS).call(channel, data);
	}



}
