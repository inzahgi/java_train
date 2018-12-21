package com.tcl.mie.framework.bean;

import java.lang.reflect.Method;

/**
 * 需要处理的url对应处理方法的注册类
 */
public class Handler {
    //处理的controller bean
    private Class<?> ControllerClass;
    //处理对应的方法
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod){
        this.ControllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return ControllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
