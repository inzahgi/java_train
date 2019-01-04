package com.example.study.model.rule.vo;

public class BaseVo
{

    private String id;

    private String taskId;

    private Integer isChecked;

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public Integer getIsChecked()
    {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked)
    {
        this.isChecked = isChecked;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

}
