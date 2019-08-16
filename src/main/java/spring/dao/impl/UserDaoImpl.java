package spring.dao.impl;

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
    //public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    //    this.jdbcTemplate = jdbcTemplate;
    //}

    @Autowired
    public JdbcTemplate jdbcTemplate;
    public void printfUser() {
        System.out.println("------------这是userdao层");
    }
    public void findUser(){
        String sql = "select name from test";
        RowMapper<User> userRowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = this.jdbcTemplate.query(sql,userRowMapper);
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

}
