package com.example.study.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.inzahgi.game.entity.ControlDataProtoc;
import com.inzahgi.game.entity.DataProtoc;
import com.inzahgi.game.entity.GameDataProtoc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DataTest {

    @Before
    public void init(){
        ControlDataProtoc.ControlData controlData = ControlDataProtoc.ControlData.newBuilder()
                .setMsgCode(1).setData(ByteString.copyFromUtf8("111111")).setPlayload("1111").build();
        GameDataProtoc.GameData gameData = GameDataProtoc.GameData.newBuilder()
                .setMsgCode(2).build();
        DataProtoc.Data data = DataProtoc.Data.newBuilder()
                .setMsgId(1L).setCtrlMsg(controlData).setGameMsg(gameData).setInfo("all").build();

    }

    @Test
    public void protobufTest(){

        ControlDataProtoc.ControlData controlData = ControlDataProtoc.ControlData.newBuilder()
                .setMsgCode(1).setData(ByteString.copyFromUtf8("111111")).setPlayload("1111").build();
        GameDataProtoc.GameData gameData = GameDataProtoc.GameData.newBuilder()
                .setMsgCode(2).build();
        DataProtoc.Data data = DataProtoc.Data.newBuilder()
                .setMsgId(1L).setCtrlMsg(controlData).setGameMsg(gameData).setInfo("all").build();

        System.out.println();
        byte[] bytes = data.toByteArray();

        try{
            System.out.println("\n\n\n\n\n----------------------------------\n");
            System.out.println(JsonFormat.printer().print(data));

            DataProtoc.Data dataNext = DataProtoc.Data.parseFrom(bytes);

            System.out.println(JsonFormat.printer().print(dataNext));
            System.out.println(dataNext.getMsgId());
            System.out.println("\n\n\n\n\n----------------------------------\n");
        }catch (InvalidProtocolBufferException e){
            e.printStackTrace();
        }
    }

}
