package com.iflytek.fwpt.model.rule.hasTargetArea;

import com.iflytek.fwpt.model.rule.noTargetArea.TargetContractLostParamsXml;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:10:12
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "rules")
public class RulesForCarNumXml {

    @XmlElement(name = "rule")
    private RuleForCarNumXml<TargetContractLostParamsXml> targetContractLostParamsXml;

    @XmlElement(name = "rule")
    private RuleForCarNumXml<DistrictStatsParamsXml> districtStatParamsXml;

    @XmlElement(name = "rule")
    private RuleForCarNumXml<TargetMoveParamsXml> targetMoveParamsXml;

    public RuleForCarNumXml getTargetContractLostParamsXml() {
        return targetContractLostParamsXml;
    }

    public void setTargetContractLostParamsXml(RuleForCarNumXml targetContractLostParamsXml) {
        this.targetContractLostParamsXml = targetContractLostParamsXml;
    }

    public RuleForCarNumXml getDistrictStatParamsXml() {
        return districtStatParamsXml;
    }

    public void setDistrictStatParamsXml(RuleForCarNumXml districtStatParamsXml) {
        this.districtStatParamsXml = districtStatParamsXml;
    }

    public RuleForCarNumXml getTargetMoveParamsXml() {
        return targetMoveParamsXml;
    }

    public void setTargetMoveParamsXml(RuleForCarNumXml targetMoveParamsXml) {
        this.targetMoveParamsXml = targetMoveParamsXml;
    }
}
