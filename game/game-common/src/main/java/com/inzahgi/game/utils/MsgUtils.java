package com.inzahgi.game.utils;

import com.google.protobuf.ByteString;
import com.inzahgi.game.entity.ControlDataProtoc;
import com.inzahgi.game.entity.DataProtoc;
import com.inzahgi.game.entity.GameDataProtoc;

import java.util.concurrent.atomic.AtomicLong;

public class MsgUtils {

    private static final AtomicLong cnt = new AtomicLong(0L);

    private static DataProtoc.Data build(ControlDataProtoc.ControlData controlData,
                                        GameDataProtoc.GameData gameData, String info){
        return DataProtoc.Data.newBuilder().setMsgId(cnt.getAndIncrement())
                .setCtrlMsg(controlData).setGameMsg(gameData).setInfo(info).build();
    }

    public static DataProtoc.Data buildForCtrl(int code, byte[] ar, String info){
        ControlDataProtoc.ControlData controlData = ControlDataProtoc.ControlData.newBuilder()
                .setMsgCode(code).setData(ByteString.copyFrom(ar)).setPlayload(info).build();
        return build(controlData, null, null);
    }

    public static DataProtoc.Data buildForGame(int code, byte[] ar, String info){
       GameDataProtoc.GameData gameData = GameDataProtoc.GameData.newBuilder()
                .setMsgCode(code).setData(ByteString.copyFrom(ar)).setPlayload(info).build();
        return build(null, gameData, null);
    }




}
