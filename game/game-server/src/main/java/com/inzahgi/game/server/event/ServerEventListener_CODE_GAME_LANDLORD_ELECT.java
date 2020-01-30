package com.inzahgi.game.server.event;


import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.enums.ClientType;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.server.ServerContains;
import com.inzahgi.game.server.robot.RobotEventListener;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.enums.ClientType;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.helper.PokerHelper;
import com.inzahgi.game.server.ServerContains;
import com.inzahgi.game.server.robot.RobotEventListener;

public class ServerEventListener_CODE_GAME_LANDLORD_ELECT implements ServerEventListener{

	@Override
	public void call(ClientSide clientSide, String data) {

		Room room = ServerContains.getRoom(clientSide.getRoomId());
		
		if(room != null) {
			boolean isY = Boolean.valueOf(data);
			if(isY){
				clientSide.getPokers().addAll(room.getLandlordPokers());
				PokerHelper.sortPoker(clientSide.getPokers());
				
				int currentClientId = clientSide.getId();
				room.setLandlordId(currentClientId);
				room.setLastSellClient(currentClientId);
				room.setCurrentSellClient(currentClientId);
				clientSide.setType(ClientType.LANDLORD);
				
				for(ClientSide client: room.getClientSideList()){
					String result = MapHelper.newInstance()
							.put("roomId", room.getId())
							.put("roomOwner", room.getRoomOwner())
							.put("roomClientCount", room.getClientSideList().size())
							.put("landlordNickname", clientSide.getNickname())
							.put("landlordId", clientSide.getId())
							.put("additionalPokers", room.getLandlordPokers())
							.json();
					
					if(client.getRole() == ClientRole.PLAYER) {
						ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_GAME_LANDLORD_CONFIRM, result);
					}else {
						if(currentClientId == client.getId()) {
							RobotEventListener.get(ClientEventCode.CODE_GAME_POKER_PLAY).call(client, result);
						}
					}
				}
			}else{
				if(clientSide.getNext().getId() == room.getLandlordId()){
					for(ClientSide client: room.getClientSideList()){
						if(client.getRole() == ClientRole.PLAYER) {
							ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_GAME_LANDLORD_CYCLE, null);
						}
					}
					ServerEventListener.get(ServerEventCode.CODE_GAME_STARTING).call(clientSide, null);
				}else{
					ClientSide turnClientSide = clientSide.getNext();
					room.setCurrentSellClient(turnClientSide.getId());
					String result = MapHelper.newInstance()
							.put("roomId", room.getId())
							.put("roomOwner", room.getRoomOwner())
							.put("roomClientCount", room.getClientSideList().size())
							.put("preClientNickname", clientSide.getNickname())
							.put("nextClientNickname", turnClientSide.getNickname())
							.put("nextClientId", turnClientSide.getId())
							.json();
					
					for(ClientSide client: room.getClientSideList()) {
						if(client.getRole() == ClientRole.PLAYER) {
							ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_GAME_LANDLORD_ELECT, result);
						}else {
							if(client.getId() == turnClientSide.getId()) {
								RobotEventListener.get(ClientEventCode.CODE_GAME_LANDLORD_ELECT).call(client, result);
							}
						}
					}
				}
			}
		}else {
//			ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_ROOM_PLAY_FAIL_BY_INEXIST, null);
		}
	}
}
