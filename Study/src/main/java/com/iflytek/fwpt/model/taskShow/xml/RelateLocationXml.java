/*
 * 文件名：RelateLocation.java
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
 * YMGDQTL预警-relatelocation标签
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月3日
 */
@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "relatelocation")
public class RelateLocationXml implements Serializable
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 基站<br>
     */
    @XmlElement(name = "location")
    private String location;

    /**
     * 联系时间<br>
     */
    @XmlElement(name = "capturetime")
    private String captureTime;
    
    /**
     * 经度<br>
     */
    @XmlElement(name = "longitude")
    private String longitude;
    
    /**
     * 纬度<br>
     */
    @XmlElement(name = "latitude")
    private String latitude;

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getCaptureTime()
    {
        return captureTime;
    }

    public void setCaptureTime(String captureTime)
    {
        this.captureTime = captureTime;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
}
