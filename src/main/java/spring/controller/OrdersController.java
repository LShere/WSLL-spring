package spring.controller;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.pojo.GoodsOrders;
import spring.pojo.Orders;
import spring.service.CartService;
import spring.service.GoodsOrdersService;
import spring.service.OrdersService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @Autowired
    GoodsOrdersService goodsOrdersService;
    @Autowired
    CartService cartService;

    //根据用户id和订单id查找订单
    @RequestMapping(value = "/findOrdersByOpenid")
    @ResponseBody
    public List<Orders> findOrdersByOpenid(String openid,  String order_id) {

        return ordersService.findOrdersByOpenid(openid, order_id);

    }
    //删除订单
    @RequestMapping(value = "/deleteOrder")
    @ResponseBody
    public String deleteOrder(String order_id){
        int result = ordersService.deleteOrder(order_id);
        if(result>0){
            return "success";
        }else{
            return "fail";
        }
    }
    //从直接购买处添加订单(同时添加进order_goods)
    @RequestMapping(value = "/addOrderBuyNow")
    @ResponseBody
    public String addOrderBuyNow(@RequestBody JSONObject jsonObject){

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Orders orders = new Orders();

//        List<Map<String, Object>> list1 = (List<Map<String, Object>>) jsonObject.get("list");
//        List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
//        Map<String, Object> map = new HashMap<String, Object>();
//        Map<String, Object> map1 = new HashMap<String, Object>();
//        map.put("order_id", "dfsfs");
//        map.put("goods_id", 12);
//        map.put("num", 22);
//        map1.put("order_id", "gggdsfd");
//        map1.put("goods_id", 13);
//        map1.put("num", 222);
//        list1.add(map);
//        list1.add(map1);
//        System.out.println(list1);
//        int result2 = goodsOrdersService.addToGoodsOrders(list1);
        list = (List<Map<String, Object>>) jsonObject.get("goods_list");
        System.out.println(list);
        orders.setOrder_id(jsonObject.getString("order_id"));
        orders.setOpenid(jsonObject.getString("openid"));
        orders.setPay_status(jsonObject.getString("pay_status"));
        orders.setCreate_time(jsonObject.getDate("create_time"));
        orders.setPay_price(jsonObject.getFloat("pay_price"));
        int result = ordersService.addOrderBuyNow(orders);
        int result2 = goodsOrdersService.addToGoodsOrders(list);
        if(result > 0){
            System.out.println("添加订单成功");
            if(result2 > 0){
                System.out.println("添加订单商品表成功");
                return "添加两表成功";
            }
        }
        return "添加两表失败";
    }
    //从购物车处添加订单(同时添加进order_goods,并从清空购物车)
    @RequestMapping(value = "/addOrderFromCart")
    @ResponseBody
    public String addOrderFromCart(@RequestBody JSONObject jsonObject){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Orders orders = new Orders();
        list = (List<Map<String, Object>>) jsonObject.get("goods_list");
        System.out.println(list);
        orders.setOrder_id(jsonObject.getString("order_id"));
        orders.setOpenid(jsonObject.getString("openid"));
        orders.setPay_status(jsonObject.getString("pay_status"));
        orders.setCreate_time(jsonObject.getDate("create_time"));
        orders.setPay_price(jsonObject.getFloat("pay_price"));

        int result = ordersService.addOrderBuyNow(orders);
        int result2 = goodsOrdersService.addToGoodsOrders(list);
        int result3 = cartService.clearCart(jsonObject.getString("openid"));

        if(result > 0){
            System.out.println("添加订单成功");
            if(result2 > 0){
                System.out.println("添加订单商品表成功");
                if(result3 > 0){
                    System.out.println("清空购物车成功");
                    return "添加订单成功";
                }
            }
        }
        return "添加订单失败";

    }
    //获取订单
    @RequestMapping(value = "/getAllOrders")
    @ResponseBody
    public List getAllOrders(String openid){
        List list = ordersService.getAllOrders(openid);
//        for(Map<String, Object> map: list){
////            System.out.println();
////        }
        return list;
    }
    //得到不同种类订单数量
    @RequestMapping(value = "/getOrdersSortAndNum")
    @ResponseBody
    public List<String> getOrdersSortAndNum(String openid){
        List<Orders> list = ordersService.getOrdersSortAndNum(openid);
        List<String> list1 = new ArrayList<String>();
        for(Orders item : list){
            list1.add(item.getPay_status());
        }
        System.out.println(list1);
        return list1;
    }

    //取消订单
    @RequestMapping(value = "/cancelOrder")
    @ResponseBody
    public String cancelOrder(String order_id){
        int result = ordersService.cancelOrder(order_id);
        if(result > 0){
            return "取消成功";
        }else{
            return "取消失败";
        }
    }
    //支付订单
    @RequestMapping(value = "/payOrder")
    @ResponseBody
    public String payOrder(String order_id){
        int result = ordersService.payOrder(order_id);
        if(result > 0){
            return "支付成功";
        }else{
            return "支付失败";
        }
    }
    //确认收货
    @RequestMapping(value = "/receiveOrder")
    @ResponseBody
    public String receiveOrder(String order_id){
        int result = ordersService.receiveOrder(order_id);
        if(result > 0){
            return "收货成功";
        }else{
            return "收货失败";
        }
    }
}
