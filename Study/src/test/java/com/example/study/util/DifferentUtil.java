package com.example.study.util;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;
import java.util.Map;

/**
 * author:inzahgi
 * Date:2018/8/30
 * Time:15:26
 */
public class DifferentUtil {

    public static void main(String[] args) {
        //找出2个Map的不同之处与相同之处，以Map形式返回
        ImmutableMap<String,Integer> oneMap=ImmutableMap.of("key1",1,"key2",2, "key3",3);
        ImmutableMap<String,Integer> twoMap=ImmutableMap.of("key11",11,"key2",2,"key3", 4);
        MapDifference<String,Integer> diffHadle= Maps.difference(oneMap,twoMap);
        Map<String,Integer> commonMap=diffHadle.entriesInCommon();//{"key2",2},若无共同Entry，则返回长度为0的Map
        Map<String,Integer> diffOnLeft=diffHadle.entriesOnlyOnLeft();//返回左边的Map中不同或者特有的元素
        Map<String,Integer> diffOnRight=diffHadle.entriesOnlyOnRight();//返回右边的Map中不同或者特有的元素
        Map<String,ValueDifference<Integer>> diffAll = diffHadle.entriesDiffering();
        for(Map.Entry<String, Integer> entry:commonMap.entrySet()){
            System.out.println("共同Map中key:"+entry.getKey()+"  value:"+entry.getValue());
        }
        for(Map.Entry<String, Integer> entry:diffOnLeft.entrySet()){
            System.out.println("左边不同的Map中key:"+entry.getKey()+"  value:"+entry.getValue());
        }
        for(Map.Entry<String, Integer> entry:diffOnRight.entrySet()){
            System.out.println("右边不同的Map中key:"+entry.getKey()+"  value:"+entry.getValue());
        }
        for (Map.Entry<String, ValueDifference<Integer>> entry : diffAll.entrySet()){
            Integer left = entry.getValue().leftValue();
            Integer right = entry.getValue().rightValue();
            System.out.println("两边完全不同的Map中key:"+entry.getKey()+"  left value:"+ left + "  right value:" + right);

        }
    }

}
