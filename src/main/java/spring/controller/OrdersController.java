package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.pojo.Orders;
import spring.service.OrdersService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    //根据用户id和订单id查找订单
    @RequestMapping(value = "/findOrdersByOpenid")
    @ResponseBody
    public List<Orders> findOrdersByOpenid(String openid, @RequestParam(defaultValue = "0") int order_id) {

        return ordersService.findOrdersByOpenid(openid, order_id);

    }
    //删除订单
    @RequestMapping(value = "/deleteOrder")
    @ResponseBody
    public String deleteOrder(int order_id){
        int result = ordersService.deleteOrder(order_id);
        if(result>0){
            return "success";
        }else{
            return "fail";
        }
    }
}
