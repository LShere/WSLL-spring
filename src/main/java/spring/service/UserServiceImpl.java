package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.UserDao;
import spring.pojo.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    public User findUserById(String openid) {
        return userDao.findUserById(openid);
    }

    public User findUserByName(String nickname) {
        return userDao.findUserByName(nickname);
    }
}
