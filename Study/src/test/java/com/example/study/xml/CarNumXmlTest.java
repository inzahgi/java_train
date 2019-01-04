package com.example.study.xml;


import com.example.study.model.rule.AreaListXml;
import com.example.study.model.rule.BorderXml;
import com.example.study.model.rule.CoordXml;
import com.example.study.model.rule.MemberListXml;
import com.example.study.model.rule.MemberXml;
import com.example.study.model.rule.StationListXml;
import com.example.study.model.rule.StationXml;
import com.example.study.model.rule.hasTargetArea.AddrXml;
import com.example.study.model.rule.hasTargetArea.AddressXml;
import com.example.study.model.rule.hasTargetArea.CarNumXml;
import com.example.study.model.rule.hasTargetArea.CityXml;
import com.example.study.model.rule.hasTargetArea.CoreRelateAreaMemberParamsXml;
import com.example.study.model.rule.hasTargetArea.DeliveryParamsXml;
import com.example.study.model.rule.hasTargetArea.DistrictStatsParamsXml;
import com.example.study.model.rule.hasTargetArea.DynamicMembersRulesXml;
import com.example.study.model.rule.hasTargetArea.DynamicmembersXml;
import com.example.study.model.rule.hasTargetArea.HomeAreasParamsXml;
import com.example.study.model.rule.hasTargetArea.IgnoreMembersParamsXml;
import com.example.study.model.rule.hasTargetArea.NavigationParamsXml;
import com.example.study.model.rule.hasTargetArea.ReceiveaddressParamsXml;
import com.example.study.model.rule.hasTargetArea.RelateAreasParamXml;
import com.example.study.model.rule.hasTargetArea.RuleForCarNumXml;
import com.example.study.model.rule.hasTargetArea.RulesForCarNumXml;
import com.example.study.model.rule.hasTargetArea.SendCityParamsXml;
import com.example.study.model.rule.hasTargetArea.SpecialAppsParamsXml;
import com.example.study.model.rule.hasTargetArea.TargetMoveParamsXml;
import com.example.study.model.rule.hasTargetArea.UavappXml;
import com.example.study.model.rule.noTargetArea.StationAreaForCrowdFlowXml;
import com.example.study.model.rule.noTargetArea.TargetContractLostParamsXml;
import com.example.study.model.rule.noTargetArea.UpdateCycleXml;
import com.example.study.utils.XmlUtils;
import com.example.study.model.rule.AreaListXml;
import com.example.study.model.rule.BorderXml;
import com.example.study.model.rule.CoordXml;
import com.example.study.model.rule.MemberListXml;
import com.example.study.model.rule.MemberXml;
import com.example.study.model.rule.StationListXml;
import com.example.study.model.rule.StationXml;
import com.example.study.model.rule.hasTargetArea.AddrXml;
import com.example.study.model.rule.hasTargetArea.AddressXml;
import com.example.study.model.rule.hasTargetArea.CarNumXml;
import com.example.study.model.rule.hasTargetArea.CityXml;
import com.example.study.model.rule.hasTargetArea.CoreRelateAreaMemberParamsXml;
import com.example.study.model.rule.hasTargetArea.DeliveryParamsXml;
import com.example.study.model.rule.hasTargetArea.DistrictStatsParamsXml;
import com.example.study.model.rule.hasTargetArea.DynamicMembersRulesXml;
import com.example.study.model.rule.hasTargetArea.DynamicmembersXml;
import com.example.study.model.rule.hasTargetArea.HomeAreasParamsXml;
import com.example.study.model.rule.hasTargetArea.IgnoreMembersParamsXml;
import com.example.study.model.rule.hasTargetArea.NavigationParamsXml;
import com.example.study.model.rule.hasTargetArea.ReceiveaddressParamsXml;
import com.example.study.model.rule.hasTargetArea.RelateAreasParamXml;
import com.example.study.model.rule.hasTargetArea.RuleForCarNumXml;
import com.example.study.model.rule.hasTargetArea.RulesForCarNumXml;
import com.example.study.model.rule.hasTargetArea.SendCityParamsXml;
import com.example.study.model.rule.hasTargetArea.SpecialAppsParamsXml;
import com.example.study.model.rule.hasTargetArea.TargetMoveParamsXml;
import com.example.study.model.rule.hasTargetArea.UavappXml;
import com.example.study.model.rule.noTargetArea.StationAreaForCrowdFlowXml;
import com.example.study.model.rule.noTargetArea.TargetContractLostParamsXml;
import com.example.study.model.rule.noTargetArea.UpdateCycleXml;
import com.example.study.utils.XmlUtils;
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
public class CarNumXmlTest {



