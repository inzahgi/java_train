/*
 * 文件名：DataSet.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月4日
 */

package com.iflytek.fwpt.model.taskShow.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 从消息体<datasets>中取出dataset标签
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月4日
 */
@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "datasets")
public class DataSets implements Serializable
{
    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = 1L;
    /**
     * 消息描述标签<br>
     */
    @XmlElement(name = "dataset")
    private DataSet dataset;

    public DataSet getDataset()
    {
        return dataset;
    }

    public void setDataset(DataSet dataset)
    {
        this.dataset = dataset;
    }
}