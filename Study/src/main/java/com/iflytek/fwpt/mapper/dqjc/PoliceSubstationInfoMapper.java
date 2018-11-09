package com.iflytek.fwpt.mapper.dqjc;

import com.iflytek.fwpt.model.dqjc.PoliceSubstationInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoliceSubstationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoliceSubstationInfo record);

    int insertSelective(PoliceSubstationInfo record);

    PoliceSubstationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoliceSubstationInfo record);

    int updateByPrimaryKeyWithBLOBs(PoliceSubstationInfo record);

    int updateByPrimaryKey(PoliceSubstationInfo record);

    List<PoliceSubstationInfo> getAll();
}