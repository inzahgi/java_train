package com.inzahgi.game.server.event;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.Client;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.enums.GameEventCode;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.server.bean.UsersService;
import com.inzahgi.game.utils.FlowUtils;
import com.inzahgi.game.utils.UrlUtils;
import io.netty.channel.Channel;



public class ServerEventListener_CTRL_LOGIN_REQ implements ServerEventListener{

	@Inject
	private UsersService usersService;

	@Override
	public void call(Channel ch, byte[] data) {
		String input = new String(data);
		String address = UrlUtils.getRemoteAddress(ch);
		SimplePrinter.serverLog(address, input);

		Client client = usersService.login(ch, input);
		Gson gson = new Gson();
		String outStr = gson.toJson(client);
		CtrlEventCode nextCode = FlowUtils.getNext(CtrlEventCode.CTRL_LOGIN_REQ);
		pushForCtrl(ch, nextCode, outStr, "login success!");

	}
}
