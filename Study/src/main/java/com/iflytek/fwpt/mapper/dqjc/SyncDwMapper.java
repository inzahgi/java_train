package com.iflytek.fwpt.mapper.dqjc;


import com.iflytek.fwpt.vo.AddressVO;
import com.iflytek.fwpt.vo.SyncDwVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * <p>
 * 基站Mapper
 * </p>
 *
 * @author qingli8
 * @version 1.0
 * @since 2018年8月14日下午3:57:11
 *
 */
@Mapper
public interface SyncDwMapper {

    /**
     * 根据lac、ci查询基站信息
     * 
     * @author qingli8
     * @since 2018年10月24日下午4:25:18
     * @param lac
     * @param ci
     * @return
     */
    SyncDwVO getSyncDw(@Param(value = "lac") String lac, @Param(value = "ci") String ci);

    /**
     * 根据地区和地址查询基站信息
     * 
     * @author qingli8
     * @since 2018年10月29日上午10:06:33
     * @param area
     * @param address
     * @return
     */
    List<AddressVO> getSyncDwByArea(@Param(value = "area") String area, @Param(value = "address") String address);

    List<SyncDwVO> getList();
}
