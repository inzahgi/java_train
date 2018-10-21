package com.iflytek.fwpt.event;


import org.springframework.context.ApplicationEvent;

public class TroubleEvent extends ApplicationEvent {
    public TroubleEvent(Object source) {
        super(source);
    }
}
