package com.inzahgi.game.server.event;

import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.robot.RobotDecisionMakers;
import com.inzahgi.game.server.ServerContains;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.enums.ClientStatus;
import com.inzahgi.game.enums.RoomStatus;
import com.inzahgi.game.enums.RoomType;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.robot.RobotDecisionMakers;
import com.inzahgi.game.server.ServerContains;

public class ServerEventListener_CODE_ROOM_CREATE_PVE implements ServerEventListener{

	@Override
	public void call(ClientSide clientSide, String data) {
		
		int difficultyCoefficient = Integer.valueOf(data);
		if(RobotDecisionMakers.contains(difficultyCoefficient)) {

			Room room = new Room(ServerContains.getServerId());
			room.setType(RoomType.PVE);
			room.setStatus(RoomStatus.BLANK);
			room.setRoomOwner(clientSide.getNickname());
			room.getClientSideMap().put(clientSide.getId(), clientSide);
			room.getClientSideList().add(clientSide);
			room.setCurrentSellClient(clientSide.getId());
			room.setCreateTime(System.currentTimeMillis());
			room.setDifficultyCoefficient(difficultyCoefficient);
			
			clientSide.setRoomId(room.getId());
			ServerContains.addRoom(room);
			
			ClientSide preClient = clientSide;
			//Add robots
			for(int index = 1; index < 3; index ++) {
				ClientSide robot = new ClientSide(- ServerContains.getClientId(), ClientStatus.PLAYING, null);
				robot.setNickname("robot_" + index);
				robot.setRole(ClientRole.ROBOT);
				preClient.setNext(robot);
				robot.setPre(preClient);
				robot.setRoomId(room.getId());
				room.getClientSideMap().put(robot.getId(), robot);
				room.getClientSideList().add(robot);
				
				preClient = robot;
				ServerContains.CLIENT_SIDE_MAP.put(robot.getId(), robot);
			}
			preClient.setNext(clientSide);
			clientSide.setPre(preClient);
			
			ServerEventListener.get(ServerEventCode.CODE_GAME_STARTING).call(clientSide, String.valueOf(room.getId()));
		}else {
			ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_PVE_DIFFICULTY_NOT_SUPPORT, null);
		}
		
	}

	



}
