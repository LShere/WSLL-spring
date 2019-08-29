package spring.service;

import spring.pojo.Orders;

import java.util.List;
import java.util.Map;

public interface OrdersService {
    public List<Orders> findOrdersByOpenid(String openid,String order_id);
    public int deleteOrder(String order_id);

    public Integer addOrderBuyNow(Orders orders);

    public List<Map<String, Object>> getAllOrders(String openid);

    public List<Orders> getOrdersSortAndNum(String openid);

    public Integer cancelOrder(String order_id);

    public Integer payOrder(String order_id);

    public Integer receiveOrder(String order_id);

    public Integer completeOrder(String order_id);


}
