package com.iflytek.fwpt.ceritira;

public class TaskCriteria
{

    @Override
    public String toString()
    {
        return "TaskCriteria [" + (name != null ? "name=" + name + ", " : "")
            + (startTime != null ? "startTime=" + startTime + ", " : "")
            + (endTime != null ? "endTime=" + endTime + ", " : "") + (pageNo != null ? "pageNo=" + pageNo + ", " : "")
            + (pageSize != null ? "pageSize=" + pageSize + ", " : "")
            + (createUserId != null ? "createUserId=" + createUserId + ", " : "")
            + (taskId != null ? "taskId=" + taskId + ", " : "") + (account != null ? "account=" + account + ", " : "")
            + (idCard != null ? "idCard=" + idCard + ", " : "") + (searchNum != null ? "searchNum=" + searchNum : "")
            + "]";
    }

    private String name;

    private String startTime;

    private String endTime;

    private Integer pageNo;

    private Integer pageSize;

    private String createUserId;

    /**
     * 预警任务ID<br>
     */
    private String taskId;

    /**
     * 被监控账号<br>
     */
    private String account;

    /**
     * 被监控账号身份证号<br>
     */
    private String idCard;

    private String searchNum;

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getIdCard()
    {
        return idCard;
    }

    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

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

    public String getCreateUserId()
    {
        return createUserId;
    }

    public void setCreateUserId(String createUserId)
    {
        this.createUserId = createUserId;
    }

    public String getSearchNum()
    {
        return searchNum;
    }

    public void setSearchNum(String searchNum)
    {
        this.searchNum = searchNum;
    }

}
