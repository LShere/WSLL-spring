package spring.service;

import spring.pojo.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> findOrdersByOpenid(String openid,int order_id);
    public int deleteOrder(int order_id);
}
