package com.inzahgi.game.client.data;

public class UserInfo {
    private static UserInfo instance = new UserInfo();

     private String nickName;

    private UserInfo(){

    }

    public static UserInfo getInstance() {
        return instance;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
