package spring.service;

import spring.bean.User;

import java.util.List;

public interface ServiceDaoMapper {
    public List<User> findUser();
}
