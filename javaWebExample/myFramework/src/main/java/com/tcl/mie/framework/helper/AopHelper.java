package com.tcl.mie.framework.helper;

import com.tcl.mie.framework.annotation.Aspect;
import com.tcl.mie.framework.annotation.Service;
import com.tcl.mie.framework.proxy.AspectProxy;
import com.tcl.mie.framework.proxy.Proxy;
import com.tcl.mie.framework.proxy.ProxyManager;
import com.tcl.mie.framework.proxy.TransactionProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 方法拦截实现类
 */
public final class AopHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AopHelper.class);

    //生成代理类并缓存
    static{
        try{
            //获取需要生成代理的类类型
            Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
            //生成代理类
            Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
            for(Map.Entry<Class<?>, List<Proxy>> targetEntry : targetMap.entrySet()){
                Class<?> targetClass = targetEntry.getKey();
                List<Proxy> proxyList = targetEntry.getValue();
                Object proxy = ProxyManager.createProxy(targetClass, proxyList);
                BeanHelper.setBean(targetClass, proxy);
            }
        }catch (Exception e){
            LOGGER.error("aop failure", e);
        }
    }

    //获取指定注解的类型类集合
    private static Set<Class<?>> createTargetClassSet(Aspect aspect) throws Exception{
        Set<Class<?>> targetClassSet = new HashSet<Class<?>>();
        Class<? extends Annotation> annotation = aspect.value();
        if(annotation != null && !annotation.equals(Aspect.class)){
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClassSet;
    }


//    private static Map<Class<?>, Set<Class<?>>> createProxyMap() throws Exception {
//        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<Class<?>, Set<Class<?>>>();
//        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
//        for(Class<?> proxyClass : proxyClassSet) {
//            if(proxyClass.isAnnotationPresent(Aspect.class)){
//                Aspect aspect = proxyClass.getAnnotation(Aspect.class);
//                Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
//                proxyMap.put(proxyClass, targetClassSet);
//            }
//        }
//        return proxyMap;
//    }

    //按照类类型生成代理类
    private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>>proxyMap)
        throws Exception{
        Map<Class<?>, List<Proxy>> targetMap = new HashMap<Class<?>, List<Proxy>>();
        for(Map.Entry<Class<?>, Set<Class<?>>> proxyEntry : proxyMap.entrySet()){
            Class<?> proxyClass = proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();
            for(Class<?> targetClass : targetClassSet) {
                //生成代理类
                Proxy proxy = (Proxy) proxyClass.newInstance();
                //保存到现有的set集合中
                if(targetMap.containsKey(targetClass)){
                    targetMap.get(targetClass).add(proxy);
                }else{
                    //保存到新建的集合中
                    List<Proxy> proxyList = new ArrayList<Proxy>();
                    proxyList.add(proxy);
                    targetMap.put(targetClass, proxyList);
                }
            }
        }
        return targetMap;
    }

    //获取所有需要生成的代理类
    private static Map<Class<?>, Set<Class<?>>> createProxyMap() throws Exception{
        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<Class<?>, Set<Class<?>>>();
        //需要切面的类
        addAspectProxy(proxyMap);
        //需要实现事务的类
        addTransactionProxy(proxyMap);
        return proxyMap;
    }

    //获取需要切面的类
    private static void addAspectProxy(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception{
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
        for(Class<?> proxyClass : proxyClassSet){
            Aspect aspect = proxyClass.getAnnotation(Aspect.class);
            Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
            proxyMap.put(proxyClass, targetClassSet);
        }
    }

    //获取需要添加注释的类
    private static void addTransactionProxy(Map<Class<?>, Set<Class<?>>> proxyMap){
        Set<Class<?>> serviceClassSet = ClassHelper.getClassSetByAnnotation(Service.class);
        proxyMap.put(TransactionProxy.class, serviceClassSet);
    }

}
