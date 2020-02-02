package com.inzahgi.game.utils;

import com.google.protobuf.ByteString;
import com.inzahgi.game.entity.ControlDataProtoc;
import com.inzahgi.game.entity.DataProtoc;
import com.inzahgi.game.entity.Game;
import com.inzahgi.game.entity.GameDataProtoc;
import com.inzahgi.game.enums.CtrlEventCode;
import com.inzahgi.game.enums.MsgType;

import java.util.concurrent.atomic.AtomicLong;

public class MsgUtils {

    private static final AtomicLong cnt = new AtomicLong(0L);

    private static DataProtoc.Data build(ControlDataProtoc.ControlData controlData,
                                        GameDataProtoc.GameData gameData, String info){
        int typeCode = getMsgType(controlData, gameData);
        return DataProtoc.Data.newBuilder().setMsgId(cnt.getAndIncrement()).setMsgType(typeCode)
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

    private static int getMsgType(ControlDataProtoc.ControlData controlData, GameDataProtoc.GameData gameData){
        if(controlData != null && gameData != null){
            return MsgType.ONLY_CTRL_DATA.getTypeCode();
        }
        if(controlData == null && gameData != null){
            return MsgType.ONLY_GAME_DATA.getTypeCode();
        }
        return 0;

    }


}
