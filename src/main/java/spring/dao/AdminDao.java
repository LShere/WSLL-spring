package spring.dao;

import spring.pojo.Admin;

public interface AdminDao {
    public Admin findUserByName(String username);

}
