package com.tcl.mie.framework.helper;

import com.tcl.mie.framework.annotation.Action;
import com.tcl.mie.framework.bean.Handler;
import com.tcl.mie.framework.bean.Request;
import com.tcl.mie.framework.util.ArrayUtil;
import com.tcl.mie.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * controller 通过注解保存映射路径
 */
public final class ControllerHelper {
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    // 初始化 controller相关类的映射
    static{
        //获取所有controller 注解类类型
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollectionUtil.isNotEmpty(controllerClassSet)){
            //遍历所有controller 注解类型
            for(Class<?> controllerClass : controllerClassSet){
                //获取所有实现的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtil.isNotEmpty(methods)){
                    //遍历controller类中的方法 当其有action注解时 保存其请求参数和该封装handler的映射
                    for(Method method : methods){
                        if(method.isAnnotationPresent(Action.class)){
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //正则表达式  匹配映射地址 get:/customer_create
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] array = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(array) && array.length == 2){
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // 根据请求参数 查找映射的处理 handler
    public static Handler getHandler(String requestMethod, String requestPath){
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
