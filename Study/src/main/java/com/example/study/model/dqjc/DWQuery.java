package com.example.study.model.dqjc;


public class DWQuery {

    private String id;
    private Double lng;
    private Double lat;
    private String lac;
    private String ci;
    private String area;
    private String areaId;
    private String curAreaId;
    private String ownAreaId;
    private String curPcsId;//当前位置属于哪个派出所
    private String ownPcsId;
    private String level;
    private int score;
    private Integer isZk;
    private Integer isGy;
    private Integer isYx;
    private String pName;
    private String idcard;
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

    public String getCurAreaId() {
        return curAreaId;
    }

    public void setCurAreaId(String curAreaId) {
        this.curAreaId = curAreaId;
    }

    public String getOwnAreaId() {
        return ownAreaId;
    }

    public void setOwnAreaId(String ownAreaId) {
        this.ownAreaId = ownAreaId;
    }

    public String getCurPcsId() {
        return curPcsId;
    }

    public void setCurPcsId(String curPcsId) {
        this.curPcsId = curPcsId;
    }

    public String getOwnPcsId() {
        return ownPcsId;
    }

    public void setOwnPcsId(String ownPcsId) {
        this.ownPcsId = ownPcsId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Integer getIsZk() {
        return isZk;
    }

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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
