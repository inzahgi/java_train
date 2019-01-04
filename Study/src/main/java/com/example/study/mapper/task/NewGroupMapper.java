package com.example.study.mapper.task;

import com.example.study.model.task.NewGroupEntity;
import com.example.study.model.task.NewGroupEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewGroupMapper {
    int deleteByPrimaryKey(String gid);

    int insert(NewGroupEntity record);

    int insertSelective(NewGroupEntity record);

    NewGroupEntity selectByPrimaryKey(String gid);

    int updateByPrimaryKeySelective(NewGroupEntity record);

    int updateByPrimaryKey(NewGroupEntity record);
}