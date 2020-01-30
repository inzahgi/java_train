package com.inzahgi.game.client.event;

import java.util.Map;

import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_ROOM_JOIN_FAIL_BY_INEXIST extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		Map<String, Object> dataMap = MapHelper.parser(data);
		
		SimplePrinter.printNotice("Join room failed. Room " + dataMap.get("roomId") + " inexists!");
		ClientEventListener.get(ClientEventCode.CODE_SHOW_OPTIONS).call(channel, data);
	}



}
