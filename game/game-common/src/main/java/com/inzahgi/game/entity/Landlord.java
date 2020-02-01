package com.inzahgi.game.entity;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Landlord extends Game {
    // player index ----- poker
    private ArrayListMultimap<Integer, Poker> idToPokerMulList;

    //初始化时洗牌后保存所有的牌  抢地主后取前面三张
    //开始出牌前 将牌分别保存在idToPokerMulList中
    //开始出牌后 将保存上一次的出牌
    private List<Poker> pList = Lists.newArrayListWithCapacity(54);

    private int curStep = -1;

    public static final int XI_PAI = 1;

    public static final int QIANG_DI_ZHU = 2;

    public static final int  CHU_PAI = 3;



    @Override
    public byte[] calc(Room room, GameDataProtoc.GameData gameData) {

        if(curStep == -1){
            xiPai();
        }
    }

    private void xiPai(){

        curStep = 1;
        int[] ar = new int[54];
        for (int i = 0; i < 54; i++) {
            ar[i] = i+1;
        }
        for (int i = 54; i > 0; i--) {
            int j = Math.round(i);
            int tmp = ar[j];
            ar[j] = ar[i];
            ar[i] = tmp;
        }
        pList = Arrays.stream(ar).mapToObj(Poker::new).collect(Collectors.toList());

    }
}
