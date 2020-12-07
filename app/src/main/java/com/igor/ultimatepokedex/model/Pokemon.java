package com.igor.ultimatepokedex.model;

import android.graphics.Bitmap;

import java.util.List;

public class Pokemon {

    private String img;
    private String name;
    private String num;
    private String weight;
    private String height;
    private List type;


    public Pokemon(){

    }

    public Pokemon(String img, String name, String num, String weight, String height, List type) {
        this.img = img;
        this.name = name;
        this.num = num;
        this.weight = weight;
        this.height = height;
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List getType() {
        return type;
    }

    public void setType(List type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
                "Tipo =" + type +
                '}';
    }
}
