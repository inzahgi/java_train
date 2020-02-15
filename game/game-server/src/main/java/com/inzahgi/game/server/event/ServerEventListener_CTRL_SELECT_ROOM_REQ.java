package com.inzahgi.game.server.event;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.inzahgi.game.entity.Client;
import com.inzahgi.game.entity.Player;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.enums.RoomStatus;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.server.bean.RoomsSerice;
import com.inzahgi.game.server.bean.UsersService;
import com.inzahgi.game.utils.UrlUtils;
import io.netty.channel.Channel;

import java.util.List;

import static com.inzahgi.game.enums.CtrlEventCode.CTRL_JOIN_ROOM_RESP;
import static com.inzahgi.game.enums.CtrlEventCode.CTRL_SHOW_GAME_HALL_RESP;
import static com.inzahgi.game.enums.CtrlEventCode.CTRL_START_GAME_RESP;


public class ServerEventListener_CTRL_SELECT_ROOM_REQ implements ServerEventListener{

	@Inject
	private UsersService usersService;

	@Inject
	private RoomsSerice roomsSerice;

	@Override
	public void call(Channel ch, byte[] data) {
		String input = new String(data);
		String address = UrlUtils.getRemoteAddress(ch);
		SimplePrinter.serverLog(address, input);


		Client client = usersService.getOwn(ch);
		Preconditions.checkNotNull(ch);
		Player player = new Player(client.getId(), client.getNickname(), false, false);
		Room room = roomsSerice.addRoom(Integer.valueOf(input), player);
		//String outStr = gson.toJson(room);
		//CtrlEventCode nextCode = FlowUtils.getNext(CtrlEventCode.CTRL_SELECT_GAME_REQ);
		//pushForCtrl(ch, CTRL_JOIN_ROOM_RESP, outStr, "server show room list!");
		startGame(room);

	}


	private void startGame(Room room){
		Gson gson = new Gson();
		String outStr = gson.toJson(room);
		List<Player> players = room.getPlayerList();

		CtrlEventCode eventCode = CTRL_JOIN_ROOM_RESP;
		if(RoomStatus .STARTING == room.getStatus()){
			eventCode = CTRL_JOIN_ROOM_RESP;
			room.setStatus(RoomStatus.PLAY);
		}else {
			eventCode = CTRL_START_GAME_RESP;
		}

		for (Player p : players){
			Client c = usersService.getClientById(p.getClientId());
			pushForCtrl(c.getChannel(), eventCode, outStr,"start game!!");
		}

	}
}
