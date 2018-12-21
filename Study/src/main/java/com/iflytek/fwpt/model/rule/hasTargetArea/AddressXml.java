package com.iflytek.fwpt.model.rule.hasTargetArea;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:9:59
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "address")
public class AddressXml {

    @XmlElement(name = "addr")
    private List<AddrXml> addrXmlList;


    public AddressXml() {
    }

    public AddressXml(List<AddrXml> addrXmlList) {
        this.addrXmlList = addrXmlList;
    }

    public List<AddrXml> getAddrXmlList() {
        return addrXmlList;
    }

    public void setAddrXmlList(List<AddrXml> addrXmlList) {
        this.addrXmlList = addrXmlList;
    }
}
