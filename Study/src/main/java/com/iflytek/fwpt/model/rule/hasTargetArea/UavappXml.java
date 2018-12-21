package com.iflytek.fwpt.model.rule.hasTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:9:15
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "uavapp")
public class UavappXml {

    @XmlElement(name = "appids")
    private String appIds;

    public UavappXml() {
    }

    public UavappXml(String appIds) {
        this.appIds = appIds;
    }

    public String getAppIds() {
        return appIds;
    }

    public void setAppIds(String appIds) {
        this.appIds = appIds;
    }
}
