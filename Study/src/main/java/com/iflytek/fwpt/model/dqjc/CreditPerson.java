package com.iflytek.fwpt.model.dqjc;

import java.util.Date;

public class CreditPerson extends CreditScore {
    private String name;

    private String areaId;

    private String areaName;

    private String policeSubStationId;

    private String policeSubStationName;

    private Integer isGy;

    private Integer isYx;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPoliceSubStationId() {
        return policeSubStationId;
    }

    public void setPoliceSubStationId(String policeSubStationId) {
        this.policeSubStationId = policeSubStationId;
    }

    public String getPoliceSubStationName() {
        return policeSubStationName;
    }

    public void setPoliceSubStationName(String policeSubStationName) {
        this.policeSubStationName = policeSubStationName;
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


    public static final class CreditPersonBuilder {
        private CreditPerson creditPerson;

        private CreditPersonBuilder() {
            creditPerson = new CreditPerson();
        }

        public static CreditPersonBuilder aCreditPerson() {
            return new CreditPersonBuilder();
        }

        public CreditPersonBuilder name(String name) {
            creditPerson.setName(name);
            return this;
        }

        public CreditPersonBuilder areaId(String areaId) {
            creditPerson.setAreaId(areaId);
            return this;
        }

        public CreditPersonBuilder id(Integer id) {
            creditPerson.setId(id);
            return this;
        }

        public CreditPersonBuilder areaName(String areaName) {
            creditPerson.setAreaName(areaName);
            return this;
        }

        public CreditPersonBuilder policeSubStationId(String policeSubStationId) {
            creditPerson.setPoliceSubStationId(policeSubStationId);
            return this;
        }

        public CreditPersonBuilder idCard(String idCard) {
            creditPerson.setIdCard(idCard);
            return this;
        }

        public CreditPersonBuilder policeSubStationName(String policeSubStationName) {
            creditPerson.setPoliceSubStationName(policeSubStationName);
            return this;
        }

        public CreditPersonBuilder phone(String phone) {
            creditPerson.setPhone(phone);
            return this;
        }

        public CreditPersonBuilder isGy(Integer isGy) {
            creditPerson.setIsGy(isGy);
            return this;
        }

        public CreditPersonBuilder isYx(Integer isYx) {
            creditPerson.setIsYx(isYx);
            return this;
        }

        public CreditPersonBuilder level(Integer level) {
            creditPerson.setLevel(level);
            return this;
        }

        public CreditPersonBuilder score(Integer score) {
            creditPerson.setScore(score);
            return this;
        }

        public CreditPersonBuilder status(Integer status) {
            creditPerson.setStatus(status);
            return this;
        }

        public CreditPersonBuilder createtime(Date createtime) {
            creditPerson.setCreatetime(createtime);
            return this;
        }

        public CreditPerson build() {
            return creditPerson;
        }
    }
}
