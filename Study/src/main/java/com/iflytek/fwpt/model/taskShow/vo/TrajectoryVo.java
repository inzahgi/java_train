package com.iflytek.fwpt.model.taskShow.vo;


import java.util.List;


public class TrajectoryVo
{

    private String id;

    private String warningTime;

    private String lng;

    private String lat;

    private String address;

    private String taskId;

    private String pos;

    private String name;

    private String idcard;

    private String phone;

    private List<TaskVo> tasks;

    private String taskTypeName;

    private String group;

    public String getWarningTime()
    {
        return warningTime;
    }

    public void setWarningTime(String warningTime)
    {
        this.warningTime = warningTime;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getPos()
    {
        return pos;
    }

    public void setPos(String pos)
    {
        this.pos = pos;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIdcard()
    {
        return idcard;
    }

    public void setIdcard(String idcard)
    {
        this.idcard = idcard;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public List<TaskVo> getTasks()
    {
        return tasks;
    }

    public void setTasks(List<TaskVo> tasks)
    {
        this.tasks = tasks;
    }

    public String getTaskTypeName()
    {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName)
    {
        this.taskTypeName = taskTypeName;
    }

    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    
}
