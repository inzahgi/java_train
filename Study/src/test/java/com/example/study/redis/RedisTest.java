package com.example.study.redis;

import com.example.study.MyBatisApplication;
import com.example.study.model.task.NewGroupPersonEntity;
import com.example.study.MyBatisApplication;
import com.example.study.model.task.NewGroupPersonEntity;
import com.example.study.model.task.NewTaskEntity;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author:inzahgi
 * Date:2018/8/29
 * Time:8:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest(){

        System.out.println(redisTemplate.getClientList());
    }


    @Test
    public void redisForHashTest(){
        //System.out.println(redisTemplate.getClientList());
//        redisTemplate.executePipelined(new SessionCallback<Object>() {
//            @Override
//            public <K, V> Object execute(RedisOperations<K, V> redisOperations) throws DataAccessException {
//                redisTemplate.opsForHash().put("123", "123", new NewGroupPersonEntity.Builder()
//                                        .id("1111111").gid("13412").build());
//                redisTemplate.opsForHash().put("124",                    "124", "124254");
//                System.out.println(redisTemplate.opsForHash().hasKey("123",
//                        "123"));
//                //System.out.println(ngpe.toString());
//
//                return null;
//            }
//        });
        Map<String, NewGroupPersonEntity> resMap = null;
        redisTemplate.execute(new RedisCallback<Map<String, NewGroupPersonEntity>>() {
            @Override
            public Map<String, NewGroupPersonEntity> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisTemplate.opsForHash().put("123","123", new NewGroupPersonEntity.Builder()
                        .id("1111111").gid("13412").build());
                redisTemplate.opsForHash().put("123","124", new NewGroupPersonEntity.Builder()
                        .id("1111112").gid("13413").build());
                System.out.println(redisTemplate.opsForHash().hasKey("123",
                        "123"));
                 //resMap = redisTemplate.opsForHash().entries("123");

                return null;
            }
        });


    }


    @Test
    public void redisForHashTestTwo(){
        Map<Object, Object> resMap = null;

        redisTemplate.execute(new RedisCallback<Map<Object, Object>>() {
            @Override
            public Map<Object, Object> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisTemplate.opsForHash().put("123","123", new NewGroupPersonEntity.Builder()
                        .id("1111111").gid("13412").build());
                redisTemplate.opsForHash().put("123","124", new NewGroupPersonEntity.Builder()
                        .id("1111112").gid("13413").build());
                System.out.println(redisTemplate.opsForHash().hasKey("123",
                        "123"));
                Map<Object, Object> resMap = redisTemplate.opsForHash().entries("123");
                return null;
            }
        });
    }

    @Test
    public void zSetTest(){
        String key = "testZSet";
        for (int i = 0; i < 100; i++) {
            redisTemplate.opsForZSet().add("testZSet", i, 100-i);
        }

        Set<Integer> set= redisTemplate.opsForZSet().reverseRange(key, 0, 10);

        for (Integer str : set){
            System.out.println(str);
        }

    }

}
