/*
 * 文件名：MemberResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月7日
 */

package com.iflytek.fwpt.model.taskShow;

import java.util.Date;

/**
 * 预警结果人员信息tbl_member_result
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月7日
 */
public class MemberResultVo
{
    /**
     * tbl_member_result表唯一标识符<br>
     */
    private String id;
    
    /**
     * 任务ID<br>
     */
    private String taskId;
    
    /**
     * 预警ID<br>
     */
    private String ruleId;

    /**
     * 预警类型<br>
     */
    private String taskType;
    
    /**
     * 关联tbl_rule_result<br>
     */
    private String memberId;
    
    /**
     * 账号类型<br>
     */
    private String accType;
    
    /**
     * 账号<br>
     */
    private String account;
    
    /**
     * 身份证号<br>
     */
    private String idCard;
    
    /**
     * 群组名<br>
     */
    private String groupName;
    
    /**
     * 监控人员姓名<br>
     */
    private String name;
    
    /**
     * 预警时间<br>
     */
    private Date warningTime;
    
    /**
     * 基站信息<br>
     */
    private String location;
    
    /**
     * 经度<br>
     */
    private String lon;
    
    /**
     * 纬度<br>
     */
    private String lat;
    
    /**
     * 出现区域<br>
     */
    private String areaId;
    
    /**
     * 出现区域编码<br>
     */
    private String areaCode;
    
    /**
     * 消息是否已读（0-未读，1-已读）<br>
     */
    private String isReaded;
    
    /**
     * 消息是否已推送（0-未推送，1-已推送）<br>
     */
    private String isPushed;
    
    /**
     * 创建时间<br>
     */
    private Date createTime;
    
    /**
     * 创建民警<br>
     */
    private String createUser;
    
    /**
     * 每个号码接收到的预警消息数<br>
     */
    private String msgNum;

    public String getId()
    {
        return id;
    }

    public String getMsgNum()
    {
        return msgNum;
    }

    public void setMsgNum(String msgNum)
    {
        this.msgNum = msgNum;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIdCard()
    {
        return idCard;
    }

    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getRuleId()
    {
        return ruleId;
    }

    public void setRuleId(String ruleId)
    {
        this.ruleId = ruleId;
    }

    public String getTaskType()
    {
        return taskType;
    }

    public void setTaskType(String taskType)
    {
        this.taskType = taskType;
    }

    public String getMemberId()
    {
        return memberId;
    }

    public void setMemberId(String memberId)
    {
        this.memberId = memberId;
    }

    public String getAccType()
    {
        return accType;
    }

    public void setAccType(String accType)
    {
        this.accType = accType;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public Date getWarningTime()
    {
        return warningTime;
    }

    public void setWarningTime(Date warningTime)
    {
        this.warningTime = warningTime;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLon()
    {
        return lon;
    }

    public void setLon(String lon)
    {
        this.lon = lon;
    }

    public String getLat()
    {
        return lat;
    }

    public void setLat(String lat)
    {
        this.lat = lat;
    }

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getIsReaded()
    {
        return isReaded;
    }

    public void setIsReaded(String isReaded)
    {
        this.isReaded = isReaded;
    }

    public String getIsPushed()
    {
        return isPushed;
    }

    public void setIsPushed(String isPushed)
    {
        this.isPushed = isPushed;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }
}
