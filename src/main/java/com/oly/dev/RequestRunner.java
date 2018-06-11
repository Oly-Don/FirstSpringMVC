package com.oly.dev;

/**
 * usege: 记录请求、以及结果
 * Created by oly on 2018/6/1.
 */
public class RequestRunner {

    String uniqueId;

    RequestPojo requestPojo;

    ResponceHandler responceHandler;

    public RequestRunner(RequestPojo requestPojo) {
        this.requestPojo = requestPojo;
    }

}
