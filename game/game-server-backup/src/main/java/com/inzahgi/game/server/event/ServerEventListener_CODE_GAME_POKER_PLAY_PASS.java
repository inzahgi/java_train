package com.inzahgi.game.server.event;

import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.server.robot.RobotEventListener;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ClientRole;
import com.inzahgi.game.helper.MapHelper;
import com.inzahgi.game.server.ServerContains;
import com.inzahgi.game.server.robot.RobotEventListener;

public class ServerEventListener_CODE_GAME_POKER_PLAY_PASS implements ServerEventListener{

	@Override
	public void call(ClientSide clientSide, String data) {
		Room room = ServerContains.getRoom(clientSide.getRoomId());

		if(room != null) {
			//出牌方为当前客户端
			if(room.getCurrentSellClient() == clientSide.getId()) {
				//如果不是最后一个出牌者
				if(clientSide.getId() != room.getLastSellClient()) {
					//找到下一下 出牌者
					ClientSide turnClient = clientSide.getNext();
					//更新当前出牌方
					room.setCurrentSellClient(turnClient.getId());
					//发送下一个出牌消息
					for(ClientSide client: room.getClientSideList()) {
						String result = MapHelper.newInstance()
								.put("clientId", clientSide.getId())
								.put("clientNickname", clientSide.getNickname())
								.put("nextClientId", turnClient.getId())
								.put("nextClientNickname", turnClient.getNickname())
								.json();
						// 发送用户下一个出牌的消息
						if(client.getRole() == ClientRole.PLAYER) {
							ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_GAME_POKER_PLAY_PASS, result);
						}else {
							if(client.getId() == turnClient.getId()) {
								//通知机器人出牌
								RobotEventListener.get(ClientEventCode.CODE_GAME_POKER_PLAY).call(turnClient, data);
							}
						}
					}
				}else {
					// 都不要 出牌方再次出牌
					ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_GAME_POKER_PLAY_CANT_PASS, null);
				}
			}else {
				// 没有轮到该用户出牌
				ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_GAME_POKER_PLAY_ORDER_ERROR, null);
			}
		}else {
//			ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_ROOM_PLAY_FAIL_BY_INEXIST, null);
		}
	}

}
