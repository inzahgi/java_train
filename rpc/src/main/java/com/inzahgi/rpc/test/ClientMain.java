package com.inzahgi.rpc.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientMain {

    private static final Logger logger = LoggerFactory.getLogger(ClientMain.class);

    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("rpc-client.xml");

        final HelloService helloService = (HelloService)context.getBean("remoteHelloService");

        String res = helloService.sayHello("world!!!");
        System.out.println("\n\n\n-------------------------start---------------------");
        System.out.println(res);
        System.out.println("\n-=======================end==========================");
    }








}
