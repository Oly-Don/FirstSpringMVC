package com.oly.icip.web;

import io.restassured.response.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.Charset;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Administrator on 2018/5/16.
 */
public class TokenApply {

    String url;
    Response res;
    MockWebServer mockWebServer;
    long starTime;

    @BeforeTest
    public void countStartTime() {
        starTime = System.currentTimeMillis();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        url = "http://124.127.246.224:8001/icippsp/rest/token/applyToken.do?comccode=1505130131";
//        url = "http://10.10.101.26:8080/icippsp/rest/token/applyToken.do?comccode=1505130131&token=qwer";
        //监听http://192.168.45.42:80/callback  等待回调。
        /*
        构建请求
         */
        MockResponse mockResponse = new MockResponse();
        mockWebServer = new MockWebServer();
        mockResponse.setBody("s").setResponseCode(200);
        /*
      方式1：  mockWebServer.enqueue(mockResponse);
      方式2：
      final Dispatcher dispatcher = new Dispatcher() {
    @Override
    public MockResponse dispatch(RecordedRequest request) throws InterruptedException {

        if (request.getPath().equals("/v1/login/auth/")){
            return new MockResponse().setResponseCode(200);
        } else if (request.getPath().equals("v1/check/version/")){
            return new MockResponse().setResponseCode(200).setBody("version=9");
        } else if (request.getPath().equals("/v1/profile/info")) {
            return new MockResponse().setResponseCode(200).setBody("{\\\"info\\\":{\\\"name\":\"Lucas Albuquerque\",\"age\":\"21\",\"gender\":\"male\"}}");
        }
        return new MockResponse().setResponseCode(404);
    }
};
       mockWebServer.setDispatcher(mockResponse);
         */

        mockWebServer.enqueue(mockResponse);
//        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody("success"));
        mockWebServer.start(InetAddress.getByName("0.0.0.0"), 8081);
        mockWebServer.url("callback");
    }

    @Test(testName = "测试企业端的令牌获取接口"/*,threadPoolSize = 5*/, skipFailedInvocations = true, invocationCount = 1)
    public void test_Token_Apply() throws Exception {
        //执行令牌申请的请求
        res = given().post(url);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        res.print();
        /**
         * 对结果进行验证
         */
        res.then().statusCode(200).assertThat().body("status", containsString("Success"));
//        Thread.sleep(60000);
        /*
        对请求头进行处理
         */
        RecordedRequest request = mockWebServer.takeRequest();
        /**
         * post时，getbody可获取到body
         */
//        System.out.printf("返回的body：%s", request.getBody().readString(Charset.defaultCharset()));
        ;
        /**
         * get请求时，可以获取到拼接的参数
         */
//        System.out.printf("返回的get path：%s", request.getPath().toString());
        ;
    }

    @AfterTest
    public void countTime() {
        System.out.printf("run testcase total cost：%d", (System.currentTimeMillis() - starTime) / 1000);
    }

}
