package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.pojo.User;
import spring.service.ServiceDaoMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class FirstController {
    @Autowired
    private ServiceDaoMapper serviceDaoMapper;

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
        List<User> users = serviceDaoMapper.findUser();
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
        List<User> users = serviceDaoMapper.findUser();
        System.out.println(users);
        return users;
    }

}
