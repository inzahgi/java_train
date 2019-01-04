package com.example.study.model.task;

import java.io.Serializable;

/**
 * tbl_task_group
 * @author 
 */
public class TaskGroupEntity implements Serializable {
    private String id;

    /**
     * 群体名称
     */
    private String groupName;

    /**
     * 任务id
     */
    private String taskId;

    /**
     * 0:已存在1:删除
     */
    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }
}