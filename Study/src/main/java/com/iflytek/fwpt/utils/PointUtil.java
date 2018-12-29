package com.iflytek.fwpt.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.iflytek.fwpt.vo.PointVO;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class PointUtil {

    public List<PointVO> cluster(List<PointVO> list){
        Preconditions.checkArgument(list != null && list.size() > 0);
        Queue<PointVO> queue = new ArrayDeque<>(list);
        for (PointVO pv : list){


        }

        return Lists.newArrayList();
    }
}
