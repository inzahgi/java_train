package com.iflytek.fwpt.model.rule.noTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class RiskWarningParamsXml {
    @XmlElement(name = "count")
    private String count;

    @XmlElement(name = "riskcity")
    private String riskCity;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRiskCity() {
        return riskCity;
    }

    public void setRiskCity(String riskCity) {
        this.riskCity = riskCity;
    }
}
