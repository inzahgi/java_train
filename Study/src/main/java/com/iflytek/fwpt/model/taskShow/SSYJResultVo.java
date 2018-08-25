/*
 * 文件名：SSYJResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

import java.util.Date;

/**
 * 实时预警业务结果表
 * lbsCapturetime如果和Capturetime时间接近那么用lbs相关经纬度
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class SSYJResultVo extends BaseResultVo
{
    /**
     * 唯一标识符<br>
     */
    private String id;
    
    /**
     * 速度<br>
     */
    private String speed;
    
    /**
     * lbs时间<br>
     */
    private Date lbsWarningTime;
    
    /**
     * lbs经度<br>
     */
    private String lbsLon;
    
    /**
     * lbs纬度<br>
     */
    private String lbsLat;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSpeed()
    {
        return speed;
    }

    public void setSpeed(String speed)
    {
        this.speed = speed;
    }

    public Date getLbsWarningTime()
    {
        return lbsWarningTime;
    }

    public void setLbsWarningTime(Date lbsWarningTime)
    {
        this.lbsWarningTime = lbsWarningTime;
    }

    public String getLbsLon()
    {
        return lbsLon;
    }

    public void setLbsLon(String lbsLon)
    {
        this.lbsLon = lbsLon;
    }

    public String getLbsLat()
    {
        return lbsLat;
    }

    public void setLbsLat(String lbsLat)
    {
        this.lbsLat = lbsLat;
    }
}
