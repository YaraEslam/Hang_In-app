package com.m7amdelbana.javahangin.models;

import java.io.Serializable;

public class Place implements Serializable {

    private String name;
    private String image;
    private String address;

    public Place(String name, String image, String address) {
        this.name = name;
        this.image = image;
        this.address = address;
    }

    public Place() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
