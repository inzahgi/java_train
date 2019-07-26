package com.example.study.classLoad;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class MyClassLoaderByJar extends ClassLoader {

    // org.pentaho
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if(StringUtils.isEmpty(name)){
            throw new ClassNotFoundException("input file name is wrong: " + name);
        }
        System.out.println("\n\n\n");
        String path = "E:\\gitlab_example\\etl\\target\\dep-etl-0.0.1-SNAPSHOT.war";
        try {
            JarFile jarFile = new JarFile(path);
            Enumeration<JarEntry> jarEntrys = jarFile.entries();
            while (jarEntrys.hasMoreElements()) {
                JarEntry jarEntry = jarEntrys.nextElement();
                String entryPath = jarEntry.getName();
                if (entryPath.startsWith("WEB-INF/lib-provided/") && entryPath.endsWith(".jar")) {
                    JarEntry kettleJarEntry = new JarEntry(entryPath);
                    JarFile kettleJarFile = new JarFile(entryPath);
                    Enumeration<JarEntry> kettleJarEntrys = kettleJarFile.entries();
                    while (kettleJarEntrys.hasMoreElements()){
                        JarEntry kettleEntry = kettleJarEntrys.nextElement();
                        String kettleEntryPath = kettleEntry.getName();
                        name.replace("/", ".").substring(0,name.length() - 6);
                        //if()
                    }
                }
            }
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
        return null;

    }


    public static void main(String[] args) throws IOException {

    }
}
