package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.GoodsDao;
import spring.pojo.Goods;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    GoodsDao goodsDao;

    public List<Goods> findAllGoods() {
        return this.goodsDao.findAllGoods();
    }
}