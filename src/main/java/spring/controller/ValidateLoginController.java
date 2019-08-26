package spring.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.pojo.User;
import spring.service.UserService;
import spring.util.SendGet;

@RestController
public class ValidateLoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String getOpenid(@RequestBody JSONObject object) {
        System.out.println("------------------");

        String appid = "";
        String appSecret = "";
        String code = "";
        String grant_type = "";
        String nickname = "";
        try {
            //解析json数据
            //System.out.println(object.getString("code"));
            appid = object.getString("appid");
            appSecret = object.getString("appSecret");
            code = object.getString("code");
            grant_type = "authorization_code";

            nickname = object.getString("nickname");
            //先判断数据库中是否存在所请求的openid
            User user = userService.findUserByName(nickname);
            if (user == null || "".equals(user.getOpenid())) {

                String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=" + grant_type;
                String result = SendGet.get(url);
                //将字符串转化为jsonobject
                JSONObject object1 = JSON.parseObject(result);
                String openid = object1.getString("openid");
                User user1 = new User(openid, nickname);
                int insertResult = userService.addUser(user1);
                if (insertResult > 0) {
                    System.out.println("添加用户成功");
                    return result;
                }
            } else {
                return JSON.toJSONString(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
