package com.example.study.mapper.area;



import com.example.study.model.area.StationEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StationMapper
{

    void bathSave(List<StationEntity> station);

    void delete();

    List<StationEntity> getStationsByLngAndLat(@Param(value = "minLat") String minLat,
                                               @Param(value = "minLng") String minLng,
                                               @Param(value = "maxLat") String maxLat,
                                               @Param(value = "maxLng") String maxLng);

}
