package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.UserDao;
import spring.pojo.User;

import java.util.List;

@Service
@Transactional
public class ServiceDaoImpl implements ServiceDao {
    @Autowired
    private UserDao userDao;

    public List<User> findUser() {
        return userDao.findUser();
    }

    public List<User> findUserById(long id) {
        return userDao.findUserById(id);
    }

    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

}
