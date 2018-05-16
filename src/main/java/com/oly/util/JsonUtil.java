package com.oly.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;

public class JsonUtil {


    private JsonUtil() {
    }


    public static JSONArray toJSObect(String jsonstr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonstr);
        Assert.assertEquals(jsonObject.get("A"), 1);
        return (JSONArray) jsonObject.get("Body");
    }

    public static String toStr(JSONArray json) {
        return JSONObject.toJSONString(json);
    }


}
