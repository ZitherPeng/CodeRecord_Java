package com.luckycoding;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApp {

    public static void main(String[] args) {
        // ApplicationContext 容器
         ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        // BeanFactory 容器  --> XmlBeanFactory 类
        // XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.setMessage("I'm Zither");
        obj.getMessage();
        HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
        obj2.getMessage();
    }
}
