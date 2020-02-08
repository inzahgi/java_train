package com.inzahgi.game.server.event;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.inzahgi.game.entity.Client;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.server.bean.RoomsSerice;
import com.inzahgi.game.server.bean.UsersService;
import com.inzahgi.game.utils.FlowUtils;
import com.inzahgi.game.utils.UrlUtils;
import io.netty.channel.Channel;

import java.util.List;

import static com.inzahgi.game.enums.CtrlEventCode.CTRL_SHOW_GAME_HALL_RESP;


public class ServerEventListener_CTRL_SELECT_GAME_REQ implements ServerEventListener{

	@Inject
	private UsersService usersService;

	@Inject
	private RoomsSerice roomsSerice;

	@Override
	public void call(Channel ch, byte[] data) {
		String input = new String(data);
		String address = UrlUtils.getRemoteAddress(ch);
		SimplePrinter.serverLog(address, input);

		List<Room> roomList = roomsSerice.getRoomList();
		Gson gson = new Gson();
		String outStr = gson.toJson(roomList);
		//CtrlEventCode nextCode = FlowUtils.getNext(CtrlEventCode.CTRL_SELECT_GAME_REQ);
		pushForCtrl(ch, CTRL_SHOW_GAME_HALL_RESP, outStr, "server show room list!");

	}
}
