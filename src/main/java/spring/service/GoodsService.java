package spring.service;

import spring.pojo.Goods;
import spring.pojo.Page;

import java.util.List;

public interface GoodsService {

    List<Goods> findAllGoods();

    Page<Goods> findGoodPage(int currentPage, String goods_type, String goods_name, String goods_describe);

    Goods findGoodsById(int id);

    List<Goods> findGoodsByRand();

}