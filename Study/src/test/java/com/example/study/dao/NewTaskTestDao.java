package com.example.study.dao;

import com.alibaba.fastjson.JSON;
import com.example.study.model.task.AreaInfoEntitiy;
import com.example.study.model.task.GroupRuleEntity;
import com.example.study.model.task.NewGroupEntity;
import com.example.study.model.task.NewGroupPersonEntity;
import com.example.study.model.task.NewTaskEntity;
import com.example.study.mapper.task.GroupRuleMapper;
import com.example.study.mapper.task.NewGroupMapper;
import com.example.study.mapper.task.NewGroupPersonMapper;
import com.example.study.mapper.task.NewTaskMapper;
import com.example.study.model.task.*;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewTaskTestDao extends BaseTestDao {

    @Resource
    private NewTaskMapper newTaskMapper;

    @Resource
    private GroupRuleMapper groupRuleMapper;

    @Resource
    private NewGroupMapper newGroupMapper;

    @Resource
    private NewGroupPersonMapper newGroupPersonMapper;


    @Test
    public void save(){
        NewTaskEntity newTaskEntity = new NewTaskEntity();
        newTaskEntity.setTid("3");
        newTaskEntity.setAid("1");
        newTaskEntity.setApprovalType(NewTaskEntity.APPROVAL_TYPE.OFF_LINE);
        newTaskEntity.setTaskName("123");
        newTaskEntity.setStartTime("2018-12-12 10:10:05");
        newTaskEntity.setEndTime("2018-12-30 10:10:10");
        newTaskEntity.setTaskStatus(NewTaskEntity.TASK_STATUS.TO_BE_STARTED);
        newTaskEntity.setTaskType(NewTaskEntity.TASK_TYPE.REAL_TIME);
        newTaskEntity.setCreateUser("1");

        int n = newTaskMapper.insert(newTaskEntity);
        System.out.println("\n\n\n" + n+"\n\n\n");
    }

    @Test
    public void saveGroupRule(){
        GroupRuleEntity gre = new GroupRuleEntity();
        AreaInfoEntitiy aie = new AreaInfoEntitiy();
        aie.setId("1");
        aie.setBoundary("1,2;2,3");
        List<AreaInfoEntitiy> list = new ArrayList<>();
        list.add(aie);
        gre.setAreaInfo(JSON.toJSONString(list));
        gre.setCreateUser("1");
        gre.setGid("1");
        gre.setIsIntersection(GroupRuleEntity.IS_INTERSECTION.UNION);
        gre.setRid("1");
        gre.setRuleInfoXml("rule_info_xml");
        gre.setRuleParam("{}");
        gre.setRuleType("1");
        gre.setTid("1");

        groupRuleMapper.insert(gre);
    }

    @Test
    public void saveGroup(){
        NewGroupEntity nge = new NewGroupEntity();
        nge.setArg0("1");
        nge.setCreateUser("1");
        nge.setGid("1");
        nge.setGname("1");
        nge.setIsdel(NewGroupEntity.IS_DEL.NOT_DEL);
        nge.setTid("1");

        newGroupMapper.insert(nge);
    }

    @Test
    public void saveGroupPerson(){
        NewGroupPersonEntity ngpe = new NewGroupPersonEntity();
        ngpe.setCarNum("111");
        ngpe.setGid("1");
        ngpe.setId("1");
        ngpe.setIdcard("123");
        ngpe.setPhone("123");
        ngpe.setStatus(NewGroupPersonEntity.STATUS.STOP);
        newGroupPersonMapper.insert(ngpe);

    }
}
