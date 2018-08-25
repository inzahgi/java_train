/*
 * 文件名：HJHKResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

/**
 * 换机换卡预警结果表
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class HJHKResultVo extends BaseResultVo
{

    /**
     * 唯一标识符<br>
     */
    private String id;
    
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

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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
