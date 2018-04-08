package com.oly.controller.json;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oly.entity.user.UserVO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/json", produces = "application/json;charset=UTF-8")
// 请求header需要加:  Content-Typ:application/json;charset=UTF-8
public class JsonController {


    Logger logger = Logger.getLogger(JsonController.class);


    /*
                {
          "A" : 1,
          "B" : "2"
        }
     */

    //直接返回json字符串,输出json
    //    get post
    //http://localhost:8080/FirstSpringMVC/json/returnJsonStr    Content-Typ:application/json;charset=UTF-8
    @RequestMapping(value = "/returnJsonStr")
    @ResponseBody
    public String method() {
        logger.info("returnJsonStr has call ");
        return "{\"A\":1,\"B\":\"2\"}";
    }



    /*
             {
       "A" : 1,
       "B" : "2"
     }
     */

    //返回Map,输出json
    //http://localhost:8080/FirstSpringMVC/json/str2json    Content-Typ:application/json;charset=UTF-8
    @RequestMapping(value = "/str2json")
    @ResponseBody
    public ModelMap str2json() {
        logger.info("str2json has call ");
        JSONParser parser = new JSONParser("{\"A\":1,\"B\":\"2\"}");
        Map<String, Object> jsonMap = parser.parseMap();
        return new ModelMap().addAllAttributes(jsonMap);
    }


    /*
    return
[{"id":"90090","passwd":"123213","username":"admin"},{"id":"3213","passwd":"211","username":"ad321min"}]
   */
    //返回userVo对象,输出json
    //http://localhost:8080/FirstSpringMVC/json/getJson    Content-Typ:application/json;charset=UTF-8
    @RequestMapping(value = "/getJson")
    @ResponseBody
    public Object returnJson() {
        logger.info("getJson has call ");
        UserVO userVO = new UserVO();
        userVO.setUsername("admin");
        userVO.setPasswd("123213");
        userVO.setId(90090 + "");
        List<UserVO> userVOList = new ArrayList<UserVO>();
        userVOList.add(userVO);
        UserVO userVO1 = new UserVO();
        userVO1.setUsername("ad321min");
        userVO1.setPasswd("211");
        userVO1.setId(3213 + "");
        userVOList.add(userVO1);
        return userVOList;
    }


    //JSONArray：相当于List<Object>
    //JSONObject：相当于Map<String, Object>
    /*
    send
   {"id":"90090","passwd":"123213","username":"admin"}
   */
    //接收userVo对象,读取为json
    //http://localhost:8080/FirstSpringMVC/json/sendJson    Content-Typ:application/json;charset=UTF-8
    @RequestMapping(value = "/sendJson", method = RequestMethod.POST)
    @ResponseBody
    public void returnJson(@RequestBody UserVO userVo, HttpServletResponse response) {
        logger.info("getJson has call ");
        //obj 2 json str
        String toJSONString = JSONObject.toJSONString(userVo);
        //json str 2 obj
        UserVO vo = JSONArray.parseObject(toJSONString, UserVO.class);
        try {
            response.getWriter().print(vo.toString());
        } catch (IOException e) {
            logger.info("sendJson write error  .from com.oly.controller.json.JsonController.returnJson(com.oly.entity.user.UserVO, javax.servlet.http.HttpServletResponse)");
            e.printStackTrace();
        }
    }


}
