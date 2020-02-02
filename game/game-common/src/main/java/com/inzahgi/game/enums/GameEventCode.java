package com.inzahgi.game.enums;

public enum  GameEventCode {
    //服务端要求出牌(可以跳过)
    GAME_ASK_PLAY_NORMAL(10000, "服务端要求出牌(可以跳过)"),
    //服务端要求出牌(不可跳过)
    GAME_ASK_PLAY_FORCE(10001, "服务端要求出牌(不可跳过)"),
    //出牌
    GAME_PLAY(10002,"出牌"),
    //不出
    GAME_PASS(10003,"不出"),
    //托管
    GAME_TRUSTEESHIP(10004,"托管"),
    //本回合游戏结束
    GAME_OVER(10005, "本回合游戏结束"),
    ;



    private int code;

    private String msg;

    GameEventCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static GameEventCode getByCode(int code){
        for( GameEventCode c : GameEventCode.values()){
            if(c.getCode() == code){
                return c;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
