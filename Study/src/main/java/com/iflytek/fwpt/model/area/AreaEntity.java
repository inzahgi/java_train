package com.iflytek.fwpt.model.area;


import java.util.List;


public class AreaEntity
{

    private String id;

    private String name;

    private String labelName;

    private String labelId;

    private Integer stationNum = 0;

    private String boundanies;

    /**
     * 预警区域边界坐标点（通过boundanies进行切割处理）
     */
    private List<double[]> points;

    private String userId;

    private String createTime;

    private String updateTime;

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

    public String getLabelName()
    {
        return labelName;
    }

    public void setLabelName(String labelName)
    {
        this.labelName = labelName;
    }

    public Integer getStationNum()
    {
        return stationNum;
    }

    public void setStationNum(Integer stationNum)
    {
        this.stationNum = stationNum;
    }

    public String getBoundanies()
    {
        return boundanies;
    }

    public void setBoundanies(String boundanies)
    {
        this.boundanies = boundanies;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public List<double[]> getPoints()
    {
        return points;
    }

    public void setPoints(List<double[]> points)
    {
        this.points = points;
    }

    public String getLabelId()
    {
        return labelId;
    }

    public void setLabelId(String labelId)
    {
        this.labelId = labelId;
    }

    public String getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AreaEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", labelName='" + labelName + '\'' +
                ", labelId='" + labelId + '\'' +
                ", stationNum=" + stationNum +
                ", boundanies='" + boundanies + '\'' +
                ", points=" + points +
                ", userId='" + userId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
