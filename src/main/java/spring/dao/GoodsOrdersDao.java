package spring.dao;

import spring.pojo.GoodsOrders;

import java.util.List;
import java.util.Map;

public interface GoodsOrdersDao {
    public Integer addToGoodsOrders(List<Map<String, Object>> list);
}
