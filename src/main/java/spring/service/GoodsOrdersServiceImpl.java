package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.GoodsOrdersDao;
import spring.pojo.GoodsOrders;

import java.util.List;
import java.util.Map;

@Service
public class GoodsOrdersServiceImpl implements GoodsOrdersService{

    @Autowired
    private GoodsOrdersDao goodsOrdersDao;

    public Integer addToGoodsOrders(List<Map<String, Object>> list) {
        return goodsOrdersDao.addToGoodsOrders(list);
    }
}
