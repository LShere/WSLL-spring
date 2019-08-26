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
}
