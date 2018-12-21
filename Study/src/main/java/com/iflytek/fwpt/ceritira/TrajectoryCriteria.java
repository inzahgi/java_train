package com.iflytek.fwpt.ceritira;

public class TrajectoryCriteria
{

    private String id;

    private String startTime;

    private String endTime;

    private String phone;

    private Integer pageNo;

    private Integer pageSize;

    private String userId;

    private String taskId;

    private String lng;

    private String lat;

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

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

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

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getLng()
    {
        return lng;
    }

    public void setLng(String lng)
    {
        this.lng = lng;
    }

    public String getLat()
    {
        return lat;
    }

    public void setLat(String lat)
    {
        this.lat = lat;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "TrajectoryCriteria [" + (id != null ? "id=" + id + ", " : "")
            + (startTime != null ? "startTime=" + startTime + ", " : "")
            + (endTime != null ? "endTime=" + endTime + ", " : "") + (phone != null ? "phone=" + phone + ", " : "")
            + (pageNo != null ? "pageNo=" + pageNo + ", " : "")
            + (pageSize != null ? "pageSize=" + pageSize + ", " : "")
            + (userId != null ? "userId=" + userId + ", " : "") + (taskId != null ? "taskId=" + taskId + ", " : "")
            + (lng != null ? "lng=" + lng + ", " : "") + (lat != null ? "lat=" + lat + ", " : "")
            + (getStartTime() != null ? "getStartTime()=" + getStartTime() + ", " : "")
            + (getEndTime() != null ? "getEndTime()=" + getEndTime() + ", " : "")
            + (getPhone() != null ? "getPhone()=" + getPhone() + ", " : "")
            + (getPageNo() != null ? "getPageNo()=" + getPageNo() + ", " : "")
            + (getPageSize() != null ? "getPageSize()=" + getPageSize() + ", " : "")
            + (getUserId() != null ? "getUserId()=" + getUserId() + ", " : "")
            + (getTaskId() != null ? "getTaskId()=" + getTaskId() + ", " : "")
            + (getLng() != null ? "getLng()=" + getLng() + ", " : "")
            + (getLat() != null ? "getLat()=" + getLat() + ", " : "")
            + (getId() != null ? "getId()=" + getId() + ", " : "")
            + (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + ", "
            + (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
    }

}
