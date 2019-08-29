package spring.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.pojo.Admin;
import spring.service.AdminSedrvice;
import spring.token.TokenUtil;

import java.util.HashMap;
import java.util.Map;

@Controller
//@RequestMapping(value = "/admin")
public class loginController {
    @Autowired
    private AdminSedrvice adminSedrvice;

    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> loginTest(@Param("username") String username, @RequestParam String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        Admin admin = adminSedrvice.findUserByName(username);
        if (admin == null) {
            map.put("code", 400);
            map.put("message", "用户名不存在!");
            return map;
        }
        if (admin.getPassword().equals(password)) {
            String token = TokenUtil.sign(username, password);
            if (token != null) {
                map.put("code", 200);
                map.put("message", "认证成功");
                map.put("token", token);
            }
            return map;
        } else {
            map.put("code", 401);
            map.put("message", "密码错误!");
            return map;
        }
    }
}
