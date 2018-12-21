package com.iflytek.fwpt.dao;


import com.iflytek.fwpt.Application;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SysdictTestDao {

//    @Resource
//    private SysDictMapper dictMapper;
//
//    @Test
//    public void addTest(){
//        String path = "C:\\Users\\admin\\Desktop\\区号-1.txt";
//        File file = new File(path);
//        if(file.exists() && file.isFile()) {
//            try {
//                BufferedReader br = new BufferedReader(new FileReader(file));
//                String str = null;
//                while((str = br.readLine()) != null){
//                    String[] arr = str.trim().split(" ");
//                    System.out.println(arr[0] + "\t-------------\t" + arr[1]);
//                    SysDictEntity sysDictEntity = new SysDictEntity.Builder()
//                            .dictTypeCode("cityCode")
//                            .dictTypeName("城市编码")
//                            .dictCode(arr[1])
//                            .dictName(arr[0])
//                            .build();
//
//                    dictMapper.insertSelective(sysDictEntity);
//                }
//
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    @Test
//    public void cacheTest(){
////        new CacheLoader<String, Map<String, String>>() {
////            @Override
////            public Map<String, String> load(String s) throws Exception {
////                System.out.println("\n\n\nloading !!!");
////                List<SysDictEntity> list = dictMapper.selectByDictTypeCode(s);
////                Map<String, String> map = Maps.newHashMap();
////                for (SysDictEntity sde : list){
////                    map.put(sde.getDictName(), sde.getDictCode());
////                }
////                //System.out.println(map.size());
////                return map;
////            }
////        });
//        LoadingCache<String, Map<String, String>> cache = CacheBuilder.newBuilder()
//                .maximumSize(1000)
//                .expireAfterAccess(30L, TimeUnit.HOURS)
//                .build(createCacheLoader());
//
//        try {
//
//            Map<String, String> map = cache.getUnchecked("cityCode");
//            System.out.println(map.size());
//            Thread.sleep(1000*5);
//            System.out.println(cache.getUnchecked("cityCode").size());
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public CacheLoader<String, Map<String, String>> createCacheLoader() {
//        return new com.google.common.cache.CacheLoader<String, Map<String, String>>() {
//            @Override
//            public Map<String, String> load(String key) throws Exception {
//                System.out.println("加载创建key:" + key);
//                //SysDictMapper sysDictMapper = (SysDictMapper)SpringUtil.getBean("sysDictMapper");
//                //List<SysDictEntity> list = sysDictMapper.selectByDictTypeCode(key);
//                List<SysDictEntity> list = dictMapper.selectByDictTypeCode(key);
//                Map<String, String> map = Maps.newHashMap();
//                for (SysDictEntity sde : list) {
//                    map.put(sde.getDictName(), sde.getDictCode());
//                }
//                System.out.println("查询数据库完成size:" + map.size());
//                return map;
//            }
//        };
//    }








}
