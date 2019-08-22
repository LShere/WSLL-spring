package spring.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.pojo.User;
import spring.service.ServiceDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class loginController {
    @Autowired
    private ServiceDao serviceDao;

    @PostMapping(value = "/login2")
    @ResponseBody
    public List<User> login(@Param("username") String username, @Param("password") String password) {
        return serviceDao.findUserById(1);
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> loginTest(@Param("username") String username, @RequestParam String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        User SqlUser = serviceDao.findUserByName(username);
        if (SqlUser == null) {
            map.put("login", "failed");
            map.put("message", "用户名不存在!");
            return map;
        }
        if (SqlUser.getPassword().equals(password)) {
            map.put("login", "success");
            map.put("message", "登陆成功");
            return map;
        } else {
            map.put("login", "failed");
            map.put("message", "密码错误!");
            return map;
        }
    }
}
