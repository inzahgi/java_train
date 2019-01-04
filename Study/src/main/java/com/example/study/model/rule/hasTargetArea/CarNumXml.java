package com.example.study.model.rule.hasTargetArea;


import com.example.study.model.rule.AreaListXml;
import com.example.study.model.rule.MemberListXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "condition")
public class CarNumXml {
    @XmlElement(name = "members")
    private MemberListXml memberListXml;

    @XmlElement(name = "dynamicmembers")
    private DynamicmembersXml dynamicmembersXml;

    @XmlElement(name = "arealist")
    private AreaListXml areaListXml;

    @XmlElement(name = "rules")
    private RulesForCarNumXml rulesForCarNumXml;

    @XmlElement(name = "appearcity")
    private String appearcity;

    @XmlElement(name = "inOutType")
    private String inOutType;

    @XmlElement(name = "calType")
    private String calType;

    @XmlElement(name = "statusHist")
    private String statusHist;

    @XmlElement(name = "leaveSpan")
    private String leaveSpan;

    @XmlElement(name = "staySpan")
    private String staySpan;


    public MemberListXml getMemberListXml() {
        return memberListXml;
    }

    public void setMemberListXml(MemberListXml memberListXml) {
        this.memberListXml = memberListXml;
    }

    public DynamicmembersXml getDynamicmembersXml() {
        return dynamicmembersXml;
    }

    public void setDynamicmembersXml(DynamicmembersXml dynamicmembersXml) {
        this.dynamicmembersXml = dynamicmembersXml;
    }

    public AreaListXml getAreaListXml() {
        return areaListXml;
    }

    public void setAreaListXml(AreaListXml areaListXml) {
        this.areaListXml = areaListXml;
    }

    public RulesForCarNumXml getRulesForCarNumXml() {
        return rulesForCarNumXml;
    }

    public void setRulesForCarNumXml(RulesForCarNumXml rulesForCarNumXml) {
        this.rulesForCarNumXml = rulesForCarNumXml;
    }

    public String getAppearcity() {
        return appearcity;
    }

    public void setAppearcity(String appearcity) {
        this.appearcity = appearcity;
    }

    public String getInOutType() {
        return inOutType;
    }

    public void setInOutType(String inOutType) {
        this.inOutType = inOutType;
    }

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
    }

    public String getStatusHist() {
        return statusHist;
    }

    public void setStatusHist(String statusHist) {
        this.statusHist = statusHist;
    }

    public String getLeaveSpan() {
        return leaveSpan;
    }

    public void setLeaveSpan(String leaveSpan) {
        this.leaveSpan = leaveSpan;
    }

    public String getStaySpan() {
        return staySpan;
    }

    public void setStaySpan(String staySpan) {
        this.staySpan = staySpan;
    }
}
