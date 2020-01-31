package com.inzahgi.game.server.event;

import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.server.ServerContains;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.server.ServerContains;

public class ServerEventListener_CODE_CLIENT_EXIT implements ServerEventListener{

	@Override
	public void call(ClientSide clientSide, String data) {

		Room room = ServerContains.getRoom(clientSide.getRoomId());

		if(room != null) {
			String result = MapHelper.newInstance()
								.put("roomId", room.getId())
								.put("exitClientId", clientSide.getId())
								.put("exitClientNickname", clientSide.getNickname())
								.json();
			for(ClientSide client: room.getClientSideList()) {
				if(client.getRole() == ClientRole.PLAYER){
					ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_CLIENT_EXIT, result);
					client.init();
				}
			}
			ServerContains.removeRoom(room.getId());
		}
	}

}
