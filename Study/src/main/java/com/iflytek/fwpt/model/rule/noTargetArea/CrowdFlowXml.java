package com.iflytek.fwpt.model.rule.noTargetArea;

import com.iflytek.fwpt.model.rule.AreaListXml;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/24
 * Time:17:22
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "condition")
public class CrowdFlowXml implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "homearea")
    private String homeArea = "023";

    @XmlElement(name = "appinfos")
    private AppinfosXml appinfosXml;

    @XmlElement(name = "arealist")
    private AreaListXml areaListXml;

    @XmlElement(name = "rules")
    private RulesXml rulesXml;











    public String getHomeArea() {
        return homeArea;
    }

    public void setHomeArea(String homeArea) {
        this.homeArea = homeArea;
    }

    public AppinfosXml getAppinfosXml() {
        return appinfosXml;
    }

    public void setAppinfosXml(AppinfosXml appinfosXml) {
        this.appinfosXml = appinfosXml;
    }

    public AreaListXml getAreaListXml() {
        return areaListXml;
    }

    public void setAreaListXml(AreaListXml areaListXml) {
        this.areaListXml = areaListXml;
    }

    public RulesXml getRulesXml() {
        return rulesXml;
    }

    public void setRulesXml(RulesXml rulesXml) {
        this.rulesXml = rulesXml;
    }
}
