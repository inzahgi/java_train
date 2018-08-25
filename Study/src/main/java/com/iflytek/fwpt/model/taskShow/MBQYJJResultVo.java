/*
 * 文件名：MBQYJJResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

/**
 * 目标区域聚集预警
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class MBQYJJResultVo extends BaseResultVo
{

    /**
     * 唯一标识符<br>
     */
    private String id;
    
    /**
     * 聚集区域ID<br>
     */
    private String areaId;
    
    /**
     * 聚集人数<br>
     */
    private String gathernum;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getGathernum()
    {
        return gathernum;
    }

    public void setGathernum(String gathernum)
    {
        this.gathernum = gathernum;
    }
}
