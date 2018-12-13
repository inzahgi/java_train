package com.iflytek.fwpt.model.rule.vo;

/**
* @ClassName: BehavioWarningRuleVo
* @Description:行为预警
* @author jgwang2
* @date 2018年5月17日
*
*/

public class BehavioWarningRuleVo
{
    /**
     * 敏感地区通联预警
     */
    private SensitiveAreaContactVo sensitiveArea;

    /**
     * 失联预警
     */
    private MissWarningVo missWarning;

    /**
     * 管控目标通联
     */
    private ControlTargetContactVo targetContact;

    /**
     * 管控目标与重庆通联
     */
    private ControlTargetContactWhithCQVo cqContact;

    /**
     * 静默预警
     */
    private SilenceWarningVo silenceWarningVo;

    /**
     * 交通住宿预警
     */
    private TrafficStayVo trafficStayVo;

    /**
     * 开关机预警
     */
    private OnOffPhoneWarningVo onOffWarning;

    /**
     * 换机换卡预警
     */
    private ReplacementCardVo replacementCard;

    private String prevCode;

    private String nextCode;

    private String typeCode;

    private String taskName;

    public SensitiveAreaContactVo getSensitiveArea()
    {
        return sensitiveArea;
    }

    public void setSensitiveArea(SensitiveAreaContactVo sensitiveArea)
    {
        this.sensitiveArea = sensitiveArea;
    }

    public MissWarningVo getMissWarning()
    {
        return missWarning;
    }

    public void setMissWarning(MissWarningVo missWarning)
    {
        this.missWarning = missWarning;
    }

    public ControlTargetContactVo getTargetContact()
    {
        return targetContact;
    }

    public void setTargetContact(ControlTargetContactVo targetContact)
    {
        this.targetContact = targetContact;
    }

    public ControlTargetContactWhithCQVo getCqContact()
    {
        return cqContact;
    }

    public void setCqContact(ControlTargetContactWhithCQVo cqContact)
    {
        this.cqContact = cqContact;
    }

    public SilenceWarningVo getSilenceWarningVo()
    {
        return silenceWarningVo;
    }

    public void setSilenceWarningVo(SilenceWarningVo silenceWarningVo)
    {
        this.silenceWarningVo = silenceWarningVo;
    }

    public TrafficStayVo getTrafficStayVo()
    {
        return trafficStayVo;
    }

    public void setTrafficStayVo(TrafficStayVo trafficStayVo)
    {
        this.trafficStayVo = trafficStayVo;
    }

    public OnOffPhoneWarningVo getOnOffWarning()
    {
        return onOffWarning;
    }

    public void setOnOffWarning(OnOffPhoneWarningVo onOffWarning)
    {
        this.onOffWarning = onOffWarning;
    }

    public ReplacementCardVo getReplacementCard()
    {
        return replacementCard;
    }

    public void setReplacementCard(ReplacementCardVo replacementCard)
    {
        this.replacementCard = replacementCard;
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
