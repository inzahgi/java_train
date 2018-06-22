package com.tcl.mie.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarFile;

public class ClassUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className, boolean isInitialized){
        Class<?> cls;
        try{
            cls = Class.forName(className, isInitialized, getClassLoader());
        }catch (ClassNotFoundException e){
            LOGGER.error("load class failure ", e);
            throw new RuntimeException(e);
        }
        return cls;
    }

    public static Set<Class<?>> getClassSet(String packageName){
        Set<Class<?>> classSet = new HashSet<Class<?>>();

        try{
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".","/"));
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                if(url != null){
                    String protocol = url.getProtocol();
                    if(protocol.equals("file")){
                        String packagePath = url.getPath().replaceAll("%20", " ");
                        addClass(classSet, packagePath, packageName);
                    }else if(protocol.equals("jar")){
                        JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
                        if(jarURLConnection != null){
                            JarFile = jarURLConnection.getJarFile();
                            if(jarFile != null){
                                //Enumeration
                            }
                        }
                    }
                }
            }
        }
    }
}
