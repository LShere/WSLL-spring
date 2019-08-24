package spring.dao;

import spring.pojo.User;

import java.util.List;

public interface UserDao {
    public List<User> findUser();
    public List<User> findUserById(long id);
    public User findUserByName(String name);
}
