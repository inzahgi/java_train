package com.iflytek.fwpt.model.rule.header;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "communication")
public class CommunicationXml implements Serializable
{
    
        /**
        * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
        */
        
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "sponsorcity")
    private String sponsorCity;

    @XmlElement(name = "sponsorip")
    private String sponsorip;

    @XmlElement(name = "cities")
    private String cities;

    public String getSponsorCity()
    {
        return sponsorCity;
    }

    public void setSponsorCity(String sponsorCity)
    {
        this.sponsorCity = sponsorCity;
    }

    public String getSponsorip()
    {
        return sponsorip;
    }

    public void setSponsorip(String sponsorip)
    {
        this.sponsorip = sponsorip;
    }

    public String getCities()
    {
        return cities;
    }

    public void setCities(String cities)
    {
        this.cities = cities;
    }

}
