package com.tcl.mie.framework.bean;

import java.lang.reflect.Method;

public class Handler {
    private Class<?> ControllerClass;

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
