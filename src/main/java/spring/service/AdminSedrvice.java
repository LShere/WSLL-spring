package spring.service;

import spring.pojo.Admin;

public interface AdminSedrvice {
    public Admin findUserByName(String username);

}
