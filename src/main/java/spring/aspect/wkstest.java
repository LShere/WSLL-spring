package spring.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dao.GoodsDao;
import spring.pojo.Goods;

import java.util.List;

public class wkstest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        GoodsDao dao=(GoodsDao) applicationContext.getBean("GoodsDao");
        List<Goods> list=dao.findAllGoods();
        System.out.println(list.size());
    }
}
