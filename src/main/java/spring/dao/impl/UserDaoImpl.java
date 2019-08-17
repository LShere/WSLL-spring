package spring.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import spring.bean.User;
import spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void printfUser() {
        System.out.println("------------这是userdao层");
    }

    public void findUser() {
        String sql = "select name from test";
        RowMapper<User> userRowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = this.jdbcTemplate.query(sql, userRowMapper);
        System.out.println("数据长度是：" + users.size());
    }

    public void add() {
        String sql = "insert into test(name) values ('xin')";
        jdbcTemplate.execute(sql);
    }

    public void update() {
        String sql = "insert into test(name) values ('xin')";
        jdbcTemplate.execute(sql);
    }

    public void delete() {

    }

    @Transactional
    public void transferAccounts(double money) {
        String sql = "update test set balance = balance+" + money + " where name = 'lin'";
        String sql2 = "update test set balance = balance-" + money + " where name = 'luo'";
        int row = jdbcTemplate.update(sql);
        System.out.println("影响行数1:" + row);
        //int a = 10 / 0;
        int row2 = jdbcTemplate.update(sql2);
        System.out.println("影响行数2:" + row2);
    }

}
