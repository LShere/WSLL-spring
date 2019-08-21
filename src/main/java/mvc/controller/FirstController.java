package mvc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.bean.User;
import spring.controller.MapperController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FirstController {
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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        MapperController mapperController = (MapperController) applicationContext.getBean("mapperController");
        List<User> users = mapperController.print();
        for (User user : users) {
            System.out.println(user.getName());
        }
        return users;
    }

    //需要参数的GET
    @GetMapping(value = "/axiosId")
    @ResponseBody
    public String axiosId(@RequestParam String id) {
        System.out.println("axiosId:" + id);
        return id;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public List<User> test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        MapperController mapperController= (MapperController) applicationContext.getBean("mapperController");
        List<User> users = mapperController.print();
        System.out.println(users);
        return users;
    }

}
