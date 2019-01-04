package com.example.study.PointCluster;

import com.example.study.geo.GeoHash;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
public class HashGeoTest {


    @Test
    public void getCluster(){
        int LEN = 11;
        GeoHash geoHash = new GeoHash();
        double swLon = 115.094375;
        double swLat = 37.9849275;
        double neLon = 118.87868;
        double neLat = 39.4832957;

        int swLonBit = geoHash.getGeoHashBit(swLon, LEN, true);
        int neLonBit = geoHash.getGeoHashBit(neLon, LEN, true);

        int swLatBit = geoHash.getGeoHashBit(swLat, LEN, false);
        int neLatBit = geoHash.getGeoHashBit(neLat, LEN, false);

//        System.out.println("--------- long --------");
//        for (int i = swLonBit; i <= neLonBit; i++) {
//            System.out.println("lon = \t" + geoHash.decode(i, LEN, true));
//        }
//
//        System.out.println("\n\n");
//
//        System.out.println("--------- lat --------");
//        for (int i = swLatBit; i <= neLatBit; i++) {
//            System.out.println("lat = \t" + geoHash.decode(i, LEN, false));
//        }
        Table<Double, Double, Boolean> table = HashBasedTable.create();
        System.out.println("-------------\n\n");
        for (int i = swLonBit; i <= neLonBit ; i++) {
            for (int j = swLatBit; j <= neLatBit ; j++) {
                double lon = geoHash.decode(i, LEN, true);
                double lat = geoHash.decode(j, LEN, false);
                if(i == swLonBit || i == neLonBit || i == swLatBit || i == neLatBit){
                    table.put(lon, lat, true);
                }else {
                    table.put(lon, lat, false);
                }
            }
        }

        System.out.println("-------------------------");
        for(Double dx : table.columnKeySet()){
            for (Map.Entry<Double, Boolean> entryY : table.column(dx).entrySet()){
                System.out.println(dx + " " + entryY.getKey() + "\t------\t" +entryY.getValue());
            }
        }
    }

}
