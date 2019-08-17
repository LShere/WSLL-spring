package spring.test;

import org.apache.ibatis.session.SqlSession;
import spring.Utils.MybatisUtils;
import spring.bean.Customer;

import java.util.List;

public class TestMybatis {
    private static SqlSession sqlSession = MybatisUtils.getSession();

    public static void main(String[] args) {
        selectIf();
        //update();
    }

    private static void insert() {
        try {
            List<Customer> customers = sqlSession.selectList("spring.mapper"
                    + ".findCustomer");
            System.out.println(customers.toString());
        } finally {
            sqlSession.close();
        }
    }

    private static void update() {
        Customer customer = new Customer();
        customer.setCustomerNumber(103);
        customer.setCustomerName("lin");
        try {
            int rows = sqlSession.update("spring.mapper"
                    + ".update", customer);
            sqlSession.commit();
            System.out.println("affected rows:" + rows);
        } finally {
            sqlSession.close();
        }
    }

    private static void selectIf() {
        Customer customer = new Customer();
        customer.setCustomerNumber(1);
        customer.setCustomerName("lin");
        try {
            List<Customer> customers = sqlSession.selectList("spring.mapper"
                    + ".select-if",customer);
            for (Customer customer1 : customers) {
                System.out.println(customer1.getCustomerName());
            }
        } finally {
            sqlSession.close();
        }
    }
}
