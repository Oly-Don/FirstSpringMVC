package com.oly.dev;

/**
 * Created by Administrator on 2018/6/1.
 */
public class RequestPojo {

    public String method;
    public String url;
    public String path;
    public String body;
    public Contect_Type contect_type;

    public RequestPojo(String method, String url, String path, String body, Contect_Type contect_type) {
        this.method = method;
        this.url = url;
        this.path = path;
        this.body = body;
        this.contect_type = contect_type;
    }

    public RequestPojo() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Contect_Type getContect_type() {
        return contect_type;
    }

    public void setContect_type(Contect_Type contect_type) {
        this.contect_type = contect_type;
    }
}