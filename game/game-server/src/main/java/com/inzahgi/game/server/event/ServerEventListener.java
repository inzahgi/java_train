package com.inzahgi.game.server.event;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inzahgi.game.channel.ChannelUtils;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.entity.Room;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.enums.GameEventCode;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.enums.ServerEventCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

public interface ServerEventListener {

	void call(Channel ch, byte[] data);

	Map<Integer, ServerEventListener> LISTENER_MAP = new HashMap<>();
	
	String LISTENER_PREFIX = "com.inzahgi.game.server.event.ServerEventListener_";
	
	@SuppressWarnings("unchecked")
	public static ServerEventListener get(int msgCode, String name){
		ServerEventListener listener = null;
		try {
			if(ServerEventListener.LISTENER_MAP.containsKey(msgCode)){
				listener = ServerEventListener.LISTENER_MAP.get(msgCode);
			}else{
				String eventListener = LISTENER_PREFIX + name;
				Class<ServerEventListener> listenerClass = (Class<ServerEventListener>) Class.forName(eventListener);
				try {
					listener = listenerClass.getDeclaredConstructor().newInstance();
				} catch (InvocationTargetException | NoSuchMethodException e) {
					e.printStackTrace();
				}
				ServerEventListener.LISTENER_MAP.put(msgCode, listener);
			}
			return listener;
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return listener;
	}

	default ChannelFuture pushForCtrl(Channel ch, CtrlEventCode ctrlEventCode, String data, String info){
		return ChannelUtils.pushForCtrl(ch, ctrlEventCode, data.getBytes(), info);
	}

	default ChannelFuture pushForGame(Channel ch, GameEventCode gameEventCode, String data, String info){
		return ChannelUtils.pushForGame(ch, gameEventCode, data.getBytes(), info);
	}

	default void pushAllForGame(List<Channel> chList, GameEventCode gameEventCode, String data, String info){
		for (Channel ch : chList) {
			ChannelUtils.pushForGame(ch, gameEventCode, data.getBytes(), info);
		}
	}
	
}
