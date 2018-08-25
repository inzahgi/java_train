package com.iflytek.fwpt.mapper.area;




import com.iflytek.fwpt.ceritira.AreaCriteria;
import com.iflytek.fwpt.model.area.AreaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AreaMapper
{

    public List<AreaEntity> getAreaPage(@Param(value = "criteria") AreaCriteria criteria);

    public List<AreaEntity> getAreaByUserId(@Param(value = "id") String id);

    public AreaEntity getAreaById(@Param(value = "id") String id);

    public void save(AreaEntity area);

    public void update(AreaEntity area);

    public void bathDelete(List<String> list);

    public List<AreaEntity> getAreaByIds(List<String> idList);

    public String getAreaIdByRuleId(@Param(value = "ruleId") String ruleId);

    public String getAreaIdByTaskId(@Param(value = "taskId") String taskId);

    int findSameNameAndLabelByUser(@Param(value = "name") String name, @Param(value = "labelId") String labelId,
                                   @Param(value = "userId") String userId);

}
