package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.pojo.User;
import spring.service.ServiceDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class FirstController {
    @Autowired
    private ServiceDao serviceDao;

    @RequestMapping(value = "/firstController")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "这是我的第一个Spring MVC程序");
        mav.setViewName("first");
        return mav;
    }

    @RequestMapping(value = "/user")
    public String selectUserById(@RequestParam(value = "user_id") String id) {
        System.out.println(id);
        return "success";
    }

    @RequestMapping(value = "/api")
    @ResponseBody
    public User TestAPI(@RequestBody User user) {
        return user;
    }

    //不需要参数的GET
    @GetMapping(value = "/axiosNoPara")
    @ResponseBody
    public List<User> axiosNoPara() {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        //MapperController mapperController = (MapperController) applicationContext.getBean("mapperController");
        List<User> users = serviceDao.findUser();
        for (User user : users) {
            System.out.println(user.getUsername());
        }
        return users;
    }



    @RequestMapping("/test2")
    @ResponseBody
    public List<User> test2() {
        List<User> users = serviceDao.findUser();
        System.out.println(users);
        return users;
    }

}
