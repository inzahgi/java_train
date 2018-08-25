package com.iflytek.fwpt.model.task;

import java.util.Date;

/**
 * tbl_group_rule
 * @author 
 */
public class GroupRuleEntity {
    /**
     * 预警任务规则ID(此ID与hz交互用)
     */
    private String rid;

    /**
     * 预警任务ID
     */
    private String tid;

    /**
     * 群体ID
     */
    private String gid;

    /**
     * 规则类型
     */
    private String ruleType;

    /**
     * 是否为交集（交集和并集格式不一样1为交集0为并集
     */
    private String isIntersection;

    /**
     * 规则xml形式
     */
    private String ruleInfoXml;

    /**
     * 规则参数
     */
    private String ruleParam;

    /**
     * 区域id和边界点信息
     */
    private String areaInfo;

    /**
     * 创建者
     */
    private String createUser;

    private Date createTime;

    private Date updateTime;



    /**
     * 是否为交集（交集和并集格式不一样1为交集0为并集
     */
    public interface IS_INTERSECTION{
        String INTERSECTION = "1";
        String UNION = "0";
    }


    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getIsIntersection() {
        return isIntersection;
    }

    public void setIsIntersection(String isIntersection) {
        this.isIntersection = isIntersection;
    }

    public String getRuleInfoXml() {
        return ruleInfoXml;
    }

    public void setRuleInfoXml(String ruleInfoXml) {
        this.ruleInfoXml = ruleInfoXml;
    }

    public String getRuleParam() {
        return ruleParam;
    }

    public void setRuleParam(String ruleParam) {
        this.ruleParam = ruleParam;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}