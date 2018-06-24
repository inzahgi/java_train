package com.tcl.mie.framework;

import com.tcl.mie.framework.helper.BeanHelper;
import com.tcl.mie.framework.helper.ClassHelper;
import com.tcl.mie.framework.helper.ControllerHelper;
import com.tcl.mie.framework.helper.IocHelper;
import com.tcl.mie.framework.util.ClassUtil;

public final class HelperLoader {
    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName());
        }
    }
}
