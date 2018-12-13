package com.tcl.mie.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射代理类
 */
public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    //实例化类类型
    public static Object newInstance(Class<?> cls){
        Object instance;
        try{
            instance = cls.newInstance();
        }catch (Exception e){
            LOGGER.error("new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    //反射执行特定方法
    public static Object invokeMethod(Object obj, Method method, Object... args){
        Object result;
        try{
            method.setAccessible(true);
            result = method.invoke(obj,args);
        }catch(Exception e){
            LOGGER.error("invoke method failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    //设置类属性
    public static void setField(Object obj, Field field, Object value){
        try{
            field.setAccessible(true);
            field.set(obj, value);
        }catch (Exception e){
            LOGGER.error("set filed failure", e);
            throw new RuntimeException(e);
        }
    }

}
