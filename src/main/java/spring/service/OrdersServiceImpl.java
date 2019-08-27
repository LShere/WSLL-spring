package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.OrdersDao;
import spring.pojo.Orders;

import java.util.List;

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


}
