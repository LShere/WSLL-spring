package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.bean.User;
import spring.dao.UserDaoMapper;

import java.util.List;

@Service
public class ServiceDaoMapperImpl implements ServiceDaoMapper {

    @Autowired
    private UserDaoMapper userDaoMapper;

    public List<User> findUser() {
        return userDaoMapper.findUser();
    }

    public User findUserByName(String name) {
        return userDaoMapper.findUserByName(name);
    }
}
