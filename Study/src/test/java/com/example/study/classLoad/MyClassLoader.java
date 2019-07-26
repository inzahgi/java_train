package com.example.study.classLoad;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //return super.findClass(name);
        //InputStream in = this.getResourceAsStream("com.example.study.vo.PhoneVO.class");
        String myPath = "./" + "com/example/study/vo/PhoneVO.class";
        byte[] cLassBytes = null;
        //Path path = null;
        try {
            //path = Paths.get(new URI(myPath));
            //cLassBytes = Files.readAllBytes(path);
            URL url = this.getResource("com/example/study/vo/PhoneVO.class");


        } catch (Exception e) {
            e.printStackTrace();
        }
        Class clazz = defineClass(name, cLassBytes, 0, cLassBytes.length);
        return clazz;

    }

    public static void main(String[] args) throws Exception{
        MyClassLoader mc = new MyClassLoader();
        mc.findClass("1111");
    }
}
