/*
 * 文件名：BaseResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

import java.util.Date;

/**
 * 预警任务展示通用属性表
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class BaseResultVo
{

    /**
     * tbl_location_result表唯一标识符<br>
     */
    private String baseId;
    
    /**
     * 预警任务ID<br>
     */
    private String ruleId;

    /**
     * 任务类型<br>
     */
    private String taskType;
    
    /**
     * 账号类型<br>
     */
    private String accType;
    
    /**
     * 账号<br>
     */
    private String account;
    
    /**
     * 基站信息<br>
     */
    private String location;
    
    /**
     * 经度<br>
     */
    private String lon;
    
    /**
     * 纬度<br>
     */
    private String lat;
    
    /**
     * 出现时间<br>
     */
    private Date time;
    
    /**
     * 出现区域<br>
     */
    private String area;

    /**
     * 创建时间<br>
     */
    private Date createTime;
    
    /**
     * 自定义预警结果表列名<br>
     */
    private String zdyName;
    
    /**
     * 自定义预警结果表列的值<br>
     */
    private String zdyValue;
    
    /**
     * 消息是否已读（0-未读，1-已读）<br>
     */
    private String isReaded;
    
    /**
     * 预警时间<br>
     */
    private Date warningTime;
    
    /**
     * 用户账号json格式信息<br>
     */
    private String accountJSON;
    
    /**
     * 自定义预警column标签json格式信息<br>
     */
    private String columnsJSON;
    
    /**
     * 中心点经度<br>
     */
    private String centLon;
    
    /**
     * 中心点纬度<br>
     */
    private String centLat;
    
    /**
     * 聚集半径<br>
     */
    private String gatherradius;

    public String getRuleId()
    {
        return ruleId;
    }

    public void setRuleId(String ruleId)
    {
        this.ruleId = ruleId;
    }

    public String getTaskType()
    {
        return taskType;
    }

    public void setTaskType(String taskType)
    {
        this.taskType = taskType;
    }

    public String getAccType()
    {
        return accType;
    }

    public void setAccType(String accType)
    {
        this.accType = accType;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
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

    public String getZdyName()
    {
        return zdyName;
    }

    public void setZdyName(String zdyName)
    {
        this.zdyName = zdyName;
    }

    public String getZdyValue()
    {
        return zdyValue;
    }

    public void setZdyValue(String zdyValue)
    {
        this.zdyValue = zdyValue;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getBaseId()
    {
        return baseId;
    }

    public void setBaseId(String baseId)
    {
        this.baseId = baseId;
    }

    public String getIsReaded()
    {
        return isReaded;
    }

    public void setIsReaded(String isReaded)
    {
        this.isReaded = isReaded;
    }

    public String getAccountJSON()
    {
        return accountJSON;
    }

    public void setAccountJSON(String accountJSON)
    {
        this.accountJSON = accountJSON;
    }

    public Date getWarningTime()
    {
        return warningTime;
    }

    public void setWarningTime(Date warningTime)
    {
        this.warningTime = warningTime;
    }

    public String getCentLon()
    {
        return centLon;
    }

    public void setCentLon(String centLon)
    {
        this.centLon = centLon;
    }

    public String getCentLat()
    {
        return centLat;
    }

    public void setCentLat(String centLat)
    {
        this.centLat = centLat;
    }

    public String getGatherradius()
    {
        return gatherradius;
    }

    public void setGatherradius(String gatherradius)
    {
        this.gatherradius = gatherradius;
    }

    public String getColumnsJSON()
    {
        return columnsJSON;
    }

    public void setColumnsJSON(String columnsJSON)
    {
        this.columnsJSON = columnsJSON;
    }
}
