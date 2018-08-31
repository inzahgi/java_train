package com.iflytek.fwpt;


import com.iflytek.fwpt.ceritira.AreaCriteria;
import com.iflytek.fwpt.mapper.area.AreaMapper;
import com.iflytek.fwpt.model.area.AreaEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisApplication.class)
public class MyBatisApplicationTests {


	@Resource
	private AreaMapper areaMapper;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
		System.out.println("\n\n\n");
		List<AreaEntity> list = areaMapper.getAreaPage(new AreaCriteria());
		for (AreaEntity entity :  list){
			System.out.println(entity.toString());
		}
	}



}
