/*
 * 文件名：MemberXml.java
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
 * members-member标签
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月3日
 */
@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "member")
public class MemberXml implements Serializable
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 账号类型<br>
     */
    @XmlElement(name = "accounttype")
    private String accountType;

    /**
     * 账号<br>
     */
    @XmlElement(name = "account")
    private String account;

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

    /**
     * 基站信息<br>
     */
    @XmlElement(name = "location")
    private String location;
    
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
    
    /**
     * 上次出现时间<br>
     */
    @XmlElement(name = "lasttime")
    private String lastTime;
    
    /**
     * 上次出现位置CGI(基站信息)<br>
     */
    @XmlElement(name = "lastlocation")
    private String lastLocation;
    
    /**
     * 上次出现区域<br>
     */
    @XmlElement(name = "lastarea")
    private String lastArea;
    
    /**
     * 基站信息<br>
     */
    @XmlElement(name = "cgi")
    private String cgi;

    public String getAccountType()
    {
        return accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

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

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
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

    public String getLastTime()
    {
        return lastTime;
    }

    public void setLastTime(String lastTime)
    {
        this.lastTime = lastTime;
    }

    public String getLastLocation()
    {
        return lastLocation;
    }

    public void setLastLocation(String lastLocation)
    {
        this.lastLocation = lastLocation;
    }

    public String getLastArea()
    {
        return lastArea;
    }

    public void setLastArea(String lastArea)
    {
        this.lastArea = lastArea;
    }

    public String getCgi()
    {
        return cgi;
    }

    public void setCgi(String cgi)
    {
        this.cgi = cgi;
    }
}
