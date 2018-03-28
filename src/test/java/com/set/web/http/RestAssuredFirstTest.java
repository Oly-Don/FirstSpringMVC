package com.set.web.http;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.HashMap;

public class RestAssuredFirstTest {

    @BeforeMethod
    public void setUp() {

    }


    @Test
    public void testRestAssured() throws Exception {
        String url = "https://blog.csdn.net/u012516914/article/details/61647198";
//        String url = "http://192.168.0.135:8080/customsrest/wmsjson/hp/service?method=dubhe.wms.carton.rewrite";
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("A", "123");
        Response response = RestAssured.get(new URI(url));
        XmlPath xmlPath = response.xmlPath();
        xmlPath.get("html");
    }

    @Test
    public void testRestAssuredGet() throws Exception {
        String url = "https://blog.csdn.net/u012516914/article/details/61647198";
        Response response = RestAssured.get(new URI(url));
        XmlPath xmlPath = response.xmlPath();
        xmlPath.get("html");
    }

    @AfterMethod
    public void tearDown() {

    }
}
