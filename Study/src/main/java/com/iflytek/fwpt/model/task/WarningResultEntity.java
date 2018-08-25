package com.iflytek.fwpt.model.task;

public class WarningResultEntity
{

    private String id;

    private String hzRuleId;

    private String taskType;

    private String result;

    private String createTime;

    private Integer isdone;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getHzRuleId()
    {
        return hzRuleId;
    }

    public void setHzRuleId(String hzRuleId)
    {
        this.hzRuleId = hzRuleId;
    }

    public String getTaskType()
    {
        return taskType;
    }

    public void setTaskType(String taskType)
    {
        this.taskType = taskType;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public Integer getIsdone()
    {
        return isdone;
    }

    public void setIsdone(Integer isdone)
    {
        this.isdone = isdone;
    }

}
