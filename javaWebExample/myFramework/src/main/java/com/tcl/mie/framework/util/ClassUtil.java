package com.tcl.mie.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * class加载工具类
 */
public final class ClassUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    //获取当前线程的类加载器
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    //加载类
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

    // 按类名加载
    public static Class<?> loadClass(String className){
        return loadClass(className, true);
    }

    /**
     *  按包名加载
     * @param packageName
     * @return
     */
    public static Set<Class<?>> getClassSet(String packageName){
        Set<Class<?>> classSet = new HashSet<Class<?>>();

        try{
            //通过类加载器获取需要的资源
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".","/"));
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                if(url != null){
                    String protocol = url.getProtocol();
                    //如果是协议是文件
                    if(protocol.equals("file")){
                        //获取文件路径
                        String packagePath = url.getPath().replaceAll("%20", " ");
                        //加载类 并保存类型类到集合
                        addClass(classSet, packagePath, packageName);
                    }else if(protocol.equals("jar")){
                        //如果是jar文件地址
                        //打开jar文件
                        JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
                        if(jarURLConnection != null){
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if(jarFile != null){
                                Enumeration<JarEntry> jarEntries = jarFile.entries();
                                //遍历jar文件 获取类名 加载类 并保存到set集合
                                while (jarEntries.hasMoreElements()){
                                    JarEntry jarEntry = jarEntries.nextElement();
                                    String jarEntryName = jarEntry.getName();
                                    if(jarEntryName.endsWith(".class")){
                                        String className = jarEntryName.substring(0,
                                                jarEntryName.lastIndexOf("."))
                                                .replaceAll("/", ".");
                                        doAddClass(classSet, className);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            LOGGER.error("get class set failure", e);
            throw new RuntimeException(e);
        }
        return classSet;
    }

    //按包名添加类文件
    private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName){
        //查找需要加载的文件
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
        //遍历files数组 加载相关类
        for(File file : files){
            String fileName = file.getName();
            //如果是类文件 获取类名 直接加载
            if(file.isFile()){
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if(StringUtil.isNotEmpty(packageName)){
                    className = packageName + "." + className;
                }
                //加载类 并将该类型类保存到set集合
                doAddClass(classSet, className);
            }else {
                //如果是目录 递归的继续加载类文件
                //当前文件名为二级目录
                String subPackagePath = fileName;
                if(StringUtil.isNotEmpty(packagePath)){
                    subPackagePath = packagePath + "/" + subPackagePath;
                }
                String subPackageName = fileName;
                if(StringUtil.isNotEmpty(packageName)){
                    subPackageName = packageName + "." + subPackageName;
                }
                //递归 加载类
                addClass(classSet, subPackagePath, subPackageName);
            }
        }
    }
    //加载类文件保存到set中
    private static void doAddClass(Set<Class<?>> classSet, String className){
        Class<?> cls = loadClass(className, false);
        classSet.add(cls);
    }

}
