package com.example.study.model.task;

import java.io.Serializable;
import java.util.Date;

/**
 * tbl_task
 * @author 
 */
public class NewTaskEntity {
    private String tid;

    private String taskName;

    /**
     * 预警类型（0-实时监控、1-消息预警）
     */
    private String taskType;

    /**
     * 审批类型（0-线上、1-线下）
     */
    private String approvalType;

    /**
     * 审批id
     */
    private String aid;

    /**
     * 任务开始时间
     */
    private String startTime;

    /**
     * 任务结束时间
     */
    private String endTime;

    /**
     * 任务状态(2-执行中，5-撤销，3-完成，0-未开始，1-开始，4-变更，6-删除)
     */
    private String taskStatus;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 备注
     */
    private String arg0;

    public interface TASK_TYPE{
        String REAL_TIME = "0";

        String MESSAGE_WARNING = "1";
    }

    public interface APPROVAL_TYPE{
        String ON_LINE = "0";

        String OFF_LINE = "1";
    }

    /**
     * 任务状态(2-执行中，5-撤销，3-完成，0-未开始，1-开始，4-变更，6-删除)
     */
    public interface TASK_STATUS{
        String TO_BE_STARTED = "0";
        String START = "1";
        String RUNNING = "2";
        String DONE = "3";
        String CHANGE = "4";
        String CANCEL = "5";
        String DELETE = "6";
    }




    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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