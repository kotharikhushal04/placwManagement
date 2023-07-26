package com.placeManage.placeManagement.dto;

public class Placedto {
    private String name;
    private String prefix;
    public Placedto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Placedto(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }


}
