package com.example.study.xxx;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;


import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomResult {

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> redList = Lists.newArrayList(2, 4, 6, 7, 8, 9,
        11, 12, 15, 16, 17, 18, 19, 24, 25, 26, 27, 28, 29, 31, 32);
        List<Integer> buleList = Lists.newArrayList(1, 2, 4, 5, 7, 8, 9, 10, 11);



        for (int i = 0; i < 2; i++) {
            Set<Integer> redTmp = Sets.newTreeSet();
            Set<Integer> buleTmp = Sets.newTreeSet();

            List<Integer> redCopyList = Lists.newArrayList(redList);
            List<Integer> buleCopyList = Lists.newArrayList(buleList);

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

            System.out.println("red: " + redTmp);
            System.out.println("bule: " + buleTmp);
            System.out.println("\n\n");
        }
    }
}
