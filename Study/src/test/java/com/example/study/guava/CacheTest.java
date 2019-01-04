package com.example.study.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MyBatisApplication.class)
public class CacheTest {

    private static Logger log = LoggerFactory.getLogger(CacheTest.class);

    public static CacheLoader<String, Employee> createCacheLoader () {
        return new CacheLoader<String, Employee>() {
            @Override
            public Employee load(String key) throws Exception {
                log.info("加载创建key:" + key);
                return new Employee(key, key + "dept", key + "id");
            }
        };
    }

    @Test
    public void cacheLoadTest() throws Exception {

        LoadingCache<String, Employee> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(30L, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Employee>() {
                    @Override
                    public Employee load(String key) throws Exception {
                        log.info("加载创建key:" + key);
                        return new Employee(key, key + "dept", key + "id");
                    }
                });

        Employee employee1 = cache.getUnchecked("aaaa");
        log.info("{}", employee1);

        Employee employee2 = cache.getUnchecked("aaaa");
        log.info("{}", employee2);

        try{
            java.lang.Thread.sleep(60*1000 );
        }catch (java.lang.InterruptedException e){
            e.printStackTrace();
        }
        Employee employee3 = cache.getUnchecked("aaaa");
        log.info("{}", employee3);
    }

    @Test
    public void callableTest(){
//        Cache<Key, Value> cache = CacheBuilder.newBuilder()
//                .maximumSize(1000)
//                .build(); // look Ma, no CacheLoader
//
//        try {
//            // If the key wasn't in the "easy to compute" group, we need to
//            // do things the hard way.
//            cache.get(key, new Callable<Value>() {
//                @Override
//                public Value call() throws AnyException {
//                    return doThingsTheHardWay(key);
//                }
//            });
//        } catch (ExecutionException e) {
//            throw new OtherException(e.getCause());
//        }

    }


}



