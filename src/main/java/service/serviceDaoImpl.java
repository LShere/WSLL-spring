package service;

import dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class serviceDaoImpl implements serviceDao {
    @Resource(name = "userDao")
    private UserDao userDao;
    //public void setUserDao(UserDao userDao) {
    //    this.userDao = userDao;
    //}

    public void printfUser() {
        userDao.printfUser();
    }
}
