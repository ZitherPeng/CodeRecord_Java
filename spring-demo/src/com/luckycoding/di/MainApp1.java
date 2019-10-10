package com.luckycoding.di;

import com.luckycoding.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/luckycoding/di/Beans.xml");
        JavaCollection javaCollection = (JavaCollection) applicationContext.getBean("javaCollection");
        System.out.println(javaCollection.getList());
        System.out.println(javaCollection.getMap());
        System.out.println(javaCollection.getProperties());
        System.out.println(javaCollection.getSet());

        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("outerBean");
        helloWorld.getMessage();

    }
}
