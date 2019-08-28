package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.OrdersDao;
import spring.pojo.Orders;

import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceImpl implements OrdersService {
@Autowired
OrdersDao ordersDao;
    public List<Orders> findOrdersByOpenid(String openid,int order_id){
        return ordersDao.findOrdersByOpenid(openid,order_id);
    }
    public int deleteOrder(int order_id){
        return ordersDao.deleteOrder(order_id);
    }

    public Integer addOrderBuyNow(Orders orders) {
        return ordersDao.addOrderBuyNow(orders);
    }

    public List<Map<String, Object>> getAllOrders(String openid) {
        return ordersDao.getAllOrders(openid);
    }
    public List<Orders> getOrdersSortAndNum(String openid) {
        return ordersDao.getOrdersSortAndNum(openid);
    }

    public Integer cancelOrder(String order_id) {
        return ordersDao.cancelOrder(order_id);
    }

    public Integer payOrder(String order_id) {
        return ordersDao.payOrder(order_id);
    }

    public Integer receiveOrder(String order_id) {
        return ordersDao.receiveOrder(order_id);
    }

}
