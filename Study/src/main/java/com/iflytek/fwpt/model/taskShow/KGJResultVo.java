/*
 * 文件名：KGJResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

/**
 * 开关机预警结果表
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class KGJResultVo extends BaseResultVo
{

    /**
     * 唯一标识符<br>
     */
    private String id;
    
    /**
     * 事件类型<br>
     */
    private String event;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getEvent()
    {
        return event;
    }

    public void setEvent(String event)
    {
        this.event = event;
    }
}
