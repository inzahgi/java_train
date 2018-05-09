package com.inzahgi.rpc.framework.revoker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;

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
        System.out.println(this.getClass().getName() + " -------  line = 27");
        return "ok";
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
