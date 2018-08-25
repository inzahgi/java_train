/*
 * 文件名：Hzcontent.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月3日
 */

package com.iflytek.fwpt.model.taskShow.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 自定义预警-column标签
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月3日
 */
@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "column")
public class ColumnXml implements Serializable
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 表列名<br>
     */
    @XmlElement(name = "name")
    private String name;
    
    /**
     * 表列值<br>
     */
    @XmlElement(name = "value")
    private String value;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
