package com.iflytek.fwpt.mapper.dqjc;

import com.iflytek.fwpt.model.dqjc.CreditStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CreditStatisticsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditStatistics record);

    CreditStatistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditStatistics record);

    int updateByPrimaryKey(CreditStatistics record);

    List<CreditStatistics> getList(@Param("record") CreditStatistics record, @Param("queryOrder") String queryOrder);

    void insertBatch(@Param("list") List<CreditStatistics> list);

    void deleteAll();
}