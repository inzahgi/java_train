package com.example.study.mapper.task;

import com.example.study.model.task.NewGroupPersonEntity;
import com.example.study.model.task.NewGroupPersonEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewGroupPersonMapper {
    int deleteByPrimaryKey(String id);

    int insert(NewGroupPersonEntity record);

    int insertSelective(NewGroupPersonEntity record);

    NewGroupPersonEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NewGroupPersonEntity record);

    int updateByPrimaryKey(NewGroupPersonEntity record);
}