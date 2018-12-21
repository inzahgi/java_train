package com.iflytek.fwpt.model.rule.hasTargetArea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author:inzahgi
 * Date:2018/8/27
 * Time:10:14
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "params")
public class DistrictStatsParamsXml {
    @XmlElement(name = "districttype")
    private String districttype;

    @XmlElement(name = "districtids")
    private String districtids;

    @XmlElement(name = "statscycle")
    private String statcycle;


    public String getDistricttype() {
        return districttype;
    }

    public void setDistricttype(String districttype) {
        this.districttype = districttype;
    }

    public String getDistrictids() {
        return districtids;
    }

    public void setDistrictids(String districtids) {
        this.districtids = districtids;
    }

    public String getStatcycle() {
        return statcycle;
    }

    public void setStatcycle(String statcycle) {
        this.statcycle = statcycle;
    }
}
