package com.iflytek.fwpt.model.rule.vo;

public class SilenceWarningVo extends BaseVo
{
    private String startTime;

    private String endTime;

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

}
