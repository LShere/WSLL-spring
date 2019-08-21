package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.bean.User;
import spring.service.ServiceDaoMapper;
import java.util.List;

@Controller
public class MapperController {
    @Autowired
    private ServiceDaoMapper serviceDaoMapper;

    public List<User> print() {
        return serviceDaoMapper.findUser();
    }

    public User findUserByName(String name){
        return serviceDaoMapper.findUserByName(name);
    }
}
