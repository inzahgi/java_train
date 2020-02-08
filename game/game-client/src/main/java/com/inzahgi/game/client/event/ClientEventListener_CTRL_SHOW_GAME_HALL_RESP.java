package com.inzahgi.game.client.event;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.inzahgi.game.client.bean.Console;
import com.inzahgi.game.client.bean.UserInfo;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.utils.FlowUtils;
import com.inzahgi.game.utils.StringUtils;
import io.netty.channel.Channel;

import java.util.List;

public class ClientEventListener_CTRL_SHOW_GAME_HALL_RESP implements ClientEventListener{

	@Inject
	private Console console;
	@Inject
	private UserInfo userInfo;

	private static String MSG = "please input you nick name!";

	@Override
	public void call(Channel ch, byte[] data) {
		String inputStr = new String(data);
		SimplePrinter.serverLog(inputStr);
		Gson gson = new Gson();
		List<Room> list = gson.fromJson(inputStr, new TypeToken<List<Room>>(){}.getType());
		String roomListStr = showRoom(list);
		boolean flag = true;
		String out = null;
		while (flag) {
			out = console.write(roomListStr);
			if(StringUtils.isNumeric(out)){
				break;
			}
		}
		CtrlEventCode ctrlEventCode = FlowUtils.getNext(CtrlEventCode.CTRL_LOGIN_RESP);
		//String input = console.write("please input num!\n1 landord");
		pushForCtrl(ch, ctrlEventCode, out, "client send room num");
	}

	private String showRoom(List<Room> list){
		StringBuilder sb = new StringBuilder(128*list.size());
		for (Room r : list) {
			sb.append("roomNo:\t").append(r.getId())
					.append("\t\troomStatus:\t").append(r.getStatus())
					.append("\t\tplayer:\t").append(r.getPlayerList())
					.append("\n");
		}
		return sb.append("if you want built a new room, input '0'\n")
				.append("please input roomNum!")
				.toString();
	}

}
