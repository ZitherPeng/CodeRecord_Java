package com.luckycoding.loC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        ExampleBean exampleBean = (ExampleBean) applicationContext.getBean("exampleBean");
        exampleBean.getMessage();
        // 需要注册一个在 AbstractApplicationContext 类中声明的关闭 hook 的 registerShutdownHook() 方法。
        // 它将确保正常关闭，并且调用相关的 destroy 方法
        applicationContext.registerShutdownHook();

    }
}
