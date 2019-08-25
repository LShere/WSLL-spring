package spring.dao;

import spring.pojo.User;

public interface UserDao {
    //public List<User> findUser();

    //public List<User> findUserById(long id);

    public User findUserByName(String name);

    public Integer addUser(User user);

    public User findUserById(String openid);
}
