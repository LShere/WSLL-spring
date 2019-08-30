package spring.dao;

import spring.pojo.User;

import java.util.List;

public interface UserDao {
    //public List<User> findUser();

    //public List<User> findUserById(long id);

    public User findUserByName(String name);

    public Integer addUser(User user);

    public User findUserById(String openid);

    public List getCommentList();

    public List getAllOrdersAdmin();
}
