/*
 * 文件名：RuleResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月7日
 */

package com.iflytek.fwpt.model.taskShow;

import java.util.Date;

/**
 * 预警任务结果表tbl_rule_result
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月7日
 */
public class RuleResultVo
{

    /**
     * tbl_rule_result表唯一标识符<br>
     */
    private String id;
    
    /**
     * 任务ID<br>
     */
    private String taskId;
    
    /**
     * 任务名<br>
     */
    private String taskName;
    
    /**
     * 预警ID<br>
     */
    private String ruleId;

    /**
     * 预警类型<br>
     */
    private String taskType;
    
    /**
     * 预警时间<br>
     */
    private Date warningTime;
    
    /**
     * 创建时间<br>
     */
    private Date createTime;
    
    /**
     * 创建民警<br>
     */
    private String createUser;
    
    /**
     * 关联tbl_member_result<br>
     */
    private String memberId;
    
    /**
     * 用户账号json格式信息<br>
     */
    private String memberJSON;
    
    /**
     * 自定义列信息json格式信息<br>
     */
    private String columnJSON;
    
    /**
     * 消息是否已读（0-未读，1-已读）<br>
     */
    private String isReaded;

    public String getId()
    {
        return id;
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

    public Date getWarningTime()
    {
        return warningTime;
    }

    public void setWarningTime(Date warningTime)
    {
        this.warningTime = warningTime;
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

    public String getMemberId()
    {
        return memberId;
    }

    public void setMemberId(String memberId)
    {
        this.memberId = memberId;
    }

    public String getMemberJSON()
    {
        return memberJSON;
    }

    public void setMemberJSON(String memberJSON)
    {
        this.memberJSON = memberJSON;
    }

    public String getColumnJSON()
    {
        return columnJSON;
    }

    public void setColumnJSON(String columnJSON)
    {
        this.columnJSON = columnJSON;
    }

    public String getIsReaded()
    {
        return isReaded;
    }

    public void setIsReaded(String isReaded)
    {
        this.isReaded = isReaded;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }
}
