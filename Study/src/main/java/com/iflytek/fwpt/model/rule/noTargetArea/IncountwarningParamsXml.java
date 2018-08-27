package com.iflytek.fwpt.model.rule.noTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class IncountwarningParamsXml {
    @XmlElement(name = "incount")
    private String incount;

    public String getIncount() {
        return incount;
    }

    public void setIncount(String incount) {
        this.incount = incount;
    }
}
