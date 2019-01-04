package com.example.study.model.dqjc;

import java.util.Date;

/**
 * t_credit_score
 * @author 
 */
public class CreditScore {
    private Integer id;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 手机号
     */
    private String phone;

    /**
     * level	tinyInt(2)	not null	级别：1:极高 2:较高 3:高 4:中 5:低
     */
    private Integer level;

    private Integer score;

    /**
     * 1为正在使用 0为停用 默认为0
     */
    private Integer status;

    private Date createtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idcard) {
        this.idCard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


}