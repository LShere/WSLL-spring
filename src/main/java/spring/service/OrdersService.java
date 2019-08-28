package spring.service;

import spring.pojo.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> findOrdersByOpenid(String openid,String order_id);
    public int deleteOrder(String order_id);

    public Integer addOrderBuyNow(Orders orders);

}
