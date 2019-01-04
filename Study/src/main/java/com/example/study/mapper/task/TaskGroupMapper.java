package com.example.study.mapper.task;

import com.example.study.model.task.TaskGroupEntity;
import com.example.study.model.task.TaskGroupEntity;

public interface TaskGroupMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaskGroupEntity record);

    int insertSelective(TaskGroupEntity record);

    TaskGroupEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TaskGroupEntity record);

    int updateByPrimaryKey(TaskGroupEntity record);
}