package com.inzahgi.game.client.event;

import java.util.List;
import java.util.Map;

import org.nico.noson.Noson;
import org.nico.noson.entity.NoType;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_GAME_STARTING extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		
		Map<String, Object> map = MapHelper.parser(data);
		
		SimplePrinter.printNotice("Game starting !!");
		
		List<Poker> pokers = Noson.convert(map.get("pokers"), new NoType<List<Poker>>() {});
		
		SimplePrinter.printNotice("");
		SimplePrinter.printNotice("Your pokers are");
		SimplePrinter.printPokers(pokers);
	
		get(ClientEventCode.CODE_GAME_LANDLORD_ELECT).call(channel, data);
	}

}
