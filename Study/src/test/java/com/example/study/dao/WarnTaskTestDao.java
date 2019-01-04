package com.example.study.dao;


import com.example.study.model.task.WarnTaskEntity;
import com.example.study.Application;
import com.example.study.mapper.task.WarnTaskMapper;
import com.example.study.model.task.WarnTaskEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class WarnTaskTestDao {

    @Resource
    private WarnTaskMapper mapper;

    @Test
    public void addTest(){
        WarnTaskEntity entity = new WarnTaskEntity.Builder()
                .tid("2")
                .warnTypeId("1")
                .taskName("1")
                .startTime(new Date())
                .endTime(new Date())
                .taskStatus(1)
                .isMessageWarn(1)
                .isRealTimeWarn(1)
                .createUser("111")
                .isDel(0).build();

        mapper.insert(entity);

    }

}
