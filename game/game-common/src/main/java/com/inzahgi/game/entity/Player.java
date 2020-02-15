package com.inzahgi.game.entity;

public class Player {

    private int clientId;

    private String nickName;

    private boolean isRobot;

    private boolean isTrusteeship;

    public Player(int clientId, String nickName, boolean isRobot, boolean isTrusteeship) {
        this.clientId = clientId;
        this.nickName = nickName;
        this.isRobot = isRobot;
        this.isTrusteeship = isTrusteeship;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isRobot() {
        return isRobot;
    }

    public void setRobot(boolean robot) {
        isRobot = robot;
    }

    public boolean isTrusteeship() {
        return isTrusteeship;
    }

    public void setTrusteeship(boolean trusteeship) {
        isTrusteeship = trusteeship;
    }
}
