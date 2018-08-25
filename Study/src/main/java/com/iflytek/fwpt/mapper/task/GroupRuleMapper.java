package com.iflytek.fwpt.mapper.task;

import com.iflytek.fwpt.model.task.GroupRuleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupRuleMapper {
    int deleteByPrimaryKey(String rid);

    int insert(GroupRuleEntity record);

    int insertSelective(GroupRuleEntity record);

    GroupRuleEntity selectByPrimaryKey(String rid);

    int updateByPrimaryKeySelective(GroupRuleEntity record);

    int updateByPrimaryKey(GroupRuleEntity record);
}