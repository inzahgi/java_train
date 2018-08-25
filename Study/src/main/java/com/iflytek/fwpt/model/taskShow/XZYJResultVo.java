/*
 * 文件名：XZYJResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

import java.util.Date;

/**
 * 闲置预警结果表
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class XZYJResultVo extends BaseResultVo
{

    /**
     * 唯一标识符<br>
     */
    private String id;

    /**
     * 上次出现时间<br>
     */
    private Date lastTime;

    /**
     * 上次出现基站信息<br>
     */
    private String lastLocation;

    /**
     * 上次出现区域<br>
     */
    private String lastArea;

    public Date getLastTime()
    {
        return lastTime;
    }

    public void setLastTime(Date lastTime)
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

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
