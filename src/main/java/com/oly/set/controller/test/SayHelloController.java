package com.oly.set.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SayHelloController implements Controller {

    Logger logger = LoggerFactory.getLogger(SayHelloController.class);

    //    spring-mvc.xml    <bean name="/sayhello" class="SayHelloController"/>  带 /符号
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        logger.info("SayHelloController.handleRequest has been call once");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "this is from spring mvc");
        modelAndView.setViewName("/WEB-INF/views/welcome");
        return modelAndView;
    }
}
