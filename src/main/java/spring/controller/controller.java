package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.service.ServiceDaoMapper;
import spring.service.serviceDao;

@Controller
public class controller {
    //public void setServiceDao(spring.service.serviceDao serviceDao) {
    //    this.serviceDao = serviceDao;
    //}

    @Autowired
    private serviceDao serviceDao;
    private ServiceDaoMapper serviceDaoMapper;

    public void print() {
        //this.serviceDao.add();
        //this.serviceDao.printfUser();
        //模拟转账
        this.serviceDaoMapper.findUser();
    }


}
