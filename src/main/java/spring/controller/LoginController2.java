package spring.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.util.SendGet;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController2 {

    @RequestMapping("/login233")
    public String getOpenid(@RequestBody JSONObject object){
        System.out.println("------------------");
        String appid = "";
        String appSecret = "";
        String code = "";
        String grant_type = "";

        String result = "";

        try{
            //解析json数据
//            System.out.println(object.getString("code"));
            appid = object.getString("appid");
            appSecret = object.getString("appSecret");
            code = object.getString("code");
            grant_type = "grant_type";

            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=" + grant_type;

            return SendGet.get(url);


        }catch (Exception e){
            e.printStackTrace();
        }
        return "";

    }
}
