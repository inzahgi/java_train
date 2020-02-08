package com.inzahgi.game.client.event;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.inzahgi.game.client.bean.Console;
import com.inzahgi.game.client.bean.UserInfo;
import com.inzahgi.game.entity.Client;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.utils.FlowUtils;
import io.netty.channel.Channel;

public class ClientEventListener_CTRL_LOGIN_RESP implements ClientEventListener{

	@Inject
	private Console console;
	@Inject
	private UserInfo userInfo;

	private static String MSG = "please input you nick name!";

	@Override
	public void call(Channel ch, byte[] data) {
		String inputStr = new String(data);
		SimplePrinter.serverLog(inputStr);
//		Gson gson = new Gson();
//		Client client = gson.fromJson(inputStr, Client.class);

		CtrlEventCode ctrlEventCode = FlowUtils.getNext(CtrlEventCode.CTRL_LOGIN_RESP);
		String input = console.write("please input num!\n1 landord");
		pushForCtrl(ch, ctrlEventCode, input, "client send select game");
	}
}
