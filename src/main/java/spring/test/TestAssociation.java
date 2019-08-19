package spring.test;

import org.apache.ibatis.session.SqlSession;
import spring.Utils.MybatisUtils;
import spring.bean.Employee;
import spring.bean.Office;

import java.util.List;

public class TestAssociation {
    private static SqlSession sqlSession = MybatisUtils.getSession();

    public static void main(String[] args) {
        //List<Employee> employees = sqlSession.selectList("spring.mapper" + ".findEmployees");
        //for (Employee employee : employees) {
        //    System.out.println(employee.getOffice());
        //}

        List<Office> offices = sqlSession.selectList("spring.mapper" + ".findOfficeEmployee");
        for (Office office : offices) {
            System.out.println(office.getEmployees());
        }
    }
}
