package com.iflytek.fwpt.model.rule.hasTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:9:39
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class DeliveryParamsXml {

    @XmlElement(name = "sendcity")
    private SendCityParamsXml sendCityParamsXml;

    @XmlElement(name = "receiveaddress")
    private ReceiveaddressParamsXml receiveaddressParamsXml;

    @XmlElement(name = "validtime")
    private String validtime;


    public SendCityParamsXml getSendCityParamsXml() {
        return sendCityParamsXml;
    }

    public void setSendCityParamsXml(SendCityParamsXml sendCityParamsXml) {
        this.sendCityParamsXml = sendCityParamsXml;
    }

    public ReceiveaddressParamsXml getReceiveaddressParamsXml() {
        return receiveaddressParamsXml;
    }

    public void setReceiveaddressParamsXml(ReceiveaddressParamsXml receiveaddressParamsXml) {
        this.receiveaddressParamsXml = receiveaddressParamsXml;
    }

    public String getValidtime() {
        return validtime;
    }

    public void setValidtime(String validtime) {
        this.validtime = validtime;
    }
}
