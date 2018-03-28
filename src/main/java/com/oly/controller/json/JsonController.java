package com.oly.controller.json;

import com.alibaba.druid.support.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/json", produces = "application/json;charset=UTF-8")
// 请求header需要加:  Content-Typ:application/json;charset=UTF-8
public class JsonController {


    //    get post
    //http://localhost:8080/FirstSpringMVC/json/reveive    Content-Typ:application/json;charset=UTF-8
    @RequestMapping(value = "/reveive")
    @ResponseBody
    public String method() {
        return "{\"A\":1,\"B\":\"2\"}";
        /*
                    {
              "A" : 1,
              "B" : "2"
            }
         */
    }

    //http://localhost:8080/FirstSpringMVC/json/user2json    Content-Typ:application/json;charset=UTF-8
    @RequestMapping(value = "/user2json")
    @ResponseBody
    public ModelMap user2json() {
        JSONParser parser = new JSONParser("{\"A\":1,\"B\":\"2\"}");
        Map<String, Object> jsonMap = parser.parseMap();
        return new ModelMap().addAllAttributes(jsonMap);
               /*
                        {
                  "A" : 1,
                  "B" : "2"
                }
                */
    }
}
