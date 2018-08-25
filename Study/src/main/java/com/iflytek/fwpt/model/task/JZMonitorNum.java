/*
 * 文件名：JZMonitorNum.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年7月4日
 */

package com.iflytek.fwpt.model.task;

/**
 * jz号码库对象，主要存放是否jz已经布控的号码
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年7月4日
 */
public class JZMonitorNum
{

    /**
     * 类型-电话号码、车牌号、身份证号等<br>
     */
    private String idType;
    
    /**
     * 号码<br>
     */
    private String idNum;

    public String getIdType()
    {
        return idType;
    }

    public void setIdType(String idType)
    {
        this.idType = idType;
    }

    public String getIdNum()
    {
        return idNum;
    }

    public void setIdNum(String idNum)
    {
        this.idNum = idNum;
    }
}
