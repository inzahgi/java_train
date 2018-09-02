package com.iflytek.fwpt.xxx;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.iflytek.fwpt.utils.HttpClientsUtil;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class CrawlerTest {

    private static Logger logger = LoggerFactory.getLogger(CrawlerTest.class);

    private static String CAIPI_163= "http://trend.caipiao.163.com/dlt/";

    public static void main(String[] args) {
        String htmlStr = HttpClientsUtil.get(CAIPI_163);
//        System.out.println(htmlStr);

        //Document doc = Jsoup.parse(new HtmlSource().HTML);
        Document doc = Jsoup.parse(htmlStr.trim());
        Element totalElement = doc.getElementById("cpdata");
        //System.out.println(ele.childNodeSize());
        List<Node> nodesList = totalElement.childNodes();

        for(Node node : nodesList){
            if( node instanceof  TextNode){
                continue;
            }
            if( node instanceof Element) {
                //System.out.println(node.toString());
                System.out.println("\n\n\n");
                //break;
                List<Node> recList = ((Element) node).childNodes();
                if (node instanceof Element){
                    List<Node> tempList = node.childNodes();
                    int redIndex = 0;
                    int blueIndex = 0;
                    Map<String, List<String>> resMap = Maps.newHashMap();

                    for (Node recNode : tempList){
                        if(recNode instanceof Element){
                            if(((Element) recNode).hasClass("f_red") ||
                                    ((Element) recNode).hasClass("f_blue") ||
                                    ((Element) recNode).hasClass("ball_red") ||
                                    ((Element) recNode).hasClass("ball_blue")) {


                                Attributes attributes = recNode.attributes();
                                String text = ((Element) recNode).text();
                                String className = ((Element) recNode).className();
                                logger.info("{}----{}------{}", attributes.dataset(), className, text);


                                addRes(resMap, text, className);

//                                if(((Element) recNode).hasClass("f_red")){
//                                    addRes(resMap, "f_red", text);
//                                }


                            }
                        }
                    }
                    logger.info("\n{}", resMap);
                }
            }

        }


    }


    private static Map<String, List<String>> addRes(Map<String, List<String>> resMap, String text, String key){
        if(resMap.containsKey(key)){
            resMap.get(key).add(text);
        }else {
            List<String> list = Lists.newArrayList(text);
            resMap.put(key, list);
        }
        return resMap;
    }

}
