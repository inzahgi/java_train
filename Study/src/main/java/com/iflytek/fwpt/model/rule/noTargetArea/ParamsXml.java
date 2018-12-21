package com.iflytek.fwpt.model.rule.noTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/25
 * Time:11:32
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class ParamsXml {
    @XmlElement(name = "updatecycle")
    private UpdateCycleXml updateCycleXml;

    @XmlElement(name = "unicom")
    private String unicom;

    @XmlElement(name = "telecom")
    private String telecom;




    public String getUnicom() {
        return unicom;
    }

    public void setUnicom(String unicom) {
        this.unicom = unicom;
    }

    public String getTelecom() {
        return telecom;
    }

    public void setTelecom(String telecom) {
        this.telecom = telecom;
    }
}
