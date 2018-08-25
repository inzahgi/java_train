package com.iflytek.fwpt.model.taskShow.vo;

public class TaskVo
{

    private String id;

    private String name;

    private Integer totalNum;

    private Integer warningNum;

    private Integer unWarningNum;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getTotalNum()
    {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum)
    {
        this.totalNum = totalNum;
    }

    public Integer getWarningNum()
    {
        return warningNum;
    }

    public void setWarningNum(Integer warningNum)
    {
        this.warningNum = warningNum;
    }

    public Integer getUnWarningNum()
    {
        return unWarningNum;
    }

    public void setUnWarningNum(Integer unWarningNum)
    {
        this.unWarningNum = unWarningNum;
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
