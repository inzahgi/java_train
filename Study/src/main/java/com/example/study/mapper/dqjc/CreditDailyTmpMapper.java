package com.example.study.mapper.dqjc;

import com.example.study.model.dqjc.CreditDailyTmp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CreditDailyTmpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditDailyTmp record);

    CreditDailyTmp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditDailyTmp record);

    int updateByPrimaryKey(CreditDailyTmp record);

    int getTotal();

    List<CreditDailyTmp> getList();

    int batchDelete(@Param("list") List<Integer> idList);

    int batchInsert(@Param("list") List<CreditDailyTmp> list);

}