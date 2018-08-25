/*
 * 文件名：JCZDQYResult.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

/**
 * 进入重点区域预警
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class JCZDQYResultVo extends BaseResultVo
{

    /**
     * 唯一标识符<br>
     */
    private String id;
    
    /**
     * 账号状态10在核心区域，20在缓冲区域，30离开核心区域，40离开缓冲区域，50不在区域，60失联，0未知<br>
     */
    private String status;
    
    /**
     * 进入重点区域滞留时间<br>
     */
    private String staytime;
    
    /**
     * 区域id<br>
     */
    private String areaId;
    
    /**
     * 上一位置信息<br>
     */
    private String oldLocation;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStaytime()
    {
        return staytime;
    }

    public void setStaytime(String staytime)
    {
        this.staytime = staytime;
    }

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getOldLocation()
    {
        return oldLocation;
    }

    public void setOldLocation(String oldLocation)
    {
        this.oldLocation = oldLocation;
    }
}
