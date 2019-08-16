package spring.test;

import spring.controller.controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDI {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        controller controller  = (controller) applicationContext.getBean("controller");
        controller.print();
    }
}
