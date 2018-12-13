package com.iflytek.fwpt.model.dqjc;

import java.util.Date;

/**
 * t_phone_info
 * @author 
 */
public class PhoneInfo {
    private String id;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 人员名称
     */
    private String pname;

    /**
     * 身份证号码
     */
    private String idcard;

    private Integer sex;

    /**
     * 涉毒角色
     */
    private String sdrole;

    /**
     * 涉毒状态
     */
    private String sdstatus;

    /**
     * 区域ID
     */
    private String areaCode;

    /**
     * 区域名
     */
    private String areaname;

    /**
     * 派出所ID
     */
    private String substationid;

    /**
     * 派出所名
     */
    private String substationname;

    /**
     * 是否侦控中
     */
    private Integer iszk;

    /**
     * 是否非关押
     */
    private Integer isgy;

    /**
     * 是否隐性
     */
    private Integer isyx;

    private Date uptime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSdrole() {
        return sdrole;
    }

    public void setSdrole(String sdrole) {
        this.sdrole = sdrole;
    }

    public String getSdstatus() {
        return sdstatus;
    }

    public void setSdstatus(String sdstatus) {
        this.sdstatus = sdstatus;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getSubstationid() {
        return substationid;
    }

    public void setSubstationid(String substationid) {
        this.substationid = substationid;
    }

    public String getSubstationname() {
        return substationname;
    }

    public void setSubstationname(String substationname) {
        this.substationname = substationname;
    }

    public Integer getIszk() {
        return iszk;
    }

    public void setIszk(Integer iszk) {
        this.iszk = iszk;
    }

    public Integer getIsgy() {
        return isgy;
    }

    public void setIsgy(Integer isgy) {
        this.isgy = isgy;
    }

    public Integer getIsyx() {
        return isyx;
    }

    public void setIsyx(Integer isyx) {
        this.isyx = isyx;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "PhoneInfo{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", pname='" + pname + '\'' +
                ", idcard='" + idcard + '\'' +
                ", sex=" + sex +
                ", sdrole='" + sdrole + '\'' +
                ", sdstatus='" + sdstatus + '\'' +
                ", areaid='" + areaCode + '\'' +
                ", areaname='" + areaname + '\'' +
                ", substationid='" + substationid + '\'' +
                ", substationname='" + substationname + '\'' +
                ", iszk=" + iszk +
                ", isgy=" + isgy +
                ", isyx=" + isyx +
                ", uptime=" + uptime +
                '}';
    }
}