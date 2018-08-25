package com.iflytek.fwpt.model.rule.vo;

public class ArriveCityVo extends BaseVo
{
    private String areaCode;

    private String repeatWarningTime = "0";

    private Integer isArrived;

    public String getAreaCode()
    {
        return areaCode;
    }

    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public Integer getIsArrived()
    {
        return isArrived;
    }

    public void setIsArrived(Integer isArrived)
    {
        this.isArrived = isArrived;
    }

    public String getRepeatWarningTime()
    {
        return repeatWarningTime;
    }

    public void setRepeatWarningTime(String repeatWarningTime)
    {
        this.repeatWarningTime = repeatWarningTime;
    }

}
