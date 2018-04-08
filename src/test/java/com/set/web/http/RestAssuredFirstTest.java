package com.set.web.http;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.HashMap;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

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
        Response response = get(new URI(url));
        XmlPath xmlPath = response.xmlPath();
        xmlPath.get("html");
    }

    @Test
    public void testRestAssuredGet() throws Exception {
        String url = "https://blog.csdn.net/u012516914/article/details/61647198";
        Response response = get(new URI(url));
        XmlPath xmlPath = response.xmlPath();
        xmlPath.get("html");
    }


    @Test
    public void testRestAssuredPost() {
        String url = "http://106.75.157.204:8080/ciq/rest/ciq/order/recieve.do";
/*        Response post = given().post(url);//contentType("application/json")
        post.prettyPrint();
        post.then().assertThat().statusCode(200);*/

        Response post = given().contentType(ContentType.JSON).body("{\n" +
                "        \"source\": null,\n" +
                "        \"messageHead\": {\n" +
                "            \"messageID\": \"RO2017SO21014741846\",\n" +
                "            \"messageType\": \"CMC104\",\n" +
                "            \"senderID\": \"OFC\",\n" +
                "            \"receiverID\": \"CIQ\",\n" +
                "            \"sendTime\": 1501829114095,\n" +
                "            \"version\": null,\n" +
                "            \"traceId\":\"IN17SO21014741846\"\n" +
                "        },\n" +
                "        \"dataInfo\": {\n" +
                "            \"subscribeId\": \"DY004301\",\n" +
                "            \"declareOrderCode\": \"RO2017SO21014741846\",\n" +
                "            \"orderNo\": \"DD17SO21014741846\",\n" +
                "            \"innerOrderNo\":\"IN17SO21014741846\",\n" +
                "            \"logisticsNo\": \"DD17SO21014741846\",\n" +
                "            \"ciqbCode\": \"000069\",\n" +
                "            \"appType\": \"S\",\n" +
                "            \"ieFlag\": \"I\",\n" +
                "            \"busiMode\": \"10\",\n" +
                "            \"ebpCode\": \"1000001336\",\n" +
                "            \"ebpName\": \"京东香港\",\n" +
                "            \"ebcCode\": \"1000001336\",\n" +
                "            \"ebcName\": \"沃尔玛香港有限公司\",\n" +
                "            \"payCode\": \"110896T004\",\n" +
                "            \"payName\": \"网银在线（北京）科技有限公司\",\n" +
                "            \"logisticsCode\": \"0000016\",\n" +
                "            \"logisticsName\": \"北京京邦达贸易有限公司\",\n" +
                "            \"goodsValue\": 6000,\n" +
                "            \"currency\": \"CNY\",\n" +
                "            \"drDate\": 1493647772000,\n" +
                "            \"orderNote\": null,\n" +
                "            \"payNo\": \"546028170501221$SO21014741846\",\n" +
                "            \"payorName\": null,\n" +
                "            \"payorAccount\": null,\n" +
                "            \"payee\": null,\n" +
                "            \"orderFcy\": null,\n" +
                "            \"payFcy\": null,\n" +
                "            \"payCurrency\": null,\n" +
                "            \"payDate\": null,\n" +
                "            \"payNote\": null,\n" +
                "            \"shipperName\": null,\n" +
                "            \"shippernTel\": null,\n" +
                "            \"consigneeName\": \"杨孟佳\",\n" +
                "            \"consigneeTel\": \"18701297177\",\n" +
                "            \"consigneeNo\": \"42062619910228002X\",\n" +
                "            \"logistDate\": 1501828865000,\n" +
                "            \"consigneeAddr\": \"报文类型代码报文类型代码报文类型代码含报类型代码报文类型文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型代报文类型代码报文类型代码报文类型代码报文报文类型代码报文类型代码报文类型代码报文类型代码报文类型代码报文类型\",\n" +
                "            \"wayNote\": null,\n" +
                "            \"orderGoods\": [\n" +
                "                {\n" +
                "                    \"subscribeId\": \"DY004301\",\n" +
                "                    \"gNum\": 1,\n" +
                "                    \"opgCode\": \"OPG161014087301\",\n" +
                "                    \"itemNo\": \"WMT4901301268617\",\n" +
                "                    \"hsCode\": null,\n" +
                "                    \"ciqGoodsNo\": null,\n" +
                "                    \"bRand\": null,\n" +
                "                    \"spec\": null,\n" +
                "                    \"ebcName\": null,\n" +
                "                    \"itemName\": \"花王 KAO 真丝羊毛浓缩洗涤液 （玫瑰花香型）500ml/瓶 日本进口\",\n" +
                "                    \"itemDescribe\": null,\n" +
                "                    \"barCode\": null,\n" +
                "                    \"qtyUnit\": \"142\",\n" +
                "                    \"qty\": 1,\n" +
                "                    \"price\": 2600,\n" +
                "                    \"totalPrice\": 2600,\n" +
                "                    \"kgs\": null,\n" +
                "                    \"net\": null,\n" +
                "                    \"currency\": \"CNY\",\n" +
                "                    \"sellWebSite\": null,\n" +
                "                    \"origin\": null,\n" +
                "                    \"notes\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"subscribeId\": \"DY004301\",\n" +
                "                    \"gNum\": 2,\n" +
                "                    \"opgCode\": \"OPG161014087073\",\n" +
                "                    \"itemNo\": \"WMT4901301276469\",\n" +
                "                    \"hsCode\": null,\n" +
                "                    \"ciqGoodsNo\": null,\n" +
                "                    \"bRand\": null,\n" +
                "                    \"spec\": null,\n" +
                "                    \"ebcName\": null,\n" +
                "                    \"itemName\": \"花王 KAO 洗衣液替代装 810g/袋 日本进口\",\n" +
                "                    \"itemDescribe\": null,\n" +
                "                    \"barCode\": null,\n" +
                "                    \"qtyUnit\": \"136\",\n" +
                "                    \"qty\": 1,\n" +
                "                    \"price\": 2800,\n" +
                "                    \"totalPrice\": 2800,\n" +
                "                    \"kgs\": null,\n" +
                "                    \"net\": null,\n" +
                "                    \"currency\": \"CNY\",\n" +
                "                    \"sellWebSite\": null,\n" +
                "                    \"origin\": null,\n" +
                "                    \"notes\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"permissions\": null\n" +
                "    }").post(url);
        post.then().assertThat().statusCode(200).assertThat().body("flag", equalTo("FAILURE")).body("errInfo", not("hsCode"));
        post.print();
    }

    @AfterMethod
    public void tearDown() {

    }
}
