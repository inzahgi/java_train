package com.tcl.mie.aspect;

import com.tcl.mie.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class ControllerAspect extends AspectProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;


    public void begin(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("----------- begin ------------");
        LOGGER.debug(String.format(String.format("class: %s", cls.getName())));
        LOGGER.debug(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result)
    throws Throwable{
        LOGGER.debug(String.format("time: %dms", System.currentTimeMillis() - begin));
        LOGGER.debug("-------------- end ------------");
    }
}
