package com.iflytek.fwpt.model.dqjc;


public class DW {

    private String id;
    private Double lng;
    private Double lat;
    private String lac;
    private String ci;
    private String area;
    private String areaId;
    private String flag;
    private Integer isZk;
    private Integer isGy;
    private Integer isYx;
    private String pName;
    private Long createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * @return the isZk
     */
    public Integer getIsZk() {
        return isZk;
    }

    /**
     * @param isZk the isZk to set
     */
    public void setIsZk(Integer isZk) {
        this.isZk = isZk;
    }


    public Integer getIsGy() {
        return isGy;
    }


    public void setIsGy(Integer isGy) {
        this.isGy = isGy;
    }


    public Integer getIsYx() {
        return isYx;
    }


    public void setIsYx(Integer isYx) {
        this.isYx = isYx;
    }


    public String getpName() {
        return pName;
    }


    public void setpName(String pName) {
        this.pName = pName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

}
