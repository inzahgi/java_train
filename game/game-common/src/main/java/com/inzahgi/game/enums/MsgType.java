package com.inzahgi.game.enums;

public enum MsgType {

    ONLY_CTRL_DATA(1),

    ONLY_GAME_DATA(2),

    ONLY_CHAT_DATA(4),


    ;


    private int typeCode;

    MsgType(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }
}
