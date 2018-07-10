package com.tcl.mie.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 实现切面的代理类
 */
public abstract class AspectProxy implements Proxy {

    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);

    //代理链实现 aop功能
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();
        try{
            if(intercept(cls, method, params)){
                before(cls, method, params);
                result = proxyChain.doProxyChain();
                after(cls, method, params, result);
            }else{
                result = proxyChain.doProxyChain();
            }
        }catch(Exception e){
            logger.error("proxy failure", e);
            error(cls, method, params, e);
            throw e;
        }finally{
            end();
        }
        return result;
    }

    //前置加强
    public void begin(){

    }

    //方法拦截 环绕加强
    public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable{
        return true;
    }

    //环绕前
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable{

    }

    //环绕后
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable{

    }

    //异常加强
    public void error(Class<?> cls, Method method, Object[] params, Throwable e){

    }

    //后置加强
    public void end(){

    }
}
