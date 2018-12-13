package com.iflytek.fwpt.map;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
public class Point {

    private static final Logger logger = LoggerFactory.getLogger(Point.class);

    List<PersonPoint> list = null;
    Random random = new Random();

    @Before
    public void init(){
        //Random random = new Random();
        int len = 1000*1000;
        list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            double lng = random.nextDouble()*2 + 105;
            double lat = random.nextDouble()*2 + 28;
            int proppertyFlag = random.nextInt(8)+1;
            list.add(PersonPoint.PersonPointBuilder.aPersonPoint().lat(lat).lng(lng)
                    .name(String.valueOf(i)).phone("13923456789")
                    .propertyFlag(proppertyFlag).stationId("123456789").build()
            );
        }
    }

    @Test
    public void testFilterScreen(){
        System.out.println("\n\n\n");
        double lowLng = 105 + random.nextDouble();
        double lowLat = 28 + random.nextDouble();
        double highLng = 106 + random.nextDouble();
        double highLat = 29 + random.nextDouble();
        long startTime = System.currentTimeMillis();
        List<PersonPoint> l1 = filterByStream(lowLng, lowLat, highLng, highLat);
        long endTime1 = System.currentTimeMillis();
        logger.info("list size = {} ----- use time {} ms!",l1.size(),
                (endTime1 - startTime));


    }

    private List<PersonPoint> filterByStream(double lowLng, double lowLat,
                                             double highLng, double highLat){

        List<PersonPoint> resList = Lists.newArrayList(list.stream()
                .filter(e ->  lowLng < e.getLng() && lowLat < e.getLat()
                        && highLng > e.getLng() && highLat > e.getLat())
                .collect(Collectors.toList()));
        return resList;
    }




}
