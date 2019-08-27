package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring.pojo.Cart;
import spring.service.CartService;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    CartService cartService;
    //购物车中种类数量
    @RequestMapping(value = "/countCart")
    @ResponseBody
    public int countCart(String openid){
        return  cartService.countCart(openid);
    }


    //删除购物车
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
    //添加购物车
    @RequestMapping(value = "/addCart")
    @ResponseBody
    public String addCart(String openid, int goods_id, int num){
        int result = cartService.addCart(openid,goods_id,num);
        if(result>0){
            return "success";
        }else {
            return "fail";
        }
    }

    //根据用户id查找购物车
    @RequestMapping(value = "/listCart")
    @ResponseBody
    public List<Cart> listCart(String openid){

        System.out.println("执行了查询方法");
        return cartService.listCart(openid);

    }
    //清空购物车
    @RequestMapping("/clearCart")
    @ResponseBody
    public String clearCart(String openid){
        System.out.println("清空购物车");
        int result = cartService.clearCart(openid);
        if(result > 0){
            return "成功清空购物车";
        }
        return "清空失败";
    }
}
