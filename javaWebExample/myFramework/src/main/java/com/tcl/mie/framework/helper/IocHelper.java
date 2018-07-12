package com.tcl.mie.framework.helper;

import com.tcl.mie.framework.annotation.Inject;
import com.tcl.mie.framework.util.ArrayUtil;
import com.tcl.mie.framework.util.ReflectionUtil;
import com.tcl.mie.framework.util.CollectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 *  ioc 初始化生成类
 */
public final class IocHelper {

    static {
        //获取所有生成的Java bean类型
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtil.isNotEmpty(beanMap)){
            //遍历bean类型 解决循环依赖的问题
            for(Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()){
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtil.isNotEmpty(beanFields)){
                    // 利用反射工具类 设置初始化bean的属性
                    for(Field beanField : beanFields){
                        if(beanField.isAnnotationPresent(Inject.class)){
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance != null){
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);

                            }
                        }
                    }
                }
            }
        }
    }
}
