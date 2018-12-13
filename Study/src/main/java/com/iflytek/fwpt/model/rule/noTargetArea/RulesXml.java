package com.iflytek.fwpt.model.rule.noTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/25
 * Time:17:26
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "rules")
public class RulesXml {
    @XmlElement(name = "rule")
    private RuleXml targetcontactlostXml;

    @XmlElement(name = "rule")
    private RuleXml incountwarningXml;

    @XmlElement(name = "rule")
    private RuleXml totalcountwarningXml;

    @XmlElement(name = "rule")
    private RuleXml riskwarningXml;

    public RuleXml getTargetcontactlostXml() {
        return targetcontactlostXml;
    }

    public void setTargetcontactlostXml(RuleXml targetcontactlostXml) {
        this.targetcontactlostXml = targetcontactlostXml;
    }

    public RuleXml getIncountwarningXml() {
        return incountwarningXml;
    }

    public void setIncountwarningXml(RuleXml incountwarningXml) {
        this.incountwarningXml = incountwarningXml;
    }

    public RuleXml getTotalcountwarningXml() {
        return totalcountwarningXml;
    }

    public void setTotalcountwarningXml(RuleXml totalcountwarningXml) {
        this.totalcountwarningXml = totalcountwarningXml;
    }

    public RuleXml getRiskwarningXml() {
        return riskwarningXml;
    }

    public void setRiskwarningXml(RuleXml riskwarningXml) {
        this.riskwarningXml = riskwarningXml;
    }
}
