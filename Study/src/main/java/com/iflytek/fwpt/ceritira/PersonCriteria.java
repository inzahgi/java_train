package com.iflytek.fwpt.ceritira;

/**
 * 
    * @ClassName: PersonCritera
    * @Description: 重点人员查询条件
    * @author jgwang2
    * @date 2018年5月9日
    *
 */
public class PersonCriteria
{

    private String name;

    private String phone;

    /**
     * 证件号码（包括身份证号码与其他证件号码）
     */
    private String certificatesNum;

    private String grouName;

    private String policeName;

    private String startTime;

    private String endTime;

    private Integer pageSize = 1;

    private Integer pageNo = 10;

    private String createUserId;

    private String policeId;

    private String exportExcelType;

    private String personIds;

    private String groupId;

    private String taskId;

    private Integer showStatus;

    //逗号拼接taskId
    private String taskIdsStr;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCertificatesNum()
    {
        return certificatesNum;
    }

    public void setCertificatesNum(String certificatesNum)
    {
        this.certificatesNum = certificatesNum;
    }

    public String getGrouName()
    {
        return grouName;
    }

    public void setGrouName(String grouName)
    {
        this.grouName = grouName;
    }

    public String getPoliceName()
    {
        return policeName;
    }

    public void setPoliceName(String policeName)
    {
        this.policeName = policeName;
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

    public String getCreateUserId()
    {
        return createUserId;
    }

    public void setCreateUserId(String createUserId)
    {
        this.createUserId = createUserId;
    }

    public String getPoliceId()
    {
        return policeId;
    }

    public void setPoliceId(String policeId)
    {
        this.policeId = policeId;
    }

    public String getExportExcelType()
    {
        return exportExcelType;
    }

    public void setExportExcelType(String exportExcelType)
    {
        this.exportExcelType = exportExcelType;
    }

    public String getPersonIds()
    {
        return personIds;
    }

    public void setPersonIds(String personIds)
    {
        this.personIds = personIds;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getTaskIdsStr() {
        return taskIdsStr;
    }

    public void setTaskIdsStr(String taskIdsStr) {
        this.taskIdsStr = taskIdsStr;
    }

    @Override
    public String toString()
    {
        return "PersonCriteria [" + (name != null ? "name=" + name + ", " : "")
            + (phone != null ? "phone=" + phone + ", " : "")
            + (certificatesNum != null ? "certificatesNum=" + certificatesNum + ", " : "")
            + (grouName != null ? "grouName=" + grouName + ", " : "")
            + (policeName != null ? "policeName=" + policeName + ", " : "")
            + (startTime != null ? "startTime=" + startTime + ", " : "")
            + (endTime != null ? "endTime=" + endTime + ", " : "")
            + (pageSize != null ? "pageSize=" + pageSize + ", " : "")
            + (pageNo != null ? "pageNo=" + pageNo + ", " : "")
            + (createUserId != null ? "createUserId=" + createUserId + ", " : "")
            + (policeId != null ? "policeId=" + policeId + ", " : "")
            + (exportExcelType != null ? "exportExcelType=" + exportExcelType + ", " : "")
            + (personIds != null ? "personIds=" + personIds + ", " : "")
            + (groupId != null ? "groupId=" + groupId + ", " : "")
            + (taskId != null ? "taskId=" + taskId + ", " : "")
            + (showStatus != null ? "showStatus=" + showStatus + ", " : "")
            + (taskIdsStr != null ? "taskIdsStr=" + taskIdsStr + ", " : "")
            + (getName() != null ? "getName()=" + getName() + ", " : "")
            + (getPhone() != null ? "getPhone()=" + getPhone() + ", " : "")
            + (getCertificatesNum() != null ? "getCertificatesNum()=" + getCertificatesNum() + ", " : "")
            + (getGrouName() != null ? "getGrouName()=" + getGrouName() + ", " : "")
            + (getPoliceName() != null ? "getPoliceName()=" + getPoliceName() + ", " : "")
            + (getStartTime() != null ? "getStartTime()=" + getStartTime() + ", " : "")
            + (getEndTime() != null ? "getEndTime()=" + getEndTime() + ", " : "")
            + (getPageSize() != null ? "getPageSize()=" + getPageSize() + ", " : "")
            + (getPageNo() != null ? "getPageNo()=" + getPageNo() + ", " : "")
            + (getCreateUserId() != null ? "getCreateUserId()=" + getCreateUserId() + ", " : "")
            + (getPoliceId() != null ? "getPoliceId()=" + getPoliceId() + ", " : "")
            + (getExportExcelType() != null ? "getExportExcelType()=" + getExportExcelType() + ", " : "")
            + (getPersonIds() != null ? "getPersonIds()=" + getPersonIds() + ", " : "")
            + (getGroupId() != null ? "getGroupId()=" + getGroupId() + ", " : "")
            + (getTaskId() != null ? "getTaskId()=" + getTaskId() + ", " : "")
            + (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + ", "
            + (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
    }

}
