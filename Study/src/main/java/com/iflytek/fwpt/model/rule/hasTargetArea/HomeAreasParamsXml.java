package com.iflytek.fwpt.model.rule.hasTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:9:01
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class HomeAreasParamsXml {
    @XmlElement(name = "homeareas")
    private String homeAreas;


    public String getHomeAreas() {
        return homeAreas;
    }

    public void setHomeAreas(String homeAreas) {
        this.homeAreas = homeAreas;
    }
}
