package com.example.study.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * 地址工具类
 */
public class AxisTool{

    private static double EARTH_RADIUS = 6378.137;

    private static Logger logger = LoggerFactory.getLogger(AxisTool.class);

    /**
     * 判断坐标是否在范围区内
     * @param ps 范围坐标
     * @param px 经度
     * @param py 纬度
     * @return true 在
     */
    public static boolean isInArea(List<double[]> ps, double px, double py){
        int n = 0;
        for (int i = 0; i < ps.size() - 1; i++ ){
            if (ps.get(i)[0] == px && ps.get(i)[1] >= py){
                if (ps.get(i)[1] == py){
                    return true;
                }
                n++ ;
                double x;
                if (i == 0){
                    x = ps.get(ps.size() - 2)[0];
                }else{
                    x = ps.get(i - 1)[0];
                }
                if ((ps.get(i + 1)[0] - ps.get(i)[0]) * (ps.get(i)[0] - x) < 0){
                    n++ ;
                }
            }
            if ((ps.get(i)[0] < px && ps.get(i + 1)[0] > px)
                || (ps.get(i)[0] > px && ps.get(i + 1)[0] < px)){
                if (ps.get(i)[1] > py && ps.get(i + 1)[1] > py){
                    n++ ;
                }else{
                    if (Math.abs((ps.get(i + 1)[1] - ps.get(i)[1])
                                 / (ps.get(i + 1)[0] - ps.get(i)[0])) == Math.abs(
                                     (ps.get(i + 1)[1] - py) / (ps.get(i + 1)[0] - px))){
                        return true;
                    }
                    if (ps.get(i + 1)[1] > ps.get(i)[1] && ps.get(i + 1)[1] > py) {

                        if (Math.abs((ps.get(i + 1)[1] - ps.get(i)[1])
                                     / (ps.get(i + 1)[0] - ps.get(i)[0])) < Math.abs(
                                         (ps.get(i + 1)[1] - py) / (ps.get(i + 1)[0] - px))){
                            n++ ;
                        }
                    }
                    if (ps.get(i + 1)[1] < ps.get(i)[1] && ps.get(i)[1] > py){
                        if (Math.abs((ps.get(i)[1] - ps.get(i + 1)[1])
                                     / (ps.get(i)[0] - ps.get(i + 1)[0])) < Math.abs(
                                         (ps.get(i)[1] - py) / (ps.get(i)[0] - px))){
                            n++ ;
                        }
                    }
                }
            }
        }
        if (n % 2 == 0){
            return false;
        }
        return true;
    }

    /**
     * 弧度
     * @param d
     * @return
     */
    private static double rad(double d){
        return d * Math.PI / 180.0;
    }

    /**
     * @Description: 计算两点间的距离
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return double
     */
    public static double distanceOfTwoPoints(double lat1, double lng1, double lat2, double lng2){
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(
            Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                      + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        // logger.info("两点间的距离是{}米", s);
        return s;
    }

   
}
