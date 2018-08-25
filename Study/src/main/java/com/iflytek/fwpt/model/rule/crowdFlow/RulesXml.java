package com.iflytek.fwpt.model.rule.crowdFlow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.ibatis.annotations.Param;

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

}
