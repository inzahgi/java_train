package com.inzahgi.game.server.event;

import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.RoomStatus;
import com.inzahgi.game.enums.RoomType;
import com.inzahgi.game.server.ServerContains;
import org.nico.noson.Noson;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.RoomStatus;
import com.inzahgi.game.enums.RoomType;
import com.inzahgi.game.server.ServerContains;

public class ServerEventListener_CODE_ROOM_CREATE implements ServerEventListener{

	@Override
	public void call(ClientSide clientSide, String data) {
		
		Room room = new Room(ServerContains.getServerId());
		room.setStatus(RoomStatus.BLANK);
		room.setType(RoomType.PVP);
		room.setRoomOwner(clientSide.getNickname());
		room.getClientSideMap().put(clientSide.getId(), clientSide);
		room.getClientSideList().add(clientSide);
		room.setCurrentSellClient(clientSide.getId());
		room.setCreateTime(System.currentTimeMillis());
		room.setLastFlushTime(System.currentTimeMillis());
		
		clientSide.setRoomId(room.getId());
		ServerContains.addRoom(room);
		
		ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_ROOM_CREATE_SUCCESS, Noson.reversal(room));
	}

	



}
