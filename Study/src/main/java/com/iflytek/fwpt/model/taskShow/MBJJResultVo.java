/*
 * 文件名：MBJJResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

/**
 * 目标聚集预警结果表
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class MBJJResultVo extends BaseResultVo
{
    /**
     * 唯一标识符<br>
     */
    private String id;
    
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

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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
}
