package com.iflytek.fwpt.model.rule.carNum;


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
    private RuleXml homeareamembersXml;

    @XmlElement(name = "rule")
    private RuleXml relateareamembersXml;

    @XmlElement(name = "rule")
    private RuleXml ignoremembersXml;

    @XmlElement(name = "rule")
    private RuleXml specialappsXml;

    @XmlElement(name = "rule")
    private RuleXml wrongRelateareamembersXml;

    @XmlElement(name = "rule")
    private RuleXml navigationXml;

    @XmlElement(name = "rule")
    private RuleXml deliveryXml;



}
