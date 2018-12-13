package com.iflytek.fwpt.xml;

import com.iflytek.fwpt.model.rule.AreaListXml;
import com.iflytek.fwpt.model.rule.BorderXml;
import com.iflytek.fwpt.model.rule.CoordXml;
import com.iflytek.fwpt.model.rule.StationListXml;
import com.iflytek.fwpt.model.rule.StationXml;
import com.iflytek.fwpt.model.rule.noTargetArea.AppinfoXml;
import com.iflytek.fwpt.model.rule.noTargetArea.AppinfosXml;
import com.iflytek.fwpt.model.rule.noTargetArea.CrowdFlowXml;

import com.iflytek.fwpt.model.rule.noTargetArea.IncountwarningParamsXml;
import com.iflytek.fwpt.model.rule.noTargetArea.RiskWarningParamsXml;
import com.iflytek.fwpt.model.rule.noTargetArea.RuleXml;
import com.iflytek.fwpt.model.rule.noTargetArea.RulesXml;
import com.iflytek.fwpt.model.rule.noTargetArea.StationAreaForCrowdFlowXml;
import com.iflytek.fwpt.model.rule.noTargetArea.TargetContractLostParamsXml;
import com.iflytek.fwpt.model.rule.noTargetArea.TotalCountWarningParamsXml;
import com.iflytek.fwpt.model.rule.noTargetArea.UpdateCycleXml;
import com.iflytek.fwpt.utils.XmlUtils;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author:inzahgi
 * Date:2018/8/24
 * Time:17:53
 */

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MyBatisApplication.class)
public class CrowdFlowXmlTest {


    @Test
    public void buildXmlOne(){
        CoordXml coordXml = new CoordXml();
        coordXml.setLat("12432");
        System.out.println("\n\n\n\n");
        try {
            System.out.println(XmlUtils.beanToXml(coordXml, CoordXml.class));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param homeArea  023
     * @param productIds
     */

    public CrowdFlowXml buildCrowdFlowXml(String homeArea, String productIds, List<StationXml> coreStationList,
                List<StationXml> bufferStationXml, List<CoordXml> corerBorderList, List<CoordXml> bufferBorderList){
        CrowdFlowXml crowdFlowXml = new CrowdFlowXml();

        crowdFlowXml.setHomeArea(homeArea);

        AppinfoXml appinfoXml = new AppinfoXml();
        appinfoXml.setProdictIds(productIds);
        AppinfosXml appinfosXml = new AppinfosXml();
        appinfosXml.setAppinfo(appinfoXml);
        crowdFlowXml.setAppinfosXml(appinfosXml);

        AreaListXml areaListXml = new AreaListXml();
        StationAreaForCrowdFlowXml stationAreaXml = new StationAreaForCrowdFlowXml();



        // 核心区 基站信息
        //StationXml stationXml = new StationXml();
        StationListXml coreStationListXml = new StationListXml();
        coreStationListXml.setLocations(coreStationList);
        stationAreaXml.setCoreLocation(coreStationListXml);

        // 缓冲区 基站信息
        StationListXml bufferStationListXml = new StationListXml();
        bufferStationListXml.setLocations(bufferStationXml);
        stationAreaXml.setBufferLocation(bufferStationListXml);


        // 核心区坐标
        BorderXml corerBorderXml = new BorderXml();
        corerBorderXml.setCoords(corerBorderList);
        stationAreaXml.setCoreBorder(corerBorderXml);

        // 缓冲区坐标
        BorderXml bufferBorderXml = new BorderXml();
        bufferBorderXml.setCoords(bufferBorderList);
        stationAreaXml.setCoreBorder(bufferBorderXml);

        areaListXml.setAreas(Arrays.asList(stationAreaXml));
        crowdFlowXml.setAreaListXml(areaListXml);

        RulesXml rulesXml = new RulesXml();
        //更新时间
        RuleXml ruleOneXml = new RuleXml();
        ruleOneXml.setName("targetcontactlost");
        TargetContractLostParamsXml targetContractLostParamsXml = new TargetContractLostParamsXml();
        UpdateCycleXml updateCycleXml = new UpdateCycleXml();
        updateCycleXml.setMobile("7200");
        updateCycleXml.setTelecom("3600");
        updateCycleXml.setUnicom("3600");
        targetContractLostParamsXml.setUpdateCycleXml(updateCycleXml);
        ruleOneXml.setParams(targetContractLostParamsXml);
        rulesXml.setTargetcontactlostXml(ruleOneXml);


        //流入人数预警
        RuleXml ruleTwoXml = new RuleXml();
        ruleTwoXml.setName("incountwarning");
        IncountwarningParamsXml incountwarningParamsXml = new IncountwarningParamsXml();
        incountwarningParamsXml.setIncount("1000");
        ruleTwoXml.setParams(incountwarningParamsXml);
        rulesXml.setIncountwarningXml(ruleTwoXml);

        //区域总人数
        RuleXml ruleThreeXml = new RuleXml();
        ruleThreeXml.setParams("totalcountwarning");
        TotalCountWarningParamsXml totalCountWarningParamsXml = new TotalCountWarningParamsXml();
        totalCountWarningParamsXml.setTotalcount("23000");
        ruleThreeXml.setParams(totalCountWarningParamsXml);
        rulesXml.setTotalcountwarningXml(ruleThreeXml);

        //敏感归属地预警
        RuleXml ruleFourXml = new RuleXml();
        ruleFourXml.setName("riskwarning");
        RiskWarningParamsXml riskWarningParamsXml = new RiskWarningParamsXml();
        riskWarningParamsXml.setCount("50");
        riskWarningParamsXml.setRiskCity("0986,0987,0988,0087");
        ruleFourXml.setParams(riskWarningParamsXml);
        rulesXml.setRiskwarningXml(ruleFourXml);

        crowdFlowXml.setRulesXml(rulesXml);

        return crowdFlowXml;
    }


    @Test
    public void printTest() throws Exception{
        System.out.println("\n\n\n");
        System.out.println(XmlUtils.beanToXml(buildCrowdFlowXml("023", "1001,1002",
                Arrays.asList(new StationXml(), new StationXml()),Arrays.asList(new StationXml(), new StationXml()),
                Arrays.asList(new CoordXml(), new CoordXml()),null), CrowdFlowXml.class));
    }


    @Test
    public void mapPrintTest() throws Exception{
    }

}
