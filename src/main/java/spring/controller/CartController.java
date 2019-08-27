package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.service.CartService;

@Controller
public class CartController {
    @Autowired
    CartService cartService;
    @RequestMapping(value = "/countCart")
    @ResponseBody
    public int countCart(String openid){
        return  cartService.countCart(openid);
    }


    @RequestMapping(value = "/deleteCart")
    @ResponseBody
    public String deleteCart(String openid,int goods_id){
        int result = cartService.deleteCart(openid,goods_id);
        if(result > 0){
            return "success";
        }else{
            return "fail";
        }
    }
    @RequestMapping(value = "/addCart")
    @ResponseBody
    public String addCart(String openid,int goods_id,int num){
        int result = cartService.addCart(openid,goods_id,num);
        if(result>0){
            return "success";
        }else {
            return "fail";
        }
    }
}
