package com.example.study.xxx;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class FilterRandom {

    public static void main(String[] args) {

        Random random = new Random();
        Set<Integer> redBallSet = Sets.newHashSet();
        Set<Integer> buleBallSet = Sets.newHashSet();

        for (int i = 1; i < 36; i++) {
            redBallSet.add(i);
        }
        for (int i = 1; i < 16; i++) {
            buleBallSet.add(i);
        }


        Set<Integer> redTmp = Sets.newHashSet();
        Set<Integer> buleTmp = Sets.newHashSet();

        for (int i = 0; i < 2; i++) {
            List<Integer> redCopyList = Lists.newArrayList(redBallSet);
            List<Integer> buleCopyList = Lists.newArrayList(buleBallSet);

            for (int j = 0; j < 5; j++) {
                int index = random.nextInt(redCopyList.size());
                redTmp.add(redCopyList.get(index));
                redCopyList.remove(index);
            }
            for (int j = 0; j < 2; j++) {
                int index = random.nextInt(buleCopyList.size());
                buleTmp.add(buleCopyList.get(index));
                buleCopyList.remove(index);
            }
        }

        redBallSet.removeAll(redTmp);
        List<Integer> redLast = Lists.newArrayList(redBallSet);
        buleBallSet.removeAll(buleTmp);
        List<Integer> buleLast = Lists.newArrayList(buleBallSet);

        System.out.println("redLast:" + redLast);
        System.out.println("buleLast:" + buleLast);

    }
}
