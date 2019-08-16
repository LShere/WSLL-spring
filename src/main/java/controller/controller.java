package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.serviceDao;

import javax.annotation.Resource;

@Controller
public class controller {
    //public void setServiceDao(service.serviceDao serviceDao) {
    //    this.serviceDao = serviceDao;
    //}

    @Autowired
    private serviceDao serviceDao;

    public void print() {
        this.serviceDao.add();
        //this.serviceDao.printfUser();
    }


}
