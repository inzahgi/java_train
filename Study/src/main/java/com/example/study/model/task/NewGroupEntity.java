package com.example.study.model.task;

import java.util.Date;

/**
 * tbl_group
 * @author 
 */
public class NewGroupEntity {
    /**
     * 群体id
     */
    private String gid;

    /**
     * 群体名称
     */
    private String gname;

    private String tid;

    /**
     * 删除状态0-未删除、1-删除
     */
    private Integer isdel;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改时间
     */
    private Date upTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 备注
     */
    private String arg0;


    public interface IS_DEL{
        Integer NOT_DEL = 0;
        Integer DELETED = 1;
    }


    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getArg0() {
        return arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }
}