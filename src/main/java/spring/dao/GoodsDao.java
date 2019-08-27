package spring.dao;

import spring.pojo.Goods;
import spring.pojo.Page;

import java.util.HashMap;
import java.util.List;

public interface GoodsDao {

    public List<Goods> findAllGoods();

    List<Goods> findGoodsPage(HashMap<String,Object> map);

    Integer countGoods();

    Goods findGoodsById(int id);

    List<Goods> findGoodsByRand(int num);

    List<Goods> findNewGoods(int n);
}
