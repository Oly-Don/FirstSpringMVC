package com.oly.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * usege:
 * Created by oly on 2018/6/1.
 */
@Controller
@RequestMapping(value = "/url/")
public class RequestController {

    @Autowired
    IRequestInvoker invoker;

    @RequestMapping(value = "/get/")
    public void invokeGet(RequestPojo requestPojo){
        RequestRunner requestRunner = invoker.get(requestPojo);
        return ;
    }


    @RequestMapping(value = "/post/")
    public void invokePost(RequestPojo requestPojo){
        RequestRunner requestRunner = invoker.post(requestPojo);
        return ;
    }



}
