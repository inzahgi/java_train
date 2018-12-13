package com.iflytek.fwpt.uaac;

import com.iflytek.fwpt.util.HttpClientForUaacUtil;
import com.sun.tools.internal.ws.wsdl.framework.EntityAction;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author:inzahgi
 * Date:2018/12/11
 * Time:16:30
 */
@RunWith(SpringRunner.class)
public class UaacLoginTest {

    @Test
    public void getOne() throws IOException{
        System.out.println("\n\n\n======================== get login page =====================");
        String url1 = "http://172.16.16.183/uaac-server/login?p=&loginType=&service=";
        CloseableHttpResponse  response1 = HttpClientForUaacUtil.get(url1);

        if (response1 != null){
            HttpEntity entity =  response1.getEntity();  //获取网页内容

            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("网页内容:"+result);
        }
//        if (response1 != null){
//            response1.close();
//        }


        //EntityUtils.consume(response1.getEntity());

//        System.out.println("\n\n\n========================= captchaImg ====================");
//        String url2 = "http://172.16.16.183/uaac-server/captchaImg";
//        CloseableHttpResponse response2 = HttpClientForUaacUtil.get(url2);




//        System.out.println("\n\n\n========================= login  ====================");
//        String url3 = "http://172.16.16.183/uaac-server/login";
//        CloseableHttpResponse response3 = HttpClientForUaacUtil.get(url2);
//



//        System.out.println("\n\n\n========================= imageServlet  ====================");
//        String url4 = "http://172.16.16.183/uaac-server/imageServlet?now=" + System.currentTimeMillis()/1000;
//        CloseableHttpResponse response4 = HttpClientForUaacUtil.get(url4);
//
//        System.out.println("\n\n\n========================= login  ====================");
//        String url5 = "http://172.16.16.183/uaac-server/login?p=&loginType=&service=";
//        String param5 = "lt=LT-2579153-bet9BpbePRtiqlQROysX7THf2a6oEl-cas&execution=e5s1&_eventId=submit&platform=&"
//                + "username=sadmin&platform=zygl&password=1111&random=1102";
//        CloseableHttpResponse response5 = HttpClientForUaacUtil.post(url5, param5);



    }



}
