package com.example.study.dqjc;



import com.alibaba.fastjson.JSON;
import com.example.study.mapper.dqjc.CreditDailyTmpMapper;
import com.example.study.mapper.dqjc.CreditScoreMapper;
import com.example.study.mapper.dqjc.PhoneInfoMapper;
import com.example.study.mapper.dqjc.SyncDwMapper;
import com.example.study.mapper.dqjc.SysDictMapper;
import com.example.study.model.dqjc.CreditDailyTmp;
import com.example.study.model.dqjc.CreditScore;
import com.example.study.model.dqjc.DW;
import com.example.study.model.dqjc.PhoneInfo;
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
import com.example.study.Application;
import com.example.study.mapper.dqjc.CreditDailyTmpMapper;
import com.example.study.mapper.dqjc.CreditScoreMapper;
import com.example.study.mapper.dqjc.PoliceSubstationInfoMapper;
import com.example.study.mapper.dqjc.SyncDwMapper;
import com.example.study.mapper.dqjc.SysDictMapper;
import com.example.study.model.dqjc.CreditDailyTmp;
import com.example.study.model.dqjc.CreditScore;
import com.example.study.model.dqjc.DW;
import com.example.study.model.dqjc.PhoneInfo;
import com.example.study.mapper.dqjc.PhoneInfoMapper;
import com.example.study.model.dqjc.PoliceSubstationInfo;
import com.example.study.model.sys.SysDict;
import com.example.study.utils.ChineseNameUtil;
import com.example.study.utils.CreateIdcardUtil;
import com.example.study.vo.SyncDwVO;
import com.example.study.vo.SysDictVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProduceData {

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

    private List<String> actionList = Arrays.asList("上网","开车", "吃饭", "写代码",
            "写bug", "调戏测试", "睡觉", "逛街", "买东西","上馆子","坐公交","喝茶","打测试",
            "请假","玩LOL");
//
//    private String[] nameAt

    @Test
    public void insertPhoneInfo(){
        //List<SysDictVO> dictVOList = sysDictMapper.getSysDict("areaName");
        List<PoliceSubstationInfo> pcStationList = policeSubstationInfoMapper.getAll();

        Set<String> filterSet = Sets.newHashSet();
        List<PhoneInfo> phoneInfoList = Lists.newArrayList();
        for (int i = 1; i <= 500000; i++) {
            PhoneInfo pi = new PhoneInfo();
            pi.setId(String.valueOf(i));
            pi.setPhone(getPhone(filterSet));
            pi.setPname(ChineseNameUtil.getName());
            pi.setIdcard(CreateIdcardUtil.getRandomID());
            pi.setSex(random.nextInt(2));
            pi.setSdrole("111000");
            pi.setSdstatus("000111");
            PoliceSubstationInfo pcStaionInfo = pcStationList.get(random.nextInt(pcStationList.size()));
            pi.setAreaCode(pcStaionInfo.getAreacode());
            pi.setAreaname(null);
            pi.setSubstationname(pcStaionInfo.getPcsname());
            pi.setSubstationid(pcStaionInfo.getPcscode());

            pi.setIsgy(random.nextInt(2));
            pi.setIsyx(random.nextInt(2));
            pi.setIszk(random.nextInt(2));

            //phoneInfoMapper.insert(pi);
            phoneInfoList.add(pi);
            if(phoneInfoList.size() >= 1000){
                phoneInfoMapper.batchInsert(phoneInfoList);
                phoneInfoList.clear();
            }
        }
        if(phoneInfoList.size() > 0){
            phoneInfoMapper.batchInsert(phoneInfoList);
            phoneInfoList.clear();
        }

    }

    @Test
    public void insertScore(){
        Date curDate = new Date();
        List<PhoneInfo> phoneList = phoneInfoMapper.getList();
        List<CreditScore> list = Lists.newArrayList();
        for(PhoneInfo pi : phoneList){
            if(random.nextBoolean()){
                continue;
            }
            CreditScore cs = new CreditScore();
            cs.setIdCard(pi.getIdcard());
            cs.setPhone(pi.getPhone());
            cs.setLevel(random.nextInt(5)+1);
            cs.setScore(1000 - cs.getLevel()*100 + random.nextInt(100));
            cs.setStatus(0);
            cs.setCreatetime(curDate);
            list.add(cs);
            //scoreMapper.insert(cs);
            if(list.size() > 1000){
                scoreMapper.batchInsert(list);
                list.clear();
            }
        }
        if(list.size() > 0){
            scoreMapper.batchInsert(list);
            list.clear();
        }
    }

    @Test
    public void insertDaily() {
        Date curDate = new Date();
        List<PhoneInfo> phoneList = phoneInfoMapper.getList();
        List<CreditDailyTmp> list = Lists.newArrayList();
        for (PhoneInfo pi : phoneList) {
            for (int i = 0; i < 10; i++) {
                CreditDailyTmp cdt = new CreditDailyTmp();
                cdt.setIdCard(pi.getIdcard());
                cdt.setCreatetime(curDate);
                cdt.setContent(getActionContent());
                //cdt.setActiontime(new Date(curDate.getTime() - (long)random.nextInt(10000000)*1000));
                cdt.setActiontime(new Date(curDate.getTime() - (long)(random.nextInt(3)+2)*86400*1000));
                //dailyTmpMapper.insert(cdt);
                list.add(cdt);
            }
            if(list.size() > 1000){
                dailyTmpMapper.batchInsert(list);
                list.clear();
            }
        }
        if(list.size() > 0){
            dailyTmpMapper.batchInsert(list);
            list.clear();
        }
    }

    @Test
    public void insertWarning() {
        Date curDate = new Date();
        List<PhoneInfo> phoneList = phoneInfoMapper.getList();
        List<CreditDailyTmp> list = Lists.newArrayList();
        for (PhoneInfo pi : phoneList) {
            for (int i = 0; i < 10; i++) {
                CreditDailyTmp cdt = new CreditDailyTmp();
                cdt.setIdCard(pi.getIdcard());
                cdt.setCreatetime(curDate);
                cdt.setContent(getActionContent());
                //cdt.setActiontime(new Date(curDate.getTime() - (long)random.nextInt(10000000)*1000));
                cdt.setActiontime(new Date(curDate.getTime() - (long)(random.nextInt(3)+2)*86400*1000));
                //dailyTmpMapper.insert(cdt);
                list.add(cdt);
            }
            if(list.size() > 1000){
                dailyTmpMapper.batchInsert(list);
                list.clear();
            }
        }
        if(list.size() > 0){
            dailyTmpMapper.batchInsert(list);
            list.clear();
        }
    }

    @Test
    public void insertLoation(){
        Date curDate = new Date();
        List<SyncDwVO> dwList = dwMapper.getList();
        List<PhoneInfo> phoneList = phoneInfoMapper.getList();
        ArrayListMultimap<String, PoliceSubstationInfo> pcsMulitumap = getPcsMap();

        List<DW> list = Lists.newArrayList();


        for(PhoneInfo pi : phoneList){
            DW dw = getDwFromList(dwList, pcsMulitumap);
            dw.setId(pi.getPhone());
            dw.setpName(pi.getPname());
            dw.setIsZk(pi.getIszk());
            dw.setIsGy(pi.getIsgy());
            dw.setIsYx(pi.getIsyx());
            dw.setCreateTime(curDate.getTime()/1000 + random.nextInt(3600*24*100));
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

    private String getPhone(Set<String> filterSet){
        String str = null;
        while (true){
            str ="1"  + String.valueOf(random.nextInt(10)) + Strings.padStart(String.valueOf(random.nextInt(1000000000)), 9, '0');
            if(!filterSet.contains(str)){
                filterSet.add(str);
                break;
            }
        }
        return str;
    }


    private void batchSaveToMonogDb(List<DW> dwList){
        //        BulkOperations.BulkMode bulkMode = new BulkOperations();
//        mongoTemplate.bulkOps()
        BulkOperations ops = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED,  "dw");
//        for (DW dw : dwList) {
//
//            //我用的insert方法
//            //注意此处的obj必须是一个DBObject，可以是json对象也可以的bson对象，entity没有试过
//            ops.insert(dw);
//            //ops.insert(Object obj);
//        }
        //循环插完以后批量执行提交一下ok！
        ops.insert(dwList);
        ops.execute();
    }


    private DW getDwFromList(List<SyncDwVO> dwVOS, ArrayListMultimap<String, PoliceSubstationInfo> multimap){
        SyncDwVO sdv = dwVOS.get(random.nextInt(dwVOS.size()));
        DW dw = new DW();
        dw.setLng(Double.valueOf(sdv.getCiLng()));
        dw.setLat(Double.valueOf(sdv.getCiLat()));
        dw.setLac(sdv.getLacCode());
        dw.setCi(sdv.getCiCode());
        dw.setArea(sdv.getAreaName());
        dw.setAreaId(sdv.getAreaCode());

        if(multimap.containsKey(dw.getAreaId())){
            List<PoliceSubstationInfo> pcsList = multimap.get(dw.getAreaId());
            String pcsId = findPcsId(pcsList, dw.getLng(), dw.getLat());
            String ownId = pcsList.get(random.nextInt(pcsList.size())).getPcscode();
            if(pcsId.startsWith("$")) {
                String tmpStr = pcsId.substring(1);
                dw.setLocPcsId(tmpStr);
                dw.setOwnPcsId(tmpStr);
            }else {
                dw.setLocPcsId(pcsId);
                if(random.nextBoolean()){
                    dw.setOwnPcsId(pcsId);
                }else {
                    dw.setOwnPcsId(ownId);
                }
            }
        }

        return dw;
    }


    private String getActionContent(){
        return actionList.get(random.nextInt(actionList.size()));
    }



    @Test
    public void updatePersonPCs(){
        List<PhoneInfo> list = phoneInfoMapper.getList();
        List<PoliceSubstationInfo> stationList = policeSubstationInfoMapper.getAll();
        List<SysDictVO> dictList = sysDictMapper.getSysDict("areaName");
        Map<String, String> dictMap = Maps.newHashMap();
        for (SysDictVO vo : dictList){
            dictMap.put(vo.getDictCode(), vo.getDictName());
        }

        for (PhoneInfo pi : list){
            PoliceSubstationInfo substation = stationList.get(random.nextInt(stationList.size()));
            String areaName = dictMap.get(substation.getAreacode());
            pi.setAreaCode(substation.getAreacode());
            pi.setAreaname(areaName);
            pi.setSubstationid(substation.getPcscode());
            pi.setSubstationname(substation.getPcsname());
            phoneInfoMapper.updateByPrimaryKey(pi);
        }
    }

    @Test
    public void updateAreaName(){
        List<PhoneInfo> list = phoneInfoMapper.getList();
        List<SysDictVO> dictList = sysDictMapper.getSysDict("areaName");

        for (PhoneInfo pi : list){
            SysDictVO dictVO = dictList.get(random.nextInt(dictList.size()));
            pi.setSex(random.nextInt(2));
            pi.setAreaCode(dictVO.getDictCode());
            pi.setAreaname(dictVO.getDictName());
            phoneInfoMapper.updateArea(pi);
        }

    }

    private ArrayListMultimap<String, PoliceSubstationInfo> getPcsMap() {
        List<PoliceSubstationInfo> pcStationList = policeSubstationInfoMapper.getAll();

        ArrayListMultimap<String, PoliceSubstationInfo> multimap =
                ArrayListMultimap.create(60, 50);

        for (PoliceSubstationInfo pcsInfo : pcStationList){
            String regionStr = pcsInfo.getRegion();
            String[] strArr = regionStr.split(",");
            List<double[]> pointList = Lists.newArrayList();
            for (int i = 0; i < strArr.length / 2; i++) {
                double[] pointArr = new double[2];
                pointArr[0] = Double.parseDouble(strArr[2*i]);
                pointArr[1] = Double.parseDouble(strArr[2*i +1]);
                pointList.add(pointArr);
            }
            pcsInfo.setPointList(pointList);
            multimap.put(pcsInfo.getAreacode(), pcsInfo);
        }
        return multimap;
    }

    private String findPcsId( List<PoliceSubstationInfo> pcStationList, double lon, double lat){
        String nearPcsId = null;
        double distance = 0;
        for(PoliceSubstationInfo pcsInfo : pcStationList){
            if(AxisTool.isInArea(pcsInfo.getPointList(), lon, lat)){
                return pcsInfo.getPcscode();
            }
            double tmp = AxisTool.distanceOfTwoPoints(pcsInfo.getLng(), pcsInfo.getLat(), lon, lat);
            if(distance == 0 || tmp < distance){
                nearPcsId = pcsInfo.getPcscode();
            }
        }
        return "$" +nearPcsId;
    }

}
