package spring.dao;

import spring.pojo.Goods;

import java.util.List;

public interface GoodsDao {

    public List<Goods> findAllGoods();

}
