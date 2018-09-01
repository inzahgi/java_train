package com.iflytek.fwpt.xxx;

import com.iflytek.fwpt.utils.HttpClientsUtil;
import org.apache.commons.lang3.StringUtils;
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
                    int i = 0;
                    for (Node recNode : tempList){
                        if(recNode instanceof Element){
                            if(((Element) recNode).hasClass("f_red") ||
                                    ((Element) recNode).hasClass("f_blue") ||
                                    ((Element) recNode).hasClass("ball_red") ||
                                    ((Element) recNode).hasClass("ball_blue")) {

                                Attributes attributes = recNode.attributes();
                                String text = ((Element) recNode).text();
                                logger.info("{}----{}", attributes.dataset(), text);
                            }
                        }
                    }
                }
            }

        }


    }

}
