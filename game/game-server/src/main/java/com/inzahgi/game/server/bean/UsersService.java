package com.inzahgi.game.server.bean;

import com.inzahgi.game.entity.Client;
import com.inzahgi.game.server.ServerContains;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersService {

    private final static AtomicInteger CLIENT_ATOMIC_ID = new AtomicInteger(1);

    private Map<Integer, Client> userMap = new ConcurrentHashMap<>();

    public Client login(int id, String nickName){
        Client client = new Client();
        client.setId(id);
        client.setNickname(nickName);
        userMap.put(id, client);
    }

    private int getId(Channel channel){
        String longId = channel.id().asLongText();
        Integer clientId = ServerContains.CHANNEL_ID_MAP.get(longId);
        if(null == clientId){
            clientId = ServerContains.getClientId();
            ServerContains.CHANNEL_ID_MAP.put(longId, clientId);
        }
        return clientId;
    }

}
