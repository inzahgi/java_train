package com.iflytek.fwpt.model.rule.hasTargetArea;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:9:40
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "sendcity")
public class SendCityParamsXml {

    @XmlElement(name = "city")
    private List<CityXml> cityXmlList;


    public List<CityXml> getCityXmlList() {
        return cityXmlList;
    }

    public void setCityXmlList(List<CityXml> cityXmlList) {
        this.cityXmlList = cityXmlList;
    }
}
