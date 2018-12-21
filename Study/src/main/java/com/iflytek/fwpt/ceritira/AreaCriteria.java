package com.iflytek.fwpt.ceritira;

public class AreaCriteria
{
    private String name;

    private String lable;

    private String startTime;

    private String endTime;

    private Integer pageSize;

    private Integer pageNo;

    private String userId;

    @Override
    public String toString()
    {
        return "AreaCriteria [" + (name != null ? "name=" + name + ", " : "")
            + (lable != null ? "lable=" + lable + ", " : "")
            + (startTime != null ? "startTime=" + startTime + ", " : "")
            + (endTime != null ? "endTime=" + endTime + ", " : "")
            + (pageSize != null ? "pageSize=" + pageSize + ", " : "")
            + (pageNo != null ? "pageNo=" + pageNo + ", " : "") + (userId != null ? "userId=" + userId + ", " : "")
            + (getName() != null ? "getName()=" + getName() + ", " : "")
            + (getLable() != null ? "getLable()=" + getLable() + ", " : "")
            + (getStartTime() != null ? "getStartTime()=" + getStartTime() + ", " : "")
            + (getEndTime() != null ? "getEndTime()=" + getEndTime() + ", " : "")
            + (getUserId() != null ? "getUserId()=" + getUserId() + ", " : "")
            + (getPageSize() != null ? "getPageSize()=" + getPageSize() + ", " : "")
            + (getPageNo() != null ? "getPageNo()=" + getPageNo() + ", " : "")
            + (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + ", "
            + (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLable()
    {
        return lable;
    }

    public void setLable(String lable)
    {
        this.lable = lable;
    }

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

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public Integer getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(Integer pageNo)
    {
        this.pageNo = pageNo;
    }

}
