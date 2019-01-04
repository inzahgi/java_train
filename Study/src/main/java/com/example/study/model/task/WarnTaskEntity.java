package com.example.study.model.task;

import java.util.Date;

/**
 * tbl_warn_task
 * @author 
 */
public class WarnTaskEntity  {
    /**
     * 预警ID
     */
    private String tid;

    /**
     * 预警类型ID
     */
    private String warnTypeId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务开始时间
     */
    private Date startTime;

    /**
     * 任务结束时间
     */
    private Date endTime;

    /**
     * 任务状态0未提交1未开始2执行中3已完成4已撤销
     */
    private Integer taskStatus;

    /**
     * 是否实时监控
     */
    private Integer isRealTimeWarn;

    /**
     * 是否消息预警
     */
    private Integer isMessageWarn;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date upTime;

    /**
     * 删除状态0-未删除、1-删除
     */
    private Integer isDel;

    public WarnTaskEntity() {

    }

    public WarnTaskEntity(WarnTaskEntity target) {
        this.tid = target.tid;
        this.warnTypeId = target.warnTypeId;
        this.taskName = target.taskName;
        this.startTime = target.startTime;
        this.endTime = target.endTime;
        this.taskStatus = target.taskStatus;
        this.isRealTimeWarn = target.isRealTimeWarn;
        this.isMessageWarn = target.isMessageWarn;
        this.createUser = target.createUser;
        this.createTime = target.createTime;
        this.upTime = target.upTime;
        this.isDel = target.isDel;
    }

    public static class Builder{
        private WarnTaskEntity entity;

        public Builder() {
            this.entity = new WarnTaskEntity();
        }

        public Builder tid(String tid){
            entity.tid = tid;
            return this;
        }

        public Builder warnTypeId(String warnTypeId){
            entity.warnTypeId = warnTypeId;
            return this;
        }

        public Builder taskName(String taskName){
            entity.taskName = taskName;
            return this;
        }

        public Builder startTime(Date startTime){
            entity.startTime = startTime;
            return this;
        }

        public Builder endTime(Date endTime){
            entity.endTime = endTime;
            return this;
        }

        public Builder taskStatus(Integer taskStatus){
            entity.taskStatus = taskStatus;
            return this;
        }

        public Builder isRealTimeWarn(Integer isRealTimeWarn){
            entity.isRealTimeWarn = isRealTimeWarn;
            return this;
        }

        public Builder isMessageWarn(Integer isMessageWarn){
            entity.isMessageWarn = isMessageWarn;
            return this;
        }

        public Builder createUser(String createUser){
            entity.createUser = createUser;
            return this;
        }

        public Builder createTime(Date createTime){
            entity.createTime = createTime;
            return this;
        }

        public Builder upTime(Date upTime){
            entity.upTime = upTime;
            return this;
        }

        public Builder isDel(Integer isDel){
            entity.isDel = isDel;
            return this;
        }


        public WarnTaskEntity build() {
            return entity;
        }
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getWarnTypeId() {
        return warnTypeId;
    }

    public void setWarnTypeId(String warnTypeId) {
        this.warnTypeId = warnTypeId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getisRealTimeWarn() {
        return isRealTimeWarn;
    }

    public void setisRealTimeWarn(Integer isRealTimeWarn) {
        this.isRealTimeWarn = isRealTimeWarn;
    }

    public Integer getIsMessageWarn() {
        return isMessageWarn;
    }

    public void setIsMessageWarn(Integer isMessageWarn) {
        this.isMessageWarn = isMessageWarn;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WarnTaskEntity other = (WarnTaskEntity) that;
        return (this.getTid() == null ? other.getTid() == null : this.getTid().equals(other.getTid()))
            && (this.getWarnTypeId() == null ? other.getWarnTypeId() == null : this.getWarnTypeId().equals(other.getWarnTypeId()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getTaskStatus() == null ? other.getTaskStatus() == null : this.getTaskStatus().equals(other.getTaskStatus()))
            && (this.getisRealTimeWarn() == null ? other.getisRealTimeWarn() == null : this.getisRealTimeWarn().equals(other.getisRealTimeWarn()))
            && (this.getIsMessageWarn() == null ? other.getIsMessageWarn() == null : this.getIsMessageWarn().equals(other.getIsMessageWarn()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpTime() == null ? other.getUpTime() == null : this.getUpTime().equals(other.getUpTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTid() == null) ? 0 : getTid().hashCode());
        result = prime * result + ((getWarnTypeId() == null) ? 0 : getWarnTypeId().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getTaskStatus() == null) ? 0 : getTaskStatus().hashCode());
        result = prime * result + ((getisRealTimeWarn() == null) ? 0 : getisRealTimeWarn().hashCode());
        result = prime * result + ((getIsMessageWarn() == null) ? 0 : getIsMessageWarn().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpTime() == null) ? 0 : getUpTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", warnTypeId=").append(warnTypeId);
        sb.append(", taskName=").append(taskName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", isRealTimeWarn=").append(isRealTimeWarn);
        sb.append(", isMessageWarn=").append(isMessageWarn);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", upTime=").append(upTime);
        sb.append(", isDel=").append(isDel);
        sb.append("]");
        return sb.toString();
    }
}