package com.inzahgi.rpc.framework.revoker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RevokerProxyBeanFactory implements InvocationHandler {

    private ExecutorService fixedThreadPool = null;

    private Class<?> targetInterface;

    private int consumeTimeout;

    private static int threadWorkerNumber = 10;

    private String clusterStrategy;

    public RevokerProxyBeanFactory(Class<?> targetInterface, int consumeTimeout, String clusterStrategy) {
        this.targetInterface = targetInterface;
        this.consumeTimeout = consumeTimeout;
        this.clusterStrategy = clusterStrategy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if(fixedThreadPool == null){
                synchronized (RevokerProxyBeanFactory.class){
                    if(null == fixedThreadPool){
                        fixedThreadPool = Executors.newFixedThreadPool(2);
                    }
                }
            }
            String serverIp = "127.0.0.1";
            int serverPort = 12345;
            InetSocketAddress inetSocketAddress = new InetSocketAddress(serverIp, serverPort);

            Future<String> responseFuture = fixedThreadPool.submit(RevokerServiceCallable.of(inetSocketAddress, method.getName()));

            String response = responseFuture.get(10, TimeUnit.SECONDS);
            if(response != null){
                return response;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return null;

//        System.out.println(this.getClass().getName() + " -------  line = 27");
//        return "ok";
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{targetInterface}, this);
    }

    private static volatile RevokerProxyBeanFactory singleton;

    public static RevokerProxyBeanFactory singleton(Class<?> targetInterface, int consumeTimeout,
                                                       String clusterStrategy) throws Exception{

        if(null == singleton){
            synchronized (RevokerProxyBeanFactory.class){
                if(null == singleton){
                    singleton = new RevokerProxyBeanFactory(targetInterface, consumeTimeout, clusterStrategy);
                }
            }
        }
        return singleton;
    }









}
