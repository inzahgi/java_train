package com.iflytek.fwpt.mapper.task;



import com.iflytek.fwpt.model.task.WarnTaskEntity;
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