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
public class UpdateData {

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


    @Test
    public void updatePersonPCs(){
        List<PhoneInfo> list = phoneInfoMapper.getList();
        //List<PoliceSubstationInfo> stationList = policeSubstationInfoMapper.getAll();
        List<SysDictVO> dictList = sysDictMapper.getSysDict("areaName");
        Map<String, String> dictMap = Maps.newHashMap();
        for (SysDictVO vo : dictList){
            dictMap.put(vo.getDictCode(), vo.getDictName());
        }
        ArrayListMultimap<String, PoliceSubstationInfo> pcsMap = getPcsMap();

        for (PhoneInfo pi : list){
            String areaCode = pi.getAreaCode();
            if(pcsMap.containsKey(areaCode)) {
                List<PoliceSubstationInfo> pl = pcsMap.get(areaCode);
                    int n = pl.size();
                    int i = random.nextInt(n);
                    PoliceSubstationInfo psi = pl.get(i);
                    pi.setControlStationId(psi.getPcscode());
                    pi.setControlStationName(psi.getPcsname());
                    int j = random.nextInt(3);
                    int zk = 0, yx =0, gy = 0;
                    switch(j){
                        case 0: zk = 1;break;
                        case 1: yx = 1;break;
                        case 2: gy = 1;break;
                        default:break;
                    }


                    pi.setIszk(zk);
                    pi.setIsyx(yx);
                    pi.setIsgy(gy);
                    phoneInfoMapper.updateControlIdAndName(pi);
            }
        }
    }


    private ArrayListMultimap<String, PoliceSubstationInfo> getPcsMap() {
        List<PoliceSubstationInfo> pcStationList = policeSubstationInfoMapper.getAll();

        ArrayListMultimap<String, PoliceSubstationInfo> multimap =
                ArrayListMultimap.create(60, 50);

        for (PoliceSubstationInfo pcsInfo : pcStationList){
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
