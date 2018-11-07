package com.iflytek.fwpt.vo;


public class PhoneVO {

    private String phone;
    private String name;
    private Integer type;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return this.phone.hashCode() + this.type;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PhoneVO))
            return false;

        PhoneVO p = (PhoneVO) obj;

        return this.phone.equals(p.getPhone()) && this.type == p.getType();
    }
}
