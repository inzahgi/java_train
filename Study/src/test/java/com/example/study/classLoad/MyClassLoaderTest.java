package com.example.study.classLoad;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class MyClassLoaderTest extends ClassLoader {




    public static void main(String[] args) throws IOException {

        MyClassLoaderTest classLoader = new MyClassLoaderTest();
        System.out.println("\n\n\n");
        String path = "E:\\gitlab_example\\etl\\target\\dep-etl-0.0.1-SNAPSHOT.war";

            JarFile jarFile = new JarFile(path);
            Enumeration<JarEntry> jarEntrys = jarFile.entries();
            while (jarEntrys.hasMoreElements()) {
                JarEntry jarEntry = jarEntrys.nextElement();
                String entryPath = jarEntry.getName();
                if (entryPath.startsWith("WEB-INF/lib-provided/") && entryPath.endsWith(".jar")) {
                    //File file = new File(entryPath);
                    //JarFile kettleJarFile = new JarFile(file);
                    InputStream is = jarFile.getInputStream(jarEntry);
                    InputStreamReader isr = new InputStreamReader(is);

                    

//                    Enumeration<JarEntry> kettleJarEntrys = kettleJarFile.entries();
//                    while (kettleJarEntrys.hasMoreElements()) {
//                        JarEntry kettleEntry = kettleJarEntrys.nextElement();
//                        System.out.println(kettleEntry.getName());
//
//                        //if()
//                    }
                }
            }

    }

}
