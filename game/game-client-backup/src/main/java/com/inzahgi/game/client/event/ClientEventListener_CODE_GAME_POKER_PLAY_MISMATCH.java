package com.inzahgi.game.client.event;

import java.util.Map;

import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_GAME_POKER_PLAY_MISMATCH extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		Map<String, Object> map = MapHelper.parser(data);
		
		SimplePrinter.printNotice("Your pokers' type is " + map.get("playType") + " (" + map.get("playCount") + ") but previous pokers' type is " + map.get("preType") + " (" + map.get("preCount") + "), mismatch !!");
		
		if(lastPokers != null) {
			SimplePrinter.printNotice(lastSellClientNickname + "[" + lastSellClientType + "] played:");
			SimplePrinter.printPokers(lastPokers);
		}
		
		pushToServer(channel, ServerEventCode.CODE_GAME_POKER_PLAY_REDIRECT);
	}

}
