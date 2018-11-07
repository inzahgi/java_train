package com.iflytek.fwpt.model.dqjc;

import java.util.Date;

public class User {

    private int id;
    private String userName;
    private String passWord;
    private Date updateTime;

    public User() {

    }

    public User(int id, String userName, String passWord, Date updateTime) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
