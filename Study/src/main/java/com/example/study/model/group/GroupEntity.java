package com.example.study.model.group;

public class GroupEntity
{
    private String id;

    private String name;

    private String oldName;

    private String userId;

    private String createTime;

    private Integer personCount = 0;

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

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getOldName()
    {
        return oldName;
    }

    public void setOldName(String oldName)
    {
        this.oldName = oldName;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public Integer getPersonCount()
    {
        return personCount;
    }

    public void setPersonCount(Integer personCount)
    {
        this.personCount = personCount;
    }

    @Override
    public String toString() {
        return "GroupEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", oldName='" + oldName + '\'' +
                ", userId='" + userId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", personCount=" + personCount +
                '}';
    }
}
