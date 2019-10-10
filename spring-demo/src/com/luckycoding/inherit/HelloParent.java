package com.luckycoding.inherit;

public class HelloParent {

    private String message1;
    private String message2;

    public void getMessage1() {
        System.out.println("your message1: " + message1);
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void getMessage2() {
        System.out.println("your message2: " + message2);
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
}
