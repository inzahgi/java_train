package com.example.study.mapper.dqjc;

import com.example.study.model.dqjc.PhoneInfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhoneInfoMapper {

    int insert(PhoneInfo record);

    PhoneInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhoneInfo record);

    int updateByPrimaryKey(PhoneInfo record);

    List<PhoneInfo> getList();

    int batchInsert(@Param("list")List<PhoneInfo> list);

    int updateArea(PhoneInfo record);
}