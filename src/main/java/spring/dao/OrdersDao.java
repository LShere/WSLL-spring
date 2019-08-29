package spring.dao;

import org.apache.ibatis.annotations.Param;
import spring.pojo.Orders;

import java.util.List;
import java.util.Map;

public interface OrdersDao {

    public List<Orders> findOrdersByOpenid(@Param("openid") String openid,@Param("order_id") String order_id);

    public int deleteOrder(String order_id);

    public Integer addOrderBuyNow(Orders orders); //直接为订单表添加一条记录

    public List<Map<String, Object>> getAllOrders(String openid);

    public List<Orders> getOrdersSortAndNum(String openid);

    public Integer cancelOrder(String order_id);

    public Integer payOrder(String order_id);

    public Integer receiveOrder(String order_id);

    public Integer completeOrder(String order_id);


//    public Integer addOrderFromCart(Orders orders); //添加订单同时清空购物车

}
