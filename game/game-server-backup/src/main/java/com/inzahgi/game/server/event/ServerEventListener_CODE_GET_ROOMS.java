package com.inzahgi.game.server.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.server.ServerContains;
import org.nico.noson.Noson;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.server.ServerContains;

public class ServerEventListener_CODE_GET_ROOMS implements ServerEventListener{

	@Override
	public void call(ClientSide clientSide, String data) {
		List<Map<String, Object>> roomList = new ArrayList<>(ServerContains.getRoomMap().size());
		for(Entry<Integer, Room> entry: ServerContains.getRoomMap().entrySet()) {
			Room room = entry.getValue();
			roomList.add(MapHelper.newInstance()
					.put("roomId", room.getId())
					.put("roomOwner", room.getRoomOwner())
					.put("roomClientCount", room.getClientSideList().size())
					.put("roomType", room.getType())
					.map());
		}
		ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_SHOW_ROOMS, Noson.reversal(roomList));
	}

}
