package com.inzahgi.game.server.event;

import java.util.LinkedList;
import java.util.List;

import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.enums.ClientType;
import com.inzahgi.game.enums.RoomStatus;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.server.robot.RobotEventListener;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.enums.ClientType;
import com.inzahgi.game.enums.RoomStatus;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.server.ServerContains;
import com.inzahgi.game.server.robot.RobotEventListener;

public class ServerEventListener_CODE_GAME_STARTING implements ServerEventListener{

	@Override
	public void call(ClientSide clientSide, String data) {

		Room room = ServerContains.getRoom(clientSide.getRoomId());

		LinkedList<ClientSide> roomClientList = room.getClientSideList();

		// Send the points of poker
		List<List<Poker>> pokersList = PokerHelper.distributePoker();
		int cursor = 0;
		for(ClientSide client: roomClientList){
			client.setPokers(pokersList.get(cursor ++));
		}
		room.setLandlordPokers(pokersList.get(3));

		// Push information about the robber
		int startGrabIndex = (int)(Math.random() * 3);
		ClientSide startGrabClient = roomClientList.get(startGrabIndex);
		room.setCurrentSellClient(startGrabClient.getId());
		
		// Push start game messages
		room.setStatus(RoomStatus.STARTING);


		for(ClientSide client: roomClientList) {
			client.setType(ClientType.PEASANT);

			String result = MapHelper.newInstance()
					.put("roomId", room.getId())
					.put("roomOwner", room.getRoomOwner())
					.put("roomClientCount", room.getClientSideList().size())
					.put("nextClientNickname", startGrabClient.getNickname())
					.put("nextClientId", startGrabClient.getId())
					.put("pokers", client.getPokers())
					.json();

			if(client.getRole() == ClientRole.PLAYER) {
				ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_GAME_STARTING, result);
			}else {
				if(startGrabClient.getId() == client.getId()) {
					RobotEventListener.get(ClientEventCode.CODE_GAME_LANDLORD_ELECT).call(client, result);
				}
			}

		}


	}

}
