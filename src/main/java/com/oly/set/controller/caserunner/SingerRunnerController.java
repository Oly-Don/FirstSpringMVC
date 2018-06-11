package com.oly.set.controller.caserunner;


import com.oly.set.entity.RunnerVo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/runner")
public class SingerRunnerController {

    Logger looger = Logger.getLogger(SingerRunnerController.class);


    //标签库  singlecase.jsp
    //get 获取数据,组装数据回显
    @RequestMapping(value = "/runsingle")
    public String singlecase(Model model) {
        looger.info("SingerRunnerController.singlecase");
        /*
     默认选中项
         */
        RunnerVo vo = new RunnerVo();
        vo.setBody("");
        List<String> method = new ArrayList<String>();
        method.add("post");
        vo.setHttpMethods(method);
        List<String> contect = new ArrayList<String>();
        contect.add("application/json");
        vo.setConterctTypes(contect);
        vo.setUrl("");

        /*
        界面可选项
         */
        model.addAttribute("RunnerVo", vo);
        List<String> methods = new ArrayList<String>();
        methods.add("post");
        methods.add("get");
        methods.add("delete");
        model.addAttribute("methodsList", methods);
        List<String> contectTypes = new ArrayList<String>();
        contectTypes.add("application/json");
        contectTypes.add("application/xml");
        contectTypes.add("application/x-www-form-urlencoded");
        model.addAttribute("contectTypesList", contectTypes);
        return "singlecase";
    }

    //前端post请求,处理程序
    @RequestMapping(value = "/runCase", method = RequestMethod.POST)
    public void runCase(
            @RequestParam(value = "RunnerVo", required = false) RunnerVo vo,
            Model model, HttpServletRequest request) {
        looger.info("SingerRunnerController.runCase");
        if (vo != null) {
            Response response = RestAssured.given().contentType("application/json").body(vo.getBody()).post(vo.getUrl());
            response.print();
        }
        Map parameterMap = request.getParameterMap();
        String errorMessage = "back http run result return ui";
        model.addAttribute("errorMessage", errorMessage);
    }


    @RequestMapping(value = "/testcastrunner")
    public String testcastrunner(
      /*      @RequestParam(value = "body", required = false) String body,
            @RequestParam(value = "url", required = false) String url,
            @RequestParam(value = "method", required = false) String method,
            @RequestParam(value = "contect", required = false) String contect,
            @RequestParam(value = "result", required = false) String result*/
            @RequestParam(value = "RunnerVo", required = false) RunnerVo vo
            , Model model
    ) {
//        looger.info(body + url + method + contect + result);
        looger.info(vo);
        model.addAttribute("resultError", "Error");
        return "testcaserun";
    }

}
