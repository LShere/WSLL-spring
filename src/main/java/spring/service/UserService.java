package spring.service;

import spring.pojo.User;

import java.util.List;

public interface UserService {
    public Integer addUser(User user);

    public User findUserById(String openid);

    public User findUserByName(String nickname);

    public List getCommentList();

    public List getAllOrdersAdmin();
}
