package com.iflytek.fwpt.vo;

import java.util.Set;

public class StationVO {

    private Double lng;
    private Double lat;
    private String lac;
    private String ci;
    private String type;
    private Set<PhoneVO> phoneList;

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

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<PhoneVO> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(Set<PhoneVO> phoneList) {
        this.phoneList = phoneList;
    }

}
