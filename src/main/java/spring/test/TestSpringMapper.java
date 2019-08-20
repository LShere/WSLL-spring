package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.controller.MapperController;
import spring.controller.controller;

public class TestSpringMapper {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        MapperController mapperController= (MapperController) applicationContext.getBean("mapperController");
        mapperController.print();
    }
}
