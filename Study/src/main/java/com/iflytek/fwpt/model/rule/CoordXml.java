package com.iflytek.fwpt.model.rule;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "coord")
public class CoordXml implements Serializable
{
    
        /**
        * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
        */
        
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "lon")
    private String lon;

    @XmlElement(name = "lat")
    private String lat;

    public String getLon()
    {
        return lon;
    }

    public void setLon(String lon)
    {
        this.lon = lon;
    }

    public String getLat()
    {
        return lat;
    }

    public void setLat(String lat)
    {
        this.lat = lat;
    }

}
