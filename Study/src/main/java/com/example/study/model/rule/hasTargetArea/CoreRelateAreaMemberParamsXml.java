package com.example.study.model.rule.hasTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:9:19
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class CoreRelateAreaMemberParamsXml {

    @XmlElement(name = "relateareas")
    private String relateareas;

    @XmlElement(name = "areaid")
    private String areaid;

    @XmlElement(name = "validtime")
    private String validtime;


    public String getRelateareas() {
        return relateareas;
    }

    public void setRelateareas(String relateareas) {
        this.relateareas = relateareas;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getValidtime() {
        return validtime;
    }

    public void setValidtime(String validtime) {
        this.validtime = validtime;
    }
}