    public CarNumXml buildCarNumXml(List<MemberXml> memberXmlList, MemberXml ignoreMember,
                                    List<CityXml> cityXmlList, List<AddrXml> addrXmlList, List<StationXml> coreStationList,
                                    List<StationXml> bufferStationXml, List<CoordXml> corerBorderList, List<CoordXml> bufferBorderList){
        CarNumXml carNumXml = new CarNumXml();

        //members  车牌
        MemberListXml memberListXml = new MemberListXml();
        memberListXml.setMembers(memberXmlList);
        carNumXml.setMemberListXml(memberListXml);

        //dynamicMembers
        DynamicMembersRulesXml dynamicMembersRulesXml = new DynamicMembersRulesXml();
        //--- homeAreas
        HomeAreasParamsXml homeAreasParamsXml = new HomeAreasParamsXml();
        homeAreasParamsXml.setHomeAreas("020,029,0478");
        dynamicMembersRulesXml.setHomeareamembersXml(new RuleForCarNumXml<>("homeareamembers", homeAreasParamsXml));

        //---- 对端号码的归属地
        RelateAreasParamXml relateAreasParamXml = new RelateAreasParamXml();
        relateAreasParamXml.setRelateAreas("020,029,0478");
        dynamicMembersRulesXml.setRelateareamembersXml(new RuleForCarNumXml<>("relateareamembers", relateAreasParamXml));

        //----- 忽略目标
        IgnoreMembersParamsXml ignoreMembersParamsXml = new IgnoreMembersParamsXml();
        ignoreMembersParamsXml.setMemberXml(ignoreMember);
        dynamicMembersRulesXml.setIgnoremembersXml(new RuleForCarNumXml<>("ignoremembers", ignoreMembersParamsXml));

        //------ 特殊app
        SpecialAppsParamsXml specialAppsParamsXml = new SpecialAppsParamsXml();
        specialAppsParamsXml.setUavappXml(new UavappXml("23453,53553,634432"));
        specialAppsParamsXml.setValidtime("30");
        dynamicMembersRulesXml.setSpecialappsXml(new RuleForCarNumXml<>("specialapps", specialAppsParamsXml));

        //------- 核心区与敏感地区通连
        CoreRelateAreaMemberParamsXml coreRelateAreaMemberParamsXml = new CoreRelateAreaMemberParamsXml();
        coreRelateAreaMemberParamsXml.setRelateareas("020,029,0478");
        coreRelateAreaMemberParamsXml.setAreaid("area1,area2");
        coreRelateAreaMemberParamsXml.setValidtime("30");
        dynamicMembersRulesXml.setCoreRelateareamembersXml(new RuleForCarNumXml<>("relateareamembers", coreRelateAreaMemberParamsXml));


        //------ 导航
        NavigationParamsXml navigationParamsXml = new NavigationParamsXml();
        navigationParamsXml.setAreaid("area1, area2");
        navigationParamsXml.setValidtime("30");
        dynamicMembersRulesXml.setNavigationXml(new RuleForCarNumXml<>("navigation", navigationParamsXml));


        //------  寄递
        DeliveryParamsXml deliveryParamsXml = new DeliveryParamsXml();
        //------------ 敏感寄件地区
        SendCityParamsXml sendCityParamsXml = new SendCityParamsXml();
        sendCityParamsXml.setCityXmlList(cityXmlList);
        deliveryParamsXml.setSendCityParamsXml(sendCityParamsXml);
        //------------- 敏感收件地区
        AddressXml addressXml = new AddressXml(addrXmlList);
        deliveryParamsXml.setReceiveaddressParamsXml(new ReceiveaddressParamsXml(addressXml));

        deliveryParamsXml.setValidtime("30");
        dynamicMembersRulesXml.setDeliveryXml(new RuleForCarNumXml<>("delivery", deliveryParamsXml));

        //区域
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
        carNumXml.setAreaListXml(areaListXml);

        RulesForCarNumXml rulesForCarNumXml = new RulesForCarNumXml();
        //在控目标失联时间设定  默认
        TargetContractLostParamsXml targetContractLostParamsXml = new TargetContractLostParamsXml();
        targetContractLostParamsXml.setUpdateCycleXml(new UpdateCycleXml());
        rulesForCarNumXml.setTargetContractLostParamsXml(new RuleForCarNumXml("targetcontactlost", targetContractLostParamsXml));

        //在控目标行政区分布统计  参数目前为空
        DistrictStatsParamsXml districtStatsParamsXml = new DistrictStatsParamsXml();
        rulesForCarNumXml.setDistrictStatParamsXml(new RuleForCarNumXml("districtstats", districtStatsParamsXml));


        //目标迁徙  默认参数
        TargetMoveParamsXml targetMoveParamsXml = new TargetMoveParamsXml();
        rulesForCarNumXml.setTargetMoveParamsXml(new RuleForCarNumXml("targetmove", targetMoveParamsXml));

        carNumXml.setRulesForCarNumXml(rulesForCarNumXml);

        carNumXml.setAppearcity("020,0755,0757");
        carNumXml.setInOutType("1");
        carNumXml.setCalType("0");
        carNumXml.setStatusHist("1");
        carNumXml.setLeaveSpan("7200");
        carNumXml.setStaySpan("14400");



        DynamicmembersXml dynamicmembersXml = new DynamicmembersXml();
        dynamicmembersXml.setDynamicMembersRulesXml(dynamicMembersRulesXml);
        carNumXml.setDynamicmembersXml(dynamicmembersXml);

        return carNumXml;

    }


    @Test
    public void printTest() throws Exception{
        System.out.println("\n\n\n");
        System.out.println(XmlUtils.beanToXml(buildCarNumXml(Arrays.asList(new MemberXml(), new MemberXml()), new MemberXml(),
                Arrays.asList(new CityXml()), Arrays.asList(new AddrXml()),
                Arrays.asList(new StationXml(), new StationXml()),Arrays.asList(new StationXml(), new StationXml()),
                Arrays.asList(new CoordXml(), new CoordXml()),null), CarNumXml.class));
    }


    @Test
    public void mapPrintTest() throws Exception{
    }

}
