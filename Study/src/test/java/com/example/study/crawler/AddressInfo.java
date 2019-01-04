package com.example.study.crawler;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Objects;

public class AddressInfo {

    private String id;

    private String title;

    private String address;

    private String tel;

    private String category;

    private String type;

    @JSONField(name = "location")
    private Location location;

    @JSONField(name = "ad_info")
    private AdInfo adInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AdInfo getAdInfo() {
        return adInfo;
    }

    public void setAdInfo(AdInfo adInfo) {
        this.adInfo = adInfo;
    }

    public static class Location{
        private double lat;

        private double lng;

        public void setLat(double lat) {
            this.lat = lat;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public double getLng() {
            return lng;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "lat=" + lat +
                    ", lng=" + lng +
                    '}';
        }
    }

    public static class AdInfo{
        private String  adcode;

        private String province;

        private String city;

        private String district;

        public String getAdcode() {
            return adcode;
        }

        public void setAdcode(String adcode) {
            this.adcode = adcode;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        @Override
        public String toString() {
            return "AdInfo{" +
                    "adcode='" + adcode + '\'' +
                    ", province='" + province + '\'' +
                    ", city='" + city + '\'' +
                    ", district='" + district + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", location=" + location +
                ", adInfo=" + adInfo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressInfo that = (AddressInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, address);
    }
}
