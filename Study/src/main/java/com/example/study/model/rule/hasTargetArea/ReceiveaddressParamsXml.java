package com.example.study.model.rule.hasTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:9:58
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "receiveaddress")
public class ReceiveaddressParamsXml {

    @XmlElement(name = "address")
    private AddressXml addressXml;

    public ReceiveaddressParamsXml(AddressXml addressXml) {
        this.addressXml = addressXml;
    }

    public ReceiveaddressParamsXml() {
    }

    public AddressXml getAddressXml() {
        return addressXml;
    }

    public void setAddressXml(AddressXml addressXml) {
        this.addressXml = addressXml;
    }
}
