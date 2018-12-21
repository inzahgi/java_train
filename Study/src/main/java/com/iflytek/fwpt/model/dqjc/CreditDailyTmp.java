package com.iflytek.fwpt.model.dqjc;

import java.util.Date;

/**
 * t_credit_daily_tmp
 * @author 
 */
public class CreditDailyTmp {
    private Integer id;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 行为记录
     */
    private String content;

    /**
     * 行为时间
     */
    private Date actiontime;

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

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getActiontime() {
        return actiontime;
    }

    public void setActiontime(Date actiontime) {
        this.actiontime = actiontime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}