package com.example.study.model.rule.vo;




import com.example.study.model.area.AreaEntity;

import java.util.List;


public class AreaClusteringVo extends BaseVo
{

    private String areaIds;

    private String gatherTime;

    private String gatherNum;

    private List<AreaEntity> areas;

    public String getAreaIds()
    {
        return areaIds;
    }

    public void setAreaIds(String areaIds)
    {
        this.areaIds = areaIds;
    }

    public String getGatherTime()
    {
        return gatherTime;
    }

    public void setGatherTime(String gatherTime)
    {
        this.gatherTime = gatherTime;
    }

    public String getGatherNum()
    {
        return gatherNum;
    }

    public void setGatherNum(String gatherNum)
    {
        this.gatherNum = gatherNum;
    }

    public List<AreaEntity> getAreas()
    {
        return areas;
    }

    public void setAreas(List<AreaEntity> areas)
    {
        this.areas = areas;
    }

}
