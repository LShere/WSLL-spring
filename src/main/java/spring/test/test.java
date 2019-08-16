package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.dao.UserDao;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/ApplicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.printfUser();

    }
}
