package spring.service;

import spring.pojo.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> findAllGoods();

}