package com.inzahgi.game.server.bean;

import com.inzahgi.game.entity.Client;
import com.inzahgi.game.server.ServerContains;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersService {

    private final static AtomicInteger CLIENT_ATOMIC_ID = new AtomicInteger(1);

    public final static Map<String, Integer> CHANNEL_ID_MAP = new ConcurrentHashMap<>();

    private Map<Integer, Client> userMap = new ConcurrentHashMap<>();


    public Client login(Channel channel, String nickName){
        Client client = new Client();
        //todo 考虑断线重连
        Integer id = getId(channel);
        client.setId(id);
        client.setNickname(nickName);
        client.setChannel(channel);
        userMap.put(id, client);
        return client;
    }

    private int getId(Channel channel){
        String longId = channel.id().asLongText();
        Integer clientId = ServerContains.CHANNEL_ID_MAP.get(longId);
        if(null == clientId){
            clientId = CLIENT_ATOMIC_ID.getAndIncrement();
            CHANNEL_ID_MAP.put(longId, clientId);
        }
        return clientId;
    }

}
