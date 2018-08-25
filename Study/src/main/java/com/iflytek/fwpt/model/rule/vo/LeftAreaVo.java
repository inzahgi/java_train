package com.iflytek.fwpt.model.rule.vo;




import com.iflytek.fwpt.model.area.AreaEntity;

import java.util.List;


public class LeftAreaVo extends BaseVo
{

    private String areaIds;

    private String warningSpanTime;

    private List<AreaEntity> areas;

    public String getAreaIds()
    {
        return areaIds;
    }

    public void setAreaIds(String areaIds)
    {
        this.areaIds = areaIds;
    }

    public String getWarningSpanTime()
    {
        return warningSpanTime;
    }

    public void setWarningSpanTime(String warningSpanTime)
    {
        this.warningSpanTime = warningSpanTime;
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
