package com.inzahgi.game.client.event;

import java.util.Map;

import org.nico.noson.util.string.StringUtils;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.print.SimpleWriter;

import io.netty.channel.Channel;

public class ClientEventListener_CODE_CLIENT_NICKNAME_SET extends ClientEventListener{

	public static final int NICKNAME_MAX_LENGTH = 10;
	
	@Override
	public void call(Channel channel, String data) {
		
		// If it is not the first time that the user is prompted to enter nickname
		// If first time, data = null or "" otherwise not empty
		if (StringUtils.isNotBlank(data)) {
			Map<String, Object> dataMap = MapHelper.parser(data);
			if (dataMap.containsKey("invalidLength")) {
				SimplePrinter.printNotice("Your nickname length was invalid: " + dataMap.get("invalidLength"));
			}
		}
		SimplePrinter.printNotice("Please set your nickname (upto " + NICKNAME_MAX_LENGTH + " characters)");
		String nickname = SimpleWriter.write("nickname");
		
		// If the length of nickname is more that NICKNAME_MAX_LENGTH
		if (nickname.trim().length() > NICKNAME_MAX_LENGTH) {
			String result = MapHelper.newInstance().put("invalidLength", nickname.trim().length()).json();
			get(ClientEventCode.CODE_CLIENT_NICKNAME_SET).call(channel, result);
		}else{
			pushToServer(channel, ServerEventCode.CODE_CLIENT_NICKNAME_SET, nickname);
		}
	}



}
