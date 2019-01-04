package com.example.study.model.rule.noTargetArea;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/24
 * Time:17:24
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "appinfo")
public class AppinfoXml implements Serializable{
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "category")
    private String category;

    @XmlElement(name = "productid")
    private String prodictIds;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProdictIds() {
        return prodictIds;
    }

    public void setProdictIds(String prodictIds) {
        this.prodictIds = prodictIds;
    }
}
