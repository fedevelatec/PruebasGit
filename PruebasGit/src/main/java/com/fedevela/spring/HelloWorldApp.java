package com.fedevela.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://examples.javacodegeeks.com/enterprise-java/spring/beans-spring/spring-bean-scopes-example/
 * Cambiar en el applicacionContext el prototype por singleton
 */
public class HelloWorldApp {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld helloObj1 = (HelloWorld) context.getBean("helloWorldBean");

        helloObj1.setName("name set by object 1");

        System.out.println(helloObj1);

        HelloWorld helloObj2 = (HelloWorld) context.getBean("helloWorldBean");

        System.out.println(helloObj2);
    }
}
