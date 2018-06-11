package com.oly.set.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;

public class JsonUtil {

    private JsonUtil() {
        throw new RuntimeException("can't instance");
    }

    public static JSONArray str2JSObect(String jsonstr) {
        return JSONObject.parseArray(jsonstr);
    }

    public static String json2Str(JSONArray json) {
        return JSONObject.toJSONString(json);
    }


}
