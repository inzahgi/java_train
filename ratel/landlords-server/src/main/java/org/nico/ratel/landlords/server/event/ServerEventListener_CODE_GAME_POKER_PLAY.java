package org.nico.ratel.landlords.server.event;

import java.util.List;

import org.nico.noson.Noson;
import org.nico.ratel.landlords.channel.ChannelUtils;
import org.nico.ratel.landlords.entity.ClientSide;
import org.nico.ratel.landlords.entity.Poker;
import org.nico.ratel.landlords.entity.PokerSell;
import org.nico.ratel.landlords.entity.Room;
import org.nico.ratel.landlords.enums.ClientEventCode;
import org.nico.ratel.landlords.enums.ClientRole;
import org.nico.ratel.landlords.enums.SellType;
import org.nico.ratel.landlords.enums.ServerEventCode;
import org.nico.ratel.landlords.helper.MapHelper;
import org.nico.ratel.landlords.helper.PokerHelper;
import org.nico.ratel.landlords.server.ServerContains;
import org.nico.ratel.landlords.server.robot.RobotEventListener;

public class ServerEventListener_CODE_GAME_POKER_PLAY implements ServerEventListener{

	@Override
	public void call(ClientSide clientSide, String data) {
		//获取房间
		Room room = ServerContains.getRoom(clientSide.getRoomId());
		if(room != null) {
			//如果是当前的出牌方
			if(room.getCurrentSellClient() == clientSide.getId()) {
				//反序列化输入参数
				Character[] options = Noson.convert(data, Character[].class);
				// 获取输入牌数索引
				int[] indexes = PokerHelper.getIndexes(options, clientSide.getPokers());
				//检查输入扑克牌索引是否正确
				if(PokerHelper.checkPokerIndex(indexes, clientSide.getPokers())){
					boolean sellFlag = true;
					//获取输出扑克
					List<Poker> currentPokers = PokerHelper.getPoker(indexes, clientSide.getPokers());
					//检查出牌类型 并初始化 出牌结果
					PokerSell currentPokerShell = PokerHelper.checkPokerType(currentPokers);
					if(currentPokerShell.getSellType() != SellType.ILLEGAL) {
						//如果上一次出牌的不是当前出牌人
						if(room.getLastSellClient() != clientSide.getId() && room.getLastPokerShell() != null){
							PokerSell lastPokerShell = room.getLastPokerShell();
							//出牌类型不符合  直接返回
							if((lastPokerShell.getSellType() != currentPokerShell.getSellType() || lastPokerShell.getSellPokers().size() != currentPokerShell.getSellPokers().size()) && currentPokerShell.getSellType() != SellType.BOMB && currentPokerShell.getSellType() != SellType.KING_BOMB) {
								String result = MapHelper.newInstance()
													.put("playType", currentPokerShell.getSellType())
													.put("playCount", currentPokerShell.getSellPokers().size())
													.put("preType", lastPokerShell.getSellType())
													.put("preCount", lastPokerShell.getSellPokers().size())
													.json();
								sellFlag = false;
								ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_GAME_POKER_PLAY_MISMATCH, result);
								//出牌牌面过小 返回
							}else if(lastPokerShell.getScore() >= currentPokerShell.getScore()) {
								String result = MapHelper.newInstance()
										.put("playScore", currentPokerShell.getScore())
										.put("preScore", lastPokerShell.getScore())
										.json();
								sellFlag = false;
								ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_GAME_POKER_PLAY_LESS, result);
							}
						}
					}else {
						//出牌类型错误 直接返回
						sellFlag = false;
						ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_GAME_POKER_PLAY_INVALID, null);
					}
					// 出牌成功
					if(sellFlag) {
						//更换出牌方
						ClientSide next = clientSide.getNext();
						//更新最后出牌
						room.setLastSellClient(clientSide.getId());
						room.setLastPokerShell(currentPokerShell);
						room.setCurrentSellClient(next.getId());
						//移除当前出牌
						clientSide.getPokers().removeAll(currentPokers);
						MapHelper mapHelper = MapHelper.newInstance()
								.put("clientId", clientSide.getId())
								.put("clientNickname", clientSide.getNickname())
								.put("clientType", clientSide.getType())
								.put("pokers", currentPokers);
						//如果牌面不为空 更新下次出牌人昵称
						if(! clientSide.getPokers().isEmpty()) {
							mapHelper.put("sellClinetNickname", next.getNickname());
						}
						
						String result = mapHelper.json();
						//更新出牌信息
						for(ClientSide client: room.getClientSideList()) {
							if(client.getRole() == ClientRole.PLAYER) {
								ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_SHOW_POKERS, result);
							}
						}
						// 如果 本方已经出完牌 直接获胜
						if(clientSide.getPokers().isEmpty()) {
							result = MapHelper.newInstance()
												.put("winnerNickname", clientSide.getNickname())
												.put("winnerType", clientSide.getType())
												.json();
							// 更新 游戏结束信息
							for(ClientSide client: room.getClientSideList()) {
								if(client.getRole() == ClientRole.PLAYER) {
									ChannelUtils.pushToClient(client.getChannel(), ClientEventCode.CODE_GAME_OVER, result);
								}
							}
							//通知玩家游戏退出
							ServerEventListener.get(ServerEventCode.CODE_CLIENT_EXIT).call(clientSide, data);
						}else {
							//通知玩家出牌
							if(next.getRole() == ClientRole.PLAYER) {
								ServerEventListener.get(ServerEventCode.CODE_GAME_POKER_PLAY_REDIRECT).call(next, result);
							}else {
								//通知机器人出牌
								RobotEventListener.get(ClientEventCode.CODE_GAME_POKER_PLAY).call(next, data);
							}
						}
					}
				}else{
					//出牌结果检查 不对
					ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_GAME_POKER_PLAY_INVALID, null);
				}
			}else {
				//没有轮到该玩家出牌
				ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_GAME_POKER_PLAY_ORDER_ERROR, null);
			}
		}else {
//			ChannelUtils.pushToClient(clientSide.getChannel(), ClientEventCode.CODE_ROOM_PLAY_FAIL_BY_INEXIST, null);
		}
	}

}
