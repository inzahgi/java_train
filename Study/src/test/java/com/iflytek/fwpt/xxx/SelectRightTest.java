package com.iflytek.fwpt.xxx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class SelectRightTest {

    public static void main(String[] args) {

        Set<Integer> buledSet = Sets.newHashSet(2, 4, 5, 12, 14, 16, 17, 18, 19, 20, 21, 29, 30, 35 );
        Set<Integer> redSet = Sets.newHashSet(2, 6, 7, 10, 12);

        List<Integer> buleList = Lists.newArrayList();
        List<Integer> redList = Lists.newArrayList();

        for (int i = 0; i < 35; i++) {
            int n = i+1;
            if(i < 12){
                if(!redSet.contains(n)){
                    redList.add(n);
                }
            }
            if(!buledSet.contains(n)){
                buleList.add(n);
            }
        }

        Random random = new Random();
        int n = (int)(random.nextInt()*random.nextDouble());
        random.setSeed(n);

        Set<Integer> buleResSet = Sets.newTreeSet();
        while(buleResSet.size() != 5){
            int k = random.nextInt(buleList.size());
            buleResSet.add(buleList.get(k));
        }

        JSON json = new JSONObject();
        System.out.println(json.toJSONString(buleResSet));
        System.out.println("\n\n");


        Set<Integer> redResSet = Sets.newTreeSet();
        while(redResSet.size() != 2){
            int k = random.nextInt(redList.size());
            redResSet.add(redList.get(k));
        }
        System.out.println(json.toJSONString(redResSet));


    }


}
