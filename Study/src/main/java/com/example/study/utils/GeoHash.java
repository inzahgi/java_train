package com.example.study.utils;


import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;

public class GeoHash {

//    private static int numbits = 6 * 5;
//    final static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7',
//            '8', '9', 'b', 'c', 'd', 'e', 'f', 'g',
//            'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r',
//            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//    final static HashMap<Character, Integer> lookup = new HashMap<Character, Integer>();
//    static {
//        int i = 0;
//        for(char c : digits)
//            lookup.put(c, i++);
//    }
//
//    public double[] decode(String geoHash) {
//        StringBuilder buffer = new StringBuilder();
//        for(char c : geoHash.toCharArray()) {
//            //还原 原始值
//            int i = lookup.get(c) + 32;
//            //求对应序列值
//            //只求后5位的 (< 32) 前面的位数可以忽略
//            buffer.append(Integer.toString(i, 2).substring(1));
//        }
//        // 经度位
//        BitSet lonset = new BitSet();
//        // 纬度位
//        BitSet latset = new BitSet();
//
//        // even bits  偶数
//        int j = 0;
//        for(int i = 0; i < numbits*2; i += 2) {
//            boolean isSet = false;
//            if(i < buffer.length())
//                isSet = buffer.charAt(i) == '1';
//            lonset.set(j++, isSet);
//        }
//
//        // odd bits  奇数
//        j = 0;
//        for(int i = 1; i < numbits*2; i += 2) {
//            boolean isSet = false;
//            if(i < buffer.length())
//                isSet = buffer.charAt(i) == '1';
//            latset.set(j++, isSet);
//        }
//
//        double lon = decode(lonset, -180, 180);
//        double lat = decode(latset, -90, 90);
//
//        return new double[] {lat, lon};
//    }
//
//    /**
//     * 转换位实际的经纬度
//     * @param bs 输入的位数
//     * @param floor 下限
//     * @param ceiling 上限
//     * @return  单个坐标值
//     */
//    private double decode(BitSet bs, double floor, double ceiling) {
//        double mid = 0;
//        //反向推导坐标
//        for(int i = 0; i < bs.length(); i++) {
//            mid = (floor + ceiling) / 2;
//            if(bs.get(i))
//                floor = mid;
//            else
//                ceiling = mid;
//        }
//        return mid;
//    }
//
//    public String encode(double lat, double lon) {
//        BitSet latbits = getBits(lat, -90, 90);
//        BitSet lonbits = getBits(lon, -180, 180);
//        StringBuilder buffer = new StringBuilder();
//        //合并二进制  偶数为经度 奇数为纬度
//        for(int i = 0; i < numbits; i++) {
//            buffer.append(lonbits.get(i) ? '1' : '0');
//            buffer.append(latbits.get(i) ? '1' : '0');
//        }
//        //base32 编码
//        return base32(Long.parseLong(buffer.toString(), 2));
//    }
//
//    /**
//     * 经纬度坐标 转换为 geoHash 二进制
//     * @param d
//     * @param floor
//     * @param ceiling
//     * @return
//     */
//    private BitSet getBits(double d, double floor, double ceiling) {
//        BitSet buffer = new BitSet(numbits);
//        for(int i = 0; i < numbits; i++) {
//            double mid = (floor + ceiling) / 2;
//            if(d >= mid) {
//                buffer.set(i);
//                floor = mid;
//            } else {
//                ceiling = mid;
//            }
//        }
//        return buffer;
//    }
//
//    /**
//     * 做base32
//     * @param i
//     * @return
//     */
//    private static String base32(long i) {
//        char[] buf = new char[65];
//        int charPos = 64;
//        //判断是否是负数
//        boolean negative = (i < 0);
//        //非负数反转  即首位置一
//        if(!negative)
//            i = -i;
//        //当输入数小于32 时
//        while(i <= -32) {
//            //求反 求余 映射到指定编码
//            buf[charPos--] = digits[(int) (-(i % 32))];
//            i /= 32;
//        }
//        //最后一位 映射
//        buf[charPos] = digits[(int) (-i)];
//
//        //如果是负数 最后一位添加标志位
//        if(negative)
//            buf[--charPos] = '-';
//        //拼接字符串
//        return new String(buf, charPos, (65 - charPos));
//    }
//
//    public static void main(String[] args) {
//        //System.out.println(new GeoHash().encode(39.92324, 116.3906));
//        //输出：wx4g0ec19x3d
//
//        GeoHash geoHash = new GeoHash();
//        String x = geoHash.encode(39.92324, 116.3906);
//        System.out.println(Arrays.toString(geoHash.decode(x)));
//    }
}

