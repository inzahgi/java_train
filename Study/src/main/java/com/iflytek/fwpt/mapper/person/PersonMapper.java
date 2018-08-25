package com.iflytek.fwpt.mapper.person;



import com.iflytek.fwpt.ceritira.PersonCriteria;
import com.iflytek.fwpt.model.person.PersonEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 
    * @ClassName: PersonMapper
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author jgwang2
    * @date 2018年5月9日
    *
 */
public interface PersonMapper
{

    /**
     * 根据查询条件获取人员列表数据
     * @return
     */
    public List<PersonEntity> getPersonPage(@Param(value = "criteria") PersonCriteria criteria);

    public List<PersonEntity> getPersonPageByTaskId(@Param(value = "criteria") PersonCriteria criteria);

    /**
     * 根据电话号码获取人员列表数据
     * @return
     */
    public List<PersonEntity> getPersonByPhone(@Param(value = "phone") String phone);

    public PersonEntity getPersonByPhoneAndTaskId(@Param(value = "phone") String phone,
                                                  @Param(value = "taskId") String taskId);

    /**
     * 根据电话号码获取人员列表数据
     * @return
     */
    public List<PersonEntity> getPersonByIds(List<String> list);

    public List<PersonEntity> getPersonsByPersonIds(List<String> list);

    /**
     * 根据民警id获取人员信息
     * @return
     */
    public List<PersonEntity> getPersonByPoliceId(@Param(value = "policeId") String policeId);

    // /**
    // * 根据任务id获取人员信息
    // * @return
    // */
    // public List<PersonEntity> getPersonByTaskId(@Param(value = "taskId") String taskId);

    void save(PersonEntity person);

    void bathSave(List<PersonEntity> list);

    void update(PersonEntity person);

    /** 
    * 批量删除
    * @param list   重点人员id 
    * @return void    返回类型
    * @author jgwang2 
    * @throws 
    */
    void bathDelete(List<String> list);

    void bathDeleteByGroupIds(List<String> list);

    void deleteByPhone(@Param(value = "phone") String phone);

    void deleteById(@Param(value = "id") String id);

    /** 
    * 批量跟新人员状态为布控状态 
    * @param list    
    * @return void    返回类型
    * @author jgwang2 
    * @throws 
    */
    void bathUpdateStatus(List<String> list);

    /** 
    * 根基电话号码，群体id，所属民警id，查询人员数量，如果有数量表示该数据存在（号码，所属群体，所属民警为唯一主键）
    * @param phone 电话号码
    * @param groupId 群体id
    * @param policeId 民警id
    * @return Integer    返回类型
    * @author jgwang2 
    * @throws 
    */
    Integer getCountByPhoneAndGourpIdAndPoliceId(@Param(value = "phone") String phone,
                                                 @Param(value = "groupId") String groupId,
                                                 @Param(value = "policeId") String policeId);

    public PersonEntity getPersonById(@Param(value = "id") String id);

    Integer getRspCountByPersonId(@Param(value = "personId") String personId);

    public List<PersonEntity> getPersonsByGroupIds(List<String> list);

    /**
     * 根据任务id获取人员信息
     * @return
     */
    public List<String> getPersonByTaskId(@Param(value = "taskId") String taskId);

    public List<String> getStoragePersonByTaskId(@Param(value = "taskId") String taskId);

    public List<String> getPhonesByPersonIds(List<String> list);

    public List<PersonEntity> getPersongsByPersonIds(List<String> list);

    public List<PersonEntity> getPersonByGroupIdAndUserId(@Param(value = "groupId") String groupId,
                                                          @Param(value = "userId") String userId);

    public List<PersonEntity> getPoliceMessageByUserId(@Param(value = "userId") String userId);

    void bathUpdatePoliceName(List<PersonEntity> list);

    Integer getPersonCounByGroupId(@Param(value = "groupId") String groupId);

    List<PersonEntity> getPersonCountByGroupIdList(@Param(value = "list") List<String> groupIds);

    public List<PersonEntity> getPersonByGroupIdsAndPoliceId(@Param(value = "groupIds") List<String> groupIds,
                                                             @Param(value = "policeId") String policeId);

    public List<PersonEntity> getStoragePersonPage(@Param(value = "criteria") PersonCriteria criteria);

    public List<PersonEntity> getPersonByPhones(List<String> phones);

    public Integer getRspPersonCountByGroupId(@Param(value = "groupId") String groupId);

    /**
     * 统计预警任务布控人数
     * 〈功能详细描述〉
     * @author xinguo@iflytek.com
     * @version 2018年6月8日
     */
    public Integer queryCountNumByTaskId(@Param(value = "taskId") String taskId);

}
