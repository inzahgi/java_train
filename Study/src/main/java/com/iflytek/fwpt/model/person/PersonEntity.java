package com.iflytek.fwpt.model.person;

public class PersonEntity
{

    private String id;

    private String name;

    private String phone;

    private String idcard;

    private String otherCardType;

    private String otherCardNum;

    private String policeId;

    private String policeName;

    private String groupId;

    private String groupName;

    private String isWarning;

    private String createUser;

    private String createTime;

    private String updateTime;

    /**
     * 所属的群体id集合以逗号分割（该字段主要用于前端传递给后台进行处理）
     */
    private String checkGroupIds;

    /**
     * 所属的民警id集合以逗号分割（该字段主要用于前端传递给后台进行处理）
     */
    private String checkPoliceIds;

    /**
     * 状态标识（0表示该人员的所有数据可以进行修改，1表示该人员只有姓名，身份证，其他证件可以被修改）
     */
    private String status;

    private Integer personCnt;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

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

    public String getIdcard()
    {
        return idcard;
    }

    public void setIdcard(String idcard)
    {
        this.idcard = idcard;
    }

    public String getPoliceId()
    {
        return policeId;
    }

    public void setPoliceId(String policeId)
    {
        this.policeId = policeId;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }

    public String getIsWarning()
    {
        return isWarning;
    }

    public void setIsWarning(String isWarning)
    {
        this.isWarning = isWarning;
    }

    public String getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getOtherCardType()
    {
        return otherCardType;
    }

    public void setOtherCardType(String otherCardType)
    {
        this.otherCardType = otherCardType;
    }

    public String getOtherCardNum()
    {
        return otherCardNum;
    }

    public void setOtherCardNum(String otherCardNum)
    {
        this.otherCardNum = otherCardNum;
    }

    public String getPoliceName()
    {
        return policeName;
    }

    public void setPoliceName(String policeName)
    {
        this.policeName = policeName;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getCheckGroupIds()
    {
        return checkGroupIds;
    }

    public void setCheckGroupIds(String checkGroupIds)
    {
        this.checkGroupIds = checkGroupIds;
    }

    public String getCheckPoliceIds()
    {
        return checkPoliceIds;
    }

    public void setCheckPoliceIds(String checkPoliceIds)
    {
        this.checkPoliceIds = checkPoliceIds;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Integer getPersonCnt() {
        return personCnt;
    }

    public void setPersonCnt(Integer personCnt) {
        this.personCnt = personCnt;
    }
}
