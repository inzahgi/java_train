package com.example.inzahgi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/test")
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String testOne(){
        return "hello world!";
    }


    @GetMapping("/daletou")
    public String randomDaletou(){
        //Random random = new Random();

    }

}
