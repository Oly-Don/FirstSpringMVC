package com.set.tools;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ApacheHttpclientTest {


    private String uri;

    @Test
    public void testClient() {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("https://www.baidu.com/");
        try {
            CloseableHttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() throws UnsupportedEncodingException {
        uri = "http://192.168.0.135:8080/customs/rest/custjson/addPubOrder.do";
        List<BasicNameValuePair> paramList = new ArrayList<BasicNameValuePair>();
        paramList.add(new BasicNameValuePair("a", "1"));
        paramList.add(new BasicNameValuePair("b", "2"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
        postWithEntity(uri, entity);
    }

    private void postWithEntity(String uri, HttpEntity entity) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(uri);
        post.setEntity(entity);
        try {
            CloseableHttpResponse response = client.execute(post);
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
