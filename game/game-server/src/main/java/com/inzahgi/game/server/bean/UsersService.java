package com.inzahgi.game.server.bean;

import com.inzahgi.game.entity.Client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UsersService {

    private Map<Integer, Client> userMap = new ConcurrentHashMap<>();

    public Client login(int id, String nickName){
        Client client = new Client();
        client.setId(id);
        client.setNickname(nickName);
        userMap.put(id, client);
    }

}
