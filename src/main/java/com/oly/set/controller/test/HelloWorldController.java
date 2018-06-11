package com.oly.set.controller.test;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/helloworld")
public class HelloWorldController {


    //http://localhost:8080/FirstSpringMVC/oly/message
    @RequestMapping(value = "/message", method = RequestMethod.POST, consumes = "application/json", headers = "Content-Language=en")
    public String helloWorld(ModelAndView modelAndView) {
        modelAndView.addObject("message", "helloworld1");
        return "helloworld";
    }

    //http://localhost:8080/FirstSpringMVC/oly/path
    @RequestMapping(value = "/path", method = RequestMethod.GET, produces = "text/html;charset=utf-8")
    public String addPath(ModelAndView modelAndView) {
        modelAndView.addObject("message", "helloworld2");
        return "hellopath";
    }

    @RequestMapping(value = "/request")
    public void handleHttpRequest(HttpServletRequest request) {
        String method = request.getMethod();
        if (method.toLowerCase().equals("get")) {
            System.out.println(request.getRequestURL().toString());
        }
    }

    //http://localhost:8080/FirstSpringMVC/oly/default
    @RequestMapping(value = "/default")
    public String defaultPage(Model model) {
        System.out.println(model.asMap().get("id"));
        return "hellopath";
    }

    @ModelAttribute
    public void runBeforeHandle(Model model) {
        model.addAttribute("id", "999999999");
    }
}
