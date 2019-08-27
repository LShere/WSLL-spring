package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import spring.dao.CartDao;
import spring.dao.GoodsDao;
import spring.pojo.Cart;
import spring.pojo.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;
    @Autowired
    GoodsDao goodsDao;

    public int countCart(String openid) {
        return cartDao.countCart(openid);
    }

    public int deleteCart(String openid, int goods_id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid", openid);
        map.put("goods_id", goods_id);

        return cartDao.deleteCart(map);
    }

    public int addCart(String openid, int goods_id, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid", openid);
        map.put("goods_id", goods_id);
        map.put("num", num);

        Goods goods = new Goods();
        goods = goodsDao.findGoodsById(goods_id);

        map.put("file_path", goods.getGoods_picture_path());
        map.put("goods_price", goods.getGoods_price());
        map.put("goods_name", goods.getGoods_name());

        return cartDao.addCart(map);
    }

    public List<Cart> listCart(String openid) {
        return cartDao.listCart(openid);
    }
}
