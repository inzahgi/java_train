package com.iflytek.fwpt.model.dqjc;

import java.io.Serializable;
import java.util.Date;

/**
 * t_police_substation_info
 * @author 
 */
public class PoliceSubstationInfo implements Serializable {
    private Integer id;

    /**
     * 派出所名称
     */
    private String pcsname;

    /**
     * 派出所编码
     */
    private String pcscode;

    /**
     * 行政区编码
     */
    private String areacode;

    private Double lng;

    private Double lat;

    private Date updatetime;

    /**
     * 区域边界点
     */
    private String region;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPcsname() {
        return pcsname;
    }

    public void setPcsname(String pcsname) {
        this.pcsname = pcsname;
    }

    public String getPcscode() {
        return pcscode;
    }

    public void setPcscode(String pcscode) {
        this.pcscode = pcscode;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "PoliceSubstationInfo{" +
                "id=" + id +
                ", pcsname='" + pcsname + '\'' +
                ", pcscode='" + pcscode + '\'' +
                ", areacode='" + areacode + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", updatetime=" + updatetime +
                ", region='" + region + '\'' +
                '}';
    }
}