package spring.dao;

import spring.pojo.User;

import java.util.List;

public interface UserDaoMapper {
    public List<User> findUser();
    public User findUserByName(String name);
}
