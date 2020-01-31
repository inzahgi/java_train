package com.inzahgi.game.client.event;

import java.util.Map;

import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_GAME_OVER extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		Map<String, Object> map = MapHelper.parser(data);
		SimplePrinter.printNotice("\nPlayer " + map.get("winnerNickname") + "[" + map.get("winnerType") + "]" + " won the game");
		SimplePrinter.printNotice("Game over, friendship first, competition second\n");
	}

}
