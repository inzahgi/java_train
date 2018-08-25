package com.iflytek.fwpt.ceritira;

public class GroupCriteria
{
    private String name;

    private String startTime;

    private String endTime;

    private Integer pageSize;

    private Integer pageNo;

    private String userId;

    @Override
    public String toString()
    {
        return "GroupCriteria [" + (name != null ? "name=" + name + ", " : "")
            + (startTime != null ? "startTime=" + startTime + ", " : "")
            + (endTime != null ? "endTime=" + endTime + ", " : "")
            + (pageSize != null ? "pageSize=" + pageSize + ", " : "")
            + (pageNo != null ? "pageNo=" + pageNo + ", " : "") + (userId != null ? "userId=" + userId + ", " : "")
            + (policeId != null ? "policeId=" + policeId + ", " : "")
            + (getName() != null ? "getName()=" + getName() + ", " : "")
            + (getStartTime() != null ? "getStartTime()=" + getStartTime() + ", " : "")
            + (getEndTime() != null ? "getEndTime()=" + getEndTime() + ", " : "")
            + (getPageSize() != null ? "getPageSize()=" + getPageSize() + ", " : "")
            + (getPageNo() != null ? "getPageNo()=" + getPageNo() + ", " : "")
            + (getUserId() != null ? "getUserId()=" + getUserId() + ", " : "")
            + (getPoliceId() != null ? "getPoliceId()=" + getPoliceId() + ", " : "")
            + (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + ", "
            + (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
    }

    private String policeId;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPoliceId()
    {
        return policeId;
    }

    public void setPoliceId(String policeId)
    {
        this.policeId = policeId;
    }

}
