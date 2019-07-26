package com.example.study.dqjc;


import com.example.study.Application;
import com.example.study.mapper.dqjc.CreditDailyTmpMapper;
import com.example.study.mapper.dqjc.CreditScoreMapper;
import com.example.study.mapper.dqjc.PhoneInfoMapper;
import com.example.study.mapper.dqjc.PoliceSubstationInfoMapper;
import com.example.study.mapper.dqjc.SyncDwMapper;
import com.example.study.mapper.dqjc.SysDictMapper;
import com.example.study.model.dqjc.CreditDailyTmp;
import com.example.study.model.dqjc.CreditPerson;
import com.example.study.model.dqjc.CreditScore;
import com.example.study.model.dqjc.DW;
import com.example.study.model.dqjc.PhoneInfo;
import com.example.study.model.dqjc.PoliceSubstationInfo;
import com.example.study.utils.AxisTool;
import com.example.study.utils.ChineseNameUtil;
import com.example.study.utils.CreateIdcardUtil;
import com.example.study.vo.SyncDwVO;
import com.example.study.vo.SysDictVO;
import com.github.inzahgi.spring.boot.starter.hbase.api.HbaseTemplate;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProduceLocationData {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private HbaseTemplate hbaseTemplate;
    @Resource
    private PhoneInfoMapper phoneInfoMapper;
    @Resource
    private CreditScoreMapper scoreMapper;
    @Resource
    private CreditDailyTmpMapper dailyTmpMapper;
    @Resource
    private SyncDwMapper dwMapper;
    @Resource
    private PoliceSubstationInfoMapper policeSubstationInfoMapper;

    @Resource
    private SysDictMapper sysDictMapper;

    private Random random = new Random();




    @Test
    public void insertOriginLoation(){
        Date curDate = new Date();
        List<SyncDwVO> dwList = dwMapper.getList();
        CreditPerson cpQuery = CreditPerson.CreditPersonBuilder.aCreditPerson()
                .status(1).build();
        List<CreditPerson> scoreList = scoreMapper.getList(cpQuery);
        ArrayListMultimap<String, PoliceSubstationInfo> pcsMulitumap = getPcsMap();
        Map<String, String> pcsToAreaMap = getPcsToAreaMap();

        List<DW> list = Lists.newArrayList();

        mongoTemplate.remove(new Query(), "dw");
        for(CreditPerson cp : scoreList){
            DW dw = getDwFromList(dwList, pcsMulitumap, pcsToAreaMap);
            if(dw == null)
                continue;
            dw.setId(cp.getPhone());
            dw.setpName(cp.getName());
            dw.setIsZk(cp.getIsZk());
            dw.setIsGy(cp.getIsGy());
            dw.setIsYx(cp.getIsYx());
            dw.setCreateTime(String.valueOf(curDate.getTime()/1000 + random.nextInt(3600*24*100)));
            list.add(dw);
            if(list.size() > 1000){
                batchSaveToMonogDb(list);
                list.clear();
            }
        }
        if(list.size() > 0){
            batchSaveToMonogDb(list);
            list.clear();
        }
    }


    private void batchSaveToMonogDb(List<DW> dwList){
        //        BulkOperations.BulkMode bulkMode = new BulkOperations();
//        mongoTemplate.bulkOps()
        BulkOperations ops = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED,  "dw");
        ops.insert(dwList);
//        List<Pair<Query, Update>> list = Lists.newArrayList();
//        for(DW dw : dwList){
//            Query query = new Query(Criteria.where("id").is(dw.getId()));
//            Update update = new Update();
//            update.set("lng", dw.getLng());
//            update.set("lat", dw.getLat());
//            update.set("lac", dw.getLac());
//            update.set("ci", dw.getCi());
//            update.set("area", dw.getArea());
//            update.set("createTime", dw.getCreateTime());
//            update.set("pcsCode", dw.getPcsCode());
//            Pair<Query, Update> pair = Pair.of(query, update);
//            list.add(pair);
//        }
//        ops.updateMulti(list);
        ops.execute();
    }


    private DW getDwFromList(List<SyncDwVO> dwVOS, ArrayListMultimap<String, PoliceSubstationInfo> multimap,
                             Map<String, String> pcsToAreaMap){
        SyncDwVO sdv = dwVOS.get(random.nextInt(dwVOS.size()));
        DW dw = new DW();
        //dw.setLng(Double.valueOf(sdv.getCiLng()));
        //dw.setLat(Double.valueOf(sdv.getCiLat()));
        dw.setLac(sdv.getLacCode());
        dw.setCi(sdv.getCiCode());
        dw.setArea(sdv.getAreaName());

        //获取当前所在区域
        if(multimap.containsKey(sdv.getAreaCode())){
            //获取当前所在区域的派出所
            List<PoliceSubstationInfo> pcsList = multimap.get(sdv.getAreaCode());
            //计算可能的派出所  最近的一个
            PoliceSubstationInfo psi = pcsList.get(random.nextInt(pcsList.size()));
            dw.setPcsCode(psi.getPcscode());
            BigDecimal bgLng = new BigDecimal(random.nextInt(20)*0.004/2);
            double deltaLng = bgLng.setScale(7, BigDecimal.ROUND_HALF_UP).doubleValue();
            BigDecimal bgLat = new BigDecimal(random.nextInt(20)*0.004/2);
            double deltaLat = bgLat.setScale(7, BigDecimal.ROUND_HALF_UP).doubleValue();

            if(random.nextBoolean()){
                deltaLat = -deltaLat;
            }
            if(random.nextBoolean()){
                deltaLng = -deltaLng;
            }
            dw.setLng(psi.getLng() + deltaLng);
            dw.setLat(psi.getLat() + deltaLat);
        }else {
            return null;
        }

        return dw;
    }



    private ArrayListMultimap<String, PoliceSubstationInfo> getPcsMap() {
        List<PoliceSubstationInfo> pcStationList = policeSubstationInfoMapper.getAll();

        ArrayListMultimap<String, PoliceSubstationInfo> multimap =
                ArrayListMultimap.create(60, 50);

        for (PoliceSubstationInfo pcsInfo : pcStationList){
            String regionStr = pcsInfo.getRegion();
            String[] strArr = regionStr.split(",");
            List<double[]> pointList = Lists.newArrayList();
//            for (int i = 0; i < strArr.length / 2; i++) {
//                double[] pointArr = new double[2];
//                pointArr[0] = Double.parseDouble(strArr[2*i]);
//                pointArr[1] = Double.parseDouble(strArr[2*i +1]);
//                pointList.add(pointArr);
//            }
            pcsInfo.setPointList(pointList);
            multimap.put(pcsInfo.getAreacode(), pcsInfo);
        }
        return multimap;
    }

    private Map<String, String> getPcsToAreaMap(){
        List<PoliceSubstationInfo> pcStationList = policeSubstationInfoMapper.getAll();

        Map<String, String> resMap = Maps.newHashMap();

        for (PoliceSubstationInfo pcsInfo : pcStationList){

            resMap.put( pcsInfo.getPcscode(), pcsInfo.getAreacode());
        }
        return resMap;
    }



}
