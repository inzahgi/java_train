/*
 * 文件名：GKMBTLResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

/**
 * 管控目标通联预警结果表
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class GKMBTLResultVo extends BaseResultVo
{

    /**
     * 唯一标识符<br>
     */
    private String id;
    
    /**
     * 通联号码<br>
     */
    private String receiver;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getReceiver()
    {
        return receiver;
    }

    public void setReceiver(String receiver)
    {
        this.receiver = receiver;
    }

}
