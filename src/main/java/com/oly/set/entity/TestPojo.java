package com.oly.set.entity;

import java.io.Serializable;

public class TestPojo implements Serializable {


    public String httpMethods;

    public String url;

    public String body;

    public String conterctTypes;


    public String resultInfo;

    public TestPojo(String httpMethods, String url, String body, String conterctTypes, String resultInfo) {
        this.httpMethods = httpMethods;
        this.url = url;
        this.body = body;
        this.conterctTypes = conterctTypes;
        this.resultInfo = resultInfo;
    }

    public TestPojo() {
    }

    public String getHttpMethods() {
        return httpMethods;
    }

    public void setHttpMethods(String httpMethods) {
        this.httpMethods = httpMethods;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getConterctTypes() {
        return conterctTypes;
    }

    public void setConterctTypes(String conterctTypes) {
        this.conterctTypes = conterctTypes;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }
}
