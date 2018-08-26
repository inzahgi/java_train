package com.iflytek.fwpt.model.rule.carNum;


import com.iflytek.fwpt.model.rule.MemberListXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "condition")
public class CarNumXml {
    @XmlElement(name = "members")
    private MemberListXml memberListXml;

    @XmlElement(name = "dynamicmembers")
    private
}
