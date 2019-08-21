package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.User;
import spring.controller.MapperController;

public class TestSpringMapper {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        MapperController mapperController= (MapperController) applicationContext.getBean("mapperController");
        for (User user : mapperController.print()) {
            System.out.println(user.getName());
        }
        System.out.println(mapperController.findUserByName("lin"));
    }
}
