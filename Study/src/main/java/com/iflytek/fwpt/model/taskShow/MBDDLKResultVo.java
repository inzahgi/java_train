/*
 * 文件名：MBDDLKResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

import java.util.Date;

/**
 * 目标到达离开目的地预警结果表
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class MBDDLKResultVo extends BaseResultVo
{

    /**
     * 唯一标识符<br>
     */
    private String id;
    
    /**
     * 目标行为（到达/离开）<br>
     */
    private String action;
    
    /**
     * 区域类型(地区/城市)<br>
     */
    private String areaType;
    
    /**
     * 区域编码<br>
     */
    private String areaCode;
    
    /**
     * 布控目标最后中标的时间<br>
     */
    private Date lastTime;
    
    /**
     * 布控目标最后中标的时间<br>
     */
    private Date oldLastTime;
    
    /**
     * 布控目标最后中标的位置CGI<br>
     */
    private String lastLocation;
    
    /**
     * 离开类型(默认为0-正常离开，暂未使用)<br>
     */
    private String leaveType;
    
    /**
     * 老基站信息<br>
     */
    private String oldCgi;
    
    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private String oldNet;
    
    /**
     * 老经度<br>
     */
    private String oldLon;
    
    /**
     * 老纬度<br>
     */
    private String oldLat;
    
    /**
     * 老城市区号<br>
     */
    private String oldCurArea;
    
    /**
     * 老城市编码<br>
     */
    private String oldAreaCode;
    
    /**
     * 布控目标最后中标的areacode<br>
     */
    private String lastArea;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getAreaType()
    {
        return areaType;
    }

    public void setAreaType(String areaType)
    {
        this.areaType = areaType;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

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

    public String getLeaveType()
    {
        return leaveType;
    }

    public void setLeaveType(String leaveType)
    {
        this.leaveType = leaveType;
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

    public String getLastArea()
    {
        return lastArea;
    }

    public void setLastArea(String lastArea)
    {
        this.lastArea = lastArea;
    }

    public Date getOldLastTime()
    {
        return oldLastTime;
    }

    public void setOldLastTime(Date oldLastTime)
    {
        this.oldLastTime = oldLastTime;
    }
}
