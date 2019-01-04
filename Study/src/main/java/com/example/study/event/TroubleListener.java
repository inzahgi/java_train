package com.example.study.event;


import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TroubleListener implements ApplicationListener<TroubleEvent> {
    @Override
    public void onApplicationEvent(TroubleEvent event) {
        System.out.println(">>>>>>>>>>>>>>>>trouble event:" + event);
    }
}

