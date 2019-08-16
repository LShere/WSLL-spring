package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.service.serviceDao;

@Controller
public class controller {
    //public void setServiceDao(spring.service.serviceDao serviceDao) {
    //    this.serviceDao = serviceDao;
    //}

    @Autowired
    private serviceDao serviceDao;

    public void print() {
        this.serviceDao.add();
        //this.serviceDao.printfUser();
    }


}
