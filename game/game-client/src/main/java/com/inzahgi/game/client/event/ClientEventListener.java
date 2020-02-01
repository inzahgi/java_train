package com.inzahgi.game.client.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.enums.ClientEventCode;
import com.inzahgi.game.enums.ServerEventCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

public interface ClientEventListener {

	void call(Channel channel, String data);

	Map<Integer, ClientEventListener> LISTENER_MAP = new HashMap<>();

	String LISTENER_PREFIX = "com.inzahgi.game.client.event.ClientEventListener_";


	@SuppressWarnings("unchecked")
	public static ClientEventListener get(int code){
		ClientEventListener listener = null;
		try {
			if(ClientEventListener.LISTENER_MAP.containsKey(code)){
				listener = ClientEventListener.LISTENER_MAP.get(code);
			}else{
				String eventListener = LISTENER_PREFIX + code.name();
				Class<ClientEventListener> listenerClass = (Class<ClientEventListener>) Class.forName(eventListener);
				listener = listenerClass.newInstance();
				ClientEventListener.LISTENER_MAP.put(code, listener);
			}
			return listener;
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return listener;
	}

	default ChannelFuture pushToServer(Channel channel, ServerEventCode code, String datas){
		return ChannelUtils.pushToServer(channel, code, datas);
	}

	default ChannelFuture pushToServer(Channel channel, ServerEventCode code){
		return pushToServer(channel, code, null);
	}
}
