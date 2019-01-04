package com.example.study.mapper.task;

import com.example.study.model.task.GroupRuleEntity;
import com.example.study.model.task.GroupRuleEntity;
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