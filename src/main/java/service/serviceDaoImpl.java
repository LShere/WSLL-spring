package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class serviceDaoImpl implements serviceDao {
    @Autowired
    private UserDao userDao;

    public void printfUser() {
        userDao.printfUser();
    }

    public void findUser() {
        this.userDao.findUser();
    }

    public void add() {
        this.userDao.add();
    }

    public void update() {

    }

    public void delete() {

    }
}
