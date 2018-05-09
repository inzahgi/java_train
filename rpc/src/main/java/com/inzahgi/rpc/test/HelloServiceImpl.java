package com.inzahgi.rpc.test;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello " + name + "!";
    }
}
