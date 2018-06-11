package com.oly.set.entity;

import java.io.Serializable;
import java.util.List;

public class RunnerVo implements Serializable {

    public List<String> httpMethods;

    public String url;

    public String body;

    public List<String> conterctTypes;


    public String resultInfo;

    public RunnerVo(List<String> httpMethods, String url, String body, List<String> conterctTypes, String resultInfo) {
        this.httpMethods = httpMethods;
        this.url = url;
        this.body = body;
        this.conterctTypes = conterctTypes;
        this.resultInfo = resultInfo;
    }

    public RunnerVo() {
        super();
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public List<String> getConterctTypes() {
        return conterctTypes;
    }

    public void setConterctTypes(List<String> conterctTypes) {
        this.conterctTypes = conterctTypes;
    }

    public List<String> getHttpMethods() {
        return httpMethods;
    }

    public void setHttpMethods(List<String> httpMethods) {
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

}
