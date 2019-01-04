package com.example.study.uaac;



import com.example.study.utils.HttpClientsUtil;
import com.example.study.utils.JsoupUtil;
import com.google.common.collect.Maps;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
public class LoginTest {

    @Test
    public void getLoginIndex() throws Exception{
        String uaacIndexUaac = "http://172.16.16.183/uaac-server/login";
        String htmlStr = HttpClientsUtil.get(uaacIndexUaac);
        //System.out.println(htmlStr);
        Map<String, String> map = JsoupUtil.getUaacKey(htmlStr);

        String framesetUrl = "http://172.16.16.183/uaac-server/login?" +
        "service=http%3A%2F%2F172.16.16.183%2Fuaac-crm%2Fframeset.do";

        Map<String, Object> paramMap = Maps.newHashMap();

        paramMap.put("lt", map.get("lt"));
        paramMap.put("execution", map.get("execution"));
        paramMap.put("_eventId", "submit");
        paramMap.put("platform", "");
        paramMap.put("username", "sadmin");
        paramMap.put("platform", "zygl");
        paramMap.put("password", "1111");
        paramMap.put("random", "876");


        String frameOut = HttpClientsUtil.post(framesetUrl, paramMap);
        System.out.println(frameOut);





    }

    @Test
    public void loginFirst() throws IOException {
        //curl 'http://172.16.16.183/uaac-server/login?
        // service=http%3A%2F%2F172.16.16.183%2Fuaac-crm%2Fframeset.do'
        // -H 'Connection: keep-alive'
        // -H 'Cache-Control: max-age=0'
        // -H 'Origin: http://172.16.16.183'
        // -H 'Upgrade-Insecure-Requests: 1'
        // -H 'Content-Type: application/x-www-form-urlencoded'
        // -H 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.75 Safari/537.36'
        // -H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8'
        // -H 'Referer: http://172.16.16.183/uaac-server/login?service=http%3A%2F%2F172.16.16.183%2Fuaac-crm%2Fframeset.do'
        // -H 'Accept-Encoding: gzip, deflate'
        // -H 'Accept-Language: zh-CN,zh;q=0.9'
        // -H 'Cookie: JSESSIONID=23CE2F87AA8AE4D46E094F63F528F547'
        // --data 'lt=LT-2577490-hkUvB4xiovJdhyGxSNffON9nTwU5of-cas&execution=e7s1&_eventId=submit&platform=&username=sadmin&platform=zygl&password=1111&random=876'
        // --compressed


        CookieStore cookieStore = new BasicCookieStore();
        HttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        //創建一個httpGet方法

        HttpPost httpPost = new HttpPost("http://172.16.16.183/uaac-server/login?" +
                "service=http%3A%2F%2F172.16.16.183%2Fuaac-crm%2Fframeset.do");


        //設置httpGet的头部參數信息
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.setHeader("Cache-Control", "max-age=0");
        httpPost.setHeader("Origin", "http://172.16.16.183");
        httpPost.setHeader("Upgrade-Insecure-Requests", "1");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.75 Safari/537.36");
        httpPost.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpPost.setHeader("Referer", "http://172.16.16.183/uaac-server/login?service=http%3A%2F%2F172.16.16.183%2Fuaac-crm%2Fframeset.do");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpPost.setHeader("Cookie", "JSESSIONID=23CE2F87AA8AE4D46E094F63F528F547");

        Map<String, Object> paramMap = Maps.newHashMap();
        /*
        lt:LT-2577490-hkUvB4xiovJdhyGxSNffON9nTwU5of-cas
execution:e7s1
_eventId:submit
platform:
username:sadmin
platform:zygl
password:1111
random:876
         */
        paramMap.put("lt", "LT-2577490-hkUvB4xiovJdhyGxSNffON9nTwU5of-cas");
        paramMap.put("execution", "e7s1");
        paramMap.put("_eventId", "submit");
        paramMap.put("platform", "");
        paramMap.put("username", "sadmin");
        paramMap.put("platform", "zygl");
        paramMap.put("password", "1111");
        paramMap.put("random", "876");

        //HttpClientsUtil.setPostParams(httpPost, paramMap);

        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost,
                    HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);

            List<Cookie> cookies = cookieStore.getCookies();
            for (int i = 0; i < cookies.size(); i++) {
                if (cookies.get(i).getName().equals("JSESSIONID")) {
                    System.out.println("JESSIONID = " + cookies.get(i).getValue());
                }
                if (cookies.get(i).getName().equals("CASTGC")) {
                    System.out.println("CASTGC = " + cookies.get(i).getValue());
                }
            }

        } catch (Exception e) {
            throw e;
        } finally {

            if (response != null) {
                Header[] headers = response.getAllHeaders();
                Arrays.asList(headers).forEach(e -> System.out.println(e.getName() + "-------" + e.getValue()));
            }


        }
    }
}
