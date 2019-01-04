package com.example.study.model.task;


/**
 * tbl_group_person
 * @author 
 */
public class NewGroupPersonEntity {
    private String id;

    /**
     * 群体id
     */
    private String gid;

    /**
     * 监测号码
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 车牌
     */
    private String carNum;

    /**
     * 号码状态1-使用0-废弃
     */
    private String status;

    public NewGroupPersonEntity() {
    }

    private NewGroupPersonEntity(Builder builder) {
        setId(builder.id);
        setGid(builder.gid);
        setPhone(builder.phone);
        setIdcard(builder.idcard);
        setCarNum(builder.carNum);
        setStatus(builder.status);
    }

    public interface STATUS{
        String STOP = "0";
        String USEING = "1";
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public static final class Builder {

        private String id;
        private String gid;
        private String phone;
        private String idcard;
        private String carNum;
        private String status;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder gid(String val) {
            gid = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder idcard(String val) {
            idcard = val;
            return this;
        }

        public Builder carNum(String val) {
            carNum = val;
            return this;
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public NewGroupPersonEntity build() {
            return new NewGroupPersonEntity(this);
        }
    }

    @Override
    public String toString() {
        return "NewGroupPersonEntity{" + "id='" + id + '\'' + ", gid='" + gid + '\'' + ", phone='" + phone + '\''
                + ", idcard='" + idcard + '\'' + ", carNum='" + carNum + '\'' + ", status='" + status + '\'' + '}';
    }
}