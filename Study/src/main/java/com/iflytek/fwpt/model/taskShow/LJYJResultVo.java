/*
 * 文件名：LJYJResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

/**
 * 离开区域预警
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class LJYJResultVo extends BaseResultVo
{
    /**
     * 唯一标识符<br>
     */
    private String id;
    
    /**
     * 目标号码上一个区域代码<br>
     */
    private String oldAreaId;
    
    /**
     * 上一个基站信息<br>
     */
    private String oldLocation;
    
    /**
     * 上一个经度<br>
     */
    private String oldLon;
    
    /**
     * 上一个纬度<br>
     */
    private String oldLat;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getOldAreaId()
    {
        return oldAreaId;
    }

    public void setOldAreaId(String oldAreaId)
    {
        this.oldAreaId = oldAreaId;
    }

    public String getOldLocation()
    {
        return oldLocation;
    }

    public void setOldLocation(String oldLocation)
    {
        this.oldLocation = oldLocation;
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
