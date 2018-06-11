package com.oly.hc.mock.insurance.controller;

import com.oly.hc.mock.insurance.pojo.OrderResultInfo;
import com.oly.hc.mock.insurance.pojo.send.OrderInfo;
import com.oly.hc.mock.insurance.pojo.send.VisitorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * usege:
 * Created by oly on 2018/6/11.
 */
@Controller
@RequestMapping(path = "/PolicyService.svc")
@ComponentScan("com.oly.hc.mock.insurance.pojo")
public class InsuranceController {

    OrderResultInfo resultInfo;

    @RequestMapping(value = "/PostPolicyOrder")
    public OrderResultInfo PostPolicyOrder(OrderInfo order, VisitorInfo visitor) {
        //Hard Code
        resultInfo = new OrderResultInfo();

        resultInfo.setPolicyNo("" + System.currentTimeMillis());
        resultInfo.setPrintNo(order.getPrintNo());
        resultInfo.setApplyNo(order.getInsProductNo() + "保单" + System.currentTimeMillis());
        resultInfo.setDownUrl("http://www.保单链接" + System.currentTimeMillis());
        if (order.getSignDataMd() == null) {
            resultInfo.setResultId(1);
        } else {
            resultInfo.setResultId(0);
        }
        return resultInfo;
    }

}
