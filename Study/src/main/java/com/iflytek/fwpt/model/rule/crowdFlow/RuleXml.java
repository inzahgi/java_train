package com.iflytek.fwpt.model.rule.crowdFlow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/25
 * Time:10:58
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "rule")
public class RuleXml<T> {
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "params")
    private T params;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
