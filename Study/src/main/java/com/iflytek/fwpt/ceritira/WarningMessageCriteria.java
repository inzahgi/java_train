package com.iflytek.fwpt.ceritira;

public class WarningMessageCriteria
{

    private Integer pageNo;

    private Integer pageSize;

    private String taskName;

    private String startTime;

    private String endTime;

    private String userId;

    private String phone;

    private String idcard;

    private String isRead;

    public Integer getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(Integer pageNo)
    {
        this.pageNo = pageNo;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
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

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getIdcard()
    {
        return idcard;
    }

    public void setIdcard(String idcard)
    {
        this.idcard = idcard;
    }

    public String getIsRead()
    {
        return isRead;
    }

    public void setIsRead(String isRead)
    {
        this.isRead = isRead;
    }

    @Override
    public String toString()
    {
        return "WarningMessageCriteria [" + (pageNo != null ? "pageNo=" + pageNo + ", " : "")
            + (pageSize != null ? "pageSize=" + pageSize + ", " : "")
            + (taskName != null ? "taskName=" + taskName + ", " : "")
            + (startTime != null ? "startTime=" + startTime + ", " : "")
            + (endTime != null ? "endTime=" + endTime + ", " : "") + (userId != null ? "userId=" + userId + ", " : "")
            + (phone != null ? "phone=" + phone + ", " : "") + (idcard != null ? "idcard=" + idcard + ", " : "")
            + (isRead != null ? "isRead=" + isRead + ", " : "")
            + (getPageNo() != null ? "getPageNo()=" + getPageNo() + ", " : "")
            + (getPageSize() != null ? "getPageSize()=" + getPageSize() + ", " : "")
            + (getTaskName() != null ? "getTaskName()=" + getTaskName() + ", " : "")
            + (getStartTime() != null ? "getStartTime()=" + getStartTime() + ", " : "")
            + (getEndTime() != null ? "getEndTime()=" + getEndTime() + ", " : "")
            + (getUserId() != null ? "getUserId()=" + getUserId() + ", " : "")
            + (getPhone() != null ? "getPhone()=" + getPhone() + ", " : "")
            + (getIdcard() != null ? "getIdcard()=" + getIdcard() + ", " : "")
            + (getIsRead() != null ? "getIsRead()=" + getIsRead() + ", " : "")
            + (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + ", "
            + (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
    }

}
