package com.example.study.model.rule.hasTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:9:14
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class SpecialAppsParamsXml {

    @XmlElement(name = "uavapp")
    private UavappXml uavappXml;

    @XmlElement(name = "validtime")
    private String Validtime;


    public UavappXml getUavappXml() {
        return uavappXml;
    }

    public void setUavappXml(UavappXml uavappXml) {
        this.uavappXml = uavappXml;
    }

    public String getValidtime() {
        return Validtime;
    }

    public void setValidtime(String validtime) {
        Validtime = validtime;
    }
}
