/**
  * Copyright 2018 bejson.com 
  */
package com.oly.hc.mock.insurance.pojo;

import com.oly.hc.mock.insurance.pojo.send.VisitorInfo;
import com.oly.hc.mock.insurance.pojo.send.OrderInfo;
import org.springframework.stereotype.Component;

/**
 * Auto-generated: 2018-06-11 17:30:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Component
public class InsuranceVO {

    private com.oly.hc.mock.insurance.pojo.send.OrderInfo OrderInfo;
    private com.oly.hc.mock.insurance.pojo.send.VisitorInfo VisitorInfo;
    public void setOrderInfo(OrderInfo OrderInfo) {
         this.OrderInfo = OrderInfo;
     }
     public OrderInfo getOrderInfo() {
         return OrderInfo;
     }

    public void setVisitorInfo(VisitorInfo VisitorInfo) {
         this.VisitorInfo = VisitorInfo;
     }
     public VisitorInfo getVisitorInfo() {
         return VisitorInfo;
     }

}