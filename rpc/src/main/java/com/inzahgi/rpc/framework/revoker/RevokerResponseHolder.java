package com.inzahgi.rpc.framework.revoker;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RevokerResponseHolder {

    private static final Map<String, String> responseMap = Maps.newConcurrentMap();

    //private static final ExecutorService removeExpireKeyExecutor = Executors.newSingleThreadExecutor();

    static {
//        removeExpireKeyExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    for (Map.Entry<String, String> entry : responseMap.entrySet()) {
//
//
//                    }
//                }
//            }
//        });
    }

    public static void initResponseData(String requestStr){
        responseMap.put(requestStr, "init");
    }

    public static void putResultValue(String responseStr){
        System.out.println("get res response: " + responseStr);
        String[] ar = responseStr.split("\t");
        responseMap.put(ar[0], ar[1]);
    }

    public static String getValue(String request){
        try{
            System.out.println("waiting------ line 40");
            java.lang.Thread.sleep(1000);
        }catch (java.lang.InterruptedException e){
            e.printStackTrace();
        }finally {
            return responseMap.get(request);
        }

    }






















}
