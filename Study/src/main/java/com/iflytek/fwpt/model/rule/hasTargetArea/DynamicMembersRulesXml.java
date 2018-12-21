package com.iflytek.fwpt.model.rule.hasTargetArea;


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
public class DynamicMembersRulesXml {
    @XmlElement(name = "rule")
    private RuleForCarNumXml<HomeAreasParamsXml> homeareamembersXml;

    @XmlElement(name = "rule")
    private RuleForCarNumXml<RelateAreasParamXml> relateareamembersXml;

    @XmlElement(name = "rule")
    private RuleForCarNumXml<IgnoreMembersParamsXml> ignoremembersXml;

    @XmlElement(name = "rule")
    private RuleForCarNumXml<SpecialAppsParamsXml> specialappsXml;

    @XmlElement(name = "rule")
    private RuleForCarNumXml<CoreRelateAreaMemberParamsXml> coreRelateareamembersXml;

    @XmlElement(name = "rule")
    private RuleForCarNumXml<NavigationParamsXml> navigationXml;

    @XmlElement(name = "rule")
    private RuleForCarNumXml<DeliveryParamsXml> deliveryXml;


    public RuleForCarNumXml<HomeAreasParamsXml> getHomeareamembersXml() {
        return homeareamembersXml;
    }

    public void setHomeareamembersXml(RuleForCarNumXml<HomeAreasParamsXml> homeareamembersXml) {
        this.homeareamembersXml = homeareamembersXml;
    }

    public RuleForCarNumXml<RelateAreasParamXml> getRelateareamembersXml() {
        return relateareamembersXml;
    }

    public void setRelateareamembersXml(RuleForCarNumXml<RelateAreasParamXml> relateareamembersXml) {
        this.relateareamembersXml = relateareamembersXml;
    }

    public RuleForCarNumXml<IgnoreMembersParamsXml> getIgnoremembersXml() {
        return ignoremembersXml;
    }

    public void setIgnoremembersXml(RuleForCarNumXml<IgnoreMembersParamsXml> ignoremembersXml) {
        this.ignoremembersXml = ignoremembersXml;
    }

    public RuleForCarNumXml<SpecialAppsParamsXml> getSpecialappsXml() {
        return specialappsXml;
    }

    public void setSpecialappsXml(RuleForCarNumXml<SpecialAppsParamsXml> specialappsXml) {
        this.specialappsXml = specialappsXml;
    }

    public RuleForCarNumXml<CoreRelateAreaMemberParamsXml> getCoreRelateareamembersXml() {
        return coreRelateareamembersXml;
    }

    public void setCoreRelateareamembersXml(RuleForCarNumXml<CoreRelateAreaMemberParamsXml> coreRelateareamembersXml) {
        this.coreRelateareamembersXml = coreRelateareamembersXml;
    }

    public RuleForCarNumXml<NavigationParamsXml> getNavigationXml() {
        return navigationXml;
    }

    public void setNavigationXml(RuleForCarNumXml<NavigationParamsXml> navigationXml) {
        this.navigationXml = navigationXml;
    }

    public RuleForCarNumXml<DeliveryParamsXml> getDeliveryXml() {
        return deliveryXml;
    }

    public void setDeliveryXml(RuleForCarNumXml<DeliveryParamsXml> deliveryXml) {
        this.deliveryXml = deliveryXml;
    }
}
