package dao.impl;

import dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void printfUser() {
        System.out.println("------------这是userdao层");
    }

}
