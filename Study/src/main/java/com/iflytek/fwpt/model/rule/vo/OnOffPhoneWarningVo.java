package com.iflytek.fwpt.model.rule.vo;

public class OnOffPhoneWarningVo extends BaseVo
{

    private String startTime;

    private String endTime;

    private String freeTime;

    private String rate;

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getFreeTime()
    {
        return freeTime;
    }

    public void setFreeTime(String freeTime)
    {
        this.freeTime = freeTime;
    }

    public String getRate()
    {
        return rate;
    }

    public void setRate(String rate)
    {
        this.rate = rate;
    }

}
