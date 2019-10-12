package com.luckycoding.dubbo.samples.echo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class EchoProvider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext(new String[]{"spring/echo-provider.xml"});
        context.start();

        System.in.read();

    }
}
