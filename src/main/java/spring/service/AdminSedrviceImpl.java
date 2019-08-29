package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.AdminDao;
import spring.pojo.Admin;

@Service
public class AdminSedrviceImpl implements AdminSedrvice {
    @Autowired
    AdminDao adminDao;

    public Admin findUserByName(String username) {
        return adminDao.findUserByName(username);
    }
}
