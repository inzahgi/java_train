package com.example.study.mapper.dqjc;


import com.example.study.vo.SysDictVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * <p>
 * 字典项Mapper
 * </p>
 *
 * @author qingli8
 * @version 1.0
 * @since 2018年8月14日下午3:57:11
 *
 */
@Mapper
public interface SysDictMapper {

    List<SysDictVO> getSysDict(String dictTypeCode);

    int updateAreaCode(SysDictVO vo);
}
