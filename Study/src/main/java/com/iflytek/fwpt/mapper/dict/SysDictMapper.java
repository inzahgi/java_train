package com.iflytek.fwpt.mapper.dict;


import com.iflytek.fwpt.model.dict.SysDictEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDictEntity record);

    int insertSelective(SysDictEntity record);

    SysDictEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictEntity record);

    int updateByPrimaryKey(SysDictEntity record);

    List<SysDictEntity> selectByDictTypeCode(String dictTypeCode);
}