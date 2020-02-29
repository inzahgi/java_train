package com.inzahgi.app.util;

public class FileSimulateUtil {

    private static byte b = 0;
    public static byte[] read(int start, int length){
        byte[] ar = new byte[length];
        for (int i = b; i < length; i++) {
            ar[i] = (byte)(start + i);
        }
        return ar;
    }


    public static void write(byte[] ar, int start, int length){
        System.out.println("+++++++++++++++ start = " + start + "--------- length = " + length);
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%d ",ar[i]);
        }
        System.out.println();
    }

}
