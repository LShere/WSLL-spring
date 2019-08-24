package spring.service;

import spring.pojo.User;

import java.util.List;

public interface ServiceDao {
    public List<User> findUser();
    public List<User> findUserById(long id);
    public User findUserByName(String name);
}
