package com.example.study.dqjc;



import com.alibaba.fastjson.JSON;
import com.example.study.mapper.dqjc.CreditDailyTmpMapper;
import com.example.study.mapper.dqjc.CreditScoreMapper;
import com.example.study.mapper.dqjc.PhoneInfoMapper;
import com.example.study.mapper.dqjc.SyncDwMapper;
import com.example.study.mapper.dqjc.SysDictMapper;
import com.example.study.model.dqjc.CreditDailyTmp;
import com.example.study.model.dqjc.CreditPerson;
import com.example.study.model.dqjc.CreditScore;
import com.example.study.model.dqjc.DW;
import com.example.study.model.dqjc.PhoneInfo;
import com.example.study.utils.AxisTool;
import com.example.study.utils.ChineseNameUtil;
import com.example.study.utils.CreateIdcardUtil;
import com.example.study.utils.TimeUtil;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

//    private List<String> actionList = Arrays.asList("上网","开车", "吃饭", "写代码",
//            "写bug", "调戏测试", "睡觉", "逛街", "买东西","上馆子","坐公交","喝茶","打测试",
//            "请假","玩LOL");
//
    private List<String> actionList = Arrays.asList("注射类，海洛因","滥用阿片类人员","滥用冰毒人员",
        "滥用K粉人员","滥用其他毒品人员","与涉毒人员同上网","与涉毒人员同坐火车或飞机","本地户籍人员入住本地旅店",
        "尿检呈阳性","涉毒前科记录","涉毒人员近亲","刑嫌人员前科记录","涉毒人员同住人员","涉毒人员同店人员",
        "涉毒人员同案人员","与刑嫌人员同坐火车或飞机");

    private List<String> warningList = Arrays.asList(" 四级预警，分值从低级别到高级别跨级",
            " 三级预警，当前分值与1周内分值之差大于70分",
            " 三级预警，连续1周时间，分值保持在较高及以上",
            " 二级预警，连续5周的时间，分值保持在极高级别",
            " 一级预警，匹配在逃人员");


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

        List<PhoneInfo> phoneList = getPhoneList();
        List<CreditDailyTmp> list = Lists.newArrayList();

        for (PhoneInfo pi : phoneList) {

            for (int i = 0; i < 10; i++) {
                CreditDailyTmp cdt = new CreditDailyTmp();
                cdt.setIdCard(pi.getIdcard());
                cdt.setCreatetime(curDate);
                cdt.setContent(getActionContent());
                //cdt.setActiontime(new Date(curDate.getTime() - (long)random.nextInt(10000000)*1000));
                cdt.setActiontime(new Date(curDate.getTime() - (long)(random.nextInt(30)+2)*86400*1000));
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
        //List<PhoneInfo> phoneList = phoneInfoMapper.getList();
        List<PhoneInfo> phoneList = getPhoneList();
        List<CreditDailyTmp> list = Lists.newArrayList();
        for (PhoneInfo pi : phoneList) {
            for (int i = 0; i < 5; i++) {
                CreditDailyTmp cdt = new CreditDailyTmp();
                Date actionTime = new Date(curDate.getTime() - (long)(random.nextInt(30)+2)*86400*1000);
                String timePrefix = TimeUtil.dateToStr(actionTime, "yyyy-MM-dd");
                cdt.setIdCard(pi.getIdcard());
                cdt.setCreatetime(curDate);
                cdt.setContent(timePrefix + getWarningContent());
                //cdt.setActiontime(new Date(curDate.getTime() - (long)random.nextInt(10000000)*1000));
                cdt.setActiontime(actionTime);
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
    public void insertOriginLoation(){
        Date curDate = new Date();
        List<SyncDwVO> dwList = dwMapper.getList();
        //List<PhoneInfo> phoneList = phoneInfoMapper.getList();
        CreditPerson cpQuery = CreditPerson.CreditPersonBuilder.aCreditPerson()
                .status(1).build();
        List<CreditPerson> scoreList = scoreMapper.getList(cpQuery);
        ArrayListMultimap<String, PoliceSubstationInfo> pcsMulitumap = getPcsMap();
        Map<String, String> pcsToAreaMap = getPcsToAreaMap();

        List<DW> list = Lists.newArrayList();

        for(CreditPerson cp : scoreList){
            DW dw = getDwFromList(dwList, pcsMulitumap, pcsToAreaMap);
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

//    @Test
//    public void insertNewLoation(){
//        Date curDate = new Date();
//        List<SyncDwVO> dwList = dwMapper.getList();
//        List<PhoneInfo> phoneList = phoneInfoMapper.getList();
//        ArrayListMultimap<String, PoliceSubstationInfo> pcsMulitumap = getPcsMap();
//        Map<String, String> pcsToAreaMap = getPcsToAreaMap();
//
//        List<DW> list = Lists.newArrayList();
//
//
//        for(PhoneInfo pi : phoneList){
//            DW dw = getDwFromList(dwList, pcsMulitumap, pcsToAreaMap);
//            dw.setId(pi.getPhone());
//            dw.setLevel(String.valueOf(random.nextInt(5) +1));
//            dw.setpName(pi.getPname());
//            dw.setIdcard(pi.getIdcard());
//            dw.setScore(random.nextInt(1000)+1);
//            dw.setIsZk(pi.getIszk());
//            dw.setIsGy(pi.getIsgy());
//            dw.setIsYx(pi.getIsyx());
//            dw.setCreateTime(curDate.getTime()/1000 + random.nextInt(3600*24*100));
//            list.add(dw);
//            if(list.size() > 1000){
//                batchSaveToMonogDb(list);
//                list.clear();
//            }
//        }
//        if(list.size() > 0){
//            batchSaveToMonogDb(list);
//            list.clear();
//        }
//    }

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
        BulkOperations ops = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED,  "dw_origin");
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


    private DW getDwFromList(List<SyncDwVO> dwVOS, ArrayListMultimap<String, PoliceSubstationInfo> multimap,
                             Map<String, String> pcsToAreaMap){
        SyncDwVO sdv = dwVOS.get(random.nextInt(dwVOS.size()));
        DW dw = new DW();
        dw.setLng(Double.valueOf(sdv.getCiLng()));
        dw.setLat(Double.valueOf(sdv.getCiLat()));
        dw.setLac(sdv.getLacCode());
        dw.setCi(sdv.getCiCode());
        dw.setArea(sdv.getAreaName());

        //获取当前所在区域
        if(multimap.containsKey(sdv.getAreaCode())){
            //获取当前所在区域的派出所
            List<PoliceSubstationInfo> pcsList = multimap.get(sdv.getAreaCode());
            //计算可能的派出所  最近的一个
            String pcsId = findPcsId(pcsList, dw.getLng(), dw.getLat());
            //todo  由phone_info带入
            //String ownId = pcsList.get(random.nextInt(pcsList.size())).getPcscode();
            //说明没有找到当前位置归属派出所
            if(pcsId.startsWith("$")) {
                String tmpStr = pcsId.substring(1);
                dw.setPcsCode(tmpStr);
            }else {
                //设置当前位置归属派出所
                dw.setPcsCode(pcsId);

            }
        }

        return dw;
    }

//    private DW getDwFromList(List<SyncDwVO> dwVOS, ArrayListMultimap<String, PoliceSubstationInfo> multimap,
//                             Map<String, String> pcsToAreaMap){
//        SyncDwVO sdv = dwVOS.get(random.nextInt(dwVOS.size()));
//        DW dw = new DW();
//        dw.setLng(Double.valueOf(sdv.getCiLng()));
//        dw.setLat(Double.valueOf(sdv.getCiLat()));
//        dw.setLac(sdv.getLacCode());
//        dw.setCi(sdv.getCiCode());
//        dw.setArea(sdv.getAreaName());
//        dw.setAreaId(sdv.getAreaCode());
//        dw.setCurAreaId(sdv.getAreaCode());
//
//        //获取当前所在区域
//        if(multimap.containsKey(dw.getAreaId())){
//            //获取当前所在区域的派出所
//            List<PoliceSubstationInfo> pcsList = multimap.get(dw.getAreaId());
//            //计算可能的派出所  最近的一个
//            String pcsId = findPcsId(pcsList, dw.getLng(), dw.getLat());
//            //todo  由phone_info带入
//            String ownId = pcsList.get(random.nextInt(pcsList.size())).getPcscode();
//            //说明没有找到当前位置归属派出所
//            if(pcsId.startsWith("$")) {
//                String tmpStr = pcsId.substring(1);
//                dw.setCurPcsId(tmpStr);
//                dw.setOwnPcsId(tmpStr);
//            }else {
//                //设置当前位置归属派出所
//                dw.setCurPcsId(pcsId);
//                //随机  同时属于这个派出所
//                if(random.nextBoolean()){
//                    dw.setOwnPcsId(pcsId);
//                }else {
//                    //制造流入数据
//                    dw.setOwnPcsId(ownId);
//                }
//            }
//            //dw.setOwnAreaId(pcsToAreaMap.get(dw.getOwnPcsId()));
//            dw.setOwnAreaId(dw.getOwnPcsId().substring(0, 6));
//        }
//
//        return dw;
//    }

    private String getWarningContent(){
        return warningList.get(random.nextInt(warningList.size()));
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

    private Map<String, String> getPcsToAreaMap(){
        List<PoliceSubstationInfo> pcStationList = policeSubstationInfoMapper.getAll();

        Map<String, String> resMap = Maps.newHashMap();

        for (PoliceSubstationInfo pcsInfo : pcStationList){

            resMap.put( pcsInfo.getPcscode(), pcsInfo.getAreacode());
        }
        return resMap;
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

    private List<PhoneInfo> getPhoneList(){
        List<PhoneInfo> phoneList = phoneInfoMapper.getList();

        List<String> list = scoreMapper.getIdCardList();
        Set<String> set = Sets.newHashSet(list);
        List<PhoneInfo> resList = Lists.newArrayList();
        for (PhoneInfo pi : phoneList){
            if(set.contains(pi.getIdcard())){
                resList.add(pi);
            }
        }
        return resList;
    }

}
