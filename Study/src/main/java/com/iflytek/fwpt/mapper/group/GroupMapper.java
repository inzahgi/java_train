package com.iflytek.fwpt.mapper.group;



import com.iflytek.fwpt.ceritira.GroupCriteria;
import com.iflytek.fwpt.model.group.GroupEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface GroupMapper
{

    /**
     * 根据查询条件获取人员列表数据
     * @return
     */
    public List<GroupEntity> getGroupPage(@Param(value = "criteria") GroupCriteria criteria);

    public GroupEntity getGroupByName(@Param(value = "name") String name);

    public GroupEntity getGroupById(@Param(value = "id") String id);

    public void save(GroupEntity group);

    public void bathSave(List<GroupEntity> list);

    public void update(GroupEntity group);

    public void bathDelete(@Param(value = "list") List<String> list);

    public List<GroupEntity> getGroupsByNames(List<String> list);

    public List<GroupEntity> getGroupsByPoliceIdAndName(@Param(value = "name") String name,
                                                        @Param(value = "policeId") String policeId);

    public List<GroupEntity> getGroupsByUserId(@Param(value = "userId") String userId);

}
