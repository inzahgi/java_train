package com.iflytek.fwpt.dqjc;


import Guava.common.base.Strings;
import Guava.common.collect.Sets;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iflytek.fwpt.Application;
import com.iflytek.fwpt.mapper.dqjc.CreditDailyTmpMapper;
import com.iflytek.fwpt.mapper.dqjc.CreditScoreMapper;
import com.iflytek.fwpt.mapper.dqjc.PoliceSubstationInfoMapper;
import com.iflytek.fwpt.mapper.dqjc.SyncDwMapper;
import com.iflytek.fwpt.mapper.dqjc.SysDictMapper;
import com.iflytek.fwpt.model.dqjc.CreditDailyTmp;
import com.iflytek.fwpt.model.dqjc.CreditScore;
import com.iflytek.fwpt.model.dqjc.DW;
import com.iflytek.fwpt.model.dqjc.PhoneInfo;
import com.iflytek.fwpt.mapper.dqjc.PhoneInfoMapper;
import com.iflytek.fwpt.model.dqjc.PoliceSubstationInfo;
import com.iflytek.fwpt.model.sys.SysDict;
import com.iflytek.fwpt.utils.ChineseNameUtil;
import com.iflytek.fwpt.utils.CreateIdcardUtil;
import com.iflytek.fwpt.vo.SyncDwVO;
import com.iflytek.fwpt.vo.SysDictVO;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
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
        Set<String> filterSet = Sets.newHashSet();
        List<PhoneInfo> phoneInfoList = Lists.newArrayList();
        for (int i = 1; i <= 10000; i++) {
            PhoneInfo pi = new PhoneInfo();
            pi.setId(String.valueOf(i));
            pi.setPhone(getPhone(filterSet));
            pi.setPname(ChineseNameUtil.getName());
            pi.setIdcard(CreateIdcardUtil.getRandomID());
            pi.setSex(random.nextInt(2));
            pi.setSdrole("111000");
            pi.setSdstatus("000111");
            pi.setAreaCode(random.nextInt(2) == 1 ? "4":"1");
            if(pi.getAreaCode().equals("4")){
                pi.setAreaname("沙坪坝区");
                pi.setSubstationid("5001060002");
                pi.setSubstationname("沙坪坝派出所");
            }else if(pi.getAreaCode().equals("1")){
                pi.setAreaname("渝中区");
                pi.setSubstationid("5001030017");
                pi.setSubstationname("朝天门派出所");
            }

            pi.setIsgy(random.nextInt(2));
            pi.setIsyx(random.nextInt(2));
            pi.setIszk(random.nextInt(2));

            phoneInfoMapper.insert(pi);
            //phoneInfoMapper.getList();
        }

    }

    @Test
    public void insertScore(){
        Date curDate = new Date();
        List<PhoneInfo> phoneList = phoneInfoMapper.getList();
        List<CreditScore> list = Lists.newArrayList();
        for(PhoneInfo pi : phoneList){
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
            for (int i = 0; i < 100; i++) {
                CreditDailyTmp cdt = new CreditDailyTmp();
                cdt.setIdCard(pi.getIdcard());
                cdt.setCreatetime(curDate);
                cdt.setContent(getActionContent());
                cdt.setActiontime(new Date(curDate.getTime() - (long)random.nextInt(10000000)*1000));
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
        List<DW> list = Lists.newArrayList();


        for(PhoneInfo pi : phoneList){
            DW dw = getDwFromList(dwList);
            dw.setId(pi.getPhone());
            dw.setpName(pi.getPname());
            dw.setIsZk(pi.getIszk());
            dw.setIsGy(pi.getIsgy());
            dw.setIsYx(pi.getIsyx());
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


    private DW getDwFromList(List<SyncDwVO> dwVOS){
        SyncDwVO sdv = dwVOS.get(random.nextInt(dwVOS.size()));
        DW dw = new DW();
        dw.setLng(Double.valueOf(sdv.getCiLng()));
        dw.setLat(Double.valueOf(sdv.getCiLat()));
        dw.setLac(sdv.getLacCode());
        dw.setCi(sdv.getCiCode());
        dw.setArea(sdv.getCityName());
        dw.setAreaId(dw.getArea().equals("渝中区")? "1" : "4");
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


}
