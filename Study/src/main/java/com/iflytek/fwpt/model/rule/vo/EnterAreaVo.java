package com.iflytek.fwpt.model.rule.vo;





import com.iflytek.fwpt.model.area.AreaEntity;

import java.util.List;


public class EnterAreaVo extends BaseVo
{

    private String areaIds;

    // 计算类型（按边界计算 或者按基站计算）
    private String type;

    private String warningTimeSapn;

    private List<AreaEntity> areas;

    public String getAreaIds()
    {
        return areaIds;
    }

    public void setAreaIds(String areaIds)
    {
        this.areaIds = areaIds;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getWarningTimeSapn()
    {
        return warningTimeSapn;
    }

    public void setWarningTimeSapn(String warningTimeSapn)
    {
        this.warningTimeSapn = warningTimeSapn;
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
