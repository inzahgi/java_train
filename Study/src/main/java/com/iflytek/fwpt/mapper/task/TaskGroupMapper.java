package com.iflytek.fwpt.mapper.task;

import com.iflytek.fwpt.model.task.TaskGroupEntity;

public interface TaskGroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaskGroupEntity record);

    int insertSelective(TaskGroupEntity record);

    TaskGroupEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TaskGroupEntity record);

    int updateByPrimaryKey(TaskGroupEntity record);
}