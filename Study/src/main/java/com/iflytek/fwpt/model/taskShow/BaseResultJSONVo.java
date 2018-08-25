/*
 * 文件名：BaseResultJSONVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月7日
 */

package com.iflytek.fwpt.model.taskShow;

import java.util.Date;

/**
 * 16中预警规则JSON格式Bean
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月7日
 */
public class BaseResultJSONVo
{

    /**
     * 账号类型<br>
     */
    private String accType;
    
    /**
     * 账号<br>
     */
    private String account;
    
    /**
     * 身份证号<br>
     */
    private String idCard;
    
    /**
     * 群组名<br>
     */
    private String groupName;
    
    /**
     * 监控人员姓名<br>
     */
    private String name;
    
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
     * 事件类型<br>
     */
    private String event;
    
    /**
     * 上次出现区域<br>
     */
    private String lastArea;
    
    /**
     * 上次出现时间<br>
     */
    private Date lastTime;
    
    /**
     * 联系区号<br>
     */
    private String relateHome;
    
    /**
     * 联系账号<br>
     */
    private String relateAccount;
    
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
    
    /**
     * 消失人数<br>
     */
    private String membernum;
    
    /**
     * 聚集人数<br>
     */
    private String gathernum;
    
    /**
     * 聚集区域ID<br>
     */
    private String areaId;
    
    /**
     * 旧imsi<br>
     */
    private String oldimsi;
    
    /**
     * 旧imei<br>
     */
    private String oldimei;
    
    /**
     * 旧msisdn<br>
     */
    private String oldmsisdn;
    
    /**
     * 新imsi<br>
     */
    private String newimsi;
    
    /**
     * 新imei<br>
     */
    private String newimei;
    
    /**
     * 新msisdn<br>
     */
    private String newmsisdn;
    
    /**
     * 账号状态10在核心区域，20在缓冲区域，30离开核心区域，40离开缓冲区域，50不在区域，60失联，0未知<br>
     */
    private String status;
    
    /**
     * 进入重点区域滞留时间<br>
     */
    private String staytime;
    
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
     * 通联号码<br>
     */
    private String receiver;
    
    /**
     * 自定义预警结果表列名<br>
     */
    private String zdyName;
    
    /**
     * 自定义预警结果表列的值<br>
     */
    private String zdyValue;
    
    /**
     * 表名<br>
     */
    private String tbName;
    
    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private String category;

    public String getTbName()
    {
        return tbName;
    }

    public String getIdCard()
    {
        return idCard;
    }

    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setTbName(String tbName)
    {
        this.tbName = tbName;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
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

    public String getReceiver()
    {
        return receiver;
    }

    public void setReceiver(String receiver)
    {
        this.receiver = receiver;
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

    public Date getOldLastTime()
    {
        return oldLastTime;
    }

    public void setOldLastTime(Date oldLastTime)
    {
        this.oldLastTime = oldLastTime;
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

    public String getEvent()
    {
        return event;
    }

    public void setEvent(String event)
    {
        this.event = event;
    }

    public String getLastArea()
    {
        return lastArea;
    }

    public void setLastArea(String lastArea)
    {
        this.lastArea = lastArea;
    }

    public Date getLastTime()
    {
        return lastTime;
    }

    public void setLastTime(Date lastTime)
    {
        this.lastTime = lastTime;
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

    public String getRelateHome()
    {
        return relateHome;
    }

    public void setRelateHome(String relateHome)
    {
        this.relateHome = relateHome;
    }

    public String getRelateAccount()
    {
        return relateAccount;
    }

    public void setRelateAccount(String relateAccount)
    {
        this.relateAccount = relateAccount;
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

    public String getMembernum()
    {
        return membernum;
    }

    public void setMembernum(String membernum)
    {
        this.membernum = membernum;
    }

    public String getGathernum()
    {
        return gathernum;
    }

    public void setGathernum(String gathernum)
    {
        this.gathernum = gathernum;
    }

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getOldimsi()
    {
        return oldimsi;
    }

    public void setOldimsi(String oldimsi)
    {
        this.oldimsi = oldimsi;
    }

    public String getOldimei()
    {
        return oldimei;
    }

    public void setOldimei(String oldimei)
    {
        this.oldimei = oldimei;
    }

    public String getOldmsisdn()
    {
        return oldmsisdn;
    }

    public void setOldmsisdn(String oldmsisdn)
    {
        this.oldmsisdn = oldmsisdn;
    }

    public String getNewimsi()
    {
        return newimsi;
    }

    public void setNewimsi(String newimsi)
    {
        this.newimsi = newimsi;
    }

    public String getNewimei()
    {
        return newimei;
    }

    public void setNewimei(String newimei)
    {
        this.newimei = newimei;
    }

    public String getNewmsisdn()
    {
        return newmsisdn;
    }

    public void setNewmsisdn(String newmsisdn)
    {
        this.newmsisdn = newmsisdn;
    }
}
