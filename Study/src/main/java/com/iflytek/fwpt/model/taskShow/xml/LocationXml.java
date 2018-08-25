/*
 * 文件名：LocationXml.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月3日
 */

package com.iflytek.fwpt.model.taskShow.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * location标签
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月3日
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "location")
public class LocationXml implements Serializable
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 经度<br>
     */
    @XmlElement(name = "lon")
    private String lon;

    /**
     * 纬度<br>
     */
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
