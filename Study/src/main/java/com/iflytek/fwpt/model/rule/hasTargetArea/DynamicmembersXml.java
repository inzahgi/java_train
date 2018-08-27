package com.iflytek.fwpt.model.rule.hasTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "dynamicmembers")
public class DynamicmembersXml {
    @XmlElement(name = "rules")
    private DynamicMembersRulesXml dynamicMembersRulesXml;

    public DynamicMembersRulesXml getDynamicMembersRulesXml() {
        return dynamicMembersRulesXml;
    }

    public void setDynamicMembersRulesXml(DynamicMembersRulesXml dynamicMembersRulesXml) {
        this.dynamicMembersRulesXml = dynamicMembersRulesXml;
    }
}
