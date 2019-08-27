package spring.dao;

import org.apache.ibatis.annotations.Param;
import spring.pojo.Orders;

import java.util.List;

public interface OrdersDao {

    public List<Orders> findOrdersByOpenid(@Param("openid") String openid,@Param("order_id") String order_id);

    public int deleteOrder(String order_id);

}
