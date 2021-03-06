package com.inzahgi.game.client.event;

import java.util.Map;

import com.inzahgi.game.client.GameClient;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.print.SimplePrinter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_CLIENT_EXIT extends ClientEventListener{

	@Override
	public void call(Channel channel, String data) {
		Map<String, Object> map = MapHelper.parser(data);
		
		Integer exitClientId = (Integer) map.get("exitClientId");
		
		String role = null;
		if(exitClientId == GameClient.id) {
			role = "You";
		}else {
			role = String.valueOf(map.get("exitClientNickname"));
		}
		SimplePrinter.printNotice(role + " exit from the room. Room disbanded!!\n");
		
		get(ClientEventCode.CODE_SHOW_OPTIONS).call(channel, data);
	}

}
