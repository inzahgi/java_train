package com.inzahgi.game.client.data;

import com.inzahgi.game.entity.Poker;
import com.inzahgi.game.entity.Room;

import java.util.List;

public class GameInfo {
    private static GameInfo instance = new GameInfo();

    private List<Poker> pokerList;

    private Room

    private GameInfo(){

    }

    public static GameInfo getInstance() {
        return instance;
    }

    public List<Poker> getPokerList() {
        return pokerList;
    }

    public void setPokerList(List<Poker> pokerList) {
        this.pokerList = pokerList;
    }
}
