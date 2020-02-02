package com.inzahgi.game.client.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.enums.GameEventCode;
import com.inzahgi.game.enums.ServerEventCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

public interface ClientEventListener {

	void call(Channel channel, byte[] data);

	Map<Integer, ClientEventListener> LISTENER_MAP = new HashMap<>();

	String LISTENER_PREFIX = "com.inzahgi.game.client.event.ClientEventListener_";


	@SuppressWarnings("unchecked")
	public static ClientEventListener get(int msgCode, String name){
		ClientEventListener listener = null;
		try {
			if(ClientEventListener.LISTENER_MAP.containsKey(msgCode)){
				listener = ClientEventListener.LISTENER_MAP.get(msgCode);
			}else{
				Preconditions.checkNotNull(name);
				String eventListener = LISTENER_PREFIX + name;
				Class<ClientEventListener> listenerClass = (Class<ClientEventListener>) Class.forName(eventListener);
				listener = listenerClass.newInstance();
				ClientEventListener.LISTENER_MAP.put(msgCode, listener);
			}
			return listener;
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return listener;
	}

	default ChannelFuture pushForCtrl(Channel channel, CtrlEventCode code, String datas, String info){
		return ChannelUtils.pushForCtrl(channel, code, datas.getBytes(), info);
	}

	default ChannelFuture pushForGame(Channel channel, GameEventCode code, String datas, String info){
		return ChannelUtils.pushForGame(channel, code, datas.getBytes(), info);
	}

}
