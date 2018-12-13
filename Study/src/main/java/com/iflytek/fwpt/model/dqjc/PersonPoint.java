package com.iflytek.fwpt.model.dqjc;

public class PersonPoint {
    private String name;

    private String phone;

    private int propertyFlag;

    private double lng;

    private double lat;

    private String stationId;

    public PersonPoint() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPropertyFlag() {
        return propertyFlag;
    }

    public void setPropertyFlag(int propertyFlag) {
        this.propertyFlag = propertyFlag;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }


    public static final class PersonPointBuilder {
        private PersonPoint personPoint;

        private PersonPointBuilder() {
            personPoint = new PersonPoint();
        }

        public static PersonPointBuilder aPersonPoint() {
            return new PersonPointBuilder();
        }

        public PersonPointBuilder name(String name) {
            personPoint.setName(name);
            return this;
        }

        public PersonPointBuilder phone(String phone) {
            personPoint.setPhone(phone);
            return this;
        }

        public PersonPointBuilder propertyFlag(int propertyFlag) {
            personPoint.setPropertyFlag(propertyFlag);
            return this;
        }

        public PersonPointBuilder lng(double lng) {
            personPoint.setLng(lng);
            return this;
        }

        public PersonPointBuilder lat(double lat) {
            personPoint.setLat(lat);
            return this;
        }

        public PersonPointBuilder stationId(String stationId) {
            personPoint.setStationId(stationId);
            return this;
        }

        public PersonPoint build() {
            return personPoint;
        }
    }
}
