package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.GoodsDao;
import spring.pojo.Goods;
import spring.pojo.Page;

import java.util.HashMap;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    public List<Goods> findAllGoods() {
        return this.goodsDao.findAllGoods();
    }

    /*实现分页查询*/
    public Page<Goods> findGoodPage(int currentPage, int goods_id, String goods_type, String goods_name, String goods_describe) {
        HashMap<String,Object> map=new HashMap<String, Object>();
        Page<Goods> page=new Page<Goods>();

        /*写入总记录数
        * 写入当前页数
        * 获取每页记录行数*/
        page.setTotalUsers(goodsDao.countGoods());
        page.setCurrentPage(currentPage);
        int pageSize=page.getPageSize();

        /*将当前页数和每页记录行数写入map*/
        map.put("currentPage",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);

        if (goods_id >= 0) {
            map.put("goods_id",goods_id);
        }
        if (goods_type != null) {
            map.put("goods_type",goods_type);
        }
        if (goods_name != null) {
            map.put("goods_name",goods_name);
        }
        if (goods_describe != null) {
            map.put("goods_describe",goods_describe);
        }

        List<Goods> list=goodsDao.findGoodsPage(map);
        page.setList(list);

        return page;
    }

    public Goods findGoodsById(int id) {
        return this.goodsDao.findGoodsById(id);
    }
}