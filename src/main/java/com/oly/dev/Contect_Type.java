package com.oly.dev;


public enum Contect_Type {

    XML("XML", "application/xml"), JSON("JSON", "appalication/json");

    /**
     * usege:
     * Created by oly on 2018/6/1.
     */
    String type;
    String name;

    Contect_Type(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public Contect_Type getName(String type) {
        for (Contect_Type instance : Contect_Type.values()) {
            if (instance != null && instance.equals(type)) {
                return instance;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
