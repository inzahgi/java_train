package com.iflytek.fwpt.model.rule.vo;

/**
 * 
    * @ClassName: PositionWarningRuleVo
    * @Description:位置预警规则
    * @author jgwang2
    * @date 2018年5月17日
    *
 */
public class PositionWarningRuleVo
{
    /**
     * 进入区域
     */
    private EnterAreaVo enterArea;

    /**
     * 到达城市
     */
    private ArriveCityVo arriveCity;

    /**
     * 离开区域
     */
    private LeftAreaVo leftArea;

    /**
     * 离开城市
     */
    private LeftCityVo leftCity;

    private String prevCode;

    private String nextCode;
    
    private String typeCode;

    private String taskName;

    public EnterAreaVo getEnterArea()
    {
        return enterArea;
    }

    public void setEnterArea(EnterAreaVo enterArea)
    {
        this.enterArea = enterArea;
    }

    public ArriveCityVo getArriveCity()
    {
        return arriveCity;
    }

    public void setArriveCity(ArriveCityVo arriveCity)
    {
        this.arriveCity = arriveCity;
    }

    public LeftAreaVo getLeftArea()
    {
        return leftArea;
    }

    public void setLeftArea(LeftAreaVo leftArea)
    {
        this.leftArea = leftArea;
    }

    public LeftCityVo getLeftCity()
    {
        return leftCity;
    }

    public void setLeftCity(LeftCityVo leftCity)
    {
        this.leftCity = leftCity;
    }

    public String getPrevCode()
    {
        return prevCode;
    }

    public void setPrevCode(String prevCode)
    {
        this.prevCode = prevCode;
    }

    public String getNextCode()
    {
        return nextCode;
    }

    public void setNextCode(String nextCode)
    {
        this.nextCode = nextCode;
    }

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String typeCode)
    {
        this.typeCode = typeCode;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    
}
