package com.inzahgi.rpc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerMain {

    public static void main(String[] args) {
        //发布服务
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("rpc-server.xml");
        System.out.println(" 服务发布完成");
    }
}
