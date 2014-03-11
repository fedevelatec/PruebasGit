package com.fedevela.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fedevela.spring.HelloWorldList;

public class HelloWorldListApp {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorldList hello = (HelloWorldList) context.getBean("helloWorldBeanList");

        System.out.println("List: " + hello.getList());
        System.out.println("Set : " + hello.getSet());
        System.out.println("Map : " + hello.getMap());
        System.out.println("Props : " + hello.getProps());

    }
}