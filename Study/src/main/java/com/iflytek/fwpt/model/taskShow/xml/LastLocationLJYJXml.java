/*
 * 文件名：LastLocation.java
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
 * last_location标签
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月3日
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "last_location")
public class LastLocationLJYJXml implements Serializable
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 区域编码<br>
     */
    @XmlElement(name = "oldAreaid")
    private String oldAreaId;
    
    /**
     * 上一个基站信息<br>
     */
    @XmlElement(name = "oldCgi")
    private String oldCgi ;
    
    /**
     * 上一位置经度<br>
     */
    @XmlElement(name = "oldlon")
    private String oldLon;
    
    /**
     * 上一位置纬度<br>
     */
    @XmlElement(name = "oldlat")
    private String oldLat;

    public String getOldAreaId()
    {
        return oldAreaId;
    }

    public void setOldAreaId(String oldAreaId)
    {
        this.oldAreaId = oldAreaId;
    }

    public String getOldCgi()
    {
        return oldCgi;
    }

    public void setOldCgi(String oldCgi)
    {
        this.oldCgi = oldCgi;
    }

    public String getOldLon()
    {
        return oldLon;
    }

    public void setOldLon(String oldLon)
    {
        this.oldLon = oldLon;
    }

    public String getOldLat()
    {
        return oldLat;
    }

    public void setOldLat(String oldLat)
    {
        this.oldLat = oldLat;
    }
}
