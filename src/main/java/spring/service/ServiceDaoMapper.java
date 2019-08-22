package spring.service;

import spring.pojo.User;

import java.util.List;

public interface ServiceDaoMapper {
    public List<User> findUser();

    public User findUserByName(String name);

}
