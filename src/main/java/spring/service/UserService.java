package spring.service;

import spring.pojo.User;

public interface UserService {
    public Integer addUser(User user);

    public User findUserById(String openid);

    public User findUserByName(String nickname);
}
