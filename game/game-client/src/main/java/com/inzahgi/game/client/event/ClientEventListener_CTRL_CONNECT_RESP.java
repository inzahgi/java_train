package com.inzahgi.game.client.event;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.protobuf.ByteString;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.client.bean.Console;
import com.inzahgi.game.client.bean.UserInfo;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.print.SimplePrinter;
import com.inzahgi.game.utils.FlowUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import java.util.HashMap;
import java.util.Map;

public class ClientEventListener_CTRL_CONNECT_RESP implements ClientEventListener{

	@Inject
	private Console console;
	@Inject
	private UserInfo userInfo;

	private static String MSG = "please input you nick name!";

	@Override
	public void call(Channel ch, byte[] data) {
		console.serverLog(new String(data));
		String input = console.write(MSG);
		userInfo.setNickName(input);
		CtrlEventCode ctrlEventCode = FlowUtils.getNext(CtrlEventCode.CTRL_CONNECT_RESP);
		pushForCtrl(ch, ctrlEventCode, input, "client send login");
	}
}
