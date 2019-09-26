package com.luckycoding.serialize.demo;

import java.io.Serializable;

public class FlyPig implements Serializable {
    //    public static final long serialVersionUID = 1L;
    private static String AGE = "26";
    private String name;
    private String color;
    transient private String car;

//    private String addTip;

    public static String getAGE() {
        return AGE;
    }


    public static void setAGE(String AGE) {
        FlyPig.AGE = AGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

//    public String getAddTip() {
//        return addTip;
//    }
//
//    public void setAddTip(String addTip) {
//        this.addTip = addTip;
//    }


    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", AGE='" + AGE + '\'' +
                //", addTip='" + addTip + '\'' +
                '}';
    }

    ;


}
