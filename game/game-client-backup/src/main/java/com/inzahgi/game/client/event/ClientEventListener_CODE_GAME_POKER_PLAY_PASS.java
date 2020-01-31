package com.inzahgi.game.client.event;

import java.util.Map;

import com.inzahgi.game.client.GameClient;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_GAME_POKER_PLAY_PASS extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		Map<String, Object> map = MapHelper.parser(data);
		
		SimplePrinter.printNotice(map.get("clientNickname") + " passed. It is now " + map.get("nextClientNickname") + "'s turn.");
		
		int turnClientId = (int) map.get("nextClientId");
		if(GameClient.id == turnClientId) {
			pushToServer(channel, ServerEventCode.CODE_GAME_POKER_PLAY_REDIRECT);
		}
	}

}
