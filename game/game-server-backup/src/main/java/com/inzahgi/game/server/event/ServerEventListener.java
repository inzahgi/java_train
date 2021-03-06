package com.inzahgi.game.server.event;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.enums.ServerEventCode;
import com.inzahgi.game.entity.ClientSide;
import com.inzahgi.game.enums.ServerEventCode;

public interface ServerEventListener {

	public void call(ClientSide client, String data);

	public final static Map<ServerEventCode, ServerEventListener> LISTENER_MAP = new HashMap<>();
	
	final static String LISTENER_PREFIX = "com.inzahgi.game.server.event.ServerEventListener_";
	
	@SuppressWarnings("unchecked")
	public static ServerEventListener get(ServerEventCode code){
		ServerEventListener listener = null;
		try {
			if(ServerEventListener.LISTENER_MAP.containsKey(code)){
				listener = ServerEventListener.LISTENER_MAP.get(code);
			}else{
				String eventListener = LISTENER_PREFIX + code.name();
				Class<ServerEventListener> listenerClass = (Class<ServerEventListener>) Class.forName(eventListener);
				try {
					listener = listenerClass.getDeclaredConstructor().newInstance();
				} catch (InvocationTargetException | NoSuchMethodException e) {
					e.printStackTrace();
				}
				ServerEventListener.LISTENER_MAP.put(code, listener);
			}
			return listener;
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return listener;
	}
	
}
