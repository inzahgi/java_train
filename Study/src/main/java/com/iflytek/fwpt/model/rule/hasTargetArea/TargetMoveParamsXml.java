package com.iflytek.fwpt.model.rule.hasTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:10:29
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class TargetMoveParamsXml {

    @XmlElement(name = "citymovetime")
    private String citymovetime = "7200";

    @XmlElement(name = "provincemovetime")
    private String provincemovetime = "7200";


    public String getCitymovetime() {
        return citymovetime;
    }

    public void setCitymovetime(String citymovetime) {
        this.citymovetime = citymovetime;
    }

    public String getProvincemovetime() {
        return provincemovetime;
    }

    public void setProvincemovetime(String provincemovetime) {
        this.provincemovetime = provincemovetime;
    }
}
