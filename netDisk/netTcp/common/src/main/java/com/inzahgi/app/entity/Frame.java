package com.inzahgi.app.entity;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class Frame {

    private int code;

    private long length;

    private long start;

    private String name;

    private byte[] data;


    public interface TYPE{
        int INFO = 0;
        int NAME_REQ = 1;
        int NAME_RESP = 2;
        int FILE_REQ = 3;
        int FILE_RESP = 4;
        int FINISH = 5;
        int INVAILD = 1000;
    }

    public Frame(int code, long length, long start, String name, byte[] data) {
        this.code = code;
        this.length = length;
        this.start = start;
        this.name = name;
        this.data = data;
    }

    public Frame(Frame a){
        this.code = a.code;
        this.length = a.length;
        this.start = a.start;
        this.name = a.name;
        this.data = a.data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString(){
       return JSON.toJSONString(this);
    }

}
