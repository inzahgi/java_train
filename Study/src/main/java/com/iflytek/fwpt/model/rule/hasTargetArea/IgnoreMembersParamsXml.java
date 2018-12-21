package com.iflytek.fwpt.model.rule.hasTargetArea;

import com.iflytek.fwpt.model.rule.MemberXml;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:9:12
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class IgnoreMembersParamsXml {

    @XmlElement(name = "member")
    private MemberXml memberXml;

    public MemberXml getMemberXml() {
        return memberXml;
    }

    public void setMemberXml(MemberXml memberXml) {
        this.memberXml = memberXml;
    }
}
