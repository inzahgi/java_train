package com.inzahgi.game.client.event;

import java.util.List;
import java.util.Map;

import org.nico.noson.Noson;
import org.nico.noson.entity.NoType;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_GAME_LANDLORD_CONFIRM extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		Map<String, Object> map = MapHelper.parser(data);
		
		String landlordNickname = String.valueOf(map.get("landlordNickname"));
		
		SimplePrinter.printNotice(landlordNickname + " grabbed the landlord and got extra three poker shots");
		
		List<Poker> additionalPokers = Noson.convert(map.get("additionalPokers"), new NoType<List<Poker>>() {});
		SimplePrinter.printPokers(additionalPokers);
		
		pushToServer(channel, ServerEventCode.CODE_GAME_POKER_PLAY_REDIRECT);
	}

}
