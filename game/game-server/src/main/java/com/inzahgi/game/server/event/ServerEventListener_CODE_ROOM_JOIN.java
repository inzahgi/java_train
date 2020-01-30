package com.inzahgi.game.server.event;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListMap;

import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.RoomStatus;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.server.ServerContains;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.RoomStatus;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.server.ServerContains;

public class ServerEventListener_CODE_ROOM_JOIN implements ServerEventListener{

	@Override
	public void call(ClientSide clientSide, String data) {

		Room room = ServerContains.getRoom(Integer.valueOf(data));
		
		if(room == null) {
			String result = MapHelper.newInstance()
								.put("roomId", data)
								.json();
			ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_ROOM_JOIN_FAIL_BY_INEXIST, result);
		}else {
			if(room.getClientSideList().size() == 3) {
				String result = MapHelper.newInstance()
						.put("roomId", room.getId())
						.put("roomOwner", room.getRoomOwner())
						.json();
				ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_ROOM_JOIN_FAIL_BY_FULL, result);
			}else {
				clientSide.setRoomId(room.getId());

				ConcurrentSkipListMap<Integer, ClientSide> roomClientMap = (ConcurrentSkipListMap<Integer, ClientSide>) room.getClientSideMap();
				LinkedList<ClientSide> roomClientList = room.getClientSideList();

				if(roomClientList.size() > 0){
					ClientSide pre = roomClientList.getLast();
					pre.setNext(clientSide);
					clientSide.setPre(pre);
				}

				roomClientList.add(clientSide);
				roomClientMap.put(clientSide.getId(), clientSide);

				if(roomClientMap.size() == 3) {
					clientSide.setNext(roomClientList.getFirst());
					roomClientList.getFirst().setPre(clientSide);

					ServerEventListener.get(ServerEventCode.CODE_GAME_STARTING).call(clientSide, String.valueOf(room.getId()));
				}else {
					room.setStatus(RoomStatus.WAIT);

					String result = MapHelper.newInstance()
							.put("clientId", clientSide.getId())
							.put("clientNickname", clientSide.getNickname())
							.put("roomId", room.getId())
							.put("roomOwner", room.getRoomOwner())
							.put("roomClientCount", room.getClientSideList().size())
							.json();
					for(ClientSide client: roomClientMap.values()) {
						ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_ROOM_JOIN_SUCCESS, result);
					}
				}
			}


		}
	}





}
