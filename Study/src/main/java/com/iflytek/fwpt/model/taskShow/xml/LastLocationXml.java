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
 * lastlocation标签
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月3日
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "lastlocation")
public class LastLocationXml implements Serializable
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 上一次到达离开时间<br>
     */
    @XmlElement(name = "lasttime")
    private String lastTime;
    
    /**
     * 上一个基站信息<br>
     */
    @XmlElement(name = "oldCgi")
    private String oldCgi;
    
    /**
     * 上一个net信息<br>
     */
    @XmlElement(name = "oldNet")
    private String oldNet;
    
    /**
     * 上一位置经度<br>
     */
    @XmlElement(name = "oldLon")
    private String oldLon;
    
    /**
     * 上一位置纬度<br>
     */
    @XmlElement(name = "oldLat")
    private String oldLat;
    
    /**
     * 上一位置区域<br>
     */
    @XmlElement(name = "oldCurArea")
    private String oldCurArea;
    
    /**
     * 上一位置区域编码<br>
     */
    @XmlElement(name = "oldareacode")
    private String oldAreaCode;

    public String getLastTime()
    {
        return lastTime;
    }

    public void setLastTime(String lastTime)
    {
        this.lastTime = lastTime;
    }

    public String getOldCgi()
    {
        return oldCgi;
    }

    public void setOldCgi(String oldCgi)
    {
        this.oldCgi = oldCgi;
    }

    public String getOldNet()
    {
        return oldNet;
    }

    public void setOldNet(String oldNet)
    {
        this.oldNet = oldNet;
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

    public String getOldCurArea()
    {
        return oldCurArea;
    }

    public void setOldCurArea(String oldCurArea)
    {
        this.oldCurArea = oldCurArea;
    }

    public String getOldAreaCode()
    {
        return oldAreaCode;
    }

    public void setOldAreaCode(String oldAreaCode)
    {
        this.oldAreaCode = oldAreaCode;
    }
}
