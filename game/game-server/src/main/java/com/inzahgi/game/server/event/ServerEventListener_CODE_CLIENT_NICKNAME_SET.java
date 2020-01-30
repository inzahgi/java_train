package com.inzahgi.game.server.event;

import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.server.ServerContains;

public class ServerEventListener_CODE_CLIENT_NICKNAME_SET implements ServerEventListener{

	public static final int NICKNAME_MAX_LENGTH = 10;
	
	@Override
	public void call(ClientSide client, String nickname) {
		
		if (nickname.trim().length() > NICKNAME_MAX_LENGTH) {
			String result = MapHelper.newInstance().put("invalidLength", nickname.trim().length()).json();
			ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_CLIENT_NICKNAME_SET, result);
		}else{
			ServerContains.CLIENT_SIDE_MAP.get(client.getId()).setNickname(nickname);
			ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_SHOW_OPTIONS, null);
		}
	}

}
