package com.luckycoding.inherit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");

//        HelloParent parent = (HelloParent) applicationContext.getBean("helloParent");
//        parent.getMessage1();
//        parent.getMessage2();

        HelloChild child = (HelloChild) applicationContext.getBean("helloChild");
        child.getMessage1();
        child.getMessage2();
        child.getMessage3();

    }
}
