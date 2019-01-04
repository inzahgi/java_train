package com.example.study.mapper.task;



import com.example.study.model.task.WarnTaskEntity;
import com.example.study.model.task.WarnTaskEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WarnTaskMapper {
    int deleteByPrimaryKey(String tid);

    int insert(WarnTaskEntity record);

    int insertSelective(WarnTaskEntity record);

    WarnTaskEntity selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(WarnTaskEntity record);

    int updateByPrimaryKey(WarnTaskEntity record);
}