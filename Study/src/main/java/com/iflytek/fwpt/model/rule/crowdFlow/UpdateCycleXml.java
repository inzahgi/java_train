package com.iflytek.fwpt.model.rule.crowdFlow;

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
@XmlRootElement(name = "updatecycle")
public class UpdateCycleXml {
    @XmlElement(name = "mobile")
    private String mobile;
    @XmlElement(name = "unicom")
    private String unicom;
    @XmlElement(name = "telecom")
    private String telecom;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

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
