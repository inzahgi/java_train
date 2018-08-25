package com.iflytek.fwpt.mapper.task;

import com.iflytek.fwpt.model.task.NewTaskEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewTaskMapper {
    int deleteByPrimaryKey(String tid);

    int insert(NewTaskEntity record);

    int insertSelective(NewTaskEntity record);

    NewTaskEntity selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(NewTaskEntity record);

    int updateByPrimaryKey(NewTaskEntity record);
}