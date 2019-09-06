package com.exp.zsq.io;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshengqi on 2019/4/26.
 */
public class HttpClient {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.jianshu.com/p/7a735d351391");
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        httpGet.setHeader("referer","https://www.jianshu.com/p/7a735d351391");
        httpGet.setHeader("if-none-match","W/\"53ade11a82de6f4640d384acbed4b178\"");
        httpGet.setHeader("origin","https://www.jianshu.com");
        HttpResponse response1 = httpclient.execute(httpGet);

        System.out.println(response1.getEntity());
        HttpEntity entity = response1.getEntity();
        // do something useful with the response body
        // and ensure it is fully consumed
        if (entity != null) {
            InputStream in = entity.getContent();
            InputStreamReader isr = new InputStreamReader(in);
            int s;
            s = isr.read() ;
            while (s!= -1) {
                System.out.print((char)s);
                s = isr.read() ;
            }
        }

        /*HttpPost httpPost = new HttpPost("https://www.jianshu.com/p/7a735d351391");
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("uuid", "a0ec34c7-a0f8-440e-b16d-7060004a0b51"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        httpPost.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        httpPost.setHeader("referer","https://www.jianshu.com/p/7a735d351391");
        httpPost.setHeader("if-none-match","W/\"53ade11a82de6f4640d384acbed4b178\"");
        httpPost.setHeader("origin","https://www.jianshu.com");
        CloseableHttpResponse response2 = httpclient.execute(httpPost);

        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
        }*/
    }
}
