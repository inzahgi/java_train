package com.example.study.mapper.dqjc;



import com.example.study.model.dqjc.CreditPerson;
import com.example.study.model.dqjc.CreditScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CreditScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditScore record);

    CreditScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditScore record);

    int updateByPrimaryKey(CreditScore record);

    int getTotal(CreditPerson record);

    List<CreditPerson> getList(CreditPerson record);

    int batchInsert(@Param("list") List<CreditScore> list);

    List<String> getIdCardList();
}