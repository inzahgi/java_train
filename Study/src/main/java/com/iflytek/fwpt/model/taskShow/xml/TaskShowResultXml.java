/*
 * 文件名：TaskShowResultXml.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月3日
 */

package com.iflytek.fwpt.model.taskShow.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * 预警任务结果xml对象
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月3日
 */
@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "result")
public class TaskShowResultXml implements Serializable
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
     * 事件类型<br>
     */
    @XmlElement(name = "event")
    private String event;

    /**
     * 基站信息<br>
     */
    @XmlElement(name = "location")
    private String location;

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
     * 联系区号<br>
     */
    @XmlElement(name = "relatehome ")
    private String relateHome;

    /**
     * 联系帐号<br>
     */
    @XmlElement(name = "relateaccount")
    private String relateAccount;

    /**
     * YMGDQTL预警-relatelocation标签<br>
     */
    @XmlElement(name = "relatelocation")
    private RelateLocationXml relateLocationObj;

    /**
     * members标签对象<br>
     */
    @XmlElementWrapper(name="members") 
    @XmlElement(name = "member")
    private List<MemberXml> memberObj;

    /**
     * location标签对象<br>
     */
    @XmlElement(name = "location")
    private LocationXml locationObj;

    /**
     * 聚集半径<br>
     */
    @XmlElement(name = "gatherradius")
    private String gatherradius;

    /**
     * 预警时间<br>
     */
    @XmlElement(name = "warningtime")
    private String warningtime;

    /**
     * 消失人数<br>
     */
    @XmlElement(name = "membernum")
    private String memberNum;

    /**
     * 聚集区域ID<br>
     */
    @XmlElement(name = "areaid")
    private String areaId;

    /**
     * 聚集人数<br>
     */
    @XmlElement(name = "gathernum")
    private String gatherNum;

    /**
     * 旧的imsi<br>
     */
    @XmlElement(name = "oldimsi")
    private String oldimsi;

    /**
     * 旧的imei<br>
     */
    @XmlElement(name = "oldimei")
    private String oldimei;

    /**
     * 旧的msisdn<br>
     */
    @XmlElement(name = "oldmsisdn")
    private String oldmsisdn;

    /**
     * 新的imsi<br>
     */
    @XmlElement(name = "newimsi")
    private String newimsi;

    /**
     * 新的imei<br>
     */
    @XmlElement(name = "newimei")
    private String newimei;

    /**
     * 新的msisdn<br>
     */
    @XmlElement(name = "newmsisdn")
    private String newmsisdn;

    /**
     * 中标账号信息<br>
     */
    @XmlElement(name = "accountinfo")
    private String accountinfo;

    /**
     * 中标账号状态，10在核心区域，20在缓冲区域，30离开核心区域，40离开缓冲区域，50不在区域，60失联，0未知<br>
     */
    @XmlElement(name = "status")
    private String status;

    /**
     * 中标账号在区域的滞留时间<br>
     */
    @XmlElement(name = "staytime")
    private String staytime;

    /**
     * 捕获中标账号的时间<br>
     */
    @XmlElement(name = "capturetime")
    private String capturetime;

    /**
     * 上一位置的基站信息<br>
     */
    @XmlElement(name = "oldCgi")
    private String oldCgi;

    /**
     * 目标行为（arrive/leave）<br>
     */
    @XmlElement(name = "action")
    private String action;

    /**
     * 区域类型（area/city）<br>
     */
    @XmlElement(name = "areatype")
    private String areatype;

    /**
     * 区域类型为area时为空，为city时则为布控中的areacode<br>
     */
    @XmlElement(name = "areacode")
    private String areaCode;

    /**
     * 离开类型(默认为0-正常离开，暂未使用)<br>
     */
    @XmlElement(name = "leavetype")
    private String leaveType;

    /**
     * 上一位置的基站信息<br>
     */
    @XmlElement(name = "lastlocation")
    private LastLocationXml lastLocationObj;

    /**
     * 上一位置的基站信息<br>
     */
    @XmlElement(name = "last_location")
    private LastLocationLJYJXml lastLocationLJYJObj;

    /**
     * 通联号码<br>
     */
    @XmlElement(name = "receiver")
    private String receiver;

    /**
     * 基站信息<br>
     */
    @XmlElement(name = "cgi")
    private String cgi;

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
     * 自定义预警查询表名<br>
     */
    @XmlElement(name = "tbname")
    private String tbName;

    /**
     * 自定义预警查询表名<br>
     */
    @XmlElement(name = "category")
    private String category;

    /**
     * 自定义预警-hzcontent标签<br>
     */
    @XmlElementWrapper(name="hzcontent") 
    @XmlElement(name = "column")
    private List<ColumnXml> hzContent;

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

    public String getEvent()
    {
        return event;
    }

    public void setEvent(String event)
    {
        this.event = event;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
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

    public RelateLocationXml getRelateLocationObj()
    {
        return relateLocationObj;
    }

    public void setRelateLocationObj(RelateLocationXml relateLocationObj)
    {
        this.relateLocationObj = relateLocationObj;
    }

    public List<MemberXml> getMemberObj()
    {
        return memberObj;
    }

    public void setMemberObj(List<MemberXml> memberObj)
    {
        this.memberObj = memberObj;
    }

    public LocationXml getLocationObj()
    {
        return locationObj;
    }

    public void setLocationObj(LocationXml locationObj)
    {
        this.locationObj = locationObj;
    }

    public String getGatherradius()
    {
        return gatherradius;
    }

    public void setGatherradius(String gatherradius)
    {
        this.gatherradius = gatherradius;
    }

    public String getWarningtime()
    {
        return warningtime;
    }

    public void setWarningtime(String warningtime)
    {
        this.warningtime = warningtime;
    }

    public String getMemberNum()
    {
        return memberNum;
    }

    public void setMemberNum(String memberNum)
    {
        this.memberNum = memberNum;
    }

    public String getGatherNum()
    {
        return gatherNum;
    }

    public void setGatherNum(String gatherNum)
    {
        this.gatherNum = gatherNum;
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

    public String getAccountinfo()
    {
        return accountinfo;
    }

    public void setAccountinfo(String accountinfo)
    {
        this.accountinfo = accountinfo;
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

    public String getCapturetime()
    {
        return capturetime;
    }

    public void setCapturetime(String capturetime)
    {
        this.capturetime = capturetime;
    }

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getOldCgi()
    {
        return oldCgi;
    }

    public void setOldCgi(String oldCgi)
    {
        this.oldCgi = oldCgi;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getAreatype()
    {
        return areatype;
    }

    public void setAreatype(String areatype)
    {
        this.areatype = areatype;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getLeaveType()
    {
        return leaveType;
    }

    public void setLeaveType(String leaveType)
    {
        this.leaveType = leaveType;
    }

    public LastLocationXml getLastLocationObj()
    {
        return lastLocationObj;
    }

    public void setLastLocationObj(LastLocationXml lastLocationObj)
    {
        this.lastLocationObj = lastLocationObj;
    }

    public LastLocationLJYJXml getLastLocationLJYJObj()
    {
        return lastLocationLJYJObj;
    }

    public void setLastLocationLJYJObj(LastLocationLJYJXml lastLocationLJYJObj)
    {
        this.lastLocationLJYJObj = lastLocationLJYJObj;
    }

    public String getReceiver()
    {
        return receiver;
    }

    public void setReceiver(String receiver)
    {
        this.receiver = receiver;
    }

    public String getCgi()
    {
        return cgi;
    }

    public void setCgi(String cgi)
    {
        this.cgi = cgi;
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

    public String getTbName()
    {
        return tbName;
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

    public List<ColumnXml> getHzContent()
    {
        return hzContent;
    }

    public void setHzContent(List<ColumnXml> hzContent)
    {
        this.hzContent = hzContent;
    }
}
