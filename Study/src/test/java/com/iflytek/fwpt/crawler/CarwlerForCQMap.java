package com.iflytek.fwpt.crawler;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.iflytek.fwpt.Application;
import com.iflytek.fwpt.mapper.dqjc.PoliceSubstationInfoMapper;
import com.iflytek.fwpt.mapper.dqjc.SyncDwMapper;
import com.iflytek.fwpt.mapper.dqjc.SysDictMapper;
import com.iflytek.fwpt.model.dqjc.PoliceSubstationInfo;
import com.iflytek.fwpt.model.sys.SysDict;
import com.iflytek.fwpt.utils.HttpClientsUtil;
import com.iflytek.fwpt.utils.JsoupUtil;
import com.iflytek.fwpt.vo.SyncDwVO;
import com.iflytek.fwpt.vo.SysDictVO;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.math3.analysis.function.Add;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class CarwlerForCQMap {

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private SysDictMapper sysDictMapper;

    @Resource
    private SyncDwMapper syncDwMapper;

    @Resource
    private PoliceSubstationInfoMapper policeSubstationInfoMapper;

    private List<String> queryList = Lists.newArrayList("超市", "学校", "餐馆"
    ,"银行", "车站", "医院", "社区", "加油站", "便利店");

    private String AREA_SET_KEY = "dqjc:crawler:area";

    private String PC_STATION_SET_KEY = "dqjc:crawler:pc:station";

    private String PC_STATION_LIST_KEY = "dqjc:crawler:pc:station:list";

    private String PC_LIST_KEY = "dqjc:crawler:pc:list";

    private String AREA_DICT_HASH_KEY = "dqjc:crawler:area:hash";

    private String STATION_LIST_KEY = "dqjc:crawler:station:list";




    @Test
    public void getPcStation(){
        String dirPath = "C:\\Users\\admin\\Desktop\\1\\html";
        Table<String, String, String> table = JsoupUtil.getByDir(dirPath);
        redisTemplate.opsForSet().add(AREA_SET_KEY, table.rowKeySet().toArray(new String[100]));
        redisTemplate.opsForSet().add(PC_STATION_SET_KEY, table.columnKeySet().toArray(new String[1000]));

        for (String  str : table.rowKeySet()){
            //System.out.println(str);
            System.out.println(table.row(str));
            //Map<String, String> map = table.row(str);
        }
        Set<String> res1Set = redisTemplate.opsForSet().members(AREA_SET_KEY);
        Set<String> res2Set = redisTemplate.opsForSet().members(PC_STATION_SET_KEY);

    }


    @Test
    public void request(){
        String url = "https://apis.map.qq.com/ws/place/v1/search?" +
                "keyword=";
        String paramEnd = "&boundary=region(%E9%87%8D%E5%BA%86%E5%B8%82,0)" +
                "&page_size=9" +
                "&page_index=1" +
                "&key=K76BZ-W3O2Q-RFL5S-GXOPR-3ARIT-6KFE5" +
                "&output=jsonp" +
                "&&callback=jQuery191013601220279944948_1541571286676" +
                "&_=1541571286686";

        int len = "jQuery191013601220279944948_1541571286676&&jQuery191013601220279944948_1541571286676(".length();
        Set<String> pcStationSet = redisTemplate.opsForSet().members(PC_STATION_SET_KEY);

        for (String str : pcStationSet) {
            String paramTemp=null;
            try {
                paramTemp = URLEncoder.encode(str, "utf-8");
            }catch (java.io.UnsupportedEncodingException e){
                e.printStackTrace();
                continue;
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }

            String originRes = QqMapHttpClientsUtil.get(url + paramTemp +paramEnd );

            String res = originRes.substring(len, originRes.length() -1);

            redisTemplate.opsForList().leftPush(PC_STATION_LIST_KEY, res);

            //JSONObject jsonObject = JSONObject.parseObject(res);

            System.out.println("\n\n" + res);
            //break;
            try{
                Thread.sleep(2000);
            }catch (java.lang.InterruptedException e){
                e.printStackTrace();
            }
        }
        //String key = (String)redisTemplate.opsForList().rightPop(PC_STATION_LIST_KEY);
    }


    @Test
    public void getList(){
        List<String> list = redisTemplate.opsForList().range(PC_STATION_LIST_KEY, 0, -1);
        Preconditions.checkNotNull(list);
        Set<AddressInfo> set = Sets.newHashSet();
        for (String str : list){
            JSONObject jsonObject = JSONObject.parseObject(str);
            List<AddressInfo> origanDataList = JSONArray.parseArray(jsonObject.get("data").toString(), AddressInfo.class);

            for (AddressInfo ai : origanDataList){
                //System.out.println(ai.toString());
                if(ai.getTitle().endsWith("派出所")) {
                    String pcStationName = getPCSName(ai.getTitle());
                    Preconditions.checkNotNull(pcStationName);
                    ai.setTitle(pcStationName);
                    System.out.println(ai.toString());
                    set.add(ai);
                }
            }
        }
        redisTemplate.opsForList().leftPushAll(PC_LIST_KEY, set);
    }

    private String getPCSName(String inputStr){
        Preconditions.checkArgument(StringUtils.isNotEmpty(inputStr));
        String outPutStr=null;
        if(inputStr.contains("分局")){
            int index = inputStr.indexOf("分局");
            if(index != -1){
                outPutStr = inputStr.substring(index + 2);
            }
        }else if(inputStr.contains("公安局")){
            int index = inputStr.indexOf("公安局");
            if(index != -1){
                outPutStr = inputStr.substring(index + 3);
            }
        }else {
            outPutStr = inputStr;
        }

        if(StringUtils.isEmpty(outPutStr)){
            System.out.println(inputStr + "-----------" + outPutStr);
        }
        return outPutStr;
    }

    @Test
    public void insertPcStation(){
//        List<SysDictVO> list = sysDictMapper.getSysDict("areaName");
        Map<String, String> dictMap = Maps.newHashMap();
//        for (SysDictVO vo : list){
//            dictMap.put(vo.getDictName(), vo.getDictCode());
//        }


        Multiset<String> cntSet = HashMultiset.create();
        List<AddressInfo> addressList = redisTemplate.opsForList().range(PC_LIST_KEY, 0, -1);
        for(AddressInfo addressInfo : addressList){

            PoliceSubstationInfo info = new PoliceSubstationInfo();
            info.setLat(addressInfo.getLocation().getLat());
            info.setLng(addressInfo.getLocation().getLng());
            info.setPcsname(addressInfo.getTitle());
            //String areaCode = dictMap.get(addressInfo.getAdInfo().getDistrict());
            info.setAreacode(addressInfo.getAdInfo().getAdcode());
            cntSet.add(addressInfo.getAdInfo().getAdcode());
            info.setPcscode(Strings.padStart(String.valueOf(cntSet.count(info.getAreacode())), 4, '0'));

            dictMap.put(addressInfo.getAdInfo().getDistrict(), addressInfo.getAdInfo().getAdcode());
            System.out.println(info.toString());
            //policeSubstationInfoMapper.insertSelective(info);
        }

        redisTemplate.opsForHash().putAll(AREA_DICT_HASH_KEY, dictMap);
    }

    @Test
    public void updateAreaCode(){
        Map<String, String> map =redisTemplate.opsForHash().entries(AREA_DICT_HASH_KEY);

        SysDictVO vo = new SysDictVO();
        for(Map.Entry<String, String> entry : map.entrySet()){
            vo.setDictCode(entry.getValue());
            vo.setDictName(entry.getKey());
            sysDictMapper.updateAreaCode(vo);
        }
    }


    @Test
    public void updateRegoin(){
        double r = 0.008;
        Random random = new Random();
        List<PoliceSubstationInfo> list = policeSubstationInfoMapper.getAll();
        for(PoliceSubstationInfo psi : list){
            double lng = psi.getLng();
            double lat = psi.getLat();

            double lng1 = lng - (r + random.nextDouble()*0.01);
            double lat1 = lat + (r + random.nextDouble()*0.01);

            double lng2 = lng - (r + random.nextDouble()*0.01);
            double lat2 = lat - (r + random.nextDouble()*0.01);

            double lng3 = lng + (r + random.nextDouble()*0.01);
            double lat3 = lat - (r + random.nextDouble()*0.01);

            double lng4 = lng + (r + random.nextDouble()*0.01);
            double lat4 = lat + (r + random.nextDouble()*0.01);

            StringBuilder sb = new StringBuilder(1000);
            sb.append(lng1).append(',')
                    .append(lat1).append(',')
                    .append(lng2).append(',')
                    .append(lat2).append(',')
                    .append(lng3).append(',')
                    .append(lat3).append(',')
                    .append(lng4).append(',')
                    .append(lat4).append(',');

            psi.setRegion(sb.toString());
            policeSubstationInfoMapper.updateByPrimaryKeySelective(psi);
        }
    }


    @Test
    public void getPoint(){
        Random random = new Random();
        String url = "https://apis.map.qq.com/ws/place/v1/search?" +
                "keyword=";
        String paramFirst = "&boundary=region(%E9%87%8D%E5%BA%86%E5%B8%82,0)" +
                "&page_size=20&page_index=";
        String paramEnd = "&key=K76BZ-W3O2Q-RFL5S-GXOPR-3ARIT-6KFE5" +
                "&output=jsonp" +
                "&&callback=jQuery191013601220279944948_1541571286676" +
                "&_=1541571286686";

        int len = "jQuery191013601220279944948_1541571286676&&jQuery191013601220279944948_1541571286676(".length();

        Map<String, String> map = redisTemplate.opsForHash().entries(AREA_DICT_HASH_KEY);

        redisTemplate.opsForHash().putAll(AREA_DICT_HASH_KEY + ":backup", map);


        for (String str : map.keySet()) {
            String paramTemp=null;


            Set<AddressInfo> set = Sets.newHashSet();
            int index = 0;
            boolean flag = false;
            for (int i = 1; i < 10; i++) {

                paramTemp = getQueryStr(str, index);
                if(StringUtils.isEmpty(paramTemp)){
                    //index++;
                    break;
                }

                String originRes = QqMapHttpClientsUtil.get(url +paramTemp + paramFirst +
                           i +  paramEnd);

                String res = originRes.substring(len, originRes.length() - 1);


                System.out.println("\n\n" + res);



                JSONObject jsonObject = JSONObject.parseObject(res);
                List<AddressInfo> origanDataList = JSONArray.parseArray(jsonObject.get("data").toString(), AddressInfo.class);

                int len1 = set.size();
                set.addAll(origanDataList);
                if(len1 == set.size()){
                    if(flag == false){
                        flag = true;
                    }else {
                        i = 0;
                        index++;
                    }
                }




                try {
                    Thread.sleep(3000 + random.nextInt(2000));
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }

            redisTemplate.opsForList().leftPushAll(STATION_LIST_KEY, set);
            //redisTemplate.opsForHash().delete(AREA_DICT_HASH_KEY, str);
        }
    }

    private String getQueryStr(String str, int i){
        if(i >= queryList.size()){
            return null;
        }
        try {
            return URLEncoder.encode(str + " " + queryList.get(i), "utf-8");
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    @Test
    public void insertPoint(){
        List<AddressInfo> list = redisTemplate.opsForList().range(STATION_LIST_KEY, 0 ,-1);
        int i = 1;
        Date date = new Date();
        for(AddressInfo ai : list){
            SyncDwVO vo = new SyncDwVO();
            vo.setId(ai.getId());
            vo.setCityCode("023");
            vo.setCityName("重庆");
            vo.setAreaCode(ai.getAdInfo().getAdcode());
            vo.setAreaName(ai.getAdInfo().getDistrict());
            vo.setLacCode(String.valueOf(i++));
            vo.setCiCode(String.valueOf(i++));
            vo.setCiName(ai.getTitle());
            vo.setCiLat(String.valueOf(ai.getLocation().getLat()));
            vo.setCiLng(String.valueOf(ai.getLocation().getLng()));
            vo.setCiAddress(ai.getAddress());
            vo.setCreateDate("2018-11-8 12:12:12");
            syncDwMapper.insert(vo);
        }
    }


}
