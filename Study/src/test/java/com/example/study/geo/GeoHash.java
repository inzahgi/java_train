package com.example.study.geo;


import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;

public class GeoHash {

    private static int numbits = 6 * 5;
    final static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    final static HashMap<Character, Integer> lookup = new HashMap<Character, Integer>();
    static {
        int i = 0;
        for(char c : digits)
            lookup.put(c, i++);
    }

    // 获取经纬度单独的 二进制编码
    public int[] decodeLal(String geoHash, int n) {
        StringBuilder buffer = new StringBuilder(2*n);
        for(char c : geoHash.toCharArray()) {
            //还原 原始值
            int i = lookup.get(c) + 32;
            //求对应序列值
            //只求后5位的 (< 32) 前面的位数可以忽略
            buffer.append(Integer.toString(i, 2).substring(1));
        }

        if(buffer.length() > 2*n){
            buffer = buffer.delete(0, buffer.length() - 2*n);
            //buffer.insert(0, '0');
            //buffer.delete(0, 1);
        }
        // 经度位
        //BitSet lonset = new BitSet();
        int lonFlag = 0;
        // 纬度位
        //BitSet latset = new BitSet();
        int latFlag = 0;

        // even bits  偶数
        int mask = (1 << n);
        for(int i = 0; i < buffer.length(); i += 2) {
            mask >>= 1;
            if(buffer.charAt(i) == '1') {
                lonFlag |= mask;
            }
        }

        // odd bits  奇数
        mask = 1 << n;
        for(int i = 1; i < buffer.length(); i += 2) {
            mask >>= 1;
            if(buffer.charAt(i) == '1') {
                latFlag |= mask;
            }
        }
        return new int[] {lonFlag, latFlag};
    }

    public double decode(int code, int len, boolean isLong){
        if(isLong){
            return decode(code, len, -180, 180);
        }
        return decode(code, len, -90, 90);
    }

    public double[] decodeLal(int longCode, int latCode){
        double lon = decode(longCode, 7,-180, 180);
        double lat = decode(latCode, 7, -90, 90);

        return new double[] {lat, lon};
    }


    /**
     * 转换位实际的经纬度
     * @param code 输入的单个坐标编码
     * @param len 输入的位数
     * @param floor 下限
     * @param ceiling 上限
     * @return  单个坐标值
     */
    private double decode(int code, int len, double floor, double ceiling) {
        double mid = 0;
        //反向推导坐标
        int mask = 1 << len;
        for(int i = len; i > 0; i--) {
            mask >>= 1;
            mid = (floor + ceiling) / 2;
            if((code & mask) != 0)
                floor = mid;
            else
                ceiling = mid;
        }
        return (floor + ceiling) / 2;
    }
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

    public String encode(double lon, double lat, int n) {
        int latbits = getBits(lat, n, -90, 90);
        int lonbits = getBits(lon, n,-180, 180);
        StringBuilder buffer = new StringBuilder();
        //合并二进制  偶数为经度 奇数为纬度
        int mask = 1 << n;
        for(int i = 0; i < n; i++) {
            mask >>= 1;
            buffer.append((lonbits & mask) != 0 ? '1' : '0');
            buffer.append((latbits & mask) != 0 ? '1' : '0');
        }
        //base32 编码
        return base32(Long.parseLong(buffer.toString(), 2));
    }

    /**
     * 经纬度坐标 转换为 geoHash 二进制
     * @param d
     * @param floor
     * @param ceiling
     * @return
     */
    private int getBits(double d, int n, double floor, double ceiling) {
        int res = 0;
        int mask = 1 << n;
        for(int i = 0; i < n; i++) {
            mask >>= 1;
            double mid = (floor + ceiling) / 2;
            if(d >= mid) {
                res |= mask;
                floor = mid;
            } else {
                ceiling = mid;
            }
        }
        return res;
    }

    /**
     * 做base32
     * @param i
     * @return
     */
    private static String base32(long i) {
        char[] buf = new char[65];
        int charPos = 64;
        //判断是否是负数
        boolean negative = (i < 0);
        //非负数反转  即首位置一
        if(!negative)
            i = -i;
        //当输入数小于32 时
        while(i <= -32) {
            //求反 求余 映射到指定编码
            buf[charPos--] = digits[(int) (-(i % 32))];
            i /= 32;
        }
        //最后一位 映射
        buf[charPos] = digits[(int) (-i)];

        //如果是负数 最后一位添加标志位
        if(negative)
            buf[--charPos] = '-';
        //拼接字符串
        return new String(buf, charPos, (65 - charPos));
    }

    public int getGeoHashBit(double d, int len, boolean isLon ){
        if(isLon){
            return getBits(d, len, -180, 180);
        }
            return getBits(d, len, -90, 90);

    }

    public static void main(String[] args) {
        //System.out.println(new GeoHash().encode(39.92324, 116.3906));
        //输出：wx4g0ec19x3d

        int LEN = 12;
        GeoHash geoHash = new GeoHash();
        String x = geoHash.encode(116.3906, 39.92324, LEN);

        int[] originTmp = geoHash.decodeLal(x, LEN);
        int originLong = originTmp[0];
        int originLat = originTmp[1];

        System.out.println("encode bit:\t" + originLong + "----" + originLat);

        System.out.println(geoHash.decode(originLong, LEN, -180, 180) + "-----"+
                geoHash.decode(originLat, LEN, -90, 90));

        int[] arr = {-1, 0, 1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int lonBitTmp = originLong + arr[i];
                int latBitTmp = originLat + arr[j];
                double longTmp = geoHash.decode(lonBitTmp, LEN, -180, 180);
                double latTmp = geoHash.decode(latBitTmp, LEN, -90, 90);
                System.out.println(lonBitTmp + "---" + latBitTmp + "\t\t\t" + longTmp + "------" + latTmp);
            }
        }


    }
}

