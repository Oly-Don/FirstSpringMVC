package com.oly.set.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControllerByAna {

    Logger logger = LoggerFactory.getLogger(HelloControllerByAna.class);

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
        logger.info("HelloControllerByAna.hello has been call once");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "this is from spring mvc");
        modelAndView.setViewName("welcome.jsp");
        return modelAndView;
    }
}
