package com.iflytek.fwpt.model.rule.noTargetArea;

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
@XmlRootElement(name = "appinfos")
public class AppinfosXml implements Serializable{
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "appinfo")
    private AppinfoXml appinfo;

    public AppinfoXml getAppinfo() {
        return appinfo;
    }

    public void setAppinfo(AppinfoXml appinfo) {
        this.appinfo = appinfo;
    }
}
